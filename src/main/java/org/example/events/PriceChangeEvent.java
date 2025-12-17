package org.example.events;

public class PriceChangeEvent extends MarketEvent {
    private double newPrice;
    public PriceChangeEvent(String assetName, double newPrice) {
        super(assetName);
        this.newPrice = newPrice;
    }
    public double getNewPrice() { return newPrice; }
}
