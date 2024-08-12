/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import util.DbUtil;

/**
 *
 * @author Dell New
 */
public class StudentDao {
    
    static PreparedStatement ps;
    static ResultSet rs;
    static String sql = "";
    
    
    public static int saveData(Student s){
    
        int status =0;
        
        sql = "insert into student(name,email,address,cellNo) values(?,?,?,?)";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getCellNo());
            
            
            status = ps.executeUpdate();
            
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
    
    public static List<Student> viewAllData(){
    
        List<Student> st= new ArrayList<>();
        
        sql ="select * from student";
        
        try {
            ps =DbUtil.getCon().prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("cellNo")
                        
                );
                st.add(s);
            }
            ps.close();
            rs.close();
            
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return st;
    }
    
    public static void deleteData(Student e){
    
        sql = "delete from student where id=?";
        
        try {
            ps = DbUtil.getCon().prepareStatement(sql);
            
            ps.setInt(1, e.getId());
            
            ps.executeUpdate();
            
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateData(Student e){
    
        sql ="update student set name=?,email=?,address=?,cellNo=? where id=?";
        
        try {
            ps =DbUtil.getCon().prepareStatement(sql);
            
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getAddress());
            ps.setString(4, e.getCellNo());
            
            ps.setInt(5, e.getId());
            
            ps.executeUpdate();
            
            ps.close();
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static Student getById(int id){
    
        Student e = null;
        
        sql ="select * from student where id=?";
        
        try {
            ps =DbUtil.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                e = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("cellNo")
                        
                );
                
            }
            ps.close();
            rs.close();
            
            DbUtil.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }
    
}
