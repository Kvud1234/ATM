import javax.swing.*;
import java.awt.*;

class deposite extends JFrame{
    Container d;
    JLabel topic,input;
    JTextField iinput;
    JButton add_more,Confirm,Cancel;

    deposite(){
        setSize(450,400);
        setTitle(("Deposit"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        d = getContentPane();
        d.setLayout(null);

        topic=new JLabel(("Deposit your money Here"));
        topic.setSize(350,40);
        topic.setFont(new Font("",Font.BOLD,20));
        topic.setLocation(100,10);
        d.add(topic);

        input=new JLabel("INPUT");
        input.setSize(300,40);
        input.setFont(new Font("",Font.PLAIN,18));
        input.setLocation(180,80);
        d.add(input);

        iinput=new JTextField();
        iinput.setFont(new Font("",Font.BOLD,16));
        iinput.setSize(210,50);
        iinput.setLocation(110,120);
        d.add(iinput);

        add_more=new JButton("ADD");
        add_more.setFont(new Font("",Font.BOLD,16));
        add_more.setSize(130,30);
        add_more.setLocation(260,200);
        d.add(add_more);

        Confirm=new JButton("CONFIRM");
        Confirm.setFont(new Font("",Font.BOLD,16));
        Confirm.setSize(130,30);
        Confirm.setLocation(260,250);
        d.add(Confirm);

        Cancel=new JButton("CANCEL");
        Cancel.setFont(new Font("",Font.BOLD,16));
        Cancel.setSize(130,30);
        Cancel.setLocation(60,250);
        d.add(Cancel);

        setVisible(true);    }

}
class depo{
    public static void main(String [] args){
        new deposite();
    }
}