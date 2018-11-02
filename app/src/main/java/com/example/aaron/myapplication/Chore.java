package com.example.aaron.myapplication;

public class Chore {
    int cID;
    String cName;
    String cdShort;
    String cdLong;
    int level;  //Severity
    boolean active;
    boolean completed;

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