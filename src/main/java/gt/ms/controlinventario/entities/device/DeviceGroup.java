/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.device;

import gt.ms.controlinventario.base.MinimallyAuditedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "device")
public class DeviceGroup extends MinimallyAuditedEntity {
    
    @Column(length = 128)
    private String groupName;

    public DeviceGroup() {
    }

    public DeviceGroup(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "DeviceGroup{" + "groupName=" + groupName + '}';
    }

    
}