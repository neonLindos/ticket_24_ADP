package org.example.events;

public class ThresholdEvent extends MarketEvent {
    private double threshold;
    public ThresholdEvent(String assetName, double threshold) {
        super(assetName);
        this.threshold = threshold;
    }
    public double getThreshold() { return threshold; }
}
