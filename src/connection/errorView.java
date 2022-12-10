package connection;

import java.awt.*;
import javax.swing.*;


public class errorView extends JDialog{
    JLabel errorInf=new JLabel("账户或密码错误,请重新输入");
    JLabel warning =new JLabel();
    JPanel jpanel=new JPanel();
    public errorView() {
        ImageIcon img = new ImageIcon("image/warn.png");
        errorInf.setFont(new Font("微软雅黑",Font.PLAIN,14));
        warning.setIcon(img);
        jpanel.add(warning);
        jpanel.add(errorInf);
        add(jpanel);
        setTitle("错误提示");
        setBounds(360,300,250,100);
        setVisible(true);
    }
}
