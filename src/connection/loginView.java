package connection;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class loginView extends JFrame {

    JPanel titlePanel = new JPanel();
    JPanel loginPanel = new JPanel();
    JLabel title = new JLabel("教务管理系统");
    JLabel username = new JLabel("用户：");
    JLabel password = new JLabel("密码：");
    JTextField field1 = new JTextField(15);
    JPasswordField field2 = new JPasswordField(15);
    JButton loginButton = new JButton("登录");


    public loginView() {
        // TODO Auto-generated constructor stub
        Container container = getContentPane();

        title.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        titlePanel.add(title);
        loginPanel.add(username);
        loginPanel.add(field1);
        loginPanel.add(password);
        loginPanel.add(field2);
        loginPanel.add(loginButton);
        container.add(titlePanel, BorderLayout.NORTH);
        container.add(loginPanel, BorderLayout.CENTER);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (field1.getText().equals("manager") && field2.getText().equals("123456")) {
                    dispose();
                    new mainView();
                } else {
                    new errorView();
                }

            }
        });

        setTitle("系统登录");
        setBounds(400, 300, 250, 185);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
