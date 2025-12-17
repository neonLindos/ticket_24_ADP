package org.example.notifications;

public class PushNotification implements NotificationChannel {
    public void send(String message) { System.out.println("Push: " + message); }
}
