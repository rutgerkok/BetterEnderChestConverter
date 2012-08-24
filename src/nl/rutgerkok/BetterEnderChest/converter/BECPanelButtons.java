package nl.rutgerkok.BetterEnderChest.converter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BECPanelButtons extends JPanel implements ActionListener {
    private static final long serialVersionUID = -2016536905296475613L;

    JFileChooser fileChooser;
    JButton BECVanillaButton;
    JButton vanillaBECButton;

    BECPanel mainPanel;

    public BECPanelButtons(BECPanel mainPanel) {
        this.mainPanel = mainPanel;

        fileChooser = new JFileChooser();

        BECVanillaButton = new JButton();
        BECVanillaButton.setText("BetterEnderChest --> Vanilla");
        BECVanillaButton.addActionListener(this);
        add(BECVanillaButton);

        vanillaBECButton = new JButton();
        vanillaBECButton.setText("Vanilla --> BetterEnderChest");
        vanillaBECButton.addActionListener(this);
        add(vanillaBECButton);
    }

    public void actionPerformed(ActionEvent event) {
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File levelDat = fileChooser.getSelectedFile();
            
            if (!levelDat.getName().equals("level.dat")) {
                JOptionPane.showMessageDialog(null, "Please choose the level.dat of your main world.");
            } else {
                // Start the conversion!
                
                // Get the Ender chest directory
                File chestDirectory;
                if(mainPanel.useServerRoot)
                    chestDirectory = new File(levelDat.getParentFile().getParentFile().getPath() + "/chests");
                else
                    chestDirectory = new File(levelDat.getParentFile().getParentFile().getPath() + "/plugins/BetterEnderChest/chests");
                File playerDirectory = new File(levelDat.getParentFile().getPath() + "/players");
                
                if (event.getSource() == BECVanillaButton) {
                    mainPanel.converter = new BECConvertDirectoryBECVanilla(chestDirectory, playerDirectory);
                } else {
                    mainPanel.converter = new BECConvertDirectoryVanillaBEC(chestDirectory, playerDirectory);
                }
                new Timer().schedule(new BECTimer(mainPanel), 1, 100);

                BECVanillaButton.setEnabled(false);
                vanillaBECButton.setEnabled(false);
            }
        }
    }
}
