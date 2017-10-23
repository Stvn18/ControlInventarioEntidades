    /*
 * Copyright 2016 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gt.ms.controlinventario.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import gt.ms.controlinventario.entities.converters.LocalDateTimeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Steve Ortiz
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class MinimallyAuditedEntity extends GenericEntity {

    private static final long serialVersionUID = 2955759627644100104L;

    @CreatedDate
//    @NotNull
    @Column(name = "created_at", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdAt_;

    @CreatedBy
    @Column(name = "created_by", length = 64)
    @JsonIgnore
    private String createdBy_;

    @LastModifiedDate
    @Column(name = "modified_at", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime modifiedAt_;

    @LastModifiedBy
    @Column(name = "modified_by", length = 64)
    @JsonIgnore
    private String modifiedBy_;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    /**
     * @return the createdAt_
     */
    public LocalDateTime getCreatedAt() {
        return createdAt_;
    }

    /**
     * @return the createdBy_
     */
    public String getCreatedBy() {
        return createdBy_;
    }

    /**
     * @return the modifiedAt_
     */
    public LocalDateTime getModifiedAt() {
        return modifiedAt_;
    }

    /**
     * @return the modifiedBy_
     */
    public String getModifiedBy() {
        return modifiedBy_;
    }

    @PrePersist
    public void Persistir() {
        createdAt_ = new LocalDateTimeConverter().convertToEntityAttribute(new Timestamp(new Date().getTime()));
        createdBy_ = authentication != null ? authentication.getName() : "Anonimo";
    }

    @PreUpdate
    public void Modificar() {
        modifiedAt_ = new LocalDateTimeConverter().convertToEntityAttribute(new Timestamp(new Date().getTime()));
        createdBy_ = authentication != null ? authentication.getName() : "Anonimo";
    }
}
