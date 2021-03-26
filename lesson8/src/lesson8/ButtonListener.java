package lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private final JTextField in;
    private ExpressionHelper ev;
    private Calculator calc;

    public ButtonListener(JTextField in, ExpressionHelper ev, Calculator calc) {
        this.in = in;
        this.ev = ev;
        this.calc = calc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        StringBuilder stringBuilder = new StringBuilder(in.getText());
        String next = btn.getText();
        if (next.equals("C")){
            in.setText("");
        } else if (next.equals("=")) {
            if (ev.isComputable(stringBuilder.toString())) {
                double result = calc.calculate(stringBuilder.toString());
                in.setText(String.valueOf(result));
            } else {
                WarningDialog wdialog = new WarningDialog("Выражение некорректно!");
            }

        } else if (next.equals("sqrt")) {
            stringBuilder.append(next);
            if (ev.isValid(stringBuilder.toString())){
                in.setText(stringBuilder.toString());
            }
        } else {
            stringBuilder.append(next);
            if (ev.isValid(stringBuilder.toString())){
                in.setText(stringBuilder.toString());
            } else if (ev.isOperatorAtEnd(stringBuilder.toString())) {
                in.setText(stringBuilder.deleteCharAt(stringBuilder.length()-2).toString());
            }
        }
    }
}
