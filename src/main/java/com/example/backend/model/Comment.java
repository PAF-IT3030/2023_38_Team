package com.example.backend.model;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CID;
    private String user;
    private String comment;
    private Timestamp time;

    public Comment(int CID,String user,String comment,Timestamp time){

        super();
        this.CID = CID;
        this.user = user;
        this.comment = comment;
        this.time =time;
    }

    public int getCID() {
        return CID;
    }
    public void setCID(int cID) {
        CID = cID;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Timestamp getTime() {
        return time;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }

}
