package com.example.aaron.myapplication;

public class User {

    int uID;
    String email;
    String password;
    String fName;
    String lName;
    int rID;
    int choresDone;
    int rating;
    boolean inRoom;
    String device_key; //This will be used to store information about the users device for sending notifications


    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public int getChoresDone() {
        return choresDone;
    }

    public void setChoresDone(int choresDone) {
        this.choresDone = choresDone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isInRoom() {
        return inRoom;
    }

    public void setInRoom(boolean inRoom) {
        this.inRoom = inRoom;
    }

    public String getDevice_key() {
        return device_key;
    }

    public void setDevice_key(String device_key) {
        this.device_key = device_key;
    }


    /**
     * This method will sign up a user that does not already exist in the database
     *
     * @param email The email the user will sign up with
     * @param password The password that the user will sign up with
     * @param fName The first name of the user
     * @param lName The last name of the user7
     *
     * Firebase Integration
     */
    public void signUp(String email, String password, String fName, String lName){

    }

    /**
     * This method will allow a user to Log into UrTurn using their
     * email and password
     *
     * @param email The user's email attached to their UrTurn account
     * @param password The user's password for their account
     *
     * Firebase Integration
     *
     */
    public void login(String email, String password){

    }

    /**
     * This method will allow a user to assign a chore to another user
     * Currently in the room
     */
    public void assignChore(){

    }

    /**
     * This method will allow a User to complete a chore
     * That is currently active and assigned to them
     */
    public void completeChore(){

    }

    /**
     * This metohd will allow a User with no current room to join a new room
     */
    public void joinRoom(){

    }

    /**
     * This method will allow the user inside a room to leave their current room
     *
     * This method will remove the user from the room object
     */
    public void leaveRoom(){

    }

    /**
     * This method will allow the user inside a room to change their
     * current room to another
     *
     * Firebase integration
     */
    public void changeRoom(){

    }

    /**
     * This method will allow a user to invite anotehr user
     * via email or phone number
     *
     * Firebase integration
     */
    public void inviteUser(){

    }

    /**
     * This method will assign a chore randomly to a roomate
     * beta
     *
     * Possible Firebase integration
     */
    public void randomAssignChore(){

    }


}
