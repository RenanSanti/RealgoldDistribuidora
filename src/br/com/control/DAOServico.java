/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import static br.com.control.DAO.fecharConexao;
import br.com.model.Cliente;
import br.com.model.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DAOServico {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //inserirClinete();	

        //ResultSet resultset = consultarCliente();
        //resultset.close();
        //int i = gerarSequencialIdCliente();
        //Cliente c =  new Cliente();
        //c.setIdCliente(2);
        //consultarPorChavePrimariaCliente(c);
    }

    public static ArrayList<Servico> consultarServico() {
        ArrayList<Servico> arrayListServico = null;
        try {
            Connection connection = null;
            ResultSet resultset = null;
            arrayListServico = new ArrayList();

            connection = DAO.getConexao();
            String consultar_sql = "SELECT * FROM distribuidora.servico";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            if (resultset != null) {

                while (resultset.next()) {

                    Integer idServico = resultset.getInt("idServico");
                    Integer idCliente = resultset.getInt("idCliente");
                    String idTipoLente = resultset.getString("idtipo_Lente");
                    //String cdProduto = resultset.getString("CD_PRODUTO");
                    //String nmFabricante = resultset.getString("NM_FABRICANTE");
                    //String nmMateriaPrima = resultset.getString("NM_MATERIA_PRIMA");

                    Timestamp dhInclusao = resultset.getTimestamp("dataEntrada");
                    Timestamp dhSaida = resultset.getTimestamp("DataSaida");

                    Servico servico = new Servico();

                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(idCliente);
                    cliente = DAOCliente.consultarPorChavePrimariaCliente(cliente);

                    servico.setCodigoServico(Integer.toString(idServico));
                    servico.setNmclienteServico(cliente.getNmNomeFantasia());
                    servico.setDiaEntradaServico(dhInclusao.toString());
                    //ervico.setDiaSaidaServico(Integer.toString(dhSaida));

                    arrayListServico.add(servico);

                }
            }
            fecharConexao(connection);

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListServico;
    }

    /*
    Consulta de serviço
     */
    public static ArrayList<Servico> consultarServicoCompleto() {
        ArrayList<Servico> arrayListServico = null;
        try {
            Connection connection = null;
            ResultSet resultset = null;
            arrayListServico = new ArrayList();

            connection = DAO.getConexao();
            String consultar_sql = "SELECT distribuidora.servico.*,\n"
                    + "distribuidora.status.descricaoStatus ,\n"
                    + "distribuidora.tipo_lente.descricao_tipoLente,\n"
                    + "distribuidora.cliente.nomeCliente\n"
                    + "FROM distribuidora.servico \n"
                    + "inner join distribuidora.status\n"
                    + "on distribuidora.servico.idstatus = distribuidora.status.idstatus\n"
                    + "inner join distribuidora.tipo_lente\n"
                    + "on distribuidora.servico.idtipo_Lente = distribuidora.tipo_lente.idtipo_lente\n"
                    + "inner join distribuidora.cliente\n"
                    + "on distribuidora.servico.idcliente = distribuidora.cliente.idcliente\n"
                    + "order by distribuidora.servico.idservico desc ;";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            if (resultset != null) {

                while (resultset.next()) {

                    Integer idServico = resultset.getInt("idServico");
                    String nmCliente = resultset.getString("nomeCliente");
                    String idTipoLente = resultset.getString("descricao_tipoLente");
                    String stObs = resultset.getString("obs");
                    String idStatus = resultset.getString("descricaoStatus");
                    String numBandeja = resultset.getString("nuBandeja");
                    String strPago = resultset.getString("pago");
                    Integer isCasaLente = resultset.getInt("isLenteCasa");
                    Integer isMontagem = resultset.getInt("isMontagem");
                    Integer isSurfacagem = resultset.getInt("isSurfacagem");

                    Timestamp dhInclusao = resultset.getTimestamp("dataEntrada");
                    Timestamp dhSaida = resultset.getTimestamp("dataSaida");
                    Servico servico = new Servico();

                    /*Cliente cliente = new Cliente();
                    cliente.setIdCliente(idCliente);
                    cliente = DAOCliente.consultarPorChavePrimariaCliente(cliente);*/
                    servico.setDescricaoTipoLenteServico(idTipoLente);
                    servico.setStatusServico(idStatus);
                    servico.setNumeroBandejaServico(numBandeja);
                    servico.setPagoServico(strPago);
                    servico.setCodigoServico(Integer.toString(idServico));
                    servico.setNmclienteServico(nmCliente);
                    servico.setDiaEntradaServico(String.valueOf(dhInclusao));
                    if (dhSaida != null) 
                        servico.setDiaSaidaServico(String.valueOf(dhSaida));
                    if (stObs != null) {
                        servico.setObs(stObs);
                    }
                    if (isCasaLente == 0) {
                        servico.setIsLenteCasa(false);
                    } else {
                        servico.setIsLenteCasa(true);
                    }
                    if (isMontagem == 0) {
                        servico.setIsMontagem(false);
                    } else {
                        servico.setIsMontagem(true);
                    }
                    if (isSurfacagem == 0) {
                        servico.setIsSurfacagem(false);
                    } else {
                        servico.setIsSurfacagem(true);
                    }
                    arrayListServico.add(servico);
                }
            }
            fecharConexao(connection);

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListServico;
    }

    public static ArrayList<Servico> consultarServicoComRestricao(Servico pServico) {
        ArrayList<Servico> arrayListServico = null;

        Connection connection = null;
        ResultSet resultset = null;
        arrayListServico = new ArrayList();
        int incremantadoParametros = 1;

        connection = DAO.getConexao();
        String consultar_sql = "SELECT distribuidora.servico.*,\n"
                + "distribuidora.status.descricaoStatus ,\n"
                + "distribuidora.tipo_lente.descricao_tipoLente,\n"
                + "distribuidora.cliente.nomeCliente\n"
                + "FROM distribuidora.servico \n"
                + "inner join distribuidora.status\n"
                + "on distribuidora.servico.idstatus = distribuidora.status.idstatus\n"
                + "inner join distribuidora.tipo_lente\n"
                + "on distribuidora.servico.idtipo_Lente = distribuidora.tipo_lente.idtipo_lente\n"
                + "inner join distribuidora.cliente\n"
                + "on distribuidora.servico.idcliente = distribuidora.cliente.idcliente\n";
        String consulta_order_by = "order by distribuidora.servico.idservico desc ;";

        String where_sql = " WHERE ";
        String conector = "";

        if (pServico.getCodigoServico() != null && !pServico.getCodigoServico().equals("")) {
            consultar_sql = consultar_sql + where_sql + "distribuidora.servico.idservico = ? ";
            conector = " \n AND ";
            where_sql = "";
        } else if (pServico.getNmclienteServico() != null && !pServico.getNmclienteServico().equals("")) {
            consultar_sql = consultar_sql + where_sql + conector + "distribuidora.cliente.nomeCliente = ? ";
            conector = " \n AND ";
            where_sql = "";
        }
        if (pServico.getDiaEntradaServico() != null && !pServico.getDiaEntradaServico().equals("")) {
            consultar_sql = consultar_sql + where_sql + conector + "distribuidora.servico.dataEntrada = ? ";
        }
        if (pServico.getDiaSaidaServico() != null && !pServico.getDiaSaidaServico().equals("")) {
            consultar_sql = consultar_sql + where_sql + conector + "distribuidora.servico.dataSaida = ? ";
        }
        consultar_sql = consultar_sql + consulta_order_by;

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(consultar_sql);
            if (pServico.getCodigoServico() != null && !pServico.getCodigoServico().equals("")) {
                preparedStatement.setString(incremantadoParametros++, pServico.getCodigoServico());
            } else if (pServico.getNmclienteServico() != null && !pServico.getNmclienteServico().equals("")) {
                preparedStatement.setString(incremantadoParametros++, pServico.getNmclienteServico());
            }
            if (pServico.getDiaEntradaServico() != null && !pServico.getDiaEntradaServico().equals("")) {
                preparedStatement.setString(incremantadoParametros++, pServico.getDiaEntradaServico());
            }
            if (pServico.getDiaSaidaServico() != null && !pServico.getDiaSaidaServico().equals("")) {
                preparedStatement.setString(incremantadoParametros++, pServico.getDiaSaidaServico());
            }

            resultset = preparedStatement.executeQuery();
            if (resultset != null) {

                while (resultset.next()) {

                    Integer idServico = resultset.getInt("idServico");
                    String nmCliente = resultset.getString("nomeCliente");
                    String idTipoLente = resultset.getString("descricao_tipoLente");
                    String stObs = resultset.getString("obs");
                    String idStatus = resultset.getString("descricaoStatus");
                    String numBandeja = resultset.getString("nuBandeja");
                    String strPago = resultset.getString("pago");
                    Integer isCasaLente = resultset.getInt("isLenteCasa");

                    Timestamp dhInclusao = resultset.getTimestamp("dataEntrada");
                    Timestamp dhSaida = resultset.getTimestamp("DataSaida");
                    Servico servico = new Servico();

                    /*Cliente cliente = new Cliente();
                    cliente.setIdCliente(idCliente);
                    cliente = DAOCliente.consultarPorChavePrimariaCliente(cliente);*/
                    servico.setDescricaoTipoLenteServico(idTipoLente);
                    servico.setStatusServico(idStatus);
                    servico.setNumeroBandejaServico(numBandeja);
                    servico.setPagoServico(strPago);
                    servico.setCodigoServico(Integer.toString(idServico));
                    servico.setNmclienteServico(nmCliente);
                    servico.setDiaEntradaServico(String.valueOf(dhInclusao));
                    if (dhSaida != null) {
                        servico.setDiaSaidaServico(String.valueOf(dhSaida));
                    }
                    if (stObs != null) {
                        servico.setObs(stObs);
                    }
                    if (isCasaLente == 0) {
                        servico.setIsLenteCasa(false);
                    } else {
                        servico.setIsLenteCasa(true);
                    }
                    arrayListServico.add(servico);
                }
            }
            fecharConexao(connection);

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListServico;
    }

    public static int gerarSequencialIdServico() {
        int idServico = 0;
        try {
            Connection connection = null;
            ResultSet resultset = null;

            connection = DAO.getConexao();
            String consultar_sql = "SELECT max(distribuidora.servico.idservico) as maxServico FROM distribuidora.servico;";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            String stIdServico = "";

            if (resultset != null) {
                resultset.next();
                stIdServico = resultset.getString("maxServico");
                idServico = Integer.parseInt(stIdServico);
            }
            fecharConexao(connection);

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++idServico;
    }

    /* public static Produto consultarPorChavePrimariaProduto(Produto pProduto) {

        Connection connection = null;
        Produto retornoConsulta = null;

        connection = DAO.getConexao();
        String select_sql = "SELECT * FROM `distribuidora`.`produto`";
        String where_sql = " WHERE ";
        
        if(pProduto.getCdProduto() != null){
            select_sql = select_sql + where_sql + " `CD_PRODUTO`  = ? ";
        }
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(select_sql);
            if(pProduto.getNmProduto() != null){
                preparedStatement.setString(1, pProduto.getCdProduto());
            }
            preparedStatement.setString(2, pCliente.getCdCnpj());
            preparedStatement.setString(3, pCliente.getNmNomeFantasia());
            preparedStatement.setInt(4, pCliente.getIdEndereco());
            preparedStatement.setString(5, pCliente.getNuTelefone());

            preparedStatement.execute();
            
            ResultSet resultset = preparedStatement.getResultSet();
            if(resultset != null){
                resultset.next();
                int idProduto = resultset.getInt("ID_PRODUTO");
                String nmProduto = resultset.getString("NM_PRODUTO");
                String cdProduto = resultset.getString("CD_PRODUTO");
                String nmFabricante = resultset.getString("NM_FABRICANTE");
                String nmMateriaPrima = resultset.getString("NM_MATERIA_PRIMA");
                String nuGrauEsferico = resultset.getString("NU_GRAU_ESFERICO");
                String nuGrauCilindrico = resultset.getString("NU_GRAU_CILINDRICO");
                String nuBase = resultset.getString("NU_BASE");
                String nuEspessura = resultset.getString("NU_ESPESSURA");
                Timestamp dhInclusao = resultset.getTimestamp("DH_INCLUSAO");
                Timestamp dhAlteracao = resultset.getTimestamp("DH_ALTERACAO");

                retornoConsulta = new Produto();
                retornoConsulta.setIdProduto(idProduto);
                retornoConsulta.setNmProduto(nmProduto);
                retornoConsulta.setCdProduto(cdProduto);
                retornoConsulta.setNmFabricante(nmFabricante);
                retornoConsulta.setNmMateriaPrima(nmMateriaPrima);
                retornoConsulta.setNuGrauEsferico(nuGrauEsferico);
                retornoConsulta.setNuGrauCilindrico(nuGrauCilindrico);
                retornoConsulta.setNuBase(nuBase);
                retornoConsulta.setNuEspessura(nuEspessura);
                retornoConsulta.setDhInclusao(dhInclusao);
                retornoConsulta.setDhAlteracao(dhAlteracao);
            }
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornoConsulta;
    }*/
    public static void inserirServico(Servico pServico) {

        Connection connection = null;

        connection = DAO.getConexao();
        String insert_sql = "INSERT INTO `distribuidora`.`servico`(`idservico`,`dataEntrada`,`pago`,`idstatus`,`idtipo_Lente`,`obs`,`idCliente`,`nuBandeja`,`isLenteCasa`,`isMontagem`,`isSurfacagem`)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        //INSERT INTO `distribuidora`.`servico` (`idservico`, `dataEntrada`, `pago`, `idstatus`, `idtipo_Lente`, `obs`, `idCliente`, `nuBandeja`) VALUES ('4', '2021-03-23', '1', '2', '1', 'teste', '2', '5');
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert_sql);

            preparedStatement.setString(1, pServico.getCodigoServico());
            preparedStatement.setString(2, pServico.getDiaEntradaServico());
            ///preparedStatement.setString(3, pServico.getDiaSaidaServico());
            preparedStatement.setString(3, pServico.getPagoServico());
            preparedStatement.setString(4, pServico.getStatusServico());
            preparedStatement.setString(5, pServico.getDescricaoTipoLenteServico());
            preparedStatement.setString(6, pServico.getObs());
            preparedStatement.setString(7, pServico.getIdClienteServico());
            preparedStatement.setString(8, pServico.getNumeroBandejaServico());
            preparedStatement.setBoolean(9, pServico.getIsLenteCasa());
            preparedStatement.setBoolean(10, pServico.getIsMontagem());
            preparedStatement.setBoolean(11, pServico.getIsSurfacagem());

            preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int alterarServico(Servico pServico) {

        Connection connection = null;
        int resultado = 2;

        connection = DAO.getConexao();
        String update_sql = "UPDATE `distribuidora`.`servico` SET ";
        //String insert_sql = "INSERT INTO `distribuidora`.`servico`(`idservico`,`dataEntrada`,`pago`,`idstatus`,`idtipo_Lente`,`obs`,`idCliente`,`nuBandeja`,`isLenteCasa`)VALUES(?,?,?,?,?,?,?,?,?)";
        //INSERT INTO `distribuidora`.`servico` (`idservico`, `dataEntrada`, `pago`, `idstatus`, `idtipo_Lente`, `obs`, `idCliente`, `nuBandeja`) VALUES ('4', '2021-03-23', '1', '2', '1', 'teste', '2', '5');

        String where_sql = " WHERE (`idservico` = ?)";
        String conector = "";
        int cont = 0;

        if (pServico.getDiaSaidaServico() != null && !pServico.getDiaSaidaServico().equals("")) {
            update_sql = update_sql + conector + "`distribuidora`.`servico`.`dataSaida` = ? ";
            conector = " , ";
        }
        if (pServico.getPagoServico() != null && !pServico.getPagoServico().equals("")) {
            update_sql = update_sql + conector + "`distribuidora`.`servico`.`pago` = ? ";
            conector = " , ";
        }
        if (pServico.getObs() != null && !pServico.getObs().equals("")) {
            update_sql = update_sql + conector + "`distribuidora`.`servico`.`obs` = ? ";
            conector = " , ";
        }
        if (pServico.getNumeroBandejaServico() != null && !pServico.getNumeroBandejaServico().equals("")) {
            update_sql = update_sql + conector + "`distribuidora`.`servico`.`nuBandeja` = ? ";
            conector = " , ";
        }
        update_sql = update_sql + where_sql;

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(update_sql);

            /* preparedStatement.setString(1, pServico.getCodigoServico());
            preparedStatement.setString(2, pServico.getDiaEntradaServico());
            ///preparedStatement.setString(3, pServico.getDiaSaidaServico());
            preparedStatement.setString(3, pServico.getPagoServico());
            preparedStatement.setString(4, pServico.getStatusServico());
            preparedStatement.setString(5, pServico.getDescricaoTipoLenteServico());
            preparedStatement.setString(6, pServico.getObs());
            preparedStatement.setString(7, pServico.getIdClienteServico());*/
            if (pServico.getDiaSaidaServico() != null && !pServico.getDiaSaidaServico().equals("")) {
                preparedStatement.setString(++cont, pServico.getDiaSaidaServico());
            }
            if (pServico.getPagoServico() != null && !pServico.getPagoServico().equals("")) {
                preparedStatement.setString(++cont, pServico.getPagoServico());
            }
            if (pServico.getObs() != null && !pServico.getObs().equals("")) {
                preparedStatement.setString(++cont, pServico.getObs());
            }
            if (pServico.getNumeroBandejaServico() != null && !pServico.getNumeroBandejaServico().equals("")) {
                preparedStatement.setString(++cont, pServico.getNumeroBandejaServico());
            }
            preparedStatement.setString(++cont, pServico.getCodigoServico());

            resultado = preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;

    }

    /*public static void alterarCliente(Cliente pCliente) {

        Connection connection = null;

        connection = DAO.getConexao();
        String update_sql = "UPDATE `distribuidora`.`cliente` SET `CNPJ`=?,`NOME_FANTASIA`=?,`ID_ENDERECO`=?,`NU_TELEFONE`=?,`DH_ALTERACAO`=NOW() WHERE `ID_CLIENTE` =?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(update_sql);
            
            preparedStatement.setString(1, pCliente.getCdCnpj());
            preparedStatement.setString(2, pCliente.getNmNomeFantasia());
            preparedStatement.setInt(3, pCliente.getIdEndereco());
            preparedStatement.setString(4, pCliente.getNuTelefone());
            preparedStatement.setInt(5, pCliente.getIdCliente());

            int resultado = preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deletarCliente(Cliente pCliente) {

        Connection connection = null;

        connection = DAO.getConexao();
        String delete_sql = "DELETE FROM `distribuidora`.`cliente` WHERE `ID_CLIENTE` =?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(delete_sql);
            
            preparedStatement.setInt(1, pCliente.getIdCliente());

            int resultado = preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int gerarSequencialIdCliente(){
        
        ResultSet resultset = null;
        
        String stringMaiorSequencialIdCliente = "";
        int maiorSequencialIdCliente = 0;
        
        try {
            Connection connection = DAO.getConexao();
            String consultar_sql =  "SELECT max(distribuidora.cliente.ID_CLIENTE)AS MAIOR_IDCLIENTE FROM distribuidora.cliente;";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            
            if (resultset != null) {
                resultset.next();
                stringMaiorSequencialIdCliente = resultset.getString("MAIOR_IDCLIENTE");
                if(stringMaiorSequencialIdCliente != null){
                    maiorSequencialIdCliente = Integer.parseInt(stringMaiorSequencialIdCliente);
                    System.out.print(""+ maiorSequencialIdCliente); 
                }else{
                    maiorSequencialIdCliente = 1;
                }
            } 
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++maiorSequencialIdCliente;
    }*/
}
