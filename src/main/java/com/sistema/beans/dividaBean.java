
package com.sistema.beans;

import java.util.Date;

/**
 *
 * @author SYNC
 */
public class dividaBean {
    private int codigo;
    private clientesBean credor;
    private Date dataAtualizacao;
    private double valorDivida;
    private clientesBean devedor;
    private int idPag;
    private dividaBean divida;
    private Date dataPagamento;
    private double valorPago;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public clientesBean getCredor() {
        return credor;
    }

    public void setCredor(clientesBean credor) {
        this.credor = credor;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public clientesBean getDevedor() {
        return devedor;
    }

    public void setDevedor(clientesBean devedor) {
        this.devedor = devedor;
    }

    public int getIdPag() {
        return idPag;
    }

    public void setIdPag(int idPag) {
        this.idPag = idPag;
    }

    public dividaBean getDivida() {
        return divida;
    }

    public void setDivida(dividaBean divida) {
        this.divida = divida;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    
    
}
