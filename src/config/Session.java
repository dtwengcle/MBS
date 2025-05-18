/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author markjay
 */
public class Session {
    
    private static Session instance;
    
    private int id;
    private String name;
    private String username;
    private String gender;
    private String role;
    private String email;
    private String status;
    
    public Session() {
        instance = this;
    }
    
    public void setSession (int id, String name, String username, String gender, String role, String email, String status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.role = role;
        this.email = email;
        this.status = status;
    }
    
    public static Session getInstance() {
        return instance;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getStatus() {
        return status;
    }
}
    
