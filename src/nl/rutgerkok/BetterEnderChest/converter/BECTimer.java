package nl.rutgerkok.BetterEnderChest.converter;

import java.util.TimerTask;

public class BECTimer extends TimerTask {
    private BECPanel panel;

    public BECTimer(BECPanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        if (panel.converter != null) {
            panel.description.progressDisplayer.setValue((int) (panel.converter.getProgress() * 100.0));
        }

    }

}
