package UI.Show;

import Logical.Data.OpData;
import Logical.GetAward.GetAward;
import Logical.Operation.Operation;
import Logical.Operation.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainPage {

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

    JButton btnNext = new JButton("跳题");   //跳题按钮

    JList jList = new JList();
    JScrollPane jScrollPane = new JScrollPane(jList,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    DefaultListModel<String> defaultListModel = new DefaultListModel<>();

    JLabel award = new JLabel();
    GetAward ga = new GetAward();

    Integer a = 0, b = 0;
    String op = "+";
    int result = 0;

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

        JFrame frame = new JFrame();
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
        title.setText("加减法训练模式(不计总分)");
        title.setFont(new Font("仿宋",Font.PLAIN,40));
        title.setForeground(Color.MAGENTA);
        panel.add(title);

        back.setFont(new Font("Dialog", Font.BOLD, 25));
        back.setBounds(600, 400, 127, 64);
        back.setBackground(new Color(224, 255, 255));
        panel.add(back);

        btnNew.setFont(new Font("Dialog", Font.BOLD, 25));
        btnNew.setBounds(117, 191, 127, 50);
        btnNew.setBackground(new Color(224, 255, 255));
        panel.add(btnNew);

        btnNext.setFont(new Font("Dialog", Font.BOLD, 25));
        btnNext.setBounds(250, 191, 127, 50);
        btnNext.setBackground(new Color(224, 255, 255));
        panel.add(btnNext);

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

        award.setBounds(117, 250, 300, 36);
        award.setText("");
        award.setFont(new Font("华文行楷",Font.PLAIN,40));
        award.setForeground(Color.orange);
        panel.add(award);

        txtAnswer.setBounds(379, 122, 113, 48);
        txtAnswer.setFont(new Font("Dialog",Font.PLAIN,24));
        panel.add(txtAnswer);

        sumExercise.setBounds(600, 100, 113, 48);
        sumExercise.setText("总题数:"+count1);
        sumExercise.setFont(new Font("宋体",Font.PLAIN,24));
        panel.add(sumExercise);

        rightExercise.setBounds(600, 150, 115, 48);
        rightExercise.setText("正确题数:"+count2);
        rightExercise.setFont(new Font("宋体",Font.PLAIN,20));
        panel.add(rightExercise);

        jList.setModel(defaultListModel);
        jList.setFont(new Font("Dialog", Font.BOLD, 24));
        jScrollPane.add(jList);
        jScrollPane.setBounds(100, 300, 385, 200);
        frame.add(jScrollPane);

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String disp = ""+ " "+a +" "+ op +" "+ b +" " +"="+"?";
                count1++;
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
                sumExercise.setText("总题数:"+count1);
                rightExercise.setText("正确题数:"+count2);
                lblA.setText(a.toString());
                lblB.setText(b.toString());
                lblOp.setText(op);
                txtAnswer.setText("");
                award.setText("");
                defaultListModel.addElement(disp);
                //System.out.println(defaultListModel);
                jList.setModel(defaultListModel);
            }
        });

        btnNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtAnswer.getText();
                Integer d = null;
                if(str.length()!=0)
                    d = Integer.valueOf(str);
                if(d==null||d!=result) {
                    return;
                }
                String disp = ""+ " "+a +" "+ op +" "+ b +" "+ "=" +" "+ str +" ";
                count2++;
                count1++;
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
                sumExercise.setText("总题数:"+count1);
                rightExercise.setText("正确题数:"+count2);
                lblA.setText(a.toString());
                lblB.setText(b.toString());
                lblOp.setText(op);
                txtAnswer.setText("");
                award.setText(ga.get(operator.RandomLine(3)));
                defaultListModel.addElement(disp);
                //System.out.println(defaultListModel);
                jList.setModel(defaultListModel);
                //System.out.println(jList);
                //jScrollPane.add(jList);
            }
        });


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectPage selectPage = new SelectPage();
                frame.setVisible(false);
                //selectPage.show();
            }
        });

        panel.add(imageJLabel);
        panel.setOpaque(false);    //将内容面板设置为透明；背景图片位于内容面板下方
        jScrollPane.setViewportView(jList);
        frame.setVisible(true);
    }
}
