package org.example.users;

import org.example.events.*;

public class FinancialAnalyst extends User {
    public FinancialAnalyst(String name) { super(name); }

    @Override
    public void update(MarketEvent event) {
        String msg = name + " - [Analyst] ";
        if (event instanceof PriceChangeEvent) {
            msg += "Price changed for " + event.getAssetName() + ": " + ((PriceChangeEvent) event).getNewPrice();
        } else if (event instanceof ThresholdEvent) {
            msg += "Threshold reached for " + event.getAssetName() + ": " + ((ThresholdEvent) event).getThreshold();
        } else if (event instanceof MarketAlertEvent) {
            msg += "Market alert: " + ((MarketAlertEvent) event).getMessage();
        } else if (event instanceof DividendEvent) {
            msg += "Dividend paid for " + event.getAssetName() + ": " + ((DividendEvent) event).getDividend();
        }
        notifyChannels(msg);
    }


}
