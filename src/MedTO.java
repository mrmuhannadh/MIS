/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MuhannadhRF
 */
public class MedTO {
    private String stu_id;
    private String sub_id;
    private String sub_type;
    private String meddate;
    private String medical_status;

    public MedTO(String stu_id, String sub_id, String sub_type, String meddate, String medical_status) {
        this.stu_id = stu_id;
        this.sub_id = sub_id;
        this.sub_type = sub_type;
        this.meddate = meddate;
        this.medical_status = medical_status;
    }
     public String getstu_id(){
        return stu_id;
    }
      public String getsub_id(){
        return sub_id;
    }
       public String getsubType(){
        return sub_type;
    }
        public String getMedDate(){
        return meddate;
    }
         public String getMEStatus(){
        return medical_status;
    }
}
