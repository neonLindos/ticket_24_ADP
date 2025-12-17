package org.example;

import org.example.events.*;

import java.util.ArrayList;
import java.util.List;

// ---------------------------
// 3. Интерфейс субъекта
// ---------------------------
interface Subject {
    void attach(MyObserver myObserver);
    void detach(MyObserver myObserver);
    void notifyObservers(MarketEvent event);
}


public class Stock implements Subject {
    private String name;
    private List<MyObserver> myObservers = new ArrayList<>();

    public Stock(String name) { this.name = name; }

    public void attach(MyObserver myObserver) { myObservers.add(myObserver); }
    public void detach(MyObserver myObserver) { myObservers.remove(myObserver); }

    public void notifyObservers(MarketEvent event) {
        for (MyObserver myObserver : myObservers) myObserver.update(event);
    }

    // Методы для генерации событий
    public void changePrice(double price) { notifyObservers(new PriceChangeEvent(name, price)); }
    public void reachThreshold(double threshold) { notifyObservers(new ThresholdEvent(name, threshold)); }
    public void marketAlert(String message) { notifyObservers(new MarketAlertEvent(name, message)); }
    public void dividendPaid(double dividend) { notifyObservers(new DividendEvent(name, dividend)); }
}