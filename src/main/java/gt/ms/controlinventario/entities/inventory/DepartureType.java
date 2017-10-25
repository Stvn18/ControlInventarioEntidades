/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.inventory;

import gt.ms.controlinventario.base.GenericEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "inventory")
public class DepartureType extends GenericEntity{
    
    @Column(length = 128)
    private String name;

    public DepartureType() {
    }

    public DepartureType(String name) {
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
        return "DepartureType{" + "name=" + name + '}';
    }
 
    
}