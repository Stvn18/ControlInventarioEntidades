/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.usr;

import gt.ms.controlinventario.base.MinimallyAuditedEntity;
import gt.ms.controlinventario.entities.inventory.Inventory;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "usr")
public class UserInventory extends MinimallyAuditedEntity {
    
    @ManyToOne()
    @JoinColumn()
    private Inventory inventory;

    public UserInventory() {
    }

    public UserInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "UserInventory{" + "inventory=" + inventory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.inventory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserInventory other = (UserInventory) obj;
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        return true;
    }
    
}