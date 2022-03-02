/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Servico {
    
    public Servico(){
    }
    
    private String codigoServico;
    private String nmclienteServico;
    private String idClienteServico;
    private String diaEntradaServico;
    private String diaSaidaServico;
    private String pagoServico;
    private String statusServico;
    private String descricaoTipoLenteServico;
    private String numeroBandejaServico;
    private Boolean isLenteCasa;
    private Boolean isMontagem;
    private Boolean isSurfacagem;
    private String obs;
    private String osCliente;

    public String getOsCliente() {
        return osCliente;
    }

    public void setOsCliente(String osCliente) {
        this.osCliente = osCliente;
    }

    public String getNumeroBandejaServico() {
        return numeroBandejaServico;
    }

    public void setNumeroBandejaServico(String numeroBandejaServico) {
        this.numeroBandejaServico = numeroBandejaServico;
    }

    public String getDescricaoTipoLenteServico() {
        return descricaoTipoLenteServico;
    }

    public void setDescricaoTipoLenteServico(String descricaoTipoLenteServico) {
        this.descricaoTipoLenteServico = descricaoTipoLenteServico;
    }
    
    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getNmclienteServico() {
        return nmclienteServico;
    }
    
    public String getIdClienteServico() {
        return idClienteServico;
    }

    public void setIdClienteServico(String idClienteServico) {
        this.idClienteServico = idClienteServico;
    }

    public void setNmclienteServico(String nmclienteServico) {
        this.nmclienteServico = nmclienteServico;
    }

    public String getDiaEntradaServico() {
        return diaEntradaServico;
    }
    public String getObs() {
        return obs;
    }


    public void setDiaEntradaServico(String diaEntradaServico) {
        this.diaEntradaServico = diaEntradaServico;
    }

    public String getDiaSaidaServico() {
        return diaSaidaServico;
    }

    public void setDiaSaidaServico(String diaSaidaServico) {
        this.diaSaidaServico = diaSaidaServico;
    }

    public String getPagoServico() {
        return pagoServico;
    }

    public void setPagoServico(String pagoServico) {
        this.pagoServico = pagoServico;
    }

    public String getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(String statusServico) {
        this.statusServico = statusServico;
    }

    public Boolean getIsLenteCasa() {
        return isLenteCasa;
    }

    public void setIsLenteCasa(Boolean isLenteCasa) {
        this.isLenteCasa = isLenteCasa;
    }
    public void setObs(String obs) {
        this.obs = obs;
    }
    public Boolean getIsMontagem() {
        return isMontagem;
    }

    public void setIsMontagem(Boolean isMontagem) {
        this.isMontagem = isMontagem;
    }

    public Boolean getIsSurfacagem() {
        return isSurfacagem;
    }

    public void setIsSurfacagem(Boolean isSurfacagem) {
        this.isSurfacagem = isSurfacagem;
    }
    
}
