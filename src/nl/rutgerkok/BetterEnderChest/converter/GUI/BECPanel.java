package nl.rutgerkok.BetterEnderChest.converter.GUI;

import java.util.Timer;

import javax.swing.JPanel;

import nl.rutgerkok.BetterEnderChest.converter.BECConvertDirectory;
import nl.rutgerkok.BetterEnderChest.converter.BECTimer;

public class BECPanel extends JPanel {
    private static final long serialVersionUID = -7278517486785864692L;

    public BECConvertDirectory converter;
    
    public BECPanelDescription description;
    public BECPanelButtons buttons;

    public BECPanel() {
        setLayout(null); // No layout manager, use setBounds()!

        Timer timer = new Timer();
        timer.schedule(new BECTimer(this), 50, 50);

        // Description
        description = new BECPanelDescription(this);
        description.setBounds(-6, 0, 410, 60);
        add(description);
        
        buttons = new BECPanelButtons(this);
        buttons.setBounds(0, 110, 400, 30);
        add(buttons);
    }

}
