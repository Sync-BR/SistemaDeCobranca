
package com.sistema.beans;

/**
 *
 * @author SYNC
 */
public class pagamentoBean {
    
    public clientesBean clientes = new clientesBean();
    public pagamentoBean() {
        this.clientes = new clientesBean();
    }
    
    private clientesBean idCliente;
    private clientesBean nomeCliente;
    private clientesBean endereco;
    private clientesBean documeto;
    private clientesBean email;
    private clientesBean cpf;
    

    public clientesBean getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(clientesBean idCliente) {
        this.idCliente = idCliente;
    }

    public clientesBean getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(clientesBean nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public clientesBean getEndereco() {
        return endereco;
    }

    public void setEndereco(clientesBean endereco) {
        this.endereco = endereco;
    }

    public clientesBean getDocumeto() {
        return documeto;
    }

    public void setDocumeto(clientesBean documeto) {
        this.documeto = documeto;
    }

    public clientesBean getEmail() {
        return email;
    }

    public void setEmail(clientesBean email) {
        this.email = email;
    }

    public clientesBean getCpf() {
        return cpf;
    }

    public void setCpf(clientesBean cpf) {
        this.cpf = cpf;
    }
    
}
