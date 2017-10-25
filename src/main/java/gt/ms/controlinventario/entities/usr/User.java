/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.usr;

import gt.ms.controlinventario.base.FullyAuditedEntity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author Steven
 */

@Entity()
@Audited()
@Table(schema = "usr")
public class User extends FullyAuditedEntity {
    
    private String account;
    private String password;
    private String namePerson;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(schema = "usr")
    private Set<UserRol> roles = new HashSet<>();
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(schema = "usr")
    private Set<UserInventory> inventories = new HashSet<>();

    public User() {
    }

    public User(String account, String password, String namePerson) {
        this.account = account;
        this.password = password;
        this.namePerson = namePerson;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public Set<UserRol> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRol> roles) {
        this.roles = roles;
    }

    public Set<UserInventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<UserInventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.account);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.namePerson);
        hash = 47 * hash + Objects.hashCode(this.roles);
        hash = 47 * hash + Objects.hashCode(this.inventories);
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
        final User other = (User) obj;
        if (!Objects.equals(this.account, other.account)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.namePerson, other.namePerson)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.inventories, other.inventories)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "account=" + account + ", password=" + password + ", namePerson=" + namePerson + ", roles=" + roles + ", inventories=" + inventories + '}';
    }

    
    public static User create(String account, String password, String namePerson){
        if(account == null || namePerson == null){
            return null;
        }
        return new User(account, password, namePerson);
    }
    
}