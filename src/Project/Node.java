package Project;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String text,color;
    private int x,y,width,height;
    private ArrayList<Node> child;
    Node(){
        child=new ArrayList<>();
    }
    Node(String text){
        this.text=text;
        child=new ArrayList<>();
    }
    public String getText() { return text; }

    public String getColor() { return color; }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public ArrayList<Node> getChild(){ return this.child; }

    public void setText(String text) { this.text = text; }

    public void setColor(String color) { this.color = color; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void setHeight(int height) { this.height = height; }

    public void setWidth(int width) { this.width = width; }

    public void addChild(Node child) { this.child.add(child); }
    @Override
    public String toString(){
        return "text = "+getText()+", color = "+getColor()+", x = "+getX()+", y = "+getY();
    }
}
