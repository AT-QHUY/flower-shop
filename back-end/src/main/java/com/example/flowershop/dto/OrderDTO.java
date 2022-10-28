package com.example.flowershop.dto;

import java.util.List;

public class OrderDTO {

    private int id;

    private List<OrderDetailDTO> listDetail;

    private int userId;
    private UserDTO user;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderDetailDTO> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<OrderDetailDTO> listDetail) {
        this.listDetail = listDetail;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
