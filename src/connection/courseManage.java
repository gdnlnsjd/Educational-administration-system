package connection;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class courseManage extends JDialog{
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String USER = "manager";
    public static final String PASSWORD = "123456";
    Connection conn =  DriverManager.getConnection(URL, USER, PASSWORD);// 获得数据库连接
    Vector<String> head=new Vector<String>();
    Vector<Vector<String>> data=new Vector<Vector<String>>();
    JPanel jp1 = new JPanel();
    JTable table = new JTable();
    JLabel jl1=new JLabel("教师号:");
    JLabel jl2=new JLabel("学号:");
    JLabel jl3=new JLabel("课程名:");
    JLabel jl4=new JLabel("地点编号:");
    JLabel jl5=new JLabel("上课时间；");
    JLabel jl6=new JLabel("节次；");
    JTextField jt1=new JTextField(20);
    JTextField jt2=new JTextField(20);
    JTextField jt3=new JTextField(20);
    JTextField jt4=new JTextField(20);
    JTextField jt5=new JTextField(20);
    JTextField jt6=new JTextField(20);
    JButton jb1=new JButton("增加");
    JButton jb2=new JButton("修改");
    JButton jb3=new JButton("删除");



    public courseManage() throws Exception {
        checkdata();
        init();
        mouseAction();
    }



    public void init() {
        Container container=getContentPane();
        container.setLayout(null);
        table = new JTable(data, head);
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.DARK_GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列


        // 设置行高
        table.setRowHeight(30);

        // 创建单元格渲染器
        MyTableCellRenderer renderer = new MyTableCellRenderer();
        // 遍历表格的每一列，分别给每一列设置单元格渲染器
        for (int i = 0; i < head.size(); i++) {
            // 根据 列名 获取 表格列
            TableColumn tableColumn = table.getColumn(head.get(i));
            // 设置 表格列 的 单元格渲染器
            tableColumn.setCellRenderer(renderer);
        }

        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        table.setPreferredScrollableViewportSize(new Dimension(514, 350));

        // 把表格放到滚动面板中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(table);
        jp1.add(scrollPane);
        container.add(jl1);
        container.add(jt1);
        container.add(jl2);
        container.add(jt2);
        container.add(jl3);
        container.add(jt3);
        container.add(jl4);
        container.add(jt4);
        container.add(jl5);
        container.add(jt5);
        container.add(jl6);
        container.add(jt6);
        container.add(jb1);
        container.add(jb2);
        container.add(jb3);
        jp1.setBounds(5,30,560,450);
        add(jp1);

        jl1.setBounds(580,10,100,100);
        jt1.setBounds(620,50,150,20);
        jl2.setBounds(590,50,100,100);
        jt2.setBounds(620,90,150,20);
        jl3.setBounds(580,90,100,100);
        jt3.setBounds(620,130,150,20);
        jl4.setBounds(565,130,100,100);
        jt4.setBounds(620,170,150,20);
        jl5.setBounds(565,170,100,100);
        jt5.setBounds(620,210,150,20);
        jl6.setBounds(580,210,100,100);
        jt6.setBounds(620,250,150,20);
        jb1.setBounds(640,300,100,30);
        jb2.setBounds(640,350,100,30);
        jb3.setBounds(640,400,100,30);

        setTitle("课程信息管理");
        setBounds(360,300,800,500);
        setLocationRelativeTo(null);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void checkdata() throws SQLException {
        String sql = new String("select *  from course");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        head.add("教师号");
        head.add("学号");
        head.add("课程名");
        head.add("地点编号");
        head.add("上课时间");
        head.add("节次");
        data.clear();

        while(rs.next())                  //逐条读取数据
        {  //课程参数
            Vector<String> r=new Vector<String>();
            r.add(rs.getString("教师号"));
            r.add(rs.getString("学号"));
            r.add(rs.getString("课程名"));
            r.add(rs.getString("地点编号"));
            r.add(rs.getString("上课时间"));
            r.add(rs.getString("节次"));
            data.add(r);
        }
        table.updateUI();
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO course(教师号,学号,课程名,地点编号,上课时间,节次) "+ "VALUES(?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, jt1.getText());
        st.setString(2, jt2.getText());
        st.setString(3, jt3.getText());
        st.setString(4, jt4.getText());
        st.setString(5, jt5.getText());
        st.setString(6, jt6.getText());
        st.executeUpdate();
        checkdata();

    }

    public void modify() throws SQLException {
        String sql = "update course set 教师号=?,学号=?,课程名=?,地点编号=?,上课时间=?,节次=? where 教师号 = ? and 学号=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, jt1.getText());
        st.setString(2, jt2.getText());
        st.setString(3, jt3.getText());
        st.setString(4, jt4.getText());
        st.setString(5, jt5.getText());
        st.setString(6, jt6.getText());
        st.setString(7, jt1.getText());
        st.setString(8, jt2.getText());
        st.executeUpdate();
        checkdata();

    }

    public void delete() throws SQLException {
        String sql = "delete from COURSE where 教师号 = ? and 学号=? and 地点编号=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, jt1.getText());
        st.setString(2, jt2.getText());
        st.setString(3, jt4.getText());
        st.executeUpdate();
        checkdata();

    }

    public void mouseAction(){
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(jt1.getText().length()==0||jt2.getText().length()!=10){
                    new warnView("输入的信息不符合数据库完整性约束，请重新输入");
                }//判断是否符合数据库完整性约束
                else{
                    try {
                        insert();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        jb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(jt1.getText().length()==0||jt2.getText().length()!=10){
                    new warnView("无法找到对应的课程，请重新输入");
                }//判断是否符合数据库完整性约束
                else{
                    try {
                        modify();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


            }
        });

        jb3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(jt1.getText().length()!=5||jt2.getText().length()!=10||jt4.getText().length()==0){
                    new warnView("输入信息不完整，请重新输入");
                }//判断是否符合数据库完整性约束
                else{
                    try {
                        delete();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }
}
