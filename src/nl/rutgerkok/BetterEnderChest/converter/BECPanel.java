package nl.rutgerkok.BetterEnderChest.converter;

import java.util.Timer;

import javax.swing.JPanel;

public class BECPanel extends JPanel {
    private static final long serialVersionUID = -7278517486785864692L;

    public BECConvertDirectory converter;
    
    public BECPanelDescription description;
    public BECPanelButtons buttons;
    public BECPanelOptions options;
    
    // Standard save location
    public boolean useServerRoot = true;

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
        
        options = new BECPanelOptions(this);
        options.setBounds(0, 140, 400, 30);
        add(options);
    }

}
