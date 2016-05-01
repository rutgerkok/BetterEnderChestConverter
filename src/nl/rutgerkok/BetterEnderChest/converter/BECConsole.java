package nl.rutgerkok.BetterEnderChest.converter;

import java.io.File;

public class BECConsole {
    public BECConsole(String[] startupArgs) {

        // Validate the input
        try {
            validateString(startupArgs[0], "from", "to");

            File levelDat = new File(startupArgs[1]);
            validateLevelDat(levelDat);

            // Convert
            startConversion(startupArgs);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
            System.out.println("Exiting...");
            System.exit(0);
        }

    }

    private void startConversion(String[] startupArgs) {
        // startupArgs MUST BE valid

        boolean toPluginFileFormat = startupArgs[0].equalsIgnoreCase("to");
        File levelDat = new File(startupArgs[1]);

        // Debug
        System.out.println("Debug path:" + levelDat.getAbsoluteFile());
        System.out.println("Debug path2:" + levelDat.getAbsoluteFile().getParentFile());
        System.out.println("Debug path3:" + levelDat.getAbsoluteFile().getParentFile().getParentFile());

        // Chest directory
        File chestDirectory = new File(levelDat.getAbsoluteFile().getParentFile().getParentFile().getPath() + "/plugins/BetterEnderChest/chestData");

        // Player directory
        File playerDirectory = new File(levelDat.getParentFile().getPath() + "/playerdata");

        // Start!
        if (!toPluginFileFormat) {
            new BECConvertDirectoryBECVanilla(chestDirectory, playerDirectory, false);
        } else {
            new BECConvertDirectoryVanillaBEC(chestDirectory, playerDirectory, false);
        }
    }

    /**
     * Makes sure toCheck is in strings (case-insenstive).
     * 
     * @param toCheck
     * @param strings
     * @throws IllegalArgumentException
     *             If toCheck isn't in strings (case-insensitve)
     */
    public void validateString(String toCheck, String... strings) {
        for (String string : strings) {
            if (string.equalsIgnoreCase(toCheck)) {
                return;
            }
        }

        // toCheck is not in the possible values
        throw new IllegalArgumentException(toCheck + " is not a valid value!");
    }

    /**
     * Makes sure that the file is an existing level.dat
     * 
     * @param file
     * @throws IllegalArgumentException
     *             If it is invalid.
     */
    public void validateLevelDat(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file.getAbsolutePath() + " doesn't exist!");
        }

        if (!file.getName().equals("level.dat")) {
            throw new IllegalArgumentException(file.getAbsolutePath() + " is not a level.dat!");
        }
    }
}
