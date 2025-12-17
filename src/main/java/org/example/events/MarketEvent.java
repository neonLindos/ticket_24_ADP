package org.example.events;

public abstract class MarketEvent {
    protected String assetName;
    public MarketEvent(String assetName) { this.assetName = assetName; }
    public String getAssetName() { return assetName; }
}

