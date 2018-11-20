package com.example.aaron.myapplication;

public class choreInfo {
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public choreInfo(String description, String name, String image, String id) {
        Description = description;
        Name = name;
        Image = image;
        ID = id;
    }

    private String Description;
    private String Name;
    private String Image;
    private String ID;


    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }




public choreInfo(){

    }

}
