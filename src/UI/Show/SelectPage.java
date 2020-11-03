package UI.Show;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectPage {

    public SelectPage(){
        show();
    }

    public void show(){
        JFrame frame = new JFrame();
        JPanel panel;
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel title = new JLabel();

        JButton train = new JButton("训练");
        JButton test = new JButton("测试");

        ImageIcon backgroundIcon = new ImageIcon(this.getClass().getResource("/imgs/背景2.jpg"));
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

        title.setBounds(150, 10, 480, 64);
        title.setText("欢迎进入加减法练习小程序");
        title.setFont(new Font("仿宋",Font.PLAIN,40));
        title.setForeground(Color.MAGENTA);
        panel.add(title);

        train.setFont(new Font("Dialog", Font.BOLD, 25));
        train.setBounds(250, 191, 127, 64);
        train.setBackground(new Color(224, 255, 255));
        panel.add(train);

        test.setFont(new Font("Dialog", Font.BOLD, 25));
        test.setBounds(400, 191, 127, 64);
        test.setBackground(new Color(224, 255, 255));
        panel.add(test);


        train.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainPage trainPage = new TrainPage();
                //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(false);
                trainPage.show();
            }
        });

        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TestPage testPage = new TestPage();
                frame.setVisible(false);
                testPage.show();
            }
        });

        panel.add(imageJLabel);
        panel.setOpaque(false);    //将内容面板设置为透明；背景图片位于内容面板下方

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SelectPage s = new SelectPage();
    }
}
