BetterEnderChest Converter
==========================

## Introduction
Little program for Minecraft servers that want to install or uninstall the
plugin BetterEnderChest.

This program can convert from the vanilla file format of the Minecraft server to
the format used with BetterEnderChest. This is not stricly necessary, as the
plugin BetterEnderChest can also do that by itself. It may be useful if you want
to extract all Ender Chests from the player files at once.

This program can also convert the BetterEnderChest file format back to the
format of the vanilla Minecraft server. This is useful for server admins that
wish to uninstall BetterEnderChest.

This program is only useable if you have one Ender Chests for each player on
a server. If you use a setup with different Ender Chests for different worlds,
you are out of luck.

## Download
See the Releases tab on the top of this page.

## Compiling
This program requires Java 6, but requires no other dependencies. Just use
`javac` or your favourite IDE.

## Usage (command-line)
If you're running this program on a remote server, you can use the following
command:

`java -jar BetterEnderChestConverter.jar <from/to> <path/to/level.dat/of/main/world>`

For example, you can use the following command to convert all Ender Chests
**from** BetterEnderChest to vanilla:

`java -jar BetterEnderChestConverter.jar from ./world/level.dat`

## Usage (GUI)
The GUI can only be used if your server isn't a headless server. So if your
server is actually just your desktop computer, you can use the GUI. Otherwise,
you have to use the command-line options (see above).

You can open the GUI by double-clicking the JAR file.

## Changelog

* Update 1 - can convert from BetterEnderChest to vanilla.
* Update 2 - can also convert from vanilla to BetterEnderChest. Now on Github.
* Update 3 - added support for Ender Chests saved in plugin folder.
* Update 4 - can now also run without a GUI.
* Update 5 - show popups in GUI, don't write to player files when converting from vanilla to BEC, potentially fix a NullPointerException (if not, you should now get some debug info).
* Update 6 - updated paths to work with latest BetterEnderChest.


