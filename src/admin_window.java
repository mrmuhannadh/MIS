
//import com.mysql.cj.xdevapi.Statement;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class admin_window extends javax.swing.JFrame {

    /**
     * Creates new form admin_window
     */
    public admin_window() {
        initComponents();
        //show_Users_in_table();
        this.setLocationRelativeTo(null);
        Show_Users_In_JTable();
        Show_Students_In_JTable();
        Show_Lectures_In_JTable();
        Show_Notice_In_JTable();
        Show_TO_In_JTable();
        Show_Subject_In_JTable();
        Show_StudentSubject_In_JTable();
        //Show_TimeTableICT_In_JTable();
        Filecombo();
        FilecomboStudent();
        FilecomboSubject();
        FilecomboDepartment();
        FilecomboMonSubject();
    }
    //
    dbConnection conn= new dbConnection();
    getUsersList ul= new getUsersList();
    
    public void Show_Users_In_JTable(){
        ArrayList<User> list = ul.UsersList();
        DefaultTableModel model = (DefaultTableModel)listuserTable.getModel();
        Object[] row = new Object[4];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).User_ID;
            row[1]=list.get(i).post;
            row[2]=list.get(i).Dep_ID;
            row[3]=list.get(i).date;
            //row[1]=list.get(i).password;
            model.addRow(row);
        }         
    }
    public void executeSQLQueryUser(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)listuserTable.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable();
                JOptionPane.showMessageDialog(null, "User "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" User");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
