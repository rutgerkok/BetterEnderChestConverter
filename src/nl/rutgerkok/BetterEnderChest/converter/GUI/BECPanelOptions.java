package nl.rutgerkok.BetterEnderChest.converter.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class BECPanelOptions extends JPanel implements ActionListener {

    private static final long serialVersionUID = 6668701529931093311L;
    private BECPanel mainPanel;
    
    private JRadioButton serverRootOption;
    private JRadioButton pluginFolderOption;

    public BECPanelOptions(BECPanel mainPanel) {
        this.mainPanel = mainPanel;

        add(new JLabel("Where is the chests folder?"));
        
        serverRootOption = new JRadioButton();
        serverRootOption.setText("server root");
        serverRootOption.setSelected(mainPanel.useServerRoot);
        serverRootOption.addActionListener(this);
        add(serverRootOption);
        
        pluginFolderOption = new JRadioButton();
        pluginFolderOption.setText("plugin folder");
        pluginFolderOption.setSelected(!mainPanel.useServerRoot);
        pluginFolderOption.addActionListener(this);
        add(pluginFolderOption);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == serverRootOption) {
            // Server root selected
            mainPanel.useServerRoot = true;
        } else {
            // Plugin folder selected
            mainPanel.useServerRoot = false;
        }
        
        serverRootOption.setSelected(mainPanel.useServerRoot);
        pluginFolderOption.setSelected(!mainPanel.useServerRoot);
    }
}
