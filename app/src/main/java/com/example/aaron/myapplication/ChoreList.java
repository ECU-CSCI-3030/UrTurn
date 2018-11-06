package com.example.aaron.myapplication;

public class ChoreList extends Chore {

    String dateAssigned;
    int timeActive;



    public String getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(String dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public int getTimeActive() {
        return timeActive;
    }

    public void setTimeActive(int timeActive) {
        this.timeActive = timeActive;
    }


    /**
     * This method will display the active chores
     */
    public void display(){

    }
    /**
     * This method will display all of the completed chores to the user
     */
    public void displayHistory(){

    }

}

