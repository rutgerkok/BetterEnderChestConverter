package nl.rutgerkok.BetterEnderChest.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

import javax.swing.JOptionPane;

import net.minecraftwiki.wiki.NBTClass.Tag;

public class BECConvertDirectoryBECVanilla extends BECConvertDirectory {
    private Thread thread;
    private File chestDirectory;
    private File playerDirectory;
    private float progress;

    public BECConvertDirectoryBECVanilla(File chestDirectory, File playerDirectory) {
        super(chestDirectory, playerDirectory);

        System.out.println(chestDirectory.getPath());
        System.out.println(playerDirectory.getPath());

        this.chestDirectory = chestDirectory;
        this.playerDirectory = playerDirectory;

        thread = new Thread(this);
        thread.start();
    }

    public float getProgress() {
        return progress;
    }

    public void run() {
        String[] files = chestDirectory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String fileName) {
                return fileName.endsWith(".dat");
            }
        });

        // check if there are files
        if (files == null || files.length == 0) {
            JOptionPane.showMessageDialog(null, "Found no chest files in server directory. Did you select the level.dat of your main world?");
            System.exit(0);
            return;
        }

        for (int i = 0; i < files.length; i++) {
            System.out.println("Converting " + files[i]);
            try { // convert
                File chestFile = new File(chestDirectory + "/" + files[i]);
                File playerFile = new File(playerDirectory + "/" + files[i]);

                if (playerFile.exists()) {
                    Tag main = Tag.readFrom(new FileInputStream(chestFile));
                    Tag enderInventory = main.findTagByName("Inventory");
                    Tag player = Tag.readFrom(new FileInputStream(playerFile));

                    if (player.findTagByName("EnderItems") != null)
                        player.removeSubTag(player.findTagByName("EnderItems"));

                    if (enderInventory.findTagByName(null) != null) { // only if
                                                                      // the
                                                                      // enderInventory
                                                                      // contains
                                                                      // a tag
                        player.addTag(new Tag(Tag.Type.TAG_List, "EnderItems", enderInventory.getValue()));

                        player.writeTo(new FileOutputStream(playerFile));
                    }

                } else {
                    System.out.println("Cannot convert the inventory " + files[i] + " because there is no player with that name.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cannot convert file " + files[i] + "! \n\n" + e.getMessage() + "\n\nI said you should make a backup...");
                System.out.println("Cannot convert file " + files[i] + ": " + e.getMessage());
                e.printStackTrace();
            }

            progress = ((float) i) / ((float) files.length);// for progress bar

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }

        progress = 1;
        JOptionPane.showMessageDialog(null, "Converted. Kept old chest files as a backup.");
        System.exit(0);
    }
}
