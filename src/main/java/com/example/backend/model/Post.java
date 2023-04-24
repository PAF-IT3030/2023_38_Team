package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int PID;

    private String userName;
    private String foodName;
    private String description;
    private String imageURL1;
    private String imageURL2;
    private String imageURL3;
    private String imageURL4;


    public Post(int PID,String userName,String foodName,String description ,String imageURL1,String imageURL2,String imageURL3,String imageURL4){
    super();
    this.PID = PID;
    this.userName =userName;
    this.description= description;
    this.imageURL1=imageURL1;
    this.imageURL2=imageURL2;
    this.imageURL3=imageURL3;
    this.imageURL4=imageURL4;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int pID) {
        PID = pID;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageURL1() {
        return imageURL1;
    }
    public void setImageURL1(String imageURL1) {
        this.imageURL1 = imageURL1;
    }
    public String getImageURL2() {
        return imageURL2;
    }
    public void setImageURL2(String imageURL2) {
        this.imageURL2 = imageURL2;
    }
    public String getImageURL3() {
        return imageURL3;
    }
    public void setImageURL3(String imageURL3) {
        this.imageURL3 = imageURL3;
    }
    public String getImageURL4() {
        return imageURL4;
    }
    public void setImageURL4(String imageURL4) {
        this.imageURL4 = imageURL4;
    }
}
