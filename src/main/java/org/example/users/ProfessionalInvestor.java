package org.example.users;

import org.example.events.MarketAlertEvent;
import org.example.events.MarketEvent;
import org.example.events.PriceChangeEvent;
import org.example.events.ThresholdEvent;

public class ProfessionalInvestor extends User {
    public ProfessionalInvestor(String name) { super(name); }

    @Override
    public void update(MarketEvent event) {
        String msg = name + " - [Pro] ";
        if (event instanceof PriceChangeEvent) {
            msg += "Price changed for " + event.getAssetName() + ": " + ((PriceChangeEvent) event).getNewPrice();
        } else if (event instanceof ThresholdEvent) {
            msg += "Threshold reached for " + event.getAssetName() + ": " + ((ThresholdEvent) event).getThreshold();
        } else if (event instanceof MarketAlertEvent) {
            msg += "Market alert: " + ((MarketAlertEvent) event).getMessage();
        }
        notifyChannels(msg);
    }
}
