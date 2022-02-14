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
public class Produto {

    public Produto() {

    }

    private int idProduto;
    private String nmProduto;
    private String cdProduto;
    private String nmFabricante;
    private String nmMateriaPrima;
    private String nuGrauEsferico;
    private String nuGrauCilindrico;
    private String nuBase;
    private String tpProduto;
    private String vlCompraProduto;
    private String vlVendaProduto;
    private String nuEspessura;
    private Timestamp dhInclusao;
    private Timestamp dhAlteracao;

    public String getNmFabricante() {
        return nmFabricante;
    }

    public void setNmFabricante(String nmFabricante) {
        this.nmFabricante = nmFabricante;
    }

    public String getNmMateriaPrima() {
        return nmMateriaPrima;
    }

    public void setNmMateriaPrima(String nmMateriaPrima) {
        this.nmMateriaPrima = nmMateriaPrima;
    }

    public String getNuGrauEsferico() {
        return nuGrauEsferico;
    }

    public void setNuGrauEsferico(String nuGrauEsferico) {
        this.nuGrauEsferico = nuGrauEsferico;
    }

    public String getNuGrauCilindrico() {
        return nuGrauCilindrico;
    }

    public void setNuGrauCilindrico(String nuGrauCilindrico) {
        this.nuGrauCilindrico = nuGrauCilindrico;
    }

    public String getNuBase() {
        return nuBase;
    }

    public void setNuBase(String nuBase) {
        this.nuBase = nuBase;
    }

    public String getTpProduto() {
        return tpProduto;
    }

    public void setTpProduto(String tpProduto) {
        this.tpProduto = tpProduto;
    }

    public String getNuEspessura() {
        return nuEspessura;
    }

    public void setNuEspessura(String nuEspessura) {
        this.nuEspessura = nuEspessura;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNmProduto() {
        return nmProduto;
    }

    public void setNmProduto(String nmProduto) {
        this.nmProduto = nmProduto;
    }

    public String getVlVendaProduto() {
        return vlVendaProduto;
    }

    public void setVlVendaProduto(String vlVendaProduto) {
        this.vlVendaProduto = vlVendaProduto;
    }

    public String getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(String cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getIdGrau() {
        return nuGrauEsferico;
    }

    public void setIdGrau(String idGrau) {
        this.nuGrauEsferico = idGrau;
    }

    public String getVlCompraProduto() {
        return vlCompraProduto;
    }

    public void setVlCompraProduto(String vlCompraProduto) {
        this.vlCompraProduto = vlCompraProduto;
    }

    public Timestamp getDhInclusao() {
        return dhInclusao;
    }

    public void setDhInclusao(Timestamp dhInclusao) {
        this.dhInclusao = dhInclusao;
    }

    public Timestamp getDhAlteracao() {
        return dhAlteracao;
    }

    public void setDhAlteracao(Timestamp dhAlteracao) {
        this.dhAlteracao = dhAlteracao;
    }

}
