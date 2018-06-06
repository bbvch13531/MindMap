package Project;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FuncActionListener implements ActionListener {

    JTextArea textArea;
    MindMap mindMap;
    FileDialog mSave, mOpen;
    Node root;
    static boolean isSaved=false;
    FuncActionListener(MindMap m,JTextArea t,Node root){
        this.textArea=t;
        this.mindMap=m;
        this.root=root;
        mSave = new FileDialog(mindMap, "저장", FileDialog.SAVE);
        mOpen = new FileDialog(mindMap, "열기", FileDialog.LOAD);
    }
    void setRoot(Node root){
        this.root=root;
    }
    public void actionPerformed(ActionEvent e) {
        String data;
        String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
        switch (cmd) { // 메뉴 아이템의 종류 구분
            case "새로 만들기":
//                textArea.setText("");
//                setTitle("메모장");
//                flag = 0;
//                setBounds(100, 100, 1000, 500);
                // 추후에 다시 수정 필요함.
                break;
            case "열기":
                mOpen.setVisible(true);
                data = mOpen.getDirectory() + mOpen.getFile();
                try {
                    String str = "";
                    FileReader fr = new FileReader(data);
                    BufferedReader br = new BufferedReader(fr);

                    textArea.setText(""); // 일단 초기화
                    while ((str = br.readLine()) != null) { // str에 남아둔 내용이 null 이
                        // 아니면..

                        textArea.append(str); // str의 내용을 추가
                        textArea.append("\r\n"); // readline은 개행을 못하니 개행까지 직접해준다.
                    }

                    br.close();
                    String Filename = mOpen.getFile();
//                    setTitle(Filename);
                    isSaved = true;
                } catch (Exception e1) {
                }
                break;
            case "저장":
                if (isSaved == false) {
                    mSave.setVisible(true);
                    data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와
                    // 파일명을 얻는다.
                    try {
                        FileWriter fw = new FileWriter(data + ".json"); // Save json format
                        BufferedWriter bw = new BufferedWriter(fw);
                        Gson gson=new Gson();
                        String json = gson.toJson(root);

                        for (int i = 0; i < json.length(); i++) {
                            if (json.charAt(i) == '\n') {
                                System.out.println("find");
                                bw.newLine();
                            } else
                                bw.write(json.charAt(i)); // Textarea 에 bw객체에 있는 내.  용을
                            // 넣는다.
                        }

                        bw.close();
                        String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고..
//                        setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다..
                    } catch (Exception e1) {

                    }
                    isSaved=true;
                }

                else if (isSaved == true) {
                    data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와
                    // 파일명을 얻는다.

                    try {
                        FileWriter fw = new FileWriter(data + ".txt"); // txt파일로
                        // 저장한다.
                        BufferedWriter bw = new BufferedWriter(fw);

                        String str = textArea.getText();
                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == '\n') {
                                System.out.println("find");
                                bw.newLine();
                            } else
                                bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을
                            // 넣는다.
                        }
                        bw.close();
                    } catch (Exception e2) {

                    }

                }

                break;
            case "다른 이름으로 저장":
                mSave.setVisible(true);
                data = mSave.getDirectory() + mSave.getFile(); // 파일의 디렉토리 정보와 파일명을
                // 얻는다.
                try {
                    FileWriter fw = new FileWriter(data + ".text"); // txt파일로 저장한다.
                    BufferedWriter bw = new BufferedWriter(fw);

                    String str = textArea.getText();
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '\n') {
                            System.out.println("find");
                            bw.newLine();

                        } else
                            bw.write(str.charAt(i)); // Textarea 에 bw객체에 있는 내용을 넣는다.
                    }

                    bw.close();
                    String Filename = mSave.getFile(); // 저장할 파일의 이름을 넣고,
//                    setTitle(Filename + ".txt"); // 프레임 명을 파일명으로 바꾼다.
                } catch (Exception e1) {

                }
                break;
            case "닫기":
                System.exit(0);
                break;
            case "적용":
//                imgLabel.setVisible(true);
                break;
            case "변경":
//                imgLabel.setVisible(true);
                break;
        }


    }
}