//    public void executeSQLQueryAdmin(String query, String Message){
//        Connection con = conn.getConnectionAdmin();
//        Statement st;
//        try{
//            st = con.createStatement();
//            if(st.executeUpdate(query)==1){
//                DefaultTableModel model= (DefaultTableModel)listuserTable.getModel();
//                model.setRowCount(0);
//                Show_Users_In_JTable();
//                JOptionPane.showMessageDialog(null, "User "+Message+" Success");
//            }else{
//                JOptionPane.showMessageDialog(null, "Can Not "+Message+" User");
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }
//    
    public void Show_Students_In_JTable(){
        ArrayList<student> list = ul.StudentList();
        DefaultTableModel model = (DefaultTableModel)student_table.getModel();
        Object[] row = new Object[10];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).st_id;
            row[1]=list.get(i).st_firstname;
            row[2]=list.get(i).st_lastname;
            row[3]=list.get(i).age;
            row[4]=list.get(i).DOB;
            row[5]=list.get(i).gender;
            row[6]=list.get(i).tpNo;
            row[7]=list.get(i).email;
            row[8]=list.get(i).address; 
            row[9]=list.get(i).Dep_ID;
            model.addRow(row);
        }         
    }
   public void executeSQLQueryStudent(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)student_table.getModel();
                model.setRowCount(0);
                Show_Students_In_JTable();
                FilecomboStudent();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Invalid data");
        }
    } 
   public void Show_Lectures_In_JTable(){
        ArrayList<lecture> list = ul.LectureList();
        DefaultTableModel model = (DefaultTableModel)lectureTable.getModel();
        Object[] row = new Object[11];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).lec_id;
            row[1]=list.get(i).firstname;
            row[2]=list.get(i).lastname;
            row[3]=list.get(i).age;
            row[4]=list.get(i).DOB;
            row[5]=list.get(i).gender;
            row[6]=list.get(i).tpNo;
            row[7]=list.get(i).email;
            row[8]=list.get(i).address;
            row[9]=list.get(i).qualification;
            row[10]=list.get(i).Dep_ID;
            model.addRow(row);
        }         
    }
   public void executeSQLQueryLecture(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)lectureTable.getModel();
                model.setRowCount(0);
                Show_Lectures_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            ex.printStackTrace();
    }
   }
   
   //Show notices in table
   public void Show_Notice_In_JTable(){
        ArrayList<Notice> list = ul.NoticeList();
        DefaultTableModel model = (DefaultTableModel)NoticeTable.getModel();
        Object[] row = new Object[3];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).id;
            row[1]=list.get(i).date;
            row[2]=list.get(i).notice;
            
            
            model.addRow(row);
        }         
    }
   
    public void executeSQLQueryNotice(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)NoticeTable.getModel();
                model.setRowCount(0);
                Show_Notice_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }
    public void Show_TO_In_JTable(){
        ArrayList<Techofficer> list = ul.TechOfficerList();
        DefaultTableModel model = (DefaultTableModel)TOtable.getModel();
        Object[] row = new Object[11];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).tc_id;
            row[1]=list.get(i).firstname;
            row[2]=list.get(i).lastname;
            row[3]=list.get(i).age;
            row[4]=list.get(i).DOB;
            row[5]=list.get(i).gender;
            row[6]=list.get(i).tpNo;
            row[7]=list.get(i).email;
            row[8]=list.get(i).address; 
            row[9]=list.get(i).qualification; 
            row[10]=list.get(i).Dep_ID;
            model.addRow(row);
        }         
    }
   public void executeSQLQueryTO(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)TOtable.getModel();
                model.setRowCount(0);
                Show_TO_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
   }
   public void Show_Subject_In_JTable(){
        ArrayList<Subject> list = ul.SubjectList();
        DefaultTableModel model = (DefaultTableModel)subTable.getModel();
        Object[] row = new Object[6];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).sub_id;
            row[1]=list.get(i).sub_name;
            row[2]=list.get(i).Lec_id;
            row[3]=list.get(i).Lec_fname;
            row[4]=list.get(i).Lec_lname;
            row[5]=list.get(i).sub_type;

            model.addRow(row);
        }         
    }
   public void executeSQLQuerySubject(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)subTable.getModel();
                model.setRowCount(0);
                Show_Subject_In_JTable();
                FilecomboSubject();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }
   public void Show_StudentSubject_In_JTable(){
        ArrayList<StudentSubject> list = ul.StudentSubjectList();
        DefaultTableModel model = (DefaultTableModel)substudent.getModel();
        Object[] row = new Object[4];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).getSubID();
            row[1]=list.get(i).getSubNameD();
            row[2]=list.get(i).getStID();
            row[3]=list.get(i).getSubtype();
            model.addRow(row);
        }         
    }
   public void executeSQLQueryStudentSubject(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)substudent.getModel();
                model.setRowCount(0);
                Show_StudentSubject_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }
    public void Show_TimeTableICT_In_JTable(){
        DefaultTableModel model = (DefaultTableModel)timetable.getModel();
        model.setRowCount(0);
        ArrayList<TimeTableICT> list = ul.TTICTList();
        
        Object[] row = new Object[6];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).time;
            row[1]=list.get(i).Monday;
            row[2]=list.get(i).Tuesday;
            row[3]=list.get(i).Wendsday;
            row[4]=list.get(i).Thursday;
            row[5]=list.get(i).Friday;
            model.addRow(row);
        }         
    }
    public void Show_TimeTableBST_In_JTable(){
        DefaultTableModel model = (DefaultTableModel)timetable.getModel();
        model.setRowCount(0);
        ArrayList<TimeTableBST> list = ul.TTBSTList();
        //DefaultTableModel model = (DefaultTableModel)timetable.getModel();
        Object[] row = new Object[6];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).time;
            row[1]=list.get(i).Monday;
            row[2]=list.get(i).Tuesday;
            row[3]=list.get(i).Wendsday;
            row[4]=list.get(i).Thursday;
            row[5]=list.get(i).Friday;
            model.addRow(row);
        }         
    }
    public void Show_TimeTableET_In_JTable(){
        DefaultTableModel model = (DefaultTableModel)timetable.getModel();
        model.setRowCount(0);
        ArrayList<TimeTableET> list = ul.TTETList();
        //DefaultTableModel model = (DefaultTableModel)timetable.getModel();
        Object[] row = new Object[6];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).time;
            row[1]=list.get(i).Monday;
            row[2]=list.get(i).Tuesday;
            row[3]=list.get(i).Wendsday;
            row[4]=list.get(i).Thursday;
            row[5]=list.get(i).Friday;
            model.addRow(row);
        }         
    }
    public void executeSQLQueryTimeTableICT(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)timetable.getModel();
                model.setRowCount(0);
                Show_TimeTableICT_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    } 
    public void executeSQLQueryTimeTableBST(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)timetable.getModel();
                model.setRowCount(0);
                Show_TimeTableBST_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }
    public void executeSQLQueryTimeTableET(String query, String Message){
        Connection con = conn.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                DefaultTableModel model= (DefaultTableModel)timetable.getModel();
                model.setRowCount(0);
                Show_TimeTableET_In_JTable();
                JOptionPane.showMessageDialog(null, "Data "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" Data");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }
    private void Filecombo(){
        Connection con = conn.getConnectionStudent();
        Statement st;
        ResultSet rs;
        try{
            String strlec = "select lec_id from lecture";
            st = con.prepareStatement(strlec);
            rs = st.executeQuery(strlec);
            while(rs.next()){
                String Lec_id = rs.getString("lec_id");
                jComboBox1.addItem(Lec_id);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void FilecomboStudent(){
        Connection con = conn.getConnectionStudent();
        Statement st;
        ResultSet rs;
        try{
            String strlec = "select *from student";
            st = con.prepareStatement(strlec);
            rs = st.executeQuery(strlec);
            while(rs.next()){
                String St_id = rs.getString("st_id");
                stid.addItem(St_id);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void FilecomboSubject(){
        Connection con = conn.getConnectionStudent();
        Statement st;
        ResultSet rs;
        try{
            String strlec = "select *from subject";
            st = con.prepareStatement(strlec);
            rs = st.executeQuery(strlec);
            while(rs.next()){
                String Sub_id = rs.getString("sub_id");
                subjectid.addItem(Sub_id);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void FilecomboDepartment(){
        Connection con = conn.getConnectionStudent();
        java.sql.Statement st;
        ResultSet rs;
        try{
            String strlec = "select Dep_ID from department";
            st = con.prepareStatement(strlec);
            rs = st.executeQuery(strlec);
            while(rs.next()){
                String depid = rs.getString("Dep_ID");
                depbox.addItem(depid);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void FilecomboMonSubject(){
        Connection con = conn.getConnectionStudent();
        Statement st;
        ResultSet rs;
        try{
            String strlec = "select *from subject";
            st = con.prepareStatement(strlec);
            rs = st.executeQuery(strlec);
            while(rs.next()){
                String Sub_id = rs.getString("sub_id");
                mon.addItem(Sub_id);
                tue.addItem(Sub_id);
                wens.addItem(Sub_id);
                thu.addItem(Sub_id);
                fri.addItem(Sub_id);
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     *
     */
    
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listuserTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lectureTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TOtable = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NoticeTable = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        monj = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        depbox = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        timetable = new javax.swing.JTable();
        jButton37 = new javax.swing.JButton();
        mon = new javax.swing.JComboBox<>();
        tue = new javax.swing.JComboBox<>();
        wens = new javax.swing.JComboBox<>();
        thu = new javax.swing.JComboBox<>();
        fri = new javax.swing.JComboBox<>();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        selectedtable = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        substudent = new javax.swing.JTable();
        stid = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        subjectid = new javax.swing.JComboBox<>();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        comsubtype = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        subid = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        subTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        subtype = new javax.swing.JComboBox<>();
        logout = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(211, 84, 0));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 245, 245));
        jLabel1.setText("ADMIN WINDOW");

        jTabbedPane1.setBackground(new java.awt.Color(1, 49, 65));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(1, 49, 65));

        jButton28.setBackground(new java.awt.Color(26, 188, 156));
        jButton28.setText("Manage Users");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(26, 188, 156));
        jButton29.setText("Manage Students");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(26, 188, 156));
        jButton30.setText("Manage Lectures");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(26, 188, 156));
        jButton31.setText("Manage Technical Officers");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(26, 188, 156));
        jButton32.setText("Manage Notice");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(26, 188, 156));
        jButton33.setText("Manage Time Table");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(26, 188, 156));
        jButton34.setText("Manage Subject");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(26, 188, 156));
        jButton35.setText("Assign Subjects to Students");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(26, 188, 156));
        jButton36.setText("Logout");
        jButton36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton36MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton36MouseExited(evt);
            }
        });
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton30)
                .addGap(12, 12, 12)
                .addComponent(jButton31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton36)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dash Board", jPanel11);

        jPanel2.setBackground(new java.awt.Color(1, 49, 65));

        listuserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Post", "Department", "Created Date"
            }
        ));
        jScrollPane1.setViewportView(listuserTable);

        jButton3.setBackground(new java.awt.Color(26, 188, 156));
        jButton3.setText("DELETE USER");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(26, 188, 156));
        jButton4.setText("UPDATE USER");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(26, 188, 156));
        jButton9.setText("CREATE USER");
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("USERS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(1, 49, 65));

        student_table.setBackground(new java.awt.Color(254, 254, 254));
        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "First_Name", "Last_Name", "Age", "DOB", "Gender", "TP_no", "Email", "Address", "Department"
            }
        ));
        jScrollPane3.setViewportView(student_table);

        jButton5.setBackground(new java.awt.Color(26, 188, 156));
        jButton5.setText("ADD A STUDENT");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(26, 188, 156));
        jButton6.setText("UPDATE STUDENT DETAILS");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(26, 188, 156));
        jButton7.setText("DELETE A STUDENT");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(26, 188, 156));
        jButton8.setText("SEARCH STUDENT DETAIL");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(12, 12, 12)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("STUDENT", jPanel3);

        jPanel4.setBackground(new java.awt.Color(1, 49, 65));

        lectureTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lecture ID", "First Name", "Last Name", "AGE", "DOB", "Gender", "Mobile", "Email", "Address", "Qualification", "Department"
            }
        ));
        jScrollPane2.setViewportView(lectureTable);

        jButton1.setBackground(new java.awt.Color(26, 188, 156));
        jButton1.setText("ADD  LECTURE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(26, 188, 156));
        jButton10.setText("UPDATE LECTURE DETAILS");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton10MouseExited(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(26, 188, 156));
        jButton11.setText("DELETE LECTURE DETAILS");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton11MouseExited(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(26, 188, 156));
        jButton12.setText("SEARCH LECTURE DETAILS");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addGap(24, 24, 24)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton12)
                        .addGap(31, 31, 31))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("LECTURE", jPanel4);

        jPanel5.setBackground(new java.awt.Color(1, 49, 65));

        TOtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Officer ID", "First Name", "Last Name", "AGE", "DOB", "Gender", "Mobile", "Email", "Address", "Qualification", "Department"
            }
        ));
        jScrollPane6.setViewportView(TOtable);

        jButton17.setBackground(new java.awt.Color(26, 188, 156));
        jButton17.setText("ADD  OFFICER");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton17MouseExited(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(26, 188, 156));
        jButton18.setText("UPDATE OFFICER DETAILS");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton18MouseExited(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(26, 188, 156));
        jButton19.setText("DELETE OFFICER DETAILS");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton19MouseExited(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(26, 188, 156));
        jButton20.setText("SEARCH OFFICER DETAILS");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton20MouseExited(evt);
            }
        });
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton18)
                .addGap(18, 18, 18)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("TECHNICAL OFFICER", jPanel5);

        jPanel6.setBackground(new java.awt.Color(1, 49, 65));

        NoticeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Notice ID", "Date", "Notice"
            }
        ));
        jScrollPane4.setViewportView(NoticeTable);

        jButton13.setBackground(new java.awt.Color(26, 188, 156));
        jButton13.setText("ADD NEW NOTICE");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(26, 188, 156));
        jButton14.setText("DELETE NOTICE");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(26, 188, 156));
        jButton15.setText("UPDATE NOTICE");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(26, 188, 156));
        jButton16.setText("SEARCH NOTICE");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("NOTICE", jPanel6);

        monj.setBackground(new java.awt.Color(1, 49, 65));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Department");

        timetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Mon", "Tue", "Wen", "Thur", "Fri"
            }
        ));
        timetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timetableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(timetable);

        jButton37.setText("View Time Table");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        mon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "NULL", "Interval" }));

        tue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuesday", "NULL", "Interval" }));

        wens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wendsday", "NULL", "Interval" }));

        thu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thursday", "NULL", "Interval" }));

        fri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Friday", "NULL", "Interval" }));

        jButton38.setText("CLEAR");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("UPDATE");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        time.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Monday");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Tuesday");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Thursday");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Wendsday");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Friday");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("Time");

        selectedtable.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        selectedtable.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout monjLayout = new javax.swing.GroupLayout(monj);
        monj.setLayout(monjLayout);
        monjLayout.setHorizontalGroup(
            monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monjLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wens, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
            .addGroup(monjLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel15)
                .addGap(120, 120, 120)
                .addComponent(jLabel10)
                .addGap(94, 94, 94)
                .addComponent(jLabel11)
                .addGap(78, 78, 78)
                .addComponent(jLabel13)
                .addGap(85, 85, 85)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(72, 72, 72))
            .addGroup(monjLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monjLayout.createSequentialGroup()
                            .addComponent(thu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)
                            .addComponent(fri, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monjLayout.createSequentialGroup()
                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(monjLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(52, 52, 52)
                        .addComponent(depbox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton37))
                    .addComponent(selectedtable, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        monjLayout.setVerticalGroup(
            monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monjLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(depbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectedtable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(monjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton39)
                    .addComponent(jButton38))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("TIME TABLE", monj);

        jPanel10.setBackground(new java.awt.Color(1, 49, 65));

        substudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject ID", "Subject Name", "Student ID", "Subject Type"
            }
        ));
        substudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                substudentMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(substudent);

        stid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student ID" }));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 238, 238));
        jLabel5.setText("Choose Subject");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 238, 238));
        jLabel6.setText("Choose Student");

        subjectid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject ID" }));

        jButton25.setBackground(new java.awt.Color(26, 188, 156));
        jButton25.setText("ADD INTO SYSTEM");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(26, 188, 156));
        jButton26.setText("UPDATE");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(26, 188, 156));
        jButton27.setText("DELETE");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        comsubtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Subject Type", "Theory", "Practical" }));

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(254, 238, 238));
        jLabel16.setText("Choose Subject Type");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comsubtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subjectid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(stid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subjectid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comsubtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(21, 21, 21)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ASSIGN SUBJECT", jPanel10);

        jPanel9.setBackground(new java.awt.Color(1, 49, 65));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lecture ID" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 239, 239));
        jLabel3.setText("Subject ID");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(253, 239, 239));
        jLabel4.setText("Subject Name");

        jButton21.setBackground(new java.awt.Color(26, 188, 156));
        jButton21.setText("CLEAR");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton21MouseExited(evt);
            }
        });
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(26, 188, 156));
        jButton22.setText("ADD SUBJECT");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton22MouseExited(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(26, 188, 156));
        jButton23.setText("DELETE SELECTED SUBJECT");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton23MouseExited(evt);
            }
        });
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(26, 188, 156));
        jButton24.setText("UPDATE SELECTED SUBJECT");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton24MouseExited(evt);
            }
        });
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane8.setViewportView(jTextArea2);

        subTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject ID", "Subject Name", "Lecture ID", "Lecture First Name", "Lecture Secound Name", "Subject Type"
            }
        ));
        subTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(subTable);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(253, 239, 239));
        jLabel9.setText("Subject Type");

        subtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theory", "Practical" }));
        subtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addComponent(jButton21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton22))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                    .addComponent(jButton23)
                                    .addGap(2, 2, 2))))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(subtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(70, 70, 70)
                                    .addComponent(subid)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton24, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(subid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton22)
                            .addComponent(jButton21))
                        .addGap(18, 18, 18)
                        .addComponent(jButton24)
                        .addGap(18, 18, 18)
                        .addComponent(jButton23)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SUBJECT", jPanel9);

        logout.setBackground(new java.awt.Color(26, 188, 156));
        logout.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        logout.setForeground(new java.awt.Color(1, 1, 1));
        logout.setText("logout");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(10, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/l.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(211, 84, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)
                        .addComponent(logout)
                        .addGap(36, 36, 36))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(logout))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        JFrame frame = new JFrame("LOGOUT");
        if(JOptionPane.showConfirmDialog(frame,"Do you want to logout","LOGOUT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new SearchLecture().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new DeleteLecture().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new UpdateLecture().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AddLecture().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        new SearchStudent().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new DeleteStudent().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new UpdateStudent().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new AddNewStudent().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new CreateUser().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new DeleteUser().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new AddNotice().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        new DeleteNotice().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        new UpdateNotice().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        new SearchNotice().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton5MouseExited

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(new Color(230,0,0));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_logoutMouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
         jButton6.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
         jButton7.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
         jButton7.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        jButton8.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        jButton8.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
         jButton1.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
         jButton10.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseExited
         jButton10.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton10MouseExited

    private void jButton11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseEntered
         jButton11.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton11MouseEntered

    private void jButton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseExited
        jButton11.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton11MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
         jButton12.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
         jButton12.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        jButton13.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
        jButton13.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        jButton15.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        jButton15.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        jButton14.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        jButton14.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton14MouseExited

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        jButton16.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
       jButton16.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
       jButton9.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        jButton9.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseEntered
        jButton19.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton19MouseEntered

    private void jButton19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseExited
        jButton19.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton19MouseExited

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        new DeleteOfficer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseEntered
       jButton20.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton20MouseEntered

    private void jButton20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseExited
        jButton20.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton20MouseExited

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        new SearchOfficer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        new UpdateOfficer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseExited
        jButton18.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton18MouseExited

    private void jButton18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseEntered
        jButton18.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton18MouseEntered

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        new AddOfficer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseExited
        jButton17.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton17MouseExited

    private void jButton17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseEntered
        jButton17.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton17MouseEntered

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        subid.setText("");
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        String query="insert into subject(sub_id,sub_name,Lec_id,sub_type) values('"+subid.getText()+"','"+jTextArea2.getText()+"','"+jComboBox1.getSelectedItem().toString()+"','"+subtype.getSelectedItem().toString()+"')";
        executeSQLQuerySubject(query, "Inserted");
        subid.setText("");
        jTextArea2.setText("");
        jComboBox1.setSelectedItem(null);
        subtype.setSelectedItem(null);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        JFrame frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame,"Conform if you want to Delete","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            String query="delete from subject where sub_id='"+subid.getText()+"' and sub_name='"+jTextArea2.getText()+"'";
            executeSQLQuerySubject(query, "Deleted");
            subid.setText("");
            jTextArea2.setText("");
            jComboBox1.setSelectedItem(null);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void subTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subTableMouseClicked
        int i= subTable.getSelectedRow();
        TableModel Model = subTable.getModel();
        subid.setText(Model.getValueAt(i, 0).toString());
        jTextArea2.setText(Model.getValueAt(i, 1).toString());
        jComboBox1.setSelectedItem(Model.getValueAt(i, 2).toString());
        subtype.setSelectedItem(Model.getValueAt(i, 5).toString());
    }//GEN-LAST:event_subTableMouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        String query="update subject set sub_name='"+jTextArea2.getText()+"',Lec_id='"+jComboBox1.getSelectedItem().toString()+"' ,sub_type='"+subtype.getSelectedItem().toString()+"' where sub_id='"+subid.getText()+"'";
        executeSQLQuerySubject(query, "Updated");
        subid.setText("");
        jTextArea2.setText("");
        jComboBox1.setSelectedItem(null);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseEntered
        jButton21.setBackground(new Color(230, 0, 0));
    }//GEN-LAST:event_jButton21MouseEntered

    private void jButton21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseExited
        jButton21.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton21MouseExited

    private void jButton23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseEntered
        jButton23.setBackground(new Color(230, 0, 0));
    }//GEN-LAST:event_jButton23MouseEntered

    private void jButton23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseExited
        jButton23.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton23MouseExited

    private void jButton22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseEntered
        jButton22.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton22MouseEntered

    private void jButton22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseExited
        jButton22.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton22MouseExited

    private void jButton24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseEntered
        jButton24.setBackground(new Color(22, 102, 113));
    }//GEN-LAST:event_jButton24MouseEntered

    private void jButton24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseExited
        jButton24.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton24MouseExited

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        String query="insert into studentsubject(st_id,sub_id,sub_type) values('"+stid.getSelectedItem().toString()+"','"+subjectid.getSelectedItem().toString()+"','"+comsubtype.getSelectedItem().toString()+"')";
        executeSQLQueryStudentSubject(query, "Inserted");
        String abc=comsubtype.getSelectedItem().toString();
        System.out.println(""+abc);
        //stid.setSelectedItem(null);
        //subjectid.setSelectedItem(null);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void substudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_substudentMouseClicked
        int i= substudent.getSelectedRow();
        TableModel Model = substudent.getModel();
        subjectid.setSelectedItem(Model.getValueAt(i, 0).toString());
        stid.setSelectedItem(Model.getValueAt(i, 2).toString());
        //subtype.setSelectedItem(Model.getValueAt(i, 3).toString());
       
    }//GEN-LAST:event_substudentMouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String query="update studentsubject set st_id='"+stid.getSelectedItem().toString()+"',sub_id='"+subjectid.getSelectedItem().toString()+"'";
        executeSQLQueryStudentSubject(query, "Updated");
        stid.setSelectedItem(null);
        subjectid.setSelectedItem(null);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        JFrame frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame,"Conform if you want to Delete","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            String query="delete from studentsubject where sub_id='"+subjectid.getSelectedItem().toString()+"' and st_id='"+stid.getSelectedItem().toString()+"' and sub_type='"+comsubtype.getSelectedItem().toString()+"'";
            executeSQLQueryStudentSubject(query, "Deleted");
            stid.setSelectedItem(null);
            subjectid.setSelectedItem(null);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        JFrame frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame,"Do you want to logout","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseEntered
        jButton36.setBackground(new Color(230,0,0));
    }//GEN-LAST:event_jButton36MouseEntered

    private void jButton36MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseExited
        jButton36.setBackground(new Color(26,188,156));
    }//GEN-LAST:event_jButton36MouseExited

    private void subtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtypeActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        String Selected=depbox.getSelectedItem().toString();
        //System.out.println(Selected);
        selectedtable.setText("You can see the "+Selected+" Time Table Below");
        switch(Selected){
            case "ICT":
            Show_TimeTableICT_In_JTable();

            break;
            case "BST":
            Show_TimeTableBST_In_JTable();
            break;
            case "ET":
            Show_TimeTableET_In_JTable();
            break;
        }
