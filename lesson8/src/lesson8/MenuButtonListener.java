package lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menuItem = (JMenuItem) e.getSource();
        if (menuItem.getText().equals("О программе")) {
            WarningDialog wdialog = new WarningDialog("Калькулятор простая версия 1.0");
        } else {
            System.exit(1);
        }
    }
}
