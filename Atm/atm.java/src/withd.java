import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Withdraw extends JFrame implements ActionListener {
    Container W;
    JButton L500, L1000, L2000, L5000, L10000, other;
    JLabel with;
    int current = 100000; // Example balance

    Withdraw() {
        setSize(450, 400);
        setTitle("Withdraw");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        W = getContentPane();
        W.setLayout(null);

        with = new JLabel("Select your Amount");
        with.setLocation(125, 20);
        with.setFont(new Font("", Font.BOLD, 20));
        with.setSize(300, 50);
        with.setForeground(Color.blue);
        W.add(with);

        L500 = new JButton("500");
        L500.setBounds(0, 100, 150, 50);
        L500.setFont(new Font("", Font.BOLD, 20));
        L500.addActionListener(this);
        W.add(L500);

        L1000 = new JButton("1000");
        L1000.setBounds(290, 100, 150, 50);
        L1000.setFont(new Font("", Font.BOLD, 20));
        L1000.addActionListener(this);
        W.add(L1000);

        L2000 = new JButton("2000");
        L2000.setBounds(0, 170, 150, 50);
        L2000.setFont(new Font("", Font.BOLD, 20));
        L2000.addActionListener(this);
        W.add(L2000);

        L5000 = new JButton("5000");
        L5000.setBounds(290, 170, 150, 50);
        L5000.setFont(new Font("", Font.BOLD, 20));
        L5000.addActionListener(this);
        W.add(L5000);

        L10000 = new JButton("10000");
        L10000.setBounds(0, 240, 150, 50);
        L10000.setFont(new Font("", Font.BOLD, 20));
        L10000.addActionListener(this);
        W.add(L10000);

        other = new JButton("Other");
        other.setBounds(290, 240, 150, 50);
        other.setFont(new Font("", Font.BOLD, 20));
        other.addActionListener(this);
        W.add(other);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        int amount = 0;
        if (e.getSource() == L500) amount = 500;
        else if (e.getSource() == L1000) amount = 1000;
        else if (e.getSource() == L2000) amount = 2000;
        else if (e.getSource() == L5000) amount = 5000;
        else if (e.getSource() == L10000) amount = 10000;
        else if (e.getSource() == other) {
            new Other();
            return;
        }

        if (current >= amount) {
            JOptionPane.showMessageDialog(this, "Withdrawal Successful!");
            current -= amount;
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient Balance!");
        }
    }
}

class Other extends JFrame implements ActionListener {
    Container d;
    JLabel topic, inputLabel;
    JTextField iinput;
    JButton confirm, cancel;
    int current = 100000; // Example balance

    Other() {
        setSize(450, 400);
        setTitle("Enter Amount");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        d = getContentPane();
        d.setLayout(null);

        topic = new JLabel("Input the value ");
        topic.setSize(350, 40);
        topic.setFont(new Font("", Font.BOLD, 20));
        topic.setLocation(100, 10);
        d.add(topic);

        inputLabel = new JLabel("INPUT");
        inputLabel.setSize(300, 40);
        inputLabel.setFont(new Font("", Font.PLAIN, 18));
        inputLabel.setLocation(180, 80);
        d.add(inputLabel);

        iinput = new JTextField();
        iinput.setFont(new Font("", Font.BOLD, 16));
        iinput.setSize(210, 50);
        iinput.setLocation(110, 120);
        d.add(iinput);

        confirm = new JButton("CONFIRM");
        confirm.setFont(new Font("", Font.BOLD, 16));
        confirm.setSize(130, 30);
        confirm.setLocation(260, 250);
        confirm.addActionListener(this);
        d.add(confirm);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("", Font.BOLD, 16));
        cancel.setSize(130, 30);
        cancel.setLocation(60, 250);
        cancel.addActionListener(this);
        d.add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            int value = Integer.parseInt(iinput.getText());
            if (current >= value) {
                JOptionPane.showMessageDialog(this, "Withdrawal Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Balance!");
            }
        } else if (e.getSource() == cancel) {
            dispose();
        }
    }
}
