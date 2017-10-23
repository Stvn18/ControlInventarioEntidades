/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.usr;

import gt.ms.controlinventario.base.GenericEntity;
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
public class UserRol extends GenericEntity{
    
    @ManyToOne()
    @JoinColumn()
    private Rol rol;

    public UserRol() {
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}