package br.com.control;

import static br.com.control.DAO.fecharConexao;
import br.com.model.Cliente;
import br.com.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProduto {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //inserirClinete();	

        //ResultSet resultset = consultarCliente();

        //resultset.close();
        //int i = gerarSequencialIdCliente();
        
        //Cliente c =  new Cliente();
        //c.setIdCliente(2);
        //consultarPorChavePrimariaCliente(c);
    }

    public static ArrayList<Produto> consultarProduto() {
        ArrayList<Produto> arrayListProduto = null;
        try {
            Connection connection = null;
            ResultSet resultset = null;
            arrayListProduto = new ArrayList();
            
            connection = DAO.getConexao();
            String consultar_sql = "SELECT * FROM distribuidora.produto";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            if (resultset != null) {
                
                while (resultset.next()) {

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
                    
                    Produto produto = new Produto();
                    produto.setIdProduto(idProduto);
                    produto.setNmProduto(nmProduto);
                    produto.setCdProduto(cdProduto);
                    produto.setNmFabricante(nmFabricante);
                    produto.setNmMateriaPrima(nmMateriaPrima);
                    produto.setNuGrauEsferico(nuGrauEsferico);
                    produto.setNuGrauCilindrico(nuGrauCilindrico);
                    produto.setNuBase(nuBase);
                    produto.setNuEspessura(nuEspessura);
                    produto.setDhInclusao(dhInclusao);
                    produto.setDhAlteracao(dhAlteracao);
                    
                    arrayListProduto.add(produto);
                    
                }
            }
            fecharConexao(connection);
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListProduto;
    }
    
    public static Produto consultarPorChavePrimariaProduto(Produto pProduto) {

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
            /*preparedStatement.setString(2, pCliente.getCdCnpj());
            preparedStatement.setString(3, pCliente.getNmNomeFantasia());
            preparedStatement.setInt(4, pCliente.getIdEndereco());
            preparedStatement.setString(5, pCliente.getNuTelefone());*/

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
    }

    public static void inserirCliente(Cliente pCliente) {

        Connection connection = null;

        connection = DAO.getConexao();
        String insert_sql = "INSERT INTO `distribuidora`.`produto`(`ID_PRODUTO`,`NM_PRODUTO`,`CD_PRODUTO`,`NM_FABRICANTE`,`NM_MATERIA_PRIMA`,`NU_GRAU_ESFERICO`,`NU_GRAU_CILINDRICO`,`NU_BASE`,`TP_PRODUTO`,`VL_PRODUTO_COMPRA`,`VL_PRODUTO_VENDA`,`NU_ESPESSURA`,`DH_INCLUSAO`,`DH_ALTERACAO`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert_sql);

            preparedStatement.setInt(1, pCliente.getIdCliente());
            preparedStatement.setString(2, pCliente.getCdCnpj());
            preparedStatement.setString(3, pCliente.getNmNomeFantasia());
            preparedStatement.setInt(4, pCliente.getIdEndereco());
            preparedStatement.setString(5, pCliente.getNuTelefone());

            preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
