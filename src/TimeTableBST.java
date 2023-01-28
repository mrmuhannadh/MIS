/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MuhannadhRF
 */
public class TimeTableBST {
    String time;
    String Monday;
    String Tuesday;
    String Wendsday;
    String Thursday;
    String Friday;

    public TimeTableBST(String time, String Monday, String Tuesday, String Wendsday, String Thursday, String Friday) {
        this.time = time;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wendsday = Wendsday;
        this.Thursday = Thursday;
        this.Friday = Friday;
    }
    public String getTime(){
        return time;
    }
    public String getMon(){
        return Monday;
    }
    public String getTue(){
        return Tuesday;
    }
    public String getWen(){
        return Wendsday;
    }
    public String getThus(){
        return Thursday;
    }
    public String getFri(){
        return Friday;
    }
}
