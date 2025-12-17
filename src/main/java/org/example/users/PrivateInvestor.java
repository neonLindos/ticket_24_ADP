package org.example.users;

import org.example.events.MarketEvent;
import org.example.events.PriceChangeEvent;
import org.example.events.ThresholdEvent;

public class PrivateInvestor extends User {
    public PrivateInvestor(String name) { super(name); }

    @Override
    public void update(MarketEvent event) {
        if (event instanceof PriceChangeEvent) {
            PriceChangeEvent e = (PriceChangeEvent) event;
            notifyChannels(name + " - Price changed for " + e.getAssetName() + ": " + e.getNewPrice());
        } else if (event instanceof ThresholdEvent) {
            ThresholdEvent e = (ThresholdEvent) event;
            notifyChannels(name + " - Threshold reached for " + e.getAssetName() + ": " + e.getThreshold());
        }
    }
}