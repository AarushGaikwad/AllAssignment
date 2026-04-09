package com.sunbeam.cpmc;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String password;   // ✅ changed
    private String email;
    private String addr;
    private String role;
    private Date birth;

    public User() {
    }

    public User(int id, String name, String password, String email, String addr, String role, Date birth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.addr = addr;
        this.role = role;
        this.birth = birth;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddr() { return addr; }
    public void setAddr(String addr) { this.addr = addr; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Date getBirth() { return birth; }
    public void setBirth(Date birth) { this.birth = birth; }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password +
               ", email=" + email + ", addr=" + addr + ", role=" + role +
               ", birth=" + birth + "]";
    }
}