/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author HP
 */
public class UserDAO {
    public UserDTO checkLogin(String userId, String password) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try{
            conn = DBUtils.getConnectionDynamic();
            if(conn != null){
                String sql = "SELECT fullName, roleId FROM tblUsers WHERE userID =? AND password =?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userId);
                pstm.setString(2, password);
                resultSet = pstm.executeQuery();
                if(resultSet.next()){
                    String fullName = resultSet.getString("fullName");
                    String roleId = resultSet.getString("roleID");
                    user = new UserDTO("", fullName, roleId, "");
                }
            }
        }catch(Exception event){
            event.printStackTrace();
        }finally{
            if(resultSet != null) resultSet.close();
            if(pstm != null) pstm.close();
            if(conn != null) conn.close();
        }
        return user;
    }
    
    public List<UserDTO> getListUser(String searchFullName) throws SQLException{
        
        List<UserDTO> ListUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "SELECT userID, fullName, roleID FROM tblUsers WHERE fullName like ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, "%"+searchFullName+"%");
                resultSet = pstm.executeQuery();
                while(resultSet.next()){
                    String userID = resultSet.getString("userID");
                    String fullName = resultSet.getString("fullName");
                    String roleId = resultSet.getString("roleID");
                    String password = "***";
                    ListUser.add(new UserDTO(userID, fullName, roleId, password));
                }
            }
        }catch(Exception event){
            event.printStackTrace();
        }finally{
            if(resultSet != null) resultSet.close();
            if(pstm != null) pstm.close();
            if(conn != null) conn.close();
        }
        return ListUser;
    }
    
    public boolean delete(String userID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try{
            conn= DBUtils.getConnection();
            if(conn!= null){
                String sql= " DELETE tblUSers"
                        + " WHERE userID=?";
                stm= conn.prepareStatement(sql);
                stm.setString(1, userID);
                check = stm.executeUpdate()>0?true:false;
                
            }
        }catch(Exception e){
            
        }finally{
            if(stm!= null) stm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    public boolean update(UserDTO user) throws SQLException{
        boolean check =false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!= null){
                String sql= " UPDATE tblUSers SET fullName=?, roleID=? "
                        + " WHERE userID=?";
                stm= conn.prepareStatement(sql);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getRoleId());
                stm.setString(3, user.getUserId());
                check = stm.executeUpdate()>0?true:false;
                
            }
        } catch (Exception e) {
        
        }finally{
            if(stm!= null) stm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    public UserDTO getUserInfor(String userID) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT fullName, roleID FROM tblUsers WHERE userID= ?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, userID);
                resultSet = pstm.executeQuery();
                if(resultSet.next()){
                    String fullName = resultSet.getString("fullName");
                    String roleID = resultSet.getString("roleID");
                    user = new UserDTO(userID, fullName, roleID, "");
                }
            }
        } catch (Exception event) {
            event.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    
    }
    public boolean insert(UserDTO user) throws SQLException{
        boolean check = false;
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql= " INSERT INTO tblUsers(userID, fullName, roleID, password) "
                        + " VALUES(?,?,?,?) ";
                stm=conn.prepareStatement(sql);
                stm.setString(1, user.getUserId());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRoleId());
                stm.setString(4, user.getPassword());
                check=stm.executeUpdate()>0? true: false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(stm!=null) stm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
    public boolean insertV2(UserDTO user) throws SQLException, ClassNotFoundException{
        boolean check = false;
        Connection conn=null;
        PreparedStatement stm=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql= " INSERT INTO tblUsers(userID, fullName, roleID, password) "
                        + " VALUES(?,?,?,?) ";
                stm=conn.prepareStatement(sql);
                stm.setString(1, user.getUserId());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getRoleId());
                stm.setString(4, user.getPassword());
                check=stm.executeUpdate()>0? true: false;
            }
        
        }finally{
            if(stm!=null) stm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
}
