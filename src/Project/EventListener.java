package Project;

import javax.swing.*;
import java.awt.event.*;

public class EventListener {

    class ApplyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {

            super.mouseClicked(e);
        }
    }
    class MenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand(); // 사용자가 선택한 메뉴아이템의 문자열 리턴.
            switch (cmd) { // 메뉴 아이템의 종류 구분
                case "새로 만들기":
//                    if (imgLabel.getIcon() != null)
//                        return; // 이미 로딩 되이있으면 리턴.
                    break;
                case "열기":

                    break;
                case "저장":

                    break;
                case "다른 이름으로 저장":

                    break;
                case "닫기":
                    System.exit(0);
                    break;
                case "적용":

                    break;
                case "변경":

                    break;
            }
        }
    }
}