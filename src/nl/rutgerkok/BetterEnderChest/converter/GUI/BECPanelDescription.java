package nl.rutgerkok.BetterEnderChest.converter.GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class BECPanelDescription extends JPanel {
    private static final long serialVersionUID = 7364769865041060238L;

    public BECPanel mainPanel;
    public JProgressBar progressDisplayer;

    public BECPanelDescription(BECPanel mainPanel) {
        this.mainPanel = mainPanel;

        progressDisplayer = new JProgressBar();
        progressDisplayer.setMaximum(100);

        add(new JLabel("Choose the level.dat of your main world to convert all files from or to my format."));
        add(new JLabel("PLEASE MAKE A BACKUP OF YOUR PLAYER FILES BEFORE USING THIS PROGRAM"));
        add(progressDisplayer);
    }

}
