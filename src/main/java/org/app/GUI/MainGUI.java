package org.app.GUI;

import org.app.GUI.Component.HomePage;
import org.app.GUI.Component.MemberMenu;
import org.app.GUI.Component.MemberRegistration;
import org.app.GUI.Component.Setting;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.reflect.Member;

public class MainGUI extends JFrame{
    private JMenu menu;
    private JMenuItem newTab;
    private JMenuItem closeTabMenu;
    private JMenuItem settingMenu;
    private JButton newTabWithMenu; // TODO : JUST FOR EASIER TESTING PURPOSE, MAYBE DELETE LATER
    private JButton closeTabWithMenu; // TODO : JUST FOR EASIER TESTING PURPOSE, MAYBE DELETE LATER
    private JMenuBar menuBar;
    private TabGUI tabGUI;

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
        settingMenu.addActionListener(newTabSetting());
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
        newTabAction(new MemberMenu(this)).actionPerformed(null);
        newTabAction(new MemberRegistration()).actionPerformed(null);
        newTabAction(new Setting()).actionPerformed(null);
    }

    private ActionListener newTabHome(MainGUI frame) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newTabAction(new HomePage(frame)).actionPerformed(null);
            }
        };
    }

    private ActionListener newTabSetting() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newTabAction(new Setting()).actionPerformed(null);
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

    public MainGUI() {
        setFrameConfig();
        initializeGUIElement();
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}