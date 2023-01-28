/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class StudentSubject {
    String sub_id;
    String sub_name;
    String st_id;
    String sub_type;
    public StudentSubject(String sub_id, String sub_name, String st_id, String sub_type) {
        this.sub_id = sub_id;
        this.sub_name = sub_name;
        this.st_id = st_id;
        this.sub_type= sub_type;
    }
    public String getSubID(){
        return sub_id;
    }
    public String getSubNameD(){
        return sub_name;
    }
    public String getStID(){
        return st_id;
    }
    public String getSubtype(){
        return sub_type;
    }
}
