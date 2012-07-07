package nl.rutgerkok.BetterEnderChest.converter;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BECWindow extends JFrame
{
	private static final long serialVersionUID = 4465999634997228137L;

	public static void main(String[] args) 
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException e) {} 
		catch (InstantiationException e) {} 
		catch (IllegalAccessException e) {} 
		catch (UnsupportedLookAndFeelException e) {}
		
		JFrame frame = new BECWindow();
		frame.setSize(400, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("BetterEnderChest Converter");
		frame.add(new BECPanel());
		frame.setVisible(true);
	}
}
