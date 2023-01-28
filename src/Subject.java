/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class Subject {
        String sub_id;
        String sub_name;
        String Lec_id;
        String Lec_fname;
        String Lec_lname;
        String sub_type;
    public Subject(String sub_id, String sub_name, String Lec_id, String firstname, String lastname, String sub_type) {
        this.sub_id = sub_id;
        this.sub_name = sub_name;
        this.Lec_id = Lec_id;
        this.Lec_fname = firstname;
        this.Lec_lname = lastname;
        this.sub_type = sub_type;
    }
        
    public String getID(){
        return sub_id;
    }
    public String getName(){
        return sub_name;
    }
    public String getLecID(){
        return Lec_id;
    }
    public String getFirstName(){
        return Lec_fname;
    }
    public String getLastName(){
        return Lec_lname;
    }
    public String getSubType(){
        return sub_type;
    }
}
