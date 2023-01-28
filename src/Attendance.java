
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MuhannadhRF
 */
public class Attendance {
    String st_id;
    String lec_id;
    String lec_type;
    Date date;
    int PR_AB_status;
    int M_status;
    String Sub_id;

    public Attendance(String st_id, String lec_id, String lec_type, Date date, int PR_AB_status, int M_status, String Sub_id) {
        this.st_id = st_id;
        this.lec_id = lec_id;
        this.lec_type = lec_type;
        this.date = date;
        this.PR_AB_status = PR_AB_status;
        this.M_status = M_status;
        this.Sub_id = Sub_id;
    }
    public String getst_id(){
        return st_id;
    }  
    public String getlec_id(){
        return lec_id;
    }  
    public String getlec_type(){
        return lec_type;
    }  
    public Date getdate(){
        return date;
    }  
    public int getPR_AB_status(){
        return PR_AB_status;
    }  
    public int getM_status(){
        return M_status;
    }  
    public String getSub_id(){
        return Sub_id;
    }  
    
}
