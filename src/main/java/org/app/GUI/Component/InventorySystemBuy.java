package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventorySystemBuy extends JPanel {
    private JList list1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JCheckBox pakaiPoinCheckBox;
    private JComboBox comboBox2;
    private JButton checkoutButton;
    private JButton orderButton;
    private JList list2;
    private MainGUI mainGUI;
    public InventorySystemBuy(MainGUI mainGUi) {
        this.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        this.add(scrollPane1, new GridConstraints(1, 0, 4, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list1 = new JList();
        scrollPane1.setViewportView(list1);
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Name");
        defaultComboBoxModel1.addElement("Category");
        defaultComboBoxModel1.addElement("Price");
        comboBox1.setModel(defaultComboBoxModel1);
        this.add(comboBox1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        this.add(textField1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pakaiPoinCheckBox = new JCheckBox();
        pakaiPoinCheckBox.setHorizontalAlignment(11);
        pakaiPoinCheckBox.setHorizontalTextPosition(2);
        pakaiPoinCheckBox.setText("Pakai Poin?");
        this.add(pakaiPoinCheckBox, new GridConstraints(3, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("ID");
        this.add(label1, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        this.add(comboBox2, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkoutButton = new JButton();
        checkoutButton.setText("Checkout");
        this.add(checkoutButton, new GridConstraints(4, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        orderButton = new JButton();
        orderButton.setText("Order");
        this.add(orderButton, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        this.add(scrollPane2, new GridConstraints(1, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list2 = new JList();
        scrollPane2.setViewportView(list2);

        this.mainGUI = mainGUi;
        userDefinedConfig();
    }

    public void userDefinedConfig() {
        this.setName("Inventory System Buy");


    }


    private ActionListener checkoutButtonAction(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        };
    }

    private ActionListener orderButtonAction(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    // TODO
            }
        };
    }

}
