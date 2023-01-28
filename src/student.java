/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class student {
        String st_id;
        String st_firstname;
        String st_lastname;
        String age;
        String DOB;
        String tpNo;
        String email;
        String address;
        String Dep_ID;
        String gender;
        byte[] propic;
        public student(String Student_ID,String First_Name,String Last_Name,String Age,String DOB,String Tp_no,String Email,String Address,String Department,String gender,byte[] image){
            this.st_id=Student_ID;
            this.st_firstname=First_Name;
            this.st_lastname=Last_Name;
            this.age=Age;
            this.DOB=DOB;
            this.tpNo=Tp_no;
            this.email=Email;
            this.address=Address;
            this.Dep_ID=Department;
            this.gender = gender;
            this.propic = image; 
        }    

            public String getStID(){
                return st_id;   
            }    
            public String getfirstname(){
                return st_firstname;   
            }
            public String getlaststname(){
                return st_lastname;   
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
           public String getDep(){
                return Dep_ID;   
            }
           public String getGender(){
            return gender;   
            }
           public byte[] getImage(){
            return propic;   
            }
}
