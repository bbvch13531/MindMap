package Project;

import java.awt.*;
import javax.swing.*;
import com.google.gson.Gson;
import java.io.*;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class MindMap extends JFrame{
    JSplitPane leftPane,rightPane;
    JPanel textEditor,draw,attribute;
    JMenuBar menuBar;
    JToolBar toolBar;

    MindMap(){
        setTitle("Mind Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu();
        setSize(1000,500);
        setLayout(new BorderLayout());

        add(menuBar,"North");
        add(rightPane);
        setVisible(true);
    }
    void createMenu(){
        // Create MenuBar
        menuBar = new MenuBar(this);

        // Create Panels
        textEditor = new TextEditor();
        attribute = new Attribute();
        draw = new DrawPanel();

        leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        leftPane.setLeftComponent(new JScrollPane(textEditor));
        leftPane.setRightComponent(new JScrollPane(draw));
        rightPane.setLeftComponent(leftPane);
        rightPane.setRightComponent(attribute);

        leftPane.setContinuousLayout(true);
        rightPane.setContinuousLayout(true);

        leftPane.setDividerSize(5);
        rightPane.setDividerSize(5);

        System.out.println("added");
    }
    class TextEditor extends JPanel{
        TextEditor(){
            JTextArea txtArea = new JTextArea(20,20);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(txtArea);
            setVisible(true);
        }
    }
    class DrawPanel extends JPanel{
        JLabel label;
        DrawPanel(){
            setLayout(null);
            label = new JLabel("hello");
            add(label);
            setVisible(true);
        }
    }
    class Attribute extends JPanel{
        JLabel label;
        Attribute(){
            setLayout(null);
            label = new JLabel("hello");
            add(label);
            setVisible(true);
        }
    }
    class MenuBar extends JMenuBar{
        JFrame f;
        MenuBar(JFrame f){
            this.f = f;
            JMenuItem[]  menuItem = new JMenuItem[7];
            String[] itemTitle = {"새로 만들기","열기","저장","다른 이름으로 저장","닫기","적용","변경"};
            JMenu title = new JMenu("메뉴");
            for(int i = 0; i < menuItem.length; i++){
                menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
//                menuItem[i].addActionListener(listener); // 메뉴아이템에 액션 리스너 등록.
                title.add(menuItem[i]);// 메뉴 아이템을 스크린 메뉴에 삽입
            }
            this.add(title);
            f.setJMenuBar(this); // 메뉴바를 프레임에 부착.
            setVisible(true);
        }
    }
    public static void main(String[] args){
        new MindMap();
    }

    class testGson{

        testGson(){
            String input="{"+
                    "\"data\":[" +
                    "{" +
                    "\"text\":\"계절\"," +
                    "\"child\":[" +
                    "{\"text\":\"여름\"," +
                    "\"child\":[" +
                    "{\"text\":\"태풍\",\"child\":[{}]}," +
                    "{\"text\":\"장마\",\"child\":[{}]}" +
                    "]" +
                    "}" +
                    "]" +
                    "}" +
                    "]";

//            try{
//                gson.newJsonReader(new FileReader("./MindMap.json"));
//            } catch(Exception e){
//                System.err.print(e);
//            }
            Object obj = new Gson().fromJson(input,Object.class);
            System.out.println(obj);
        }

    }
}
//  JSON parsing using gson
//  https://stackoverflow.com/questions/16377754/parse-json-file-using-gson
