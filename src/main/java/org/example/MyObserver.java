package org.example;

import org.example.events.MarketEvent;

public interface MyObserver {
    void update(MarketEvent event);
}
