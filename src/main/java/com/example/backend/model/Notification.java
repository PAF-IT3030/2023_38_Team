package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int NID;
    private String message;
    private String iconURL;

    public Notification(int NID,String message,String iconURL){
    super();
    this.NID=NID;
    this.message=message;
    this.iconURL=iconURL;

    }

    public int getNID() {
        return NID;
    }
    public void setNID(int nID) {
        NID = nID;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getIconURL() {
        return iconURL;
    }
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }
    
}
