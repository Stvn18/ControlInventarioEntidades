/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.inventory;

import gt.ms.controlinventario.base.FullyAuditedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "inventory")
@Audited()
public class Inventory extends FullyAuditedEntity{
    
    @Column(length = 255)
    private String name;
    
    @Column(length = 255)
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Warehouse warehouse;
    
}
