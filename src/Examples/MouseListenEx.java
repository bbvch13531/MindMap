package Examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseListenEx extends JFrame{
    JLabel label = new JLabel("hello");
    JLabel img = new JLabel();

    MouseListenEx(){
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        img.setIcon(new ImageIcon("images/Bird.gif"));
        c.setLayout(null);
        label.setSize(50,20);
        label.setLocation(30,30);
        c.add(img);
        setSize(300,300);
        setVisible(true);
    }

    class MyMouseListener implements MouseListener, MouseMotionListener{
        public void mousePressed(MouseEvent e){
//            int x = e.getX();
//            int y = e.getY();
//            label.setLocation(x,y);
        }
        public void mouseReleased(MouseEvent e){

        }
        public void mouseClicked(MouseEvent e){

        }
        public void mouseEntered(MouseEvent e){

        }
        public void mouseExited(MouseEvent e){

        }
        public void mouseDragged(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            label.setLocation(x,y);
            System.out.println(x+" , "+y);
        }
        public void mouseMoved(MouseEvent e){}
    }
    public static void main(String[] args){
        new MouseListenEx();
    }
}
