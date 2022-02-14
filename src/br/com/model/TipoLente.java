/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author DELL
 */
public class TipoLente {

    public TipoLente() {
    }
    private Integer idTipoCliente;
    private String descricaoTipoLente;

    public TipoLente(Integer idTipoCliente, String descricaoTipoLente) {
        this.idTipoCliente = idTipoCliente;
        this.descricaoTipoLente = descricaoTipoLente;
    }
    
    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getDescricaoTipoLente() {
        return descricaoTipoLente;
    }

    public void setDescricaoTipoLente(String descricaoTipoLente) {
        this.descricaoTipoLente = descricaoTipoLente;
    }
}
