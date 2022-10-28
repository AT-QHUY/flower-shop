package com.example.flowershop.dto;



import java.util.List;

public class UserDTO {

    private int id;
    private String name;
    private String rolename;
//    private List<OrderDTO> orderList;

    private String username;
    private String password;

    private String token;

    public UserDTO() {
    }

    public UserDTO(String token, int id) {
        this.token = token;
        this.id = id;
    }

    public UserDTO(String token) {
        this.token = token;
    }

    public UserDTO(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
