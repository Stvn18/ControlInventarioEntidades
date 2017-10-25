/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.rrhh;

import gt.ms.controlinventario.base.MinimallyAuditedEntity;
import gt.ms.controlinventario.entities.general.Department;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Steven
 */

@Entity()
@Table(schema = "rrhh")
public class Person extends MinimallyAuditedEntity{
    
    private Integer codeVH;
    
    private String name;
    
    private String lastname;
    
    @ManyToOne()
    @JoinColumn()
    private Department department;

    public Person() {
    }

    public Person(Integer codeVH, String name, String lastname, Department department) {
        this.codeVH = codeVH;
        this.name = name;
        this.lastname = lastname;
        this.department = department;
    }

    public Integer getCodeVH() {
        return codeVH;
    }

    public void setCodeVH(Integer codeVH) {
        this.codeVH = codeVH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" + "codeVH=" + codeVH + ", name=" + name + ", lastname=" + lastname + ", department=" + department + '}';
    }
    
    
}