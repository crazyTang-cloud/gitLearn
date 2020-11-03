package UI.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScorePage {
    JFrame frame = new JFrame();
    JPanel panel;
    JButton back = new JButton("退出");
    JLabel score = new JLabel();
    public void show(int n){
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon(this.getClass().getResource("./source/imgs/背景2.jpg"));
        JLabel imageJLabel = new JLabel(backgroundIcon);

        // 获取屏幕大小
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        // 设置窗体信息
        int frameWidth = 800;
        int frameHeight = 550;
        int frameX = (screenWidth - frameWidth) / 2;
        int frameY = (screenHeight - frameHeight) / 2;
        // 将窗体设置在屏幕中央
        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        imageJLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.getLayeredPane().add(imageJLabel, Integer.MIN_VALUE);

        back.setFont(new Font("Dialog", Font.BOLD, 25));
        back.setBounds(600, 400, 127, 64);
        back.setBackground(new Color(224, 255, 255));
        panel.add(back);

        score.setBounds(170, 121, 250, 37);
        score.setText("你的最终成绩为："+n*2+"分");
        score.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(score);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SelectPage selectPage = new SelectPage();

                //selectPage.show();
            }
        });


        panel.add(imageJLabel);
        panel.setOpaque(false);    //将内容面板设置为透明；背景图片位于内容面板下方

        frame.setVisible(true);
    }
}
