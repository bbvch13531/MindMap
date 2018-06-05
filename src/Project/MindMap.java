package Project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import com.google.gson.Gson;
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

        createLayout();
        setSize(1000,500);
        setLayout(new BorderLayout());

//        add(menuBar,"North");
        add(toolBar,"North");
        add(rightPane);
        setVisible(true);
    }
    void createLayout(){
        // Create MenuBar
        menuBar = new MenuBar(this);

        // Create ToolBar
        toolBar = new ToolBar();
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
    class ToolBar extends JToolBar{
        String[] itemTitle = { "새로 만들기", "열기", "저장", "다른 이름으로 저장 ", "닫기", "적용", "변경" };
        JButton[] barItem = new JButton[7];
        ToolBar(){
            for(int i=0; i <barItem.length ; i++) {
                barItem[i] = new JButton(itemTitle[i]); // ¸Þ´º¾ÆÀÌÅÛ »ý¼º
//            barItem[i].addActionListener(listener);
                this.add(barItem[i]);// ¸Þ´º ¾ÆÀÌÅÛÀ» ½ºÅ©¸° ¸Þ´º¿¡ »ðÀÔ
            }
        }
//        add(this, BorderLayout.NORTH);
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
        JPanel x,y,height,width;
        Attribute(){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            x=createPanels("X");
            y=createPanels("Y");
            height=createPanels("Height");
            width=createPanels("Width");
            add(x);
            add(y);
            add(height);
            add(width);
            setVisible(true);
//            System.out.println("Label added in Attribute pane");
        }
        JPanel createPanels(String name){
            JPanel panel = new JPanel();
            JTextField status = new JTextField(10);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel Pos = new JLabel(name);
            Pos.setFont(new Font("a", Font.PLAIN, 20));
            panel.add(Pos, FlowLayout.LEFT);
            panel.add(status,BorderLayout.EAST);
            setVisible(true);
            return panel;
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
