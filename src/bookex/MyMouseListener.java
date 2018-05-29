package bookex;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class MyMouseListener extends JFrame{
    MyMouseListener(){
        setTitle("MyMouseListener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        setLayout(null);

        Container c= getContentPane();
        MyPanel myPanel = new MyPanel();
        myPanel.setSize(450,450);
        myPanel.setBackground(Color.YELLOW);

        c.add(myPanel);
        setVisible(true);
    }
    public static void main(String[] args){
        new MyMouseListener();
    }
    class MyListener extends MouseAdapter{
        private JLabel target;

        MyListener(JLabel t){
            this.target = t;
        }
        @Override
        public void mouseClicked(MouseEvent e){
            int x = e.getX();
            int y = e.getY();

            target.setLocation(x,y);
        }
    }
    class MyPanel extends JPanel{

        MyPanel(){

            JLabel hello = new JLabel("Hello!");
            hello.setSize(450,420);
            this.addMouseListener(new MyListener(hello));

            add(hello);
        }
    }
}
