package com.sistema.dao;

import com.sistema.beans.loginBean;
import com.sistema.util.conexao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eduar Codigo de erro 200 Autenticado 400 Houver um erro na
 * autenticação. 250 Não possuir dados
 */
public class loginDao {

    public int validate(loginBean authenticate) throws Exception {
        int statusCod = 0;
        if (authenticate.getLogin().isEmpty() && authenticate.getPassword().isEmpty()) {
            statusCod = 250;
        } else if (authenticate.getLogin().isEmpty()) {
            statusCod = 250;
        } else if (authenticate.getPassword().isEmpty()) {
            statusCod = 250;
        } else {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "select * from cobranca.user where usuario = ? and password = ?";
            try {
                connection = conexao.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1, authenticate.getLogin());
                ps.setString(2, authenticate.getPassword());
                rs = ps.executeQuery();
                if (rs.next()) {
                    statusCod = 200;
                } else {
                    statusCod = 400;
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Código de tratamento: " + e.getErrorCode());
            } finally {
                conexao.closeConnection(connection, ps);
            }
        }

        return statusCod;
    }
}
