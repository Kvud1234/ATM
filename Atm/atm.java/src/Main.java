import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Atm extends JFrame implements ActionListener {
    JFrame j1=new JFrame();
    JLabel welcome;
    JButton withraw,deposit,check_balance;
    Container c;

    Atm() {
        setSize(450,400);
        setTitle(("ATM/CDM"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // welcome to atm

        welcome=new JLabel("Welcome to CDB Bank");
        welcome.setSize(300,50);
        welcome.setLocation(85,10);
        welcome.setFont(new Font("", Font.BOLD,25));
        welcome.setForeground(Color.black);
        c.add(welcome);

        // withdraw button

        withraw=new JButton("Withdraw");
        withraw.setSize(170,70);
        withraw.setLocation(0,120);
        withraw.setFont(new Font("",Font.BOLD,20));
        withraw.setBackground(Color.GRAY);
        withraw.addActionListener(this);
        withraw.setForeground(Color.black);
        c.add(withraw);

        // deposite button

        deposit=new JButton("Deposite");
        deposit.setSize(170,70);
        deposit.setLocation(265,120);
        deposit.setFont(new Font("",Font.BOLD,20));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        deposit.setBackground(Color.GRAY);

        c.add(deposit);

        // check balance button

        check_balance=new JButton("Check Balance");
        check_balance.setSize(170,70);
        check_balance.setLocation(0,220);
        check_balance.setFont(new Font("",Font.BOLD,18));
        check_balance.setForeground(Color.black);
        check_balance.addActionListener(this);
        check_balance.setBackground(Color.GRAY);
        c.add(check_balance);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== withraw){
            new Withdraw();
        } else if (e.getSource()==deposit) {
            new deposite();
        }else {
            new check_balance();
        }
    }

}

class main{
    public static void main(String[] args) {
        new Atm();
    }
}
