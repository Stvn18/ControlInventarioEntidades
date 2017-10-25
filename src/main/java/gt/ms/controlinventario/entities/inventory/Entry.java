/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.inventory;

import gt.ms.controlinventario.base.FullyAuditedEntity;
import gt.ms.controlinventario.entities.device.Device;
import gt.ms.controlinventario.entities.device.DeviceStatus;
import gt.ms.controlinventario.entities.usr.User;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "inventory")
@Audited()
public class Entry extends FullyAuditedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    public User user;

    public Integer quantity;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(schema = "inventory")
    public List<Device> devices;

    @Column(length = 255)
    private String observation;

    public Entry() {
    }

    public Entry(User user, Integer quantity, List<Device> devices, String observation) {
        this.user = user;
        this.quantity = quantity;
        this.devices = devices;
        this.observation = observation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.user);
        hash = 71 * hash + Objects.hashCode(this.quantity);
        hash = 71 * hash + Objects.hashCode(this.devices);
        hash = 71 * hash + Objects.hashCode(this.observation);
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
        final Entry other = (Entry) obj;
        if (!Objects.equals(this.observation, other.observation)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        if (!Objects.equals(this.devices, other.devices)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entry{" + "user=" + user + ", quantity=" + quantity + ", devices=" + devices + ", observation=" + observation + '}';
    }

    
}