package connection;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class mainView extends JFrame{
    JButton jb1=new JButton("学生信息管理");
    JButton jb2=new JButton("教师信息管理");
    JButton jb3=new JButton("课室信息管理");
    JButton jb4=new JButton("课程信息管理");
    JPanel jpanel=new JPanel();
    public mainView() {

        jpanel.add(jb1);
        jpanel.add(jb2);
        jpanel.add(jb3);
        jpanel.add(jb4);
        add(jpanel);

        mouseAction();

        setTitle("教务管理系统");
        setBounds(360,300,250,120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void mouseAction() {
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    new studentManage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    new teacherManage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        jb3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    new placeManage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        jb4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    new courseManage();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
