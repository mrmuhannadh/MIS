
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muhannadhrf
 */
public class getUsersList {
    public ArrayList<User> UsersList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<User> usersList= new ArrayList<User>();
        String query = "select * from users";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            User user;
            while(rs.next()){
                user = new User(rs.getString("user_id"),rs.getString("password"),rs.getString("date"),rs.getString("Dep_ID"),rs.getString("post"));
                usersList.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<student> StudentList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<student> usersList= new ArrayList<student>();
        String query = "select * from student";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            student student;
            while(rs.next()){
                student = new student(rs.getString("st_id"),rs.getString("st_firstname"),rs.getString("st_lastname"),rs.getString("st_age"),rs.getString("DOB"),rs.getString("tpNo"),rs.getString("email"),rs.getString("address"),rs.getString("Dep_ID"),rs.getString("gender"),rs.getBytes("propic"));
                usersList.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    
    public ArrayList<lecture> LectureList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<lecture> usersList= new ArrayList<lecture>();
        String query = "select * from lecture";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            lecture lecture;
            while(rs.next()){
                lecture = new lecture(rs.getString("lec_id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("age"),rs.getString("DOB"),rs.getString("tpNo"),rs.getString("email"),rs.getString("address"),rs.getString("qualification"),rs.getString("Dep_ID"),rs.getString("gender"));
                usersList.add(lecture);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    } 
    public ArrayList<Notice> NoticeList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<Notice> usersList= new ArrayList<Notice>();
        String query = "select * from notice";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Notice Notice;
            while(rs.next()){
                Notice = new Notice(rs.getString("notice_id"),rs.getString("notice"),rs.getString("date"));
                usersList.add(Notice);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    } 
    public ArrayList<Techofficer> TechOfficerList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<Techofficer> usersList= new ArrayList<Techofficer>();
        String query = "select * from techofficer";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Techofficer TO;
            while(rs.next()){
                TO = new Techofficer(rs.getString("tc_id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("age"),rs.getString("DOB"),rs.getString("tpNo"),rs.getString("email"),rs.getString("address"),rs.getString("gender"),rs.getString("qualification"),rs.getString("Dep_ID"));
                usersList.add(TO);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<Subject> SubjectList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<Subject> usersList= new ArrayList<Subject>();
        String query = "select subject.sub_id,subject.sub_name,subject.sub_type,lecture.lec_id,lecture.firstname ,lecture.lastname from lecture inner join subject where lecture.\n" +
"lec_id=subject.Lec_id";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Subject subject;
            while(rs.next()){
                subject = new Subject(rs.getString("sub_id"),rs.getString("sub_name"),rs.getString("Lec_id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("sub_type"));
                usersList.add(subject);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<StudentSubject> StudentSubjectList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<StudentSubject> usersList= new ArrayList<StudentSubject>();
        String query = "select studentsubject.sub_id,subject.sub_name,studentsubject.st_id,subject.sub_type from studentsubject inner join subject where subject.sub_id=studentsubject.sub_id";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            StudentSubject substu;
            while(rs.next()){
                substu = new StudentSubject(rs.getString("sub_id"),rs.getString("sub_name"),rs.getString("st_id"),rs.getString("sub_type"));
                usersList.add(substu);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<TimeTableICT> TTICTList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<TimeTableICT> usersList= new ArrayList<TimeTableICT>();
        String query = "select time,Monday,Tuesday,Wendsday,Thursday,Friday from TimeTable_ICT";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            TimeTableICT TTICT;
            while(rs.next()){
                TTICT = new TimeTableICT(rs.getString("time"),rs.getString("Monday"),rs.getString("Tuesday"),rs.getString("Wendsday"),rs.getString("Thursday"),rs.getString("Friday"));
                usersList.add(TTICT);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<TimeTableBST> TTBSTList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<TimeTableBST> usersList= new ArrayList<TimeTableBST>();
        String query = "select time,Monday,Tuesday,Wendsday,Thursday,Friday from TimeTable_BST";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            TimeTableBST TTBST;
            while(rs.next()){
                TTBST = new TimeTableBST(rs.getString("time"),rs.getString("Monday"),rs.getString("Tuesday"),rs.getString("Wendsday"),rs.getString("Thursday"),rs.getString("Friday"));
                usersList.add(TTBST);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<TimeTableET> TTETList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<TimeTableET> usersList= new ArrayList<TimeTableET>();
        String query = "select time,Monday,Tuesday,Wendsday,Thursday,Friday from TimeTable_ET";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            TimeTableET TTET;
            while(rs.next()){
                TTET = new TimeTableET(rs.getString("time"),rs.getString("Monday"),rs.getString("Tuesday"),rs.getString("Wendsday"),rs.getString("Thursday"),rs.getString("Friday"));
                usersList.add(TTET);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
         return usersList;
    }
    public ArrayList<Marks> marksList(){
        dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<Marks> marksList=new ArrayList<>();
        
        String query="SELECT * FROM marks";
        Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Marks mark;
            while(rs.next()){
                mark=new Marks(rs.getString("st_id"), rs.getString("lec_id") ,rs.getFloat("quiz_1"),rs.getFloat("quiz_2"),rs.getFloat("quiz_3"),rs.getFloat("quiz_4"),rs.getFloat("assessment_1"),rs.getFloat("assessment_2"),rs.getFloat("assessment_3"),rs.getFloat("mid"),rs.getFloat("final_theory"),rs.getFloat("final_practical"),rs.getFloat("Total"),rs.getFloat("Grade_point"),rs.getString("Grade"),rs.getString("sub_id"));
                marksList.add(mark);
                
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }

        return marksList;
    }
     public ArrayList<Attendance> attendanceList(){
         dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<Attendance> attendanceList=new ArrayList<>();
       
            String query="SELECT * FROM attendance";
            Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            
            Attendance attendant;
            while(rs.next()){
                attendant=new Attendance(rs.getString("st_id"),rs.getString("lec_id"),rs.getString("lec_type"),rs.getDate("date"),rs.getInt("PR_AB_status"),rs.getInt("M_status"),rs.getString("sub_id"));
                attendanceList.add(attendant);
                
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }

        return attendanceList;
    }
     public ArrayList<MedTO> medicalList(){
         dbConnection dbc=new dbConnection();
        Connection connection = dbc.getConnectionStudent();
        ArrayList<MedTO> medicalList=new ArrayList<>();
       
            String query="SELECT * FROM medical";
            Statement st;
        ResultSet rs;
         try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            
            MedTO medical;
            while(rs.next()){
                medical=new MedTO(rs.getString("stu_id"),rs.getString("sub_id"),rs.getString("sub_type"),rs.getString("date"),rs.getString("med_status"));
                medicalList.add(medical);
                
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }

        return medicalList;
    }
}
