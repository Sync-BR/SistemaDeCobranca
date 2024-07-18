package com.sistema.dao;

import com.sistema.beans.clientesBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sistema.util.conexao;

/**
 *
 * @author SYNC
 * @Status código:
 * 200 Ok
 * 300 SQL Chavekey duplicado.
 */
public class clienteDao {

    /**
     *
     * @author SYNC
     * @return retornar o status do registro.
     * @Register Funcionalidade para registrar um novo cliente.
     * @param addclientes instancia os parametros do clientesBean.
     * @throws java.lang.Exception Faz os possiveis tratamento de erro.
     */
    public int Register(clientesBean addclientes) throws Exception {
        int status = 0;
        Connection connection = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO cobranca.clientes ( Nome, Endereco, Uf, Telefone, Documento, Email, Cpf ) "
                + "value (?,?,?,?,?,?,?)";
        try {
            connection = conexao.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, addclientes.getNome());
            ps.setString(2, addclientes.getEndereco());
            ps.setString(3, addclientes.getUf());
            ps.setString(4, addclientes.getTelefone());
            ps.setString(5, addclientes.getDocumentos());
            ps.setString(6, addclientes.getEmail());
            ps.setString(7, addclientes.getCpf());
            int execute = ps.executeUpdate();
            if (execute > 0) {
                status = 200; //Retornar status ok, Registrado.
            }
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1062:
                    status = 300; //Retorna status de chave duplicada.
                    break;
                default:
                    System.out.println(e.getMessage());
                    System.out.println("Erro codigigo: " +e.getErrorCode());
            }
           
            
        } finally {
            conexao.closeConnection(connection, ps);
        }

        return status;

    }

    public static void main(String[] args) throws Exception {
        clientesBean addcliente = new clientesBean();
        clienteDao registrar = new clienteDao();
        addcliente.setCpf("061.260.395-41");
        addcliente.setDocumentos("752411");
        addcliente.setEmail("Eduardofreitasfr@gmail.com");
        addcliente.setEndereco("Alto do cabrito");
        addcliente.setNome("Eduardo freitas da silva santos");
        addcliente.setTelefone("71981590149");
        addcliente.setUf("BA");
        int status = registrar.Register(addcliente);
        if (status == 200) {
            System.out.println("Sucesso");
        } else {
            System.out.println("Falhou");
        }
    }
}
