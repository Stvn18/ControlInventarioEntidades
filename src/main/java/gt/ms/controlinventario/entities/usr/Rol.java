/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.usr;

import gt.ms.controlinventario.base.MinimallyAuditedEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Steven
 */
@Entity()
@Audited()
@Table(schema = "usr")
public class Rol extends MinimallyAuditedEntity implements GrantedAuthority {

    private String name;

    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rol{" + "name=" + name + '}';
    }

    @Override
    public String getAuthority() {
        return name;
    }

}