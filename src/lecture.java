/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class lecture {
    String lec_id;
    String firstname;
    String lastname;
    String age;
    String DOB;
    String tpNo;
    String email;
    String address;
    String qualification;
    String Dep_ID;
    String gender;

    public lecture(String lec_id, String firstname, String lastname, String age, String DOB, String tpNo, String email, String address, String qualification, String Dep_ID,String gender) {
        this.lec_id = lec_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.DOB = DOB;
        this.tpNo = tpNo;
        this.email = email;
        this.address = address;
        this.qualification = qualification;
        this.Dep_ID = Dep_ID;
        this.gender = gender;
    }

    lecture(String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public String getLecID() {
            return lec_id;
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
       public String getGender(){
            return gender;   
        }
}
