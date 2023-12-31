package org.app.GUI;

import org.app.DataStore.DataStore;
import org.app.GUI.Component.*;
import org.app.Inventory.Holder.Bill;
import org.app.Plugin.PluginManager;

import javax.swing.*;
import java.awt.event.*;

public class MainGUI extends JFrame{
    private JMenu menu;
    private JMenuItem newTab;
    private JMenuItem closeTabMenu;
    private JMenuItem settingMenu;
    private JButton newTabWithMenu; // TODO : JUST FOR EASIER TESTING PURPOSE, MAYBE DELETE LATER
    private JButton closeTabWithMenu; // TODO : JUST FOR EASIER TESTING PURPOSE, MAYBE DELETE LATER
    private JMenuBar menuBar;
    private TabGUI tabGUI;
    public DataStore dataStore;

    private void setFrameConfig() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
    }

    private void setMenu() {
        menu.add(newTab);
        menu.add(closeTabMenu);
        menu.add(settingMenu);
        menuBar.add(menu);
        menuBar.add(newTabWithMenu);
        menuBar.add(closeTabWithMenu);

        this.setJMenuBar(menuBar);
    }

    private void setTab() {
        tabGUI = new TabGUI();
        this.getContentPane().add(tabGUI);
    }

    private void setActionListener() {
        newTab.addActionListener(newTabHome(this));
        closeTabMenu.addActionListener(closeTab());
        newTabWithMenu.addActionListener(newTabHome(this));
        closeTabWithMenu.addActionListener(closeTab());
        settingMenu.addActionListener(newTabSetting(this));
    }

    private void initComponent() {
        menu = new JMenu("Menu");
        newTab = new JMenuItem("New tab");
        closeTabMenu = new JMenuItem("Close tab");
        settingMenu = new JMenuItem("Setting");
        newTabWithMenu = new JButton("New tab"); // TODO : JUST FOR EASIER TESTING PURPOSE, MAYBE DELETE LATER
        closeTabWithMenu = new JButton("Close tab"); // TODO : JUST FOR EASIER TESTING PURPOSE, MAYBE DELETE LATER
        menuBar = new JMenuBar();
    }

    private void initializeGUIElement() {
        initComponent();
        setMenu();
        setTab();
        setActionListener();

        newTabAction(new HomePage(this)).actionPerformed(null);
        for (Bill bill: dataStore.cashier().billList()) {
            newTabAction(new InventorySystemBuy(this, bill)).actionPerformed(null);
        }
        makeFinishedPanel();
    }

    private void makeFinishedPanel() {
        // TODO : just for testing purpose, delete later
//        newTabAction(new MemberMenu(this)).actionPerformed(null);
//        newTabAction(new MemberRegistration(this)).actionPerformed(null);
//        newTabAction(new SettingGUI(this)).actionPerformed(null);
//        newTabAction(new MemberHistorySelect(this)).actionPerformed(null);
//        newTabAction(new Report()).actionPerformed(null);
//        newTabAction(new InventorySystemMenu(this)).actionPerformed(null);
//        newTabAction(new InventorySystemSell(this)).actionPerformed(null);
//        newTabAction(new MemberList(this)).actionPerformed(null);
    }

    private ActionListener newTabHome(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newTabAction(new HomePage(mainGUI)).actionPerformed(null);
            }
        };
    }

    private ActionListener newTabSetting(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newTabAction(new SettingGUI(mainGUI)).actionPerformed(null);
            }
        };
    }

    public ActionListener newTabAction(JPanel newPanel) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabGUI.createNewTab(newPanel);
            }
        };
    }

    public ActionListener closeTab() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabGUI.removeTab();
            }
        };
    }

    public MainGUI(DataStore dataStore) {
        this.dataStore = dataStore;
        setFrameConfig();
        initializeGUIElement();
        PluginManager.enableAll(this);
    }
}
