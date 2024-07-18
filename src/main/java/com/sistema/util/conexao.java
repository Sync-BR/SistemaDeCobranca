package com.sistema.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SYNC
 */
public class conexao {

    public conexao() {
    }

    private static  Connection connection;

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1/cobranca", "root", "");
       
    }

    private static void close(Connection connection, PreparedStatement ps, ResultSet rs) throws Exception {
        if (connection != null) {
            connection.close();
        } else if (ps != null) {
            ps.close();
        } else if (rs != null) {
            rs.close();
        }

    }

    public static void closeConnection(Connection connection, PreparedStatement ps, ResultSet rs) throws Exception {
        close(connection, ps, rs);
    }

    public static void closeConnection(Connection connection, PreparedStatement ps) throws Exception {
        close(connection, ps, null);
    }

    public static void closeConnection(Connection connection) throws Exception {
        close(connection, null, null);
    }

}
