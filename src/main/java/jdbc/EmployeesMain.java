package jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.SQLException;

public class EmployeesMain {

    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/employees?useUnicode=True");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        try (
                Connection conn = (Connection) dataSource.getConnection();
                Statement stmt = (Statement) conn.createStatement()) {
            stmt.executeUpdate("insert into employees(emp_name) values ('John Doe')");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Cannot create");
        }
    }
}
