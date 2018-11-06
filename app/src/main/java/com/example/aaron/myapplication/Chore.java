package com.example.aaron.myapplication;

public class Chore {
    int cID;
    String cName;
    String cdShort;
    String cdLong;
    int level;  //Severity
    boolean active;
    boolean completed;


    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getCdShort() {
        return cdShort;
    }

    public void setCdShort(String cdShort) {
        this.cdShort = cdShort;
    }

    public String getCdLong() {
        return cdLong;
    }

    public void setCdLong(String cdLong) {
        this.cdLong = cdLong;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /**
     * This method will allow a user to send a notification
     * to another user to complete an active chore
     * @param notifier This User that will send the notification
     * @param notifiee This User will recieve the notification
     */
    public void notify(User notifier, User notifiee){

    }

    /**
     * This method will add a chore to the database
     * SQL
     */
    public void addChore(){

    }

    /**
     * This method will remove a chore from the database
     * SQL
     */
    public void removeChore(){

    }

    /**
     * This method is used to exchange one chore with another
     * active chore of a roomate
     */
    public void exchangeChore(Chore yourChore, User roomate, Chore roomatesChore){

    }

}