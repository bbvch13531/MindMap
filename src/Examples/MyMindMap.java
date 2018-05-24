package Examples;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MyMindMap extends JPanel {
    private JSplitPane splitPane1;
    private JSplitPane splitPane2;
    private JList list;
    private String[] MindMapNames = { "계절", "\t봄", "\t여름"};
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public MyMindMap(){
        list = new JList(MindMapNames);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        JScrollPane listScrollPane = new JScrollPane(list);
        JScrollPane listScrollPane1 = new JScrollPane(list);
        JLabel label1 = new JLabel("Label1");
        JLabel label2 = new JLabel("Label2");

        JTextArea txtLog = new JTextArea();
        txtLog.setMaximumSize(new Dimension(400,200));
        splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane1,txtLog);
        splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                listScrollPane, splitPane2);
        splitPane1.setDividerLocation(500);
        splitPane2.setDividerLocation(500);
//        label2.setSize(new Dimension(400,200));
        splitPane2.setEnabled(false);
//        splitPane1.setPreferredSize(new Dimension(400, 200));
    }
    public JSplitPane getSplitPane() {
        return splitPane1;
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("MyMindMap");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //Create menuBar
        JMenuBar myMenuBar = new JMenuBar();
        myMenuBar.setOpaque(true);
        myMenuBar.setBackground(new Color(54, 165, 180));
        myMenuBar.setPreferredSize(new Dimension(1200, 100));

//        SplitPaneDemo splitPaneDemo = new SplitPaneDemo();
        MyMindMap mmm = new MyMindMap();
        frame.setJMenuBar(myMenuBar);
        frame.getContentPane().add(mmm.getSplitPane());

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
