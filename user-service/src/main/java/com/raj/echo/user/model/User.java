package com.raj.echo.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    
    @Id
    private String Id;
    private String username;
    private String password;
    private String email;
    private String role;

    public void setName(String name){
        this.username = name;
    }
    public String getName(){
        return username;
    }

    public void setPass(String password){
        this.password = password;
    }

    public String getPass(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
