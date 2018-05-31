package Project;
import com.google.gson.Gson;
import java.io.*;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
class Node {
    private String key;
    private String value;
    private List<Node> child;
    public String getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }

    public List<Node> getNodes() {
        return child;
    }

    public void setNodes(List<Node> child) {
        this.child = child;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "key = "+getKey()+", value = "+getValue();
    }
}

public class TestGson {
    TestGson() {
        String input = "{" +
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
        String simpleInput="{\"data\":[\"a\":\"aa\",\"b\":\"bb\",\"c\":\"cc\"]}";
        String simpleInput2="{" +
                "\"key\":\"aa\"," +
                "\"value\":\"aaa\"," +
                "\"child\":[" +
                    "{" +
                    "\"key\":\"ab\"," +
                    "\"value\":\"aab\"" +
                    "}," +
                    "{" +
                    "\"key\":\"ac\"," +
                    "\"value\":\"aac\"" +
                    "}]" +
                "}";
        //            try{
//                gson.newJsonReader(new FileReader("./MindMap.json"));
//            } catch(Exception e){
//                System.err.print(e);
//            }
        try {
            Gson gson = new Gson();
            Node obj = gson.fromJson(simpleInput2, Node.class);
//            System.out.println(gson.toString());
                System.out.println(obj.getNodes());
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        TestGson tg= new TestGson();
    }
}
//https://sites.google.com/site/gson/gson-user-guide