/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.usr.builder;

import gt.ms.controlinventario.entities.usr.User;

/**
 *
 * @author Steven
 */
public class UserBuilder {

    private String account;
    private String password;
    private String namePerson;

    public UserBuilder(String account, String password, String namePerson) {
        this.account = account;
        this.password = password;
        this.namePerson = namePerson;
    }
    
    public UserBuilder setAccount(String account){
        this.account = account;
        return this;
    }
    
    public UserBuilder setPassword(String password){
        this.password = password;
        return this;
    }
    
    public UserBuilder setNamePerson(String namePerson){
        this.namePerson = namePerson;
        return this;
    }
    
    public User create(){
        return User.create(account, password, namePerson);
    }

}
