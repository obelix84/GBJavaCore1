package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningDialog {

    private static JDialog dialog;

    public WarningDialog(String message) {
        JFrame f = new JFrame();
        dialog = new JDialog(f , "Замечание", true);
        dialog.setLayout(new BorderLayout());
        JButton b = new JButton ("OK");
        b.addActionListener ( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                WarningDialog.dialog.setVisible(false);
            }
        });
        dialog.add(new JLabel (message), BorderLayout.CENTER);
        dialog.add(b, BorderLayout.SOUTH);

        dialog.setBounds(80, 75, 300, 200);
        dialog.setVisible(true);
    }
}