package Project;
import com.google.gson.Gson;
import java.io.*;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
class Node {
    private String text,color;
    private int x,y,width,height;
    private List<Node> child;

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Node> getChild() {
        return child;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setChild(List<Node> child) {
        this.child = child;
    }

    @Override
    public String toString(){
        return "text = "+getText()+", color = "+getColor()+", x = "+getX()+", y = "+getY();
    }
}

public class TestGson {
    TestGson() {
        Gson gson = new Gson();

        try {
//            gson.newJsonReader(new FileReader("./MindMap.json"));
            JsonReader jsonReader = new JsonReader(new FileReader("/Users/kyungyoungheo/IdeaProjects/MindMap/src/Project/MindMap.json"));

                Node obj = gson.fromJson(jsonReader, Node.class);
                System.out.println(obj.getClass());
                List <Node> child = obj.getChild();
                for(int i=0;i<child.size();i++){
                    System.out.println(child.get(i).toString());
                }
            }catch(Exception e){
                System.out.println(e);
        }
    }
    public static void main(String[] args){
        TestGson tg= new TestGson();
    }
}
//https://sites.google.com/site/gson/gson-user-guide