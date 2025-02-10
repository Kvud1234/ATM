
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Atm extends JFrame implements ActionListener {
    private int balance;
    private JLabel welcome;
    private JButton withdraw, deposit, checkBalance;
    private Container c;

    Atm(int initialBalance) {
        this.balance = initialBalance;

        setSize(450, 400);
        setTitle("ATM/CDM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Welcome Label
        welcome = new JLabel("Welcome to CDB Bank");
        welcome.setBounds(85, 10, 300, 50);
        welcome.setFont(new Font("", Font.BOLD, 25));
        welcome.setForeground(Color.black);
        c.add(welcome);

        // Withdraw Button
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(0, 120, 170, 70);
        withdraw.setFont(new Font("", Font.BOLD, 20));
        withdraw.setBackground(Color.GRAY);
        withdraw.addActionListener(this);
        withdraw.setForeground(Color.black);
        c.add(withdraw);

        // Deposit Button
        deposit = new JButton("Deposit");
        deposit.setBounds(265, 120, 170, 70);
        deposit.setFont(new Font("", Font.BOLD, 20));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        deposit.setBackground(Color.GRAY);
        c.add(deposit);

        // Check Balance Button
        checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(0, 220, 170, 70);
        checkBalance.setFont(new Font("", Font.BOLD, 18));
        checkBalance.setForeground(Color.black);
        checkBalance.addActionListener(this);
        checkBalance.setBackground(Color.GRAY);
        c.add(checkBalance);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            new Withdraw(this);
        } else if (e.getSource() == deposit) {
            new Deposit(this);
        } else {
            new CheckBalance(this);
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }
}

// Deposit Page
class Deposit extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirm, cancel;
    private Atm atm;

    Deposit(Atm atm) {
        this.atm = atm;

        setSize(450, 300);
        setTitle("Deposit");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container d = getContentPane();
        d.setLayout(null);

        JLabel topic = new JLabel("Deposit Money");
        topic.setBounds(150, 20, 200, 30);
        topic.setFont(new Font("", Font.BOLD, 20));
        d.add(topic);

        JLabel inputLabel = new JLabel("Amount:");
        inputLabel.setBounds(80, 80, 100, 30);
        inputLabel.setFont(new Font("", Font.PLAIN, 18));
        d.add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(180, 80, 150, 30);
        d.add(inputField);

        confirm = new JButton("Confirm");
        confirm.setBounds(260, 150, 100, 30);
        confirm.addActionListener(this);
        d.add(confirm);

        cancel = new JButton("Cancel");
        cancel.setBounds(60, 150, 100, 30);
        cancel.addActionListener(this);
        d.add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            try {
                int amount = Integer.parseInt(inputField.getText());
                atm.setBalance(atm.getBalance() + amount);
                JOptionPane.showMessageDialog(this, "Deposit Successful!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Amount!");
            }
        } else {
            dispose();
        }
    }
}

// Withdraw Page
class Withdraw extends JFrame implements ActionListener {
    private Atm atm;
    private JButton L500, L1000, L2000, L5000, L10000, other;

    Withdraw(Atm atm) {
        this.atm = atm;

        setSize(450, 300);
        setTitle("Withdraw");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container W = getContentPane();
        W.setLayout(null);

        JLabel with = new JLabel("Select Amount");
        with.setBounds(150, 20, 200, 30);
        with.setFont(new Font("", Font.BOLD, 20));
        W.add(with);

        L500 = createButton("500", 0, 70, W);
        L1000 = createButton("1000", 290, 70, W);
        L2000 = createButton("2000", 0, 140, W);
        L5000 = createButton("5000", 290, 140, W);
        L10000 = createButton("10000", 0, 210, W);
        other = createButton("Other", 290, 210, W);

        setVisible(true);
    }

    private JButton createButton(String text, int x, int y, Container container) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 40);
        button.setFont(new Font("", Font.BOLD, 16));
        button.addActionListener(this);
        container.add(button);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        int amount = 0;
        if (e.getSource() == L500) amount = 500;
        else if (e.getSource() == L1000) amount = 1000;
        else if (e.getSource() == L2000) amount = 2000;
        else if (e.getSource() == L5000) amount = 5000;
        else if (e.getSource() == L10000) amount = 10000;
        else if (e.getSource() == other) {
            new Other(atm);
            return;
        }

        if (atm.getBalance() >= amount) {
            atm.setBalance(atm.getBalance() - amount);
            JOptionPane.showMessageDialog(this, "Withdrawal Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient Balance!");
        }
    }
}

// Other Amount Withdraw
class Other extends JFrame implements ActionListener {
    private JTextField inputField;
    private Atm atm;

    Other(Atm atm) {
        this.atm = atm;

        setSize(300, 200);
        setTitle("Enter Amount");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container d = getContentPane();
        d.setLayout(new FlowLayout());

        inputField = new JTextField(10);
        d.add(inputField);

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        d.add(confirm);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int amount = Integer.parseInt(inputField.getText());
            if (atm.getBalance() >= amount) {
                atm.setBalance(atm.getBalance() - amount);
                JOptionPane.showMessageDialog(this, "Withdrawal Successful!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Balance!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Amount!");
        }
    }
}

// checkbalance

// Check Balance Page
class CheckBalance extends JFrame {
    CheckBalance(Atm atm) {
        setSize(300, 150);
        setTitle("Balance Inquiry");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel balanceLabel = new JLabel("Current Balance: " + atm.getBalance());
        balanceLabel.setFont(new Font("", Font.BOLD, 18));
        c.add(balanceLabel);

        setVisible(true);
    }
}


public class Main {
    public static void main(String[] args) {
        new Atm(5000);
    }
}
