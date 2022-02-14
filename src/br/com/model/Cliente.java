/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Timestamp;

/**
 *
 * @author Renan
 */
public class Cliente {
    
    public Cliente(){
    }
    
    private Integer idCliente;
    private String cdCnpj;
    private String nmNomeFantasia;
    private String dataInclusao;
    private Integer idEndereco;
    private String nuTelefone;
    private Timestamp dhAlteracao;

    public Timestamp getDhAlteracao() {
        return dhAlteracao;
    }

    public void setDhAlteracao(Timestamp dhAlteracao) {
        this.dhAlteracao = dhAlteracao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCdCnpj() {
        return cdCnpj;
    }

    public void setCdCnpj(String cdCnpj) {
        this.cdCnpj = cdCnpj;
    }

    public String getNmNomeFantasia() {
        return nmNomeFantasia;
    }

    public void setNmNomeFantasia(String nmNomeFantasia) {
        this.nmNomeFantasia = nmNomeFantasia;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNuTelefone() {
        return nuTelefone;
    }

    public void setNuTelefone(String nuTelefone) {
        this.nuTelefone = nuTelefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente 
                + ", cdCnpj=" + cdCnpj 
                + ", nmNomeFantasia=" + nmNomeFantasia 
                + ", dataInclusao=" + dataInclusao 
                + ", idEndereco=" + idEndereco 
                + ", nuTelefone=" + nuTelefone 
                + ", dhAlteracao=" + dhAlteracao + '}';
    }
    
    
    
    
}
