package connection;


public class mySystem {
    public static void main(String[] args) throws ClassNotFoundException {
        //加载驱动程序
        Class.forName("oracle.jdbc.driver.OracleDriver");
        loginView loginview=new loginView();
    }
}
