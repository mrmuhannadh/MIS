/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class Notice {
        String id;
        String date;
        String notice;

    public Notice(String id, String date, String notice) {
        this.id = id;
        this.date = date;
        this.notice = notice;
    }
    
    public String setID(){
        return id;
    }
    public String setNotice(){
        return notice;
    }
    public String setDate(){
        return date;
    }
}
