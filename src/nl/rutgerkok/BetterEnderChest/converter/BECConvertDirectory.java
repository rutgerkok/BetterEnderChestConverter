package nl.rutgerkok.BetterEnderChest.converter;

import java.io.File;

public abstract class BECConvertDirectory implements Runnable
{
	public BECConvertDirectory(File chestDirectory, File playerDirectory) {}
	
	public abstract float getProgress();
}