//        if(Selected=="ICT"){
//            Show_TimeTableICT_In_JTable();
//        }else if(Selected=="BST"){
//             Show_TimeTableBST_In_JTable();
//        }else if(Selected=="ET"){
//             Show_TimeTableET_In_JTable();
//        }else{
//            System.out.println("Not Selected");
//        }

    }//GEN-LAST:event_jButton37ActionPerformed

    private void timetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timetableMouseClicked
        int i= timetable.getSelectedRow();
        TableModel Modeln = timetable.getModel();
        //time.setSelectedItem(Modeln.getValueAt(i, 0).toString());
        time.setText(Modeln.getValueAt(i, 0).toString());
        mon.setSelectedItem(Modeln.getValueAt(i, 1).toString());
        tue.setSelectedItem(Modeln.getValueAt(i, 2).toString());
        wens.setSelectedItem(Modeln.getValueAt(i, 3).toString());
        thu.setSelectedItem(Modeln.getValueAt(i, 4).toString());
        fri.setSelectedItem(Modeln.getValueAt(i, 5).toString());
    }//GEN-LAST:event_timetableMouseClicked

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        mon.setSelectedItem(null);
        tue.setSelectedItem(null);
        wens.setSelectedItem(null);
        thu.setSelectedItem(null);
        fri.setSelectedItem(null);
        //time.setSelectedItem(null);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        String dep=depbox.getSelectedItem().toString();
