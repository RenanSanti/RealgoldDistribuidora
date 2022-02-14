package br.com.control;

import br.com.model.Cliente;
import br.com.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsuario {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //inserirClinete();	

        ArrayList<Usuario> resultset = consultarUsuario();

        
    }

    public static ArrayList<Usuario> consultarUsuario() {
        ArrayList<Usuario> arrayUsuario = new ArrayList();
        try {
            Connection connection = null;
            ResultSet resultset = null;
            
            
            
            connection = DAO.getConexao();
            String consultar_sql = "SELECT * FROM distribuidora.usuario";
            Statement st = connection.createStatement();
            resultset = st.executeQuery(consultar_sql);
            //PreparedStatement preparedStatement = connection.prepareStatement(consultar_sql);
            //preparedStatement.executeQuery(consultar_sql);
            //resultset = preparedStatement.getResultSet();
            if (resultset != null) {
                
                while (resultset.next()) {
                    String idUsuario = resultset.getString("idUsuario");
                    String nmLogin = resultset.getString("nmLogin");
                    String nmSenha = resultset.getString("senha");
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(idUsuario);
                    usuario.setNmLogin(nmLogin);
                    usuario.setNmSenha(nmSenha);
                    
                    System.out.println(idUsuario + " -  " + nmLogin);
                    arrayUsuario.add(usuario);
                }
            } else {
                connection.close();
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayUsuario;
    }

    public static void inserirUsuario(Usuario pUusario) {

        Connection connection = null;

        connection = DAO.getConexao();
        String insert_sql = "INSERT INTO `distribuidora`.`usuario`(`idUsuario`,`nmLogin`,`senha`)VALUES(?,?,?)";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(insert_sql);

            preparedStatement.setString(1, pUusario.getIdUsuario());
            preparedStatement.setString(2, pUusario.getNmLogin());
            preparedStatement.setString(3, pUusario.getNmSenha());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
