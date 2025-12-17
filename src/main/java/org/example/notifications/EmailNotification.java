package org.example.notifications;

public class EmailNotification implements NotificationChannel {
    public void send(String message) { System.out.println("Email: " + message); }
}

