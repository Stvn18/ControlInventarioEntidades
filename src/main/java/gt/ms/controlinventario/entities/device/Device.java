/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.device;

import gt.ms.controlinventario.base.FullyAuditedEntity;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "device")
@Audited
public class Device extends FullyAuditedEntity{
    
    @Column(length = 6)
    private String code;
    
    @Column(length = 255)
    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private DeviceStatus deviceStatus;
    
//    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable("inventory")
//    @Fetch(FetchMode.SUBSELECT)
//    private List<FileStorage> files;
    
    @Column(length = 255)
    private String brand;
    
    @Column(length = 100)
    private String serialNumber;
    
    @Column(length = 255)
    private String previousLocation;
    
    @Column(length = 255)
    private String observation;

    public Device(String code, String name, DeviceStatus deviceStatus, String brand, String serialNumber, String previousLocation, String observation) {
        this.code = code;
        this.name = name;
        this.deviceStatus = deviceStatus;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.previousLocation = previousLocation;
        this.observation = observation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(String previousLocation) {
        this.previousLocation = previousLocation;
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
        hash = 97 * hash + Objects.hashCode(this.code);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.deviceStatus);
        hash = 97 * hash + Objects.hashCode(this.brand);
        hash = 97 * hash + Objects.hashCode(this.serialNumber);
        hash = 97 * hash + Objects.hashCode(this.previousLocation);
        hash = 97 * hash + Objects.hashCode(this.observation);
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
        final Device other = (Device) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (!Objects.equals(this.serialNumber, other.serialNumber)) {
            return false;
        }
        if (!Objects.equals(this.previousLocation, other.previousLocation)) {
            return false;
        }
        if (!Objects.equals(this.observation, other.observation)) {
            return false;
        }
        if (!Objects.equals(this.deviceStatus, other.deviceStatus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Device{" + "code=" + code + ", name=" + name + ", deviceStatus=" + deviceStatus + ", brand=" + brand + ", serialNumber=" + serialNumber + ", previousLocation=" + previousLocation + ", observation=" + observation + '}';
    }
    
}