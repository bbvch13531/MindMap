package Examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImagePanel extends JPanel {

}

class ImageBtn extends JPanel implements ActionListener{

    ImageBtn(){
        ImageIcon prevIcon = new ImageIcon("images/prev.jpg");
        ImageIcon nextIcon = new ImageIcon("images/next.jpg");

        JButton prev = new JButton(prevIcon);
        JButton next = new JButton(nextIcon);

        prev.addActionListener(this);
        next.addActionListener(this);

        prev.setActionCommand("prev");
        next.setActionCommand("next");

        this.add(prev);
        this.add(next);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("prev")){

        }
        else{
            //next
        }

    }
}

public class BtnImageChange extends JFrame{

    public BtnImageChange(){
        super("BtnImageChange");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        ImagePanel imagePanel = new ImagePanel();
        ImageBtn imageBtn = new ImageBtn();

        add(imagePanel,BorderLayout.CENTER);
        add(imageBtn,BorderLayout.SOUTH);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        new BtnImageChange();
    }
}
