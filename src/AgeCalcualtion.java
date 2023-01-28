
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class AgeCalcualtion {
    public int calcAGE(String dob){
        String dYear=dob;
        int BirthYear= Integer.parseInt(dob);
        SimpleDateFormat dtoday = new SimpleDateFormat("yyyy");
        Date year = new Date();
        String today = dtoday.format(year);
        int thisYear = Integer.parseInt(today);
        int age = thisYear-BirthYear;
        System.out.println(age);
        return age;
    }
    
}
