package UI.Show;

import Logical.Data.OpData;
import Logical.Operation.Operation;
import Logical.Operation.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestPage extends Thread{

    private final int timeMin = 30;

    JFrame frame = new JFrame();
    JButton btnNew = new JButton("下一题");   //出题按钮
    //JButton startJButton = new JButton("开始");   //出题按钮
    JLabel lblA = new JLabel(); // 操作数A
    JLabel lblOp = new JLabel(); // 操作Op
    JLabel lblB = new JLabel(); // 操作数B
    JLabel label5 = new JLabel(); // =号
    JTextField txtAnswer = new JTextField();    //答案框

    JLabel title = new JLabel();

    private int count1 = 0;    //记录总题数
    JLabel sumExercise = new JLabel();

    private int count2 = 0;    //记录正确题数
    JLabel rightExercise = new JLabel();

    JLabel exerciseTime = new JLabel();

    Integer a = 0, b = 0;
    String op = "+";
    int result = 0;

    Integer min=timeMin;
    Integer sec=0;


    public void run(){
        while(true){
            try {
//                System.out.println(min);
                //               System.out.println(sec);

                exerciseTime.setBounds(550, 200, 500, 48);
                exerciseTime.setText("计时:"+min+"分钟"+sec+"秒");
                exerciseTime.setFont(new Font("宋体",Font.PLAIN,20));



                Thread.sleep(1000);
                if(sec==0&&min==0){
                    frame.setVisible(false);
                    ScorePage scorePage = new ScorePage();
                    scorePage.show(count2);
                }

                if(sec == 0){
                    min--;
                    sec = 59;
                }
                else
                    sec--;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public void show(){

        Operator operator = new Operation();
        OpData data = operator.RandomData();
        a = data.getData1();
        b = data.getData2();
        result = operator.Op_rule(data);
        int c = data.getData3();
        switch(c) {
            case 0:op="+";break;
            case 1:op="-";break;
        }

        JPanel panel;
        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton back = new JButton("退出");

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
        title.setText("欢迎进入加减法测试模式");
        title.setFont(new Font("仿宋",Font.PLAIN,40));
        title.setForeground(Color.MAGENTA);
        panel.add(title);

        back.setFont(new Font("Dialog", Font.BOLD, 25));
        back.setBounds(600, 400, 127, 64);
        back.setBackground(new Color(224, 255, 255));
        panel.add(back);

        btnNew.setFont(new Font("Dialog", Font.BOLD, 25));
        btnNew.setBounds(117, 191, 127, 64);
        btnNew.setBackground(new Color(224, 255, 255));
        panel.add(btnNew);

        lblA.setBounds(92, 122, 61, 36);
        lblA.setText(a.toString());
        //设置字体
        lblA.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblA);

        lblOp.setBounds(170, 121, 51, 37);
        lblOp.setText(op);
        lblOp.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblOp);

        lblB.setBounds(241, 122, 61, 36);
        lblB.setText(b.toString());
        lblB.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(lblB);

        label5.setBounds(321, 122, 42, 36);
        label5.setText("=");
        label5.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(label5);

        txtAnswer.setBounds(379, 122, 113, 48);
        txtAnswer.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(txtAnswer);

        sumExercise.setBounds(550, 100, 250, 48);
        sumExercise.setText("已做题数:"+count1+"(共50题)");
        sumExercise.setFont(new Font("宋体",Font.PLAIN,24));
        panel.add(sumExercise);

        rightExercise.setBounds(550, 150, 115, 48);
        rightExercise.setText("正确题数:"+count2);
        rightExercise.setFont(new Font("宋体",Font.PLAIN,20));
        panel.add(rightExercise);

        this.start();
        panel.add(exerciseTime);


        btnNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer d = null;
                String str = txtAnswer.getText();
                if(str.length()!=0)
                    d = Integer.valueOf(str);
                if(d!=null&&d==result) {
                    count2++;
                }

                count1++;
                if(count1>=50){
                    frame.setVisible(false);
                    ScorePage scorePage = new ScorePage();
                    scorePage.show(count2);
                }
                Operator operator = new Operation();
                OpData data = operator.RandomData();
                a = data.getData1();
                b = data.getData2();
                result = operator.Op_rule(data);
                int c = data.getData3();
                switch(c) {
                    case 0:op="+";break;
                    case 1:op="-";break;
                }
                sumExercise.setText("已做题数:"+count1+"(共50题)");
                rightExercise.setText("正确题数:"+count2);
                lblA.setText(a.toString());
                lblB.setText(b.toString());
                lblOp.setText(op);
                txtAnswer.setText("");
            }
        });


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
