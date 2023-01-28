/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import com.mysql.cj.xdevapi.Statement;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class student_window extends javax.swing.JFrame {

    /**
     * Creates new form window
     */
    dbConnection dbc = new dbConnection();
    Login lg = new Login();
    Connection connect = dbc.getConnectionStudent();
    getUsersList ul = new getUsersList();
    Statement st;
    ResultSet rs;
    String FName;
    String depIDStu;
    String user;
    admin_window aw = new admin_window();
    //to display the output from query
    public void executeSQLQuerySubject(String query){
        Connection con = dbc.getConnectionStudent();
        Statement st;
        try{
            st = con.prepareStatement(query);
            ResultSet set=st.executeQuery(query);
            subTable.setModel(DbUtils.resultSetToTableModel(set));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }  
    public void executeSQLQueryMarkst(String query){
        Connection con = dbc.getConnectionStudent();
        Statement st;
        try{
            st = con.prepareStatement(query);
            ResultSet set=st.executeQuery(query);
            marks.setModel(DbUtils.resultSetToTableModel(set));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }
    public void executeSQLQueryGPA(String query){
        Connection con = dbc.getConnectionStudent();
        Statement st;
        try{
            st = con.prepareStatement(query);
            ResultSet set=st.executeQuery(query);
            //marks.setModel(DbUtils.resultSetToTableModel(set));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "The value is already added");
        }
    }
    public void executeSQLQueryAtt(String query){
        Connection con = dbc.getConnectionStudent();
        Statement st;
        try{
            st = con.prepareStatement(query);
            ResultSet set=st.executeQuery(query);
            attendance.setModel(DbUtils.resultSetToTableModel(set));
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
    private void FilecomboSubjectBox(){
        Connection con = dbc.getConnectionStudent();
        Statement st;
        ResultSet rs;
        try{
            String strlec = "select distinct sub_id from attendance where  st_id='"+user+"'";
            st = con.prepareStatement(strlec);
            rs = st.executeQuery(strlec);
            while(rs.next()){
                String Sub_id = rs.getString("sub_id");
                jSub.addItem(Sub_id);
                
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public student_window(String userid) {
        initComponents();
        this.setLocationRelativeTo(null);
        Show_Notice_In_JTable();
        user = userid;
        String querySub="select subject.sub_id,subject.sub_name,lecture.firstname from subject inner join lecture where subject.Lec_id = lecture.Lec_ID and subject.sub_id in (select sub_id from studentsubject where st_id='"+user+"')";
        executeSQLQuerySubject(querySub);
        String query = "select * from student where st_id='"+user+"'";
        executeSQLQuerySubject(querySub);
        String querymarks="select *from marks where st_id='"+user+"'";
        executeSQLQueryMarkst(querymarks);
        String queryatt="select *from attendance where st_id='"+user+"'";
        executeSQLQueryAtt(queryatt);
        //sub list for combo
        
        FilecomboSubjectBox();
        
        
        try {   
            st = connect.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
                id.setText(rs.getString("st_id"));
                fname.setText(rs.getString("st_firstname"));
                lname.setText(rs.getString("st_lastname"));
                age.setText(rs.getString("st_age"));
                dob.setText(rs.getString("DOB"));
                tp.setText(rs.getString("tpNo"));
                mail.setText(rs.getString("email"));
                address.setText(rs.getString("address"));
                dep.setText(rs.getString("Dep_ID"));
                gender.setText(rs.getString("gender"));
                depIDStu=rs.getString("Dep_ID");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student_window.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(""+depIDStu);
        switch(depIDStu){
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
    }
    
    public void executeSQLQueryStuPhoto(String query, String Message){
        Connection con = dbc.getConnectionStudent();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(null, "User "+Message+" Success");
            }else{
                JOptionPane.showMessageDialog(null, "Can Not "+Message+" User");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    public void Show_Notice_In_JTable(){
        ArrayList<Notice> list = ul.NoticeList();
        DefaultTableModel model = (DefaultTableModel)noticeTable.getModel();
        Object[] row = new Object[2];
        for(int i=0; i < list.size(); i++){
            row[0]=list.get(i).notice;
            row[1]=list.get(i).date; 
            model.addRow(row);
        }         
    }   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        tp = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        dob = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        gender = new javax.swing.JTextField();
        lblimage = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dep = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        path = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noticeTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        noticearea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        subTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        timetable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        marks = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        gpa = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        attendance = new javax.swing.JTable();
        jSub = new javax.swing.JComboBox<>();
        jType = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        subidE = new javax.swing.JLabel();
        subidE1 = new javax.swing.JLabel();
        subidE2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(211, 84, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 84, 0)));

        jTabbedPane3.setBackground(new java.awt.Color(1, 49, 65));
        jTabbedPane3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(1, 49, 65));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 239, 239));
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 239, 239));
        jLabel3.setText("ID no");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(253, 239, 239));
        jLabel4.setText("Age");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(253, 239, 239));
        jLabel5.setText("Date of Birth");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(253, 239, 239));
        jLabel6.setText("Telephone No");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(253, 239, 239));
        jLabel7.setText("Address");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        tp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(253, 239, 239));
        jLabel8.setText("Last Name");

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(253, 239, 239));
        jLabel9.setText("Email");

        address.setColumns(20);
        address.setRows(5);
        jScrollPane1.setViewportView(address);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(253, 239, 239));
        jLabel11.setText("Gender");

        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 84, 0)));

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(253, 239, 239));
        jLabel13.setText("Department");

        jButton3.setText("ADD NEW");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("DELETE");

        jButton5.setText("UPDATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13))
                                .addGap(449, 449, 449)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(532, 532, 532)
                                .addComponent(path))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(age, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("PROFILE", jPanel1);

        jPanel3.setBackground(new java.awt.Color(1, 49, 65));

        noticeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "NOTICE"
            }
        ));
        noticeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noticeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(noticeTable);

        noticearea.setColumns(20);
        noticearea.setRows(5);
        jScrollPane3.setViewportView(noticearea);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(253, 239, 239));
        jLabel10.setText("Notice");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("NOTICE", jPanel3);

        jPanel2.setBackground(new java.awt.Color(1, 49, 65));

        subTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject ID", "Subject Name", "Lecture Name"
            }
        ));
        jScrollPane4.setViewportView(subTable);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("Subject List");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel15)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel15)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("SUBJECT", jPanel2);

        jPanel7.setBackground(new java.awt.Color(1, 49, 65));

        timetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "Mon", "Tue", "Wen", "Thur", "Fri"
            }
        ));
        jScrollPane9.setViewportView(timetable);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("Your Time Table");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(301, 301, 301))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel16)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Time Tabel", jPanel7);

        jPanel8.setBackground(new java.awt.Color(1, 49, 65));

        marks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_ID", "Subject ID", "Lec_ID", "Quiz 1", "Quiz 2", "Quiz 3", "Quiz 4", "Ass_ 1", "Ass_ 2", "Ass_ 3", "Mid", "Final_T", "Final_P", "Total", "Grade_point", "Grade"
            }
        ));
        jScrollPane5.setViewportView(marks);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("GPA");

        gpa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        gpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpaActionPerformed(evt);
            }
        });

        jButton6.setText("VIEW GPA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(gpa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jButton6)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton6)
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gpa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Marks", jPanel8);

        jPanel9.setBackground(new java.awt.Color(1, 49, 65));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        attendance.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        attendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "Lec_ID", "Lec_Type", "Subject_ID", "Date", "PR_AB_Status", "M_status"
            }
        ));
        jScrollPane6.setViewportView(attendance);

        jSub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECT ID" }));

        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TYPE", "T", "P" }));

        jButton2.setText("CHECK ELIGEBLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("ATTENDENCE");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("SUBJECT ID");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 240, 240));
        jLabel19.setText("ELEGEBLE/ NOT");

        subidE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subidE.setForeground(new java.awt.Color(240, 240, 240));

        subidE1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subidE1.setForeground(new java.awt.Color(240, 240, 240));

        subidE2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subidE2.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSub, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(subidE, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subidE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel19)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(subidE2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subidE1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(subidE, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subidE2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Attendnce", jPanel9);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 240, 240));
        jLabel1.setText("STUDENT DETAILS");

        jButton1.setText("logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(1, 1, 1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/l.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel12)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(181, 181, 181)
                        .addComponent(jButton1)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(frame,"Do you want to logout","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void noticeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noticeTableMouseClicked
        int i= noticeTable.getSelectedRow();
        TableModel Model = noticeTable.getModel();
        noticearea.setText(Model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_noticeTableMouseClicked

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        
        
    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void tpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String Fname = f.getAbsolutePath();
        path.setText(Fname);
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(Fname);
        Image image = icon.getImage().getScaledInstance(lblimage.getWidth(),lblimage.getHeight(), Image.SCALE_SMOOTH);
        lblimage.setIcon(icon);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String image = path.getText();
        image = image.replace("\\", "\\\\");
        String queryimage = "update student set image = '"+image+"' where st_id='"+user+"'";
        executeSQLQueryStuPhoto(queryimage,"updated");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pathActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Connection con = dbc.getConnectionStudent();
            Statement st;
            ResultSet rs;    
        try {
            //String query1="select distinct Sub_id,Lec_type, (select 100*( select count(st_id) from attendance where st_id='"+user+"' and ((PR_AB_status=1 and M_status=0) or (PR_AB_status=0 and M_status=1)) and Sub_id='"+jSub.getSelectedItem().toString()+"' and lec_type='"+jType.getSelectedItem().toString()+"')/(select count(Sub_id) from attendance where st_id='"+user+"' and lec_type='"+jType.getSelectedItem().toString()+"')) as Persentage from attendance";
            //String query1="select distinct Sub_id,Lec_type, (select 100*( select count(st_id) from attendance where st_id='"+user+"' and ((PR_AB_status=1 and M_status=0) or (PR_AB_status=0 and M_status=1)) and Sub_id='"+jSub.getSelectedItem().toString()+"' and lec_type='"+jType.getSelectedItem().toString()+"')/(select count(Sub_id) from attendance where st_id='"+user+"' and lec_type='"+jType.getSelectedItem().toString()+"')) as Persentage from attendance, case when (select 100*( select count(st_id) from attendance where st_id='"+user+"' and ((PR_AB_status=1 and M_status=0) or (PR_AB_status=0 and M_status=1)) and Sub_id='"+jSub.getSelectedItem().toString()+"' and lec_type='"+jType.getSelectedItem().toString()+"')/(select count(Sub_id) from attendance where st_id='"+user+"' and lec_type='"+jType.getSelectedItem().toString()+"'))>80.00 then 'Eligible' else 'Not Eligible' end as Eligible from attendance";
            String query1="select distinct Sub_id,Lec_type, (select 100*( select count(st_id) from attendance where st_id='"+user+"' and ((PR_AB_status=1 and M_status=0) or (PR_AB_status=0 and M_status=1)) and Sub_id='"+jSub.getSelectedItem().toString()+"' and lec_type='"+jType.getSelectedItem().toString()+"')/(select count(Sub_id) from attendance where st_id='"+user+"' and lec_type='"+jType.getSelectedItem().toString()+"')) as Persentage, case when (select 100*( select count(st_id) from attendance where st_id='"+user+"' and ((PR_AB_status=1 and M_status=0) or (PR_AB_status=0 and M_status=1)) and Sub_id='"+jSub.getSelectedItem().toString()+"' and lec_type='"+jType.getSelectedItem().toString()+"')/(select count(Sub_id) from attendance where st_id='"+user+"' and lec_type='"+jType.getSelectedItem().toString()+"'))>80.00 then 'Eligible' else 'Not Eligible' end as Eligible from attendance";
            st = con.prepareStatement(query1);
            rs = st.executeQuery(query1);
            while(rs.next()){
                String Sub_id = rs.getString("Sub_id");
                String Pers = rs.getString("Persentage");
                String Elig = rs.getString("Eligible");
                 
                subidE.setText(Sub_id); 
                subidE1.setText(Pers);
                subidE2.setText(Elig);
            }
        } catch (SQLException ex) {
            Logger.getLogger(student_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void gpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gpaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String queryforGPA=" select sum(Grade_point)/(select count(st_id)) as GPA from marks where st_id='"+user+"'";
        float GPA=0;
        try {   
            st = connect.createStatement();
            rs = st.executeQuery(queryforGPA);
            if(rs.next()){
               GPA=rs.getFloat("GPA");
               String ans=String.format("%.2f",GPA);
               gpa.setText(ans);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(student_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(student_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new student_window(String userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField age;
    private javax.swing.JTable attendance;
    private javax.swing.JTextField dep;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField gender;
    private javax.swing.JTextField gpa;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JComboBox<String> jSub;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JLabel lblimage;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mail;
    private javax.swing.JTable marks;
    private javax.swing.JTable noticeTable;
    private javax.swing.JTextArea noticearea;
    private javax.swing.JTextField path;
    private javax.swing.JTable subTable;
    private javax.swing.JLabel subidE;
    private javax.swing.JLabel subidE1;
    private javax.swing.JLabel subidE2;
    private javax.swing.JTable timetable;
    private javax.swing.JTextField tp;
    // End of variables declaration//GEN-END:variables
}
