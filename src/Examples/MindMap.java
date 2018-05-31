package Examples;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class LeftPane extends JPanel {
    JLabel la = new JLabel("Hello");
    JLabel label;
    int xpos,ypos, count = 0;
    LeftPane() {

//      setLayout(null);
//      addMouseListener(new MyMouseListener());
//      la.setSize(50, 20);
//      la.setLocation(30, 30);
//      add(la);
//      setVisible(true);
        setLayout(null);

        ImageIcon icon = new ImageIcon("image/img.jpg");
        label = new JLabel(icon);
        MyMouseListener listener = new MyMouseListener();
        label.addMouseListener(listener);
        label.addMouseMotionListener(listener);
        label.setSize(icon.getIconWidth(), icon.getIconWidth());
        label.setLocation(100,100);
        add(label);

//      setSize(300, 300);
        setVisible(true);
    }

    //   class MyMouseListener implements MouseListener {
//
//      public void mousePressed(MouseEvent e) {
//         System.out.println(1111);
//         int x = e.getX();
//         int y = e.getY();
//         la.setLocation(x, y);
//         xpos = x; ypos = y;
//         System.out.println(2222);
//      }
//
//      public void mouseReleased(MouseEvent e) {
//
//      }
//
//      public void mouseClicked(MouseEvent e) {
//      }
//
//      public void mouseEntered(MouseEvent e) {
//      }
//
//      public void mouseExited(MouseEvent e) {
//      }
//   }
    class MyMouseListener extends MouseAdapter {
        int x, y;
        public void mousePressed(MouseEvent e) {
            x = e.getX(); y = e.getY();
        }
        public void mouseDragged(MouseEvent e) {
            int distanceX = e.getX() - x;
            int distanceY = e.getY() - y;
            System.out.println(label.getX()+ distanceX + "," + (label.getY() + distanceY));
            label.setLocation(label.getX()+ distanceX, label.getY() + distanceY);
        }
    }


}
class TextArea extends JPanel{
    JTextArea ta = new JTextArea(7,20);

    TextArea(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.cyan);
        ta.setBackground(Color.cyan);
        add(ta);
        setVisible(true);
    }
}

public class MindMap extends JFrame{
    JSplitPane splitPane;
    JSplitPane splitPane2;
    JLabel imgLabel = new JLabel();
    MindMap() {
        setTitle("Mind Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();

        JToolBar toolbar = new JToolBar();
        JButton btn13 = new JButton("asdasd");
        toolbar.add(btn13);
        add(toolbar,BorderLayout.NORTH);

        setBounds(100, 100, 1000, 500);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);


        TextArea ta = new TextArea();
        LeftPane l = new LeftPane();
        RightPane r = new RightPane();
        setLayout(new BorderLayout(0, 0));
        addMouseListener(l.new MyMouseListener());

        add(splitPane2, "Center");

        setVisible(true);

        splitPane2.setContinuousLayout(true);
        splitPane.setContinuousLayout(true);

        splitPane.setLeftComponent(new JScrollPane(ta));
        splitPane.setRightComponent(new JScrollPane(l));
        splitPane2.setLeftComponent(splitPane);
        splitPane2.setRightComponent(r);

        splitPane.setDividerSize(5);
        splitPane2.setDividerLocation((int) splitPane2.getSize().getWidth() / 2);
        splitPane2.setDividerSize(5);
    }
    void createMenu()
    {
        JMenuBar bar = new JMenuBar();
        JMenuItem[]  menuItem = new JMenuItem[7];
        String[] itemTitle = {"새로 만들기","열기","저장","다른 이름으로 저장","닫기","적용","변경"};

        JMenu title = new JMenu("Menu Bar");
        MenuActionListener listener = new MenuActionListener();
        for(int i = 0; i < menuItem.length; i++){
            menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
            menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
            title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
        }
        bar.add(title); // 메뉴바에 스크린 메뉴 삽입.
        setJMenuBar(bar); // 메뉴바를 프레임에 부착.

    }
    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
            switch(cmd){ // 메뉴 아이템의 종류 구분
                case "새로 만들기" :
                    if(imgLabel.getIcon() != null) return; // 이미 로딩 되이있으면 리턴.
                    imgLabel.setIcon(new ImageIcon("image/Oz.jpg")); break;
                case "열기" :
                    imgLabel.setVisible(false); break;
                case "저장" :
                    imgLabel.setVisible(true); break;
                case "다른 이름으로 저장" :
                    imgLabel.setVisible(true); break;
                case "닫기" :
                    System.exit(0); break;
                case "적용" :
                    imgLabel.setVisible(true); break;
                case "변경" :
                    imgLabel.setVisible(true); break;
            }
        }
    }
    //   void createTool(){
//      JToolBar bar = new JToolBar();
////      JToolItem[]  menuItem = new JMenuItem[7];
//      String[] itemTitle = {"새로 만들기","열기","저장","다른 이름으로 저장","닫기","적용","변경"};
//
//      JToolBar title = new JToolBar("Tool Bar");
//      MenuActionListener listener = new MenuActionListener();
//      for(int i = 0; i < menuItem.length; i++){
//         menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
//         menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
//         title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
//      }
//      bar.add(title); // 메뉴바에 스크린 메뉴 삽입.
//      setJToolBar(bar); // 메뉴바를 프레임에 부착.
//   }
    class RightPane extends JPanel {
        RightPane() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
            X x = new X();
            Y y = new Y();
            H h = new H();
            W w = new W();
            add(x);
            add(y);
            add(h);
            add(w);

            setVisible(true);
        }
    }

    class X extends JPanel {
        X() {

            LeftPane lp = new LeftPane();
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JLabel("X :"));
            add(new JTextField(String.valueOf(lp.xpos),5));
            setVisible(true);
        }

    }

    class Y extends JPanel {
        Y() {
            LeftPane lp = new LeftPane();
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JLabel("Y :"));
            add(new JTextField(String.valueOf(lp.ypos),5));
            setVisible(true);
        }
    }

    class H extends JPanel {
        H() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JLabel("H :"));
            add(new JTextField(5));
            setVisible(true);
        }
    }

    class W extends JPanel {
        W() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(new JLabel("W :"));
            add(new JTextField(5));
            setVisible(true);
        }

    }



    public static void main(String[] args){
        new MindMap();
    }
}