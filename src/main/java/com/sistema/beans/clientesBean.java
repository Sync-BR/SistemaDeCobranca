
package com.sistema.beans;

import com.sistema.dao.clienteDao;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SYNC
 */
@ManagedBean("clienteBean")
@ViewScoped
public class clientesBean {

    public clientesBean() {
    }
    
    private int id;
    private String nome;
    private String endereco;
    private String uf;
    private String telefone;
    private String documentos;
    private String email;
    private String cpf;

    public void registerCliente() throws Exception{
        clientesBean addCliente = new clientesBean();
        clienteDao register = new clienteDao();
        addCliente.setCpf(cpf);
        addCliente.setDocumentos(documentos);
        addCliente.setEmail(email);
        addCliente.setEndereco(endereco);
        addCliente.setNome(nome);
        addCliente.setTelefone(telefone);
        addCliente.setUf(uf);
        int status = register.Register(addCliente);
        switch (status) {
            case 200:
                System.out.println("Registrado.");
                break;
            case 300: 
                System.out.println("Já existe um cpf com esse registro");
                break;
            default:
                throw new AssertionError();
        }
        
    
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
