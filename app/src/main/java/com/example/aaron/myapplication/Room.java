package com.example.aaron.myapplication;

public class Room {

        int rID;
        User[] userArray;
        String roomName;



        public int getrID() { return rID; }

        public void setrID(int rID) {
            this.rID = rID;
        }

        public User[] getUserArray() {
            return userArray;
        }

        public void setUserArray(User[] userArray) {
            this.userArray = userArray;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }
          /**
         * This method will check a room for a specified User
         *
         * @return Return True if the room contains the specified User
         */
        public boolean isInRoom(int room,int userID){

            return true;
        }


}
