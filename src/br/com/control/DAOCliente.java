package br.com.control;

import static br.com.control.DAO.fecharConexao;
import br.com.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOCliente {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //inserirClinete();	

        //ResultSet resultset = consultarCliente();

        //resultset.close();
        //int i = gerarSequencialIdCliente();
        
        Cliente c =  new Cliente();
        c.setIdCliente(2);
        consultarPorChavePrimariaCliente(c);
    }

    public static ArrayList<Cliente> consultarCliente() {
        ArrayList<Cliente> arrayListCliente = null;
        try {
            Connection connection = null;
            ResultSet resultset = null;
            arrayListCliente = new ArrayList();
            
            connection = DAO.getConexao();
            String consultar_sql = "SELECT * FROM distribuidora.cliente order by distribuidora.cliente.idcliente desc;";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            if (resultset != null) {
                
                while (resultset.next()) {
                    Integer idCliente = resultset.getInt("idCliente");
                    String cdCnpj = resultset.getString("cnpj");
                    String nmNomFantasia = resultset.getString("nomeCliente");
                    /*Date dhInclusao = resultset.getDate("DATA_INCLUSAO");
                    int idEndereco = resultset.getInt("ID_ENDERECO");
                    String nuTelefone = resultset.getString("NU_TELEFONE");
                    Timestamp dhAlteracao = resultset.getTimestamp("DH_ALTERACAO");*/
                    
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(idCliente);
                    cliente.setCdCnpj(cdCnpj);
                    cliente.setNmNomeFantasia(nmNomFantasia);
                    /*cliente.setDataInclusao(dhInclusao.toString());
                    cliente.setIdEndereco(idEndereco);
                    cliente.setNuTelefone(nuTelefone);
                    cliente.setDhAlteracao(dhAlteracao);*/
                    
                    arrayListCliente.add(cliente);
                    
                }
            }
            fecharConexao(connection);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListCliente;
    }
    
    public static Cliente consultarPorChavePrimariaCliente(Cliente pCliente) {

        Connection connection = null;
        Cliente retornoConsulta = null;

        connection = DAO.getConexao();
        String select_sql = "SELECT * FROM `distribuidora`.`cliente`";
        String where_sql = " WHERE ";
        
        if(pCliente.getCdCnpj() != null){
            select_sql = select_sql + where_sql + " `CNPJ`  = ? ";
        }else if (pCliente.getIdCliente() != null) {
            select_sql = select_sql + where_sql + " `idCliente`  = ? ";
        }
        //,`CNPJ`,`NOME_FANTASIA`,`DATA_INCLUSAO`,`ID_ENDERECO`,`NU_TELEFONE`,`DH_ALTERACAO`) VALUES(?,?,?,NOW(),?,?,NOW());";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(select_sql);
            if(pCliente.getCdCnpj() != null){
                preparedStatement.setString(1, pCliente.getCdCnpj());
            } else if (pCliente.getIdCliente() != null) {
                preparedStatement.setString(1, Integer.toString(pCliente.getIdCliente()));
        }
            /*preparedStatement.setString(2, pCliente.getCdCnpj());
            preparedStatement.setString(3, pCliente.getNmNomeFantasia());
            preparedStatement.setInt(4, pCliente.getIdEndereco());
            preparedStatement.setString(5, pCliente.getNuTelefone());*/

            preparedStatement.execute();
            
            ResultSet resultset = preparedStatement.getResultSet();
            if(resultset != null){
                resultset.next();
                String idCliente = resultset.getString("idCliente");
                 String nmNomFantasia = resultset.getString("nomeCliente");
                // Date dhInclusao = resultset.getDate("DATA_INCLUSAO");
                /*String cdCnpj = resultset.getString("CNPJ");
               
                
                int idEndereco = resultset.getInt("ID_ENDERECO");
                String nuTelefone = resultset.getString("NU_TELEFONE");
                Timestamp dhAlteracao = resultset.getTimestamp("DH_ALTERACAO");*/

                retornoConsulta = new Cliente();
                retornoConsulta.setIdCliente(Integer.parseInt(idCliente));
                //retornoConsulta.setCdCnpj(cdCnpj);
                retornoConsulta.setNmNomeFantasia(nmNomFantasia);
                //retornoConsulta.setDataInclusao(dhInclusao.toString());
                //retornoConsulta.setIdEndereco(idEndereco);
                //retornoConsulta.setNuTelefone(nuTelefone);
                //retornoConsulta.setDhAlteracao(dhAlteracao);
            }
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornoConsulta;
    }

    public static void inserirCliente(Cliente pCliente) {

        Connection connection = null;

        connection = DAO.getConexao();
        //INSERT INTO `distribuidora`.`cliente`(`ID_CLIENTE`,`CNPJ`,`NOME_FANTASIA`,`DATA_INCLUSAO`,`ID_ENDERECO`,`NU_TELEFONE`,`DH_ALTERACAO`) VALUES(?,?,?,NOW(),?,?,NOW());";
        String insert_sql = "INSERT INTO `distribuidora`.`cliente`(`idcliente`,`nomeCliente`,`cnpj`)VALUES(?,?,?)";


        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert_sql);

            preparedStatement.setInt(1, pCliente.getIdCliente());
            preparedStatement.setString(2, pCliente.getNmNomeFantasia());
            preparedStatement.setString(3, pCliente.getCdCnpj());
            
            //preparedStatement.setInt(4, pCliente.getIdEndereco());
            //preparedStatement.setString(5, pCliente.getNuTelefone());

            preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void alterarCliente(Cliente pCliente) {

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
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int gerarSequencialIdCliente(){
        
        ResultSet resultset = null;
        
        String stringMaiorSequencialIdCliente = "";
        int maiorSequencialIdCliente = 0;
        
        try {
            Connection connection = DAO.getConexao();
            String consultar_sql =  "SELECT max(distribuidora.cliente.idcliente)AS MAIOR_IDCLIENTE FROM distribuidora.cliente;";
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
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++maiorSequencialIdCliente;
    }
}
