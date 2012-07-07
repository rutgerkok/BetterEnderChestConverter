package nl.rutgerkok.BetterEnderChest.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

import javax.swing.JOptionPane;

import net.minecraftwiki.wiki.NBTClass.Tag;

public class BECConvertDirectoryVanillaBEC extends BECConvertDirectory
{
	private Thread thread; 
	private File chestDirectory;
	private File playerDirectory;
	private float progress;
	
	public BECConvertDirectoryVanillaBEC(File chestDirectory, File playerDirectory)
	{
		super(chestDirectory, playerDirectory);
		
		System.out.println(chestDirectory.getPath());
		System.out.println(playerDirectory.getPath()); 
		
		this.chestDirectory = chestDirectory;
		this.playerDirectory = playerDirectory;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public float getProgress()
	{
		return progress;
	}
	
	public void run()                       
    {                              
		//Get all files in player directory
		String[] files = playerDirectory.list(new FilenameFilter() 
			{
				@Override
				public boolean accept(File dir, String fileName) 
				{
					return fileName.endsWith(".dat");
				}
			});
		
		//check if there are files
		if(files==null||files.length==0)
		{
			JOptionPane.showMessageDialog(null, "Found no player files in world directory. Did you select the level.dat of your main world?");
			System.exit(0);
			return;
		}
		
		//create chest directory
		chestDirectory.mkdirs();
		
		//convert each file
		for (int i = 0; i < files.length; i++)
		{                
			System.out.println("Converting "+files[i]);
			try 
			{	//convert
				File chestFile = new File(chestDirectory+"/"+files[i]);
				File playerFile = new File(playerDirectory+"/"+files[i]);
				
				Tag player = Tag.readFrom(new FileInputStream(playerFile));
				
				Tag[] tagsInEnderChestFile = new Tag[2];
				tagsInEnderChestFile[0] = new Tag("Inventory", Tag.Type.TAG_Compound); //new inventory list tag containing TAG_Compound
				tagsInEnderChestFile[1] = new Tag(Tag.Type.TAG_End, null, null);
				
				Tag enderItems = player.findTagByName("EnderItems");
				if(enderItems!=null)
				{	
					Tag[] itemList = (Tag[]) enderItems.getValue();
					for(Tag itemStack: itemList)
					{	//convert all stacks one by one
						tagsInEnderChestFile[0].addTag(itemStack);
					}
					player.removeSubTag(player.findTagByName("EnderItems"));//remove the old tag
				}
				
				//make a Tag_Compound
				Tag enderChest = new Tag(Tag.Type.TAG_Compound, "Player", tagsInEnderChestFile);
				
				//save both
				player.writeTo(new FileOutputStream(playerFile));
				enderChest.writeTo(new FileOutputStream(chestFile));
			}
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(null, "Cannot convert file! \n\n"+e.getMessage()+"\n\nI said you should make a backup...");
				System.out.println("Cannot convert file: "+e.getMessage());
				e.printStackTrace();
			}

			progress = ((float)i)/((float)files.length);//for progress bar
			
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) {}
		}
		
		progress = 1;
		JOptionPane.showMessageDialog(null, "Converted. The player files don't contain a EnderInventory anymore, they have been moved to a separate file.");
		System.exit(0);
    }
}
