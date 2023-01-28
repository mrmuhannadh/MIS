
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class User {
        String User_ID;
        String password;
        String date;
        String Dep_ID;
        String post;

    public User(String User_ID, String password, String date, String Dep_ID, String post) {
        this.User_ID = User_ID;
        this.password = password;
        this.date = date;
        this.Dep_ID = Dep_ID;
        this.post = post;
    }
         
            public String getUserid(){
                return User_ID;
            }
            public String getPassword(){
                return password;   
            }
            public String getDate(){
                return date;   
            }
            public String getDep(){
                return Dep_ID;   
            }
            public String getPost(){
                return post;   
            }
 
    }
    


        

