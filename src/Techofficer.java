/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class Techofficer {
    String tc_id;
    String firstname;
    String lastname;
    String age;
    String DOB;
    String tpNo;
    String email;
    String address;
    String gender;
    String qualification;
    String Dep_ID;

    public Techofficer(String tc_id, String firstname, String lastname, String age, String DOB, String tpNo, String email, String address, String gender, String qualification, String Dep_ID) {
        this.tc_id = tc_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.DOB = DOB;
        this.tpNo = tpNo;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.qualification = qualification;
        this.Dep_ID = Dep_ID;
    }
    public String gettcID() {
            return tc_id;
        }
        public String getfirstname(){
            return firstname;   
        }
        public String getlaststname(){
            return lastname;   
        }
        public String getAge(){
            return age;   
        }
        public String getdob(){
            return DOB;   
        }
        
       public String gettp(){
            return tpNo;   
        }
       public String getemail(){
            return email;   
        }
       public String getaddress(){
            return address;   
        }
       public String getqualification(){
            return qualification;   
        }
       public String getDep(){
            return Dep_ID;   
        }
       
}
