package nl.rutgerkok.BetterEnderChest.converter;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BECPanel extends JPanel {
    private static final long serialVersionUID = -7278517486785864692L;

    public BECConvertDirectory converter;
    public BECPanelDescription description;
    public JButton BECVanillaButton;

    public BECPanel() {
        setLayout(new BorderLayout());

        Timer timer = new Timer();
        timer.schedule(new BECTimer(this), 50, 50);

        description = new BECPanelDescription(this);
        add(description, BorderLayout.CENTER);
        add(new BECPanelButtons(this), BorderLayout.SOUTH);
    }

}
