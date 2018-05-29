package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MindMap extends JFrame{
    JSplitPane leftPane,rightPane;
    JPanel left,middle,right;
    JMenuBar menuBar;
    JToolBar toolBar;

    MindMap(){
        setTitle("Mind Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();

    }
    void createMenu(){
        // Create MenuBar
        menuBar = new MenuBar();

        // Create Panels
        left = new LeftPanel();
        right = new RightPanel();
        middle = new MiddlePanel();

        leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        leftPane.setLeftComponent(new JScrollPane(left));
        leftPane.setRightComponent(new JScrollPane(middle));
        rightPane.setLeftComponent(leftPane);
        rightPane.setRightComponent(right);


    }
    class LeftPanel extends JPanel{

    }
    class MiddlePanel extends JPanel{

    }
    class RightPanel extends JPanel{

    }
    class MenuBar extends JMenuBar{
        MenuBar(){
            JMenuItem[]  menuItem = new JMenuItem[7];
            String[] itemTitle = {"새로 만들기","열기","저장","다른 이름으로 저장","닫기","적용","변경"};
            JMenu title = new JMenu("Menu Bar");
            for(int i = 0; i < menuItem.length; i++){
                menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
                menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
                title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
            }
            this.add(title);
            setJMenuBar(menuBar); // 메뉴바를 프레임에 부착.
        }
    }
    public static void main(String[] args){
        new MindMap();
    }
}
