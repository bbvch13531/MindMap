package Project;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Project.EventListener;
import org.w3c.dom.Text;

public class MindMap extends JFrame{

    JSplitPane leftPane,rightPane;
    JPanel textEditor,draw,attribute;
    JMenuBar menuBar;
    JToolBar toolBar;
    Node root;

    MindMap(){
        setTitle("Mind Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root= new Node();
        createLayout();
        setSize(1000,500);
        setLayout(new BorderLayout());

//        add(menuBar,"North");
        add(toolBar,"North");
        add(rightPane);
        setVisible(true);
    }
    void createLayout(){
        Dimension min = new Dimension(50, 50);
        // Create MenuBar
        menuBar = new MenuBar(this);

        // Create ToolBar
        toolBar = new ToolBar();
        // Create Panels
        draw = new DrawPanel();
        textEditor = new TextEditor(draw);
        attribute = new Attribute();

        leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        leftPane.setContinuousLayout(true);
        rightPane.setContinuousLayout(true);

        leftPane.setLeftComponent(new JScrollPane(textEditor));
        leftPane.setRightComponent(new JScrollPane(draw));

        rightPane.setLeftComponent(leftPane);
        rightPane.setRightComponent(attribute);

        rightPane.getRightComponent().setPreferredSize(min);

        rightPane.setDividerLocation(0.8);
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
        JPanel drawPanel;
        TextEditor(JPanel drawPanel){
            this.drawPanel=drawPanel;
            JTextArea txtArea = new JTextArea(20,20);
            txtArea.setTabSize(4);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            JButton apply= new JButton("적용");
            MyMouse mouse = new MyMouse(txtArea,drawPanel);
            apply.addMouseListener(mouse);

            add(txtArea);
            add(apply);
            setVisible(true);

        }
    }
    class DrawPanel extends JPanel{
        JLabel label;
        DrawPanel(){
            setLayout(null);
            label = new JLabel("hello");
            label.setSize(100,50);
            label.setLocation(200,200);
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
    class MyMouse extends MouseAdapter{
        JTextArea textArea;
        JPanel drawPanel;
        MyMouse(JTextArea t, JPanel p){
            this.textArea=t;
            this.drawPanel=p;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            int head=0,tail=0;
            String rawText=null;
//            System.out.println(textArea.getText());
            JLabel node1 = new JLabel(textArea.getText());
            node1.setLocation(50,50);
            node1.setSize(50,30);
            drawPanel.add(node1);
            drawPanel.setVisible(true);

            //여기에 text to Gson 을 구현
            Node parent, cur;
            parent=cur=root;
            int j=-1;
            for(int i=0;i<textArea.getLineCount();i++){
                parent=root;
                Node data1=new Node();
                try{
                    head = textArea.getLineStartOffset(i);
                    tail = textArea.getLineEndOffset(i);
                    rawText=textArea.getText(head,tail-head);
                    StringBuffer buf=new StringBuffer(rawText);
                    buf=buf.deleteCharAt(buf.length()-1);
                    rawText= new String(buf);

                } catch(Exception ex){
                    System.err.print("lineOffset Exception");
                }
                // 1.textArea에서 Line마다 text가져옴
                // 2. 가져온 text로 data1.setText()
                // 3. Node tp Gson

                data1.setColor("0xff");
                data1.setX(i*50);
                data1.setY(i*100);
                data1.setHeight(50);
                data1.setWidth(100);

                System.out.printf("head: %d, tail: %d, len: %d %s\n",head,tail,rawText.length(),rawText);
//                data1.setText(rawText);
//                root.addChild(data1);

                // tab 갯수 count해서 알맞은 깊이에 Node 추가
                if(!rawText.contains("\t")) j++;
                while(rawText.contains("\t")) {
                    cur = parent.getChild().get(j);

                    StringBuffer buf = new StringBuffer(rawText);
                    buf.deleteCharAt(0);
                    rawText = new String(buf);
                    parent=cur;
                }
                data1.setText(rawText);
                parent.addChild(data1);
                
            }
            Gson gson=new Gson();
            String json = gson.toJson(root);
            System.out.println(json);
        }
    }
}
//  JSON parsing using gson
//  https://stackoverflow.com/questions/16377754/parse-json-file-using-gson