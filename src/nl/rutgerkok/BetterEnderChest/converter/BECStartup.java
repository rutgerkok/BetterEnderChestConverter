package nl.rutgerkok.BetterEnderChest.converter;

import java.awt.GraphicsEnvironment;

import nl.rutgerkok.BetterEnderChest.converter.GUI.BECWindow;

public class BECStartup {
    public static void main(String[] args) {
        System.out.println("Starting converter version 6...");

        if (args.length > 0 || GraphicsEnvironment.isHeadless()) {
            // Given command line parameters, don't start the GUI
            if (args.length != 2) {
                System.out.println("Incorrect syntax! See online documentation for help. Closing program...");
                System.exit(0);
            }
            else
            {
                new BECConsole(args);
            }
        } else {
            // Start with a GUI
            System.out.println("No command-line arguments, starting with a GUI...");
            new BECWindow();
        }
    }
}
