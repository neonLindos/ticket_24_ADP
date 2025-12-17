package org.example.users;

import org.example.events.MarketEvent;
import org.example.MyObserver;
import org.example.notifications.NotificationChannel;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements MyObserver {
    protected String name;
    protected List<NotificationChannel> channels = new ArrayList<>();
    protected List<String> history = new ArrayList<>();

    public User(String name) { this.name = name; }

    public void addChannel(NotificationChannel channel) { channels.add(channel); }

    protected void notifyChannels(String message) {
        for (NotificationChannel channel : channels) channel.send(message);
        history.add(message);
    }

    public List<String> getHistory() { return history; }

    // Абстрактный метод для обработки событий
    public abstract void update(MarketEvent event);
}
