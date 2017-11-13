package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String usuario = "root";
    private static String senha = "casa";
    private static String banco = "np1";
    private static String ip = "127.0.0.1:3306";
    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection conexao = null;

    
   public Connection getConnection() {
        try {
            Class.forName(driver);
            if(conexao==null || conexao.isClosed()){
                conexao=DriverManager.getConnection("jdbc:mysql://" + ip + "/" + banco ,usuario, senha);
            }
            return conexao; 
        }catch (ClassNotFoundException e) {    
            throw new RuntimeException(e);    
        }catch (SQLException e) {

            closeConnection();
            throw new RuntimeException(e);
        }

    }

    private static void closeConnection(){
        try{
            if(conexao!=null && !conexao.isClosed()){
                conexao.close();
                System.out.println(">>Conexao encerrada com sucesso");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

