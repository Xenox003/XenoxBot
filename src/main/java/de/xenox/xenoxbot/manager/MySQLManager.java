package de.xenox.xenoxbot.manager;

import java.sql.*;

public class MySQLManager {
    public static Connection con = null;
    public static Statement statement = null;

    public static void connect(String database, String username, String password) {
        if (con == null) {
            try {
                con = DriverManager.getConnection(database, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void disconnect() {
        if (con != null) {
            try {
                con.close();
                con = null;
                statement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void onCommand(String sql) {

    }
    public static ResultSet onQuery(String sql) {

        return null;
    }
}
