package br.com.control;

import static br.com.control.DAO.fecharConexao;
import br.com.model.Cliente;
import br.com.model.Endereco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOEndereco {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //inserirEndereco();	

        //ResultSet resultset = consultarCliente();

        //resultset.close();
        //int i = gerarSequencialIdEndereco();
    }

    private static ResultSet consultarEndereco() throws SQLException {

        Connection connection = null;
        ResultSet resultset = null;

        connection = DAO.getConexao();
        String consultar_sql = "SELECT * FROM `distribuidora`.`endereco`";
        Statement st = connection.createStatement();
        resultset = st.executeQuery(consultar_sql);
        //PreparedStatement preparedStatement = connection.prepareStatement(consultar_sql);
        //preparedStatement.executeQuery(consultar_sql);
        //resultset = preparedStatement.getResultSet();
        if (resultset != null) {

            while (resultset.next()) {
                String idCliente = resultset.getString("ID_CLIENTE");
               Cliente cliente = new Cliente();
               cliente.setIdCliente(Integer.parseInt(idCliente));

                //System.out.println(nome + " -  " + cnpj);
            }
        } else {
            connection.close();
        }

        return resultset;
    }
    
    public static Endereco consultarPorChavePrimariaEndereco(Endereco pEndereco) {

        Connection connection = null;
        Endereco retornoConsulta = null;

        connection = DAO.getConexao();
        String select_sql = "SELECT * FROM `distribuidora`.`endereco`";
        String where_sql = " WHERE ";
        
        if(pEndereco.getIdEndereco() != null){
            select_sql = select_sql + where_sql + " `ID_ENDERECO`  = ? ";
        }
        //,`CNPJ`,`NOME_FANTASIA`,`DATA_INCLUSAO`,`ID_ENDERECO`,`NU_TELEFONE`,`DH_ALTERACAO`) VALUES(?,?,?,NOW(),?,?,NOW());";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(select_sql);
            if(pEndereco.getIdEndereco() != null){
                preparedStatement.setInt(1, pEndereco.getIdEndereco());
            }
            /*preparedStatement.setString(2, pCliente.getCdCnpj());
            preparedStatement.setString(3, pCliente.getNmNomeFantasia());
            preparedStatement.setInt(4, pCliente.getIdEndereco());
            preparedStatement.setString(5, pCliente.getNuTelefone());*/

            preparedStatement.execute();
            
            ResultSet resultset = preparedStatement.getResultSet();
            if(resultset != null){
                resultset.next();
                String idEndereco = resultset.getString("ID_ENDERECO");
                String nmRua = resultset.getString("NM_RUA");
                String nuNumero = resultset.getString("NU_NUMERO");
                String nmComplemente = resultset.getString("NM_COMPLEMENTO");
                String nmBairro = resultset.getString("NM_BAIRRO");
                String nmCidade = resultset.getString("NM_CIDADE");
                String nmEstado = resultset.getString("NM_ESTADO");
                String nmPais = resultset.getString("NM_PAIS");
                String nuCep = resultset.getString("NU_CEP");
                String nuTelefone = resultset.getString("NU_TELEFONE");
                Timestamp dhAlteracao = resultset.getTimestamp("DH_ALTERACAO");               

                    
                retornoConsulta = new Endereco();
                retornoConsulta.setIdEndereco(Integer.parseInt(idEndereco));
                retornoConsulta.setNmRua(nmRua);
                retornoConsulta.setNmComplemento(nmComplemente);
                retornoConsulta.setNmNumero(nuNumero);
                retornoConsulta.setNmBairro(nmBairro);
                retornoConsulta.setNmCidade(nmCidade);
                retornoConsulta.setNmEstado(nmEstado);
                retornoConsulta.setNmPais(nmPais);
                retornoConsulta.setNmCep(nuCep);
                retornoConsulta.setNmTelefone(nuTelefone);

            }
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornoConsulta;
    }

    public static void inserirEndereco(Endereco pEndereco) {

        Connection connection = null;

        connection = DAO.getConexao();
        String insert_sql = "INSERT INTO `distribuidora`.`endereco`(`ID_ENDERECO`,`NM_RUA`,`NU_NUMERO`,`NM_COMPLEMENTO`,`NM_BAIRRO`,`NM_CIDADE`,`NM_ESTADO`,`NM_PAIS`,`NU_CEP`)VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert_sql);

            preparedStatement.setInt(1, pEndereco.getIdEndereco());
            preparedStatement.setString(2, pEndereco.getNmRua());
            preparedStatement.setString(3, pEndereco.getNmNumero());
            preparedStatement.setString(4, pEndereco.getNmComplemento());
            preparedStatement.setString(5, pEndereco.getNmBairro());
            preparedStatement.setString(6, pEndereco.getNmCidade());
            preparedStatement.setString(7, pEndereco.getNmEstado());
            preparedStatement.setString(8, pEndereco.getNmPais());
            preparedStatement.setString(9, pEndereco.getNmCep());

            preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void alterarEndereco(Endereco pEndereco) {

        Connection connection = null;

        connection = DAO.getConexao();
        String update_sql = "UPDATE `distribuidora`.`endereco` SET `NM_RUA`= ?,`NU_NUMERO`= ?,`NM_COMPLEMENTO`= ?,`NM_BAIRRO`= ?,`NM_CIDADE`= ?,`NM_ESTADO`= ?,`NM_PAIS`= ?,`NU_CEP`= ?, `DH_ALTERACAO` = NOW()  WHERE `ID_ENDERECO` = ?";
               
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(update_sql);

            preparedStatement.setString(1, pEndereco.getNmRua());
            preparedStatement.setString(2, pEndereco.getNmNumero());
            preparedStatement.setString(3, pEndereco.getNmComplemento());
            preparedStatement.setString(4, pEndereco.getNmBairro());
            preparedStatement.setString(5, pEndereco.getNmCidade());
            preparedStatement.setString(6, pEndereco.getNmEstado());
            preparedStatement.setString(7, pEndereco.getNmPais());
            preparedStatement.setString(8, pEndereco.getNmCep());
            preparedStatement.setInt(9, pEndereco.getIdEndereco());

            int resultado = preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void deletarEndereco(Endereco pEndereco) {

        Connection connection = null;

        connection = DAO.getConexao();
        String delete_sql = "DELETE FROM `distribuidora`.`endereco` WHERE `ID_ENDERECO` = ?";
               
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(delete_sql);

            preparedStatement.setInt(1, pEndereco.getIdEndereco());

            int resultado = preparedStatement.executeUpdate();
            fecharConexao(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int gerarSequencialIdEndereco(){
        
        ResultSet resultset = null;
        
        String stringMaiorSequencialIdEndereco = "";
        int maiorSequencialIdEndereco = 0;
        
        try {
            Connection connection = DAO.getConexao();
            String consultar_sql =  "SELECT max(distribuidora.endereco.ID_ENDERECO)AS MAIOR_IDENDERECO FROM distribuidora.endereco;";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            
            if (resultset != null) {
                resultset.next();
                stringMaiorSequencialIdEndereco = resultset.getString("MAIOR_IDENDERECO");
                maiorSequencialIdEndereco = Integer.parseInt(stringMaiorSequencialIdEndereco);
                System.out.print(""+ maiorSequencialIdEndereco);
            } 
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++maiorSequencialIdEndereco;
    }

}
