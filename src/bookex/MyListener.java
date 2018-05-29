package bookex;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class MyListener extends JFrame{
    MyListener() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("This is MyListener");
        setSize(500, 500);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        add(new MyPanel(this));

        setVisible(true);
    }
    public static void main(String[] args){
        new MyListener();
    }
}
class MyActionListener implements ActionListener{
    JFrame f;
    MyActionListener(JFrame f){
        this.f=f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        if(btn.getText().equals("Action")){
            btn.setText("액션");
            f.setTitle("액션");
        }
        else{
            btn.setText("Action");
            f.setTitle("Action");
        }
    }
}
class MyPanel extends JPanel{
    MyPanel(JFrame f){
        setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener(f));
        add(btn);
    }
}