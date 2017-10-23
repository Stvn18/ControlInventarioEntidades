/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.usr;

import gt.ms.controlinventario.base.FullyAuditedEntity;
import java.util.HashSet;
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

    @Override
    public String toString() {
        return "User{" + "account=" + account + ", password=" + password + ", namePerson=" + namePerson + ", roles=" + roles + '}';
    }
    
    public static User create(String account, String password, String namePerson){
        if(account == null || namePerson == null){
            return null;
        }
        return new User(account, password, namePerson);
    }
    
}