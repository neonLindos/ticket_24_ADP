package org.example.events;

public class MarketAlertEvent extends MarketEvent {
    private String message;
    public MarketAlertEvent(String assetName, String message) {
        super(assetName);
        this.message = message;
    }
    public String getMessage() { return message; }
}
