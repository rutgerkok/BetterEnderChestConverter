package nl.rutgerkok.BetterEnderChest.converter;

import java.io.File;

import javax.swing.JOptionPane;

public abstract class BECConvertDirectory implements Runnable {

    private boolean hasGUI;

    public BECConvertDirectory(File chestDirectory, File playerDirectory, boolean hasGUI) {
        this.hasGUI = hasGUI;
    }

    public abstract float getProgress();

    protected void message(String message) {
        if (hasGUI) {
            JOptionPane.showMessageDialog(null, message);
        }
            
        System.out.println(message);
    }
}
