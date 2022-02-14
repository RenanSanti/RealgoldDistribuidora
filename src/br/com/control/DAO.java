package br.com.control;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.sql.PooledConnection;

//import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAO {
	
    DataSource dataSouce = null;

    public DAO() throws SQLException{


    }

    public static Connection getConexao()  {
        Connection connection = null;
        try{
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            String serverName = "localhost:3306";
            String schemaDataBase = "distribuidora";
            String url = "jdbc:mysql://" + serverName + "/" + schemaDataBase;
            String nomeUsuario = "root";
            //String senhaUsuario = "du8tv6f7";
            String senhaUsuario = "root";

            /*MysqlConnectionPoolDataSource mysqlConnection = (MysqlConnectionPoolDataSource) new MysqlConnectionPoolDataSource();
            mysqlConnection.setUser(nomeUsuario);
            mysqlConnection.setPassword(senhaUsuario);
            mysqlConnection.setUrl(url);

            PooledConnection pool = mysqlConnection.getPooledConnection();*/


            connection = DriverManager.getConnection(url, nomeUsuario, senhaUsuario);
            //connection = pool.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static void fecharConexao(Connection connection) throws SQLException{
        //connection.commit();
        connection.close();
    }

}
