
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class dbConnection {

   public Connection getConnectionStudent(){
        try{
            Connection con2;
            String url="jdbc:mysql://localhost:3308/mis";
            String user="root";           
            String password="";
            con2 = (Connection) DriverManager.getConnection(url, user, password);
            return con2;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
