package HotelManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    private Connection connection;
    private String connectionUrl = "jdbc:mysql://localhost:3308/hotel";
    public Statement statement;

    public Conn() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        this.connection = DriverManager.getConnection(connectionUrl, "root", "1234");
        this.statement = this.connection.createStatement();
        System.out.println("Database connected");
    }



    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }
}