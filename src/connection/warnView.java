package connection;

import javax.swing.*;

public class warnView extends JDialog {
    JLabel errorInf=new JLabel();
    ImageIcon img = new ImageIcon("image/warn.png");
    JLabel warning =new JLabel();
    JPanel jpanel=new JPanel();


    public warnView(String s){
        errorInf.setText(s);
        warning.setIcon(img);
        jpanel.add(warning);
        jpanel.add(errorInf);
        add(jpanel);
        setTitle("错误提示");
        setBounds(360,300,400,100);
        setVisible(true);
    }

}