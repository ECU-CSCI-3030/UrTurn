package com.example.aaron.myapplication;

import java.util.Random;

public class Chore {

    Random id = new Random();
    int cID;
    String cName;
    int level;  //Severity
    boolean active;

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


    /**
     * This method will allow a user to send a notification
     * to another user to complete an active chore
     * @param notifier This User that will send the notification
     * @param notifiee This User will recieve the notification
     */
    public void notify(User notifier, User notifiee){
        //Nick
    }

    /**
     * This method will add a chore to the database
     * SQL
     */
    public void addChore(){

        //Aanil


        //this is what i think  should go in
        //System.out.println("Enter your new Chore");
        //String chore = scanner.nextLine();
        //System.out.println("Enter a description of the chore");
        //String ChoreDescription = scanner.nextLine();
        //cID = id.nextInt(100);
        //System.out.println("How  severe is the chore 1 being highest, 3 being lowest");
        //level = scanner.nextInt();


    }

    /**
     * This method will remove a chore from the database
     * SQL
     */
    public void removeChore(){

    //Aaron


    }

    /**
     * This method is used to exchange one chore with another
     * active chore of a roomate
     */
    public void exchangeChore(Chore yourChore, User roomate, Chore roomatesChore){


    }

}
