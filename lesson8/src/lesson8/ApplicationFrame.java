package lesson8;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    public ApplicationFrame() {
        setTitle("Calculator");
        setBounds(50, 50, 400, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        setLayout(new BorderLayout());

        JPanel top = createTop();
        add(top, BorderLayout.NORTH);

        Component component = top.getComponent(0);
        add(createBottom((JTextField) component), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createBottom(JTextField in) {
        JPanel bottom = new JPanel();

        bottom.setLayout(new GridLayout(6, 3));

        ExpressionHelper ev = new ExpressionHelper();
        Calculator calculator = new Calculator(ev);

        ButtonListener buttonListener = new ButtonListener(in, ev, calculator);
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            bottom.add(btn);
        }

        JButton minus = new JButton("-");
        minus.addActionListener(buttonListener);
        bottom.add(minus);

        JButton plus = new JButton("+");
        plus.addActionListener(buttonListener);
        bottom.add(plus);

        JButton multiply = new JButton("*");
        multiply.addActionListener(buttonListener);
        bottom.add(multiply);

        JButton divide = new JButton("/");
        divide.addActionListener(buttonListener);
        bottom.add(divide);

        JButton point = new JButton(".");
        point.addActionListener(buttonListener);
        bottom.add(point);

        JButton sqrt = new JButton("sqrt");
        sqrt.addActionListener(buttonListener);
        bottom.add(sqrt);

        JButton clear = new JButton("C");
        clear.addActionListener(buttonListener);
        bottom.add(clear);

        JButton calc = new JButton("=");
        calc.addActionListener(buttonListener);
        bottom.add(calc);

        return bottom;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        JTextField in = new JTextField();
        in.setEditable(false);

        top.add(in, BorderLayout.NORTH);

        return top;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("Калькулятор"));
        menu.add(new JMenuItem("О программе")).addActionListener(new MenuButtonListener());
        menu.add(new JMenuItem("Выход")).addActionListener(new MenuButtonListener());
        return menuBar;
    }
}
