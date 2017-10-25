/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.general;

import gt.ms.controlinventario.base.MinimallyAuditedEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "general")
@Audited()
public class Department extends MinimallyAuditedEntity{
    
    private String codeSAP;
    
    private String departmentName;

    public Department() {
    }

    public Department(String codeSAP, String departmentName) {
        this.codeSAP = codeSAP;
        this.departmentName = departmentName;
    }

    public String getCodeSAP() {
        return codeSAP;
    }

    public void setCodeSAP(String codeSAP) {
        this.codeSAP = codeSAP;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" + "codeSAP=" + codeSAP + ", departmentName=" + departmentName + '}';
    }
     
}