package bookex;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{
    MyFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("This is MyFrame");
        setSize(500,500);
        Container c= getContentPane();
        c.setLayout(new BorderLayout());

        c.add(new NorthPane(),BorderLayout.NORTH);
        c.add(new SouthPane(),BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args){
        MyFrame frame = new MyFrame();
    }
    class NorthPane extends JPanel{
        NorthPane(){
            setBackground(Color.orange);
            add(new JButton("OK"));
            add(new JButton("Cancel"));
            add(new JButton("Ignore"));
        }
    }
    class SouthPane extends JPanel{
        SouthPane(){
            setLayout(null);
            JLabel lbl = new JLabel("Java Swing");
            lbl.setLocation(100,100);
            lbl.setSize(100,50);
            add(lbl);
        }
    }
}