//        if(dep=="ICT"){
//        String query="update TimeTable_ICT set Monday='"+mon.getSelectedItem().toString()+"',Tuesday='"+tue.getSelectedItem().toString()+"',Wendsday='"+wens.getSelectedItem().toString()+"',Thursday='"+thu.getSelectedItem().toString()+"',Friday='"+fri.getSelectedItem().toString()+"' where time='"+time.getText()+"'";
//        executeSQLQueryTimeTableICT(query,"Updated");
//        }else if(dep=="BST"){
//            String query="update TimeTable_BST set Monday='"+mon.getSelectedItem().toString()+"',Tuesday='"+tue.getSelectedItem().toString()+"',Wendsday='"+wens.getSelectedItem().toString()+"',Thursday='"+thu.getSelectedItem().toString()+"',Friday='"+fri.getSelectedItem().toString()+"' where time='"+time.getText()+"'";
//        }
//        else if(dep=="ET"){
//            String query="update TimeTable_ET set Monday='"+mon.getSelectedItem().toString()+"',Tuesday='"+tue.getSelectedItem().toString()+"',Wendsday='"+wens.getSelectedItem().toString()+"',Thursday='"+thu.getSelectedItem().toString()+"',Friday='"+fri.getSelectedItem().toString()+"' where time='"+time.getText()+"'";
//        }
//        //DefaultTableModel model = (DefaultTableModel)timetable.getModel();
            switch(dep){
                case "ICT":
                    String query="update TimeTable_ICT set Monday='"+mon.getSelectedItem().toString()+"',Tuesday='"+tue.getSelectedItem().toString()+"',Wendsday='"+wens.getSelectedItem().toString()+"',Thursday='"+thu.getSelectedItem().toString()+"',Friday='"+fri.getSelectedItem().toString()+"' where time='"+time.getText()+"'";
                    executeSQLQueryTimeTableICT(query,"Updated");
                    break;
                case "BST":
                    String querybst="update TimeTable_BST set Monday='"+mon.getSelectedItem().toString()+"',Tuesday='"+tue.getSelectedItem().toString()+"',Wendsday='"+wens.getSelectedItem().toString()+"',Thursday='"+thu.getSelectedItem().toString()+"',Friday='"+fri.getSelectedItem().toString()+"' where time='"+time.getText()+"'";
                    executeSQLQueryTimeTableBST(querybst,"Updated");
                    break;
                case "ET":
                    String queryet="update TimeTable_ET set Monday='"+mon.getSelectedItem().toString()+"',Tuesday='"+tue.getSelectedItem().toString()+"',Wendsday='"+wens.getSelectedItem().toString()+"',Thursday='"+thu.getSelectedItem().toString()+"',Friday='"+fri.getSelectedItem().toString()+"' where time='"+time.getText()+"'";
                    executeSQLQueryTimeTableBST(queryet,"Updated");
                    break;
            }
            mon.setSelectedItem(null);
            tue.setSelectedItem(null);
            wens.setSelectedItem(null);
            thu.setSelectedItem(null);
            fri.setSelectedItem(null);
            
    }//GEN-LAST:event_jButton39ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_window().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable NoticeTable;
    private javax.swing.JTable TOtable;
    private javax.swing.JComboBox<String> comsubtype;
    private javax.swing.JComboBox<String> depbox;
    private javax.swing.JComboBox<String> fri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable lectureTable;
    private javax.swing.JTable listuserTable;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> mon;
    private javax.swing.JPanel monj;
    private javax.swing.JLabel selectedtable;
    private javax.swing.JComboBox<String> stid;
    private javax.swing.JTable student_table;
    private javax.swing.JTable subTable;
    private javax.swing.JTextField subid;
    private javax.swing.JComboBox<String> subjectid;
    private javax.swing.JTable substudent;
    private javax.swing.JComboBox<String> subtype;
    private javax.swing.JComboBox<String> thu;
    private javax.swing.JLabel time;
    private javax.swing.JTable timetable;
    private javax.swing.JComboBox<String> tue;
    private javax.swing.JComboBox<String> wens;
    // End of variables declaration//GEN-END:variables
}
