
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
public class displayMessages {
    public void executeSQLQuery(String query, String Message){
        dbConnection conn= new dbConnection();
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                //DefaultTableModel model= (DefaultTableModel)jTable_Display_User.getModel();
                //model.setRowCount(0);
                //Show_Users_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not "+Message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
