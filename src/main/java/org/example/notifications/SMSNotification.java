package org.example.notifications;

public class SMSNotification implements NotificationChannel {
    public void send(String message) { System.out.println("SMS: " + message); }
}