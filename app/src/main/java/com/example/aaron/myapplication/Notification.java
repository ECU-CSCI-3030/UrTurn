package com.example.aaron.myapplication;

public class Notification {

    String contentTitle;
    String notificationText;
    String subText;
    String channelID;
    long timeoutDuration; //duration in Milliseconds
    String groupKey;    //NotificationCompactBuilder.setGroup;


    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public long getTimeoutDuration() {
        return timeoutDuration;
    }

    public void setTimeoutDuration(long timeoutDuration) {
        this.timeoutDuration = timeoutDuration;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    //Hold till Thursday



}
