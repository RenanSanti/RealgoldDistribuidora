/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Renan
 */
public class Endereco {
    
    public Endereco(){
        
    }
    
    private Integer idEndereco;
    private String nmRua;
    private String nmNumero;
    private String nmComplemento;
    private String nmBairro;
    private String nmCidade;
    private String nmEstado;
    private String nmPais;
    private String nmCep;
    private String nmTelefone;

    public String getNmTelefone() {
        return nmTelefone;
    }

    public void setNmTelefone(String nmTelefone) {
        this.nmTelefone = nmTelefone;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNmRua() {
        return nmRua;
    }

    public void setNmRua(String nmRua) {
        this.nmRua = nmRua;
    }

    public String getNmNumero() {
        return nmNumero;
    }

    public void setNmNumero(String nmNumero) {
        this.nmNumero = nmNumero;
    }
    
    public String getNmComplemento() {
        return nmComplemento;
    }

    public void setNmComplemento(String nmComplemento) {
        this.nmComplemento = nmComplemento;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getNmPais() {
        return nmPais;
    }

    public void setNmPais(String nmPais) {
        this.nmPais = nmPais;
    }

    public String getNmCep() {
        return nmCep;
    }

    public void setNmCep(String nmCep) {
        this.nmCep = nmCep;
    }
      
}
