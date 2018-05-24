package Examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorChangeRadioBtn extends JPanel implements ActionListener {

    public ColorChangeRadioBtn() {
        super(new BorderLayout());
        JRadioButton redBtn = new JRadioButton("red");
        redBtn.setActionCommand("red");
        JRadioButton blueBtn = new JRadioButton("blue");
        blueBtn.setActionCommand("blue");

        ButtonGroup group = new ButtonGroup();

        group.add(redBtn);
        group.add(blueBtn);

        redBtn.addActionListener(this);
        blueBtn.addActionListener(this);

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(redBtn);
        radioPanel.add(blueBtn);

        add(radioPanel, BorderLayout.LINE_START);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("blue")) {
            this.setBackground(Color.BLUE);
        }
        else{
            this.setBackground(Color.RED);
        }

    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ColorChangeRadioBtn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ColorChangeRadioBtn();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.setSize(300,300);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
