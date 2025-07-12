import java.sql.*;

public class Conn {
    public Connection conn;
    public Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","chinnu11");
            s =conn.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

//FIVE STEPS IN JDBC 
//1.REGISTER THE DRIVER
//2.CREATE CONNECTION
//3.CREATE STATEMENT
//4.EXECUTE QUERY
//5.CLOSE CONNECTION