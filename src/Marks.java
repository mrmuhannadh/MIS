/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Date;

/**
 *
 * @author dinal
 */
class Marks {
      private String st_id,lec_id,Grade,sub_id;
      private float quiz_1,quiz_2,quiz_3,quiz_4,assessment_1,assessment_2,assessment_3,mid,final_theory,final_practical,Total,Grade_point;


public Marks(String st_id,String lec_id,float quiz_1,float quiz_2,float quiz_3,float quiz_4,float assessment_1,float assessment_2,float assessment_3,float mid,float final_theory,float final_practical,float Total,float Grade_point,String Grade,String sub_id){
        this.st_id=st_id;
        this.lec_id=lec_id;
        this.quiz_1=quiz_1;
        this.quiz_2=quiz_2;
        this.quiz_3=quiz_3;
        this.quiz_4=quiz_4;
        this.assessment_1=assessment_1;
        this.assessment_2=assessment_2;
        this.assessment_3=assessment_3;
        this.mid=mid;
        this.final_theory=final_theory;
        this.final_practical=final_practical;
        this.Total=Total;
        this.Grade_point=Grade_point;
        this.Grade=Grade;
        this.sub_id=sub_id;
        
    }

   
    
 
  

   
    public String getst_id(){
        return st_id;
    }
    public String getlec_id(){
        return lec_id;
    }
    public float getquiz_1(){
        return quiz_1;
    }
     public float getquiz_2(){
        return quiz_2;
    }
      public float getquiz_3(){
        return quiz_3;
    }
       public float getquiz_4(){
        return quiz_4;
    }
     public float getassessment_1(){
        return assessment_1;
    }
      public float getassessment_2(){
        return assessment_2;
    }
       public float getassessment_3(){
        return assessment_3;
    }
        public float getmid(){
        return mid;
    }
     public float getfinal_theory(){
        return final_theory;
    }
      public float getfinal_practical(){
        return final_practical;
    }
public float getTotal(){
        return Total;
    }
public float getGrade_point(){
        return Grade_point;
    }

  public String getGrade(){
        return Grade;
    }  
    public String getsubid(){
        return sub_id;
    }
   
}

