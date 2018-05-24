//package Examples;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
//import java.awt.event.MouseEvent;
//import java.awt.GridLayout;
//import javax.swing.*;
//
//public class ImageDrag extends JPanel
//        implements MouseMotionListener, MouseListener {
//
//    public ImageDrag(){
//        JLabel label = new JLabel("Hello");
//        add(label);
//    }
//    public static void main(String[] args) {
//        /* Use an appropriate Look and Feel */
//        try {
//            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("ImageDrag");
//        frame.setSize(300,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        JComponent newContentPane = new ImageDrag();
//        newContentPane.setLayout(null);
//        newContentPane.setOpaque(true); //content panes must be opaque
//
//        frame.setContentPane(newContentPane);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    // MouseMotionListener methods
//    public void mouseMoved(MouseEvent e) {
//        eventOutput("Mouse moved", e);
//    }
//
//    public void mouseDragged(MouseEvent e) {
//        eventOutput("Mouse dragged", e);
//    }
//    // MouseListener methods
//    public void mousePressed(MouseEvent e) {
//        int x = e.getX();
//        int y = e.getY();
//        this.la
//    }
//
//    public void mouseReleased(MouseEvent e) {
//        eventOutput("Mouse released (# of clicks: "
//                + e.getClickCount() + ")", e);
//    }
//
//    public void mouseEntered(MouseEvent e) {
//        eventOutput("Mouse entered", e);
//    }
//
//    public void mouseExited(MouseEvent e) {
//        eventOutput("Mouse exited", e);
//    }
//
//    public void mouseClicked(MouseEvent e) {
//        eventOutput("Mouse clicked (# of clicks: "
//                + e.getClickCount() + ")", e);
//    }
//}
