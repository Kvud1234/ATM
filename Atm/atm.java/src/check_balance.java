import javax.swing.*;
import java.awt.*;

class check_balance extends JFrame{
    JFrame j5=new JFrame();
    JLabel bal;
    JTextField balance;
    Container ba;

    check_balance(){
        setSize(450,400);
        setTitle(("Check Balance"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        ba=getContentPane();
        ba.setLayout(null);

        bal=new JLabel("Your Balance :");
        bal.setSize(200,30);
        bal.setLocation(20,150);
        bal.setFont(new Font("",Font.BOLD,20));
        ba.add(bal);

        balance = new JTextField();
        balance.setBounds(220, 150, 150, 30);
        balance.setFont(new Font("", Font.BOLD, 20));
        ba.add(balance);

        setVisible(true);
    }
}
class che{
    public static void main(String [] args0){
        new check_balance();
    }
}