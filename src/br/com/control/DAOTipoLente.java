/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import static br.com.control.DAO.fecharConexao;
import br.com.model.Cliente;
import br.com.model.Servico;
import br.com.model.TipoLente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DAOTipoLente {
    
    public static ArrayList<TipoLente> consultarTipoLente() {
        ArrayList<TipoLente> arrayListTipoLente = null;
        try {
            Connection connection = null;
            ResultSet resultset = null;
            arrayListTipoLente = new ArrayList();
            
            connection = DAO.getConexao();
            String consultar_sql = "SELECT * FROM distribuidora.tipo_lente";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            if (resultset != null) {
                
                while (resultset.next()) {
                    
                    Integer idtipo_lente = resultset.getInt("idtipo_lente");
                    String descricaoTipoLente = resultset.getString("descricao_tipoLente");
                    //String cdProduto = resultset.getString("CD_PRODUTO");
                    //String nmFabricante = resultset.getString("NM_FABRICANTE");
                    //String nmMateriaPrima = resultset.getString("NM_MATERIA_PRIMA");
                    //Timestamp dhInclusao = resultset.getTimestamp("dataEntrada");
                    //Timestamp dhSaida = resultset.getTimestamp("DataSaida");
                    
                    //Servico servico = new Servico();
                    
                    TipoLente tipoLente = new TipoLente();
                    tipoLente.setIdTipoCliente(idtipo_lente);
                    tipoLente.setDescricaoTipoLente(descricaoTipoLente);
                    /*Cliente cliente = new Cliente();
                    cliente.setIdCliente(idCliente);
                    cliente = DAOCliente.consultarPorChavePrimariaCliente(cliente);
                    
                    servico.setCodigoServico(Integer.toString(idServico));
                    servico.setNmclienteServico(cliente.getNmNomeFantasia());
                    servico.setDiaEntradaServico(dhInclusao.toString());
                    //ervico.setDiaSaidaServico(Integer.toString(dhSaida));
                    */
                    arrayListTipoLente.add(tipoLente);
                    
                }
            }
            fecharConexao(connection);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListTipoLente;
    }
    
}
