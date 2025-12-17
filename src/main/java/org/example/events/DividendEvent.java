package org.example.events;

public class DividendEvent extends MarketEvent {
    private double dividend;
    public DividendEvent(String assetName, double dividend) {
        super(assetName);
        this.dividend = dividend;
    }
    public double getDividend() { return dividend; }
}
