/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcatalog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import shoppingcatalog.dbutil.DBConnection;
import shoppingcatalog.dto.UserDTO;

public class RegistrationDAO {
    
    
    private static PreparedStatement ps1,ps2,ps3;
    private static Statement st;

    static {
        try {
            Connection conn = DBConnection.getConnection();
            st=conn.createStatement();
            ps1 = conn.prepareStatement("Select username from members where username=? and membertype='CUSTOMER'");
            ps2=conn.prepareStatement("insert into members values(?,?,?)");
            ps3=conn.prepareStatement("Delete from members where username=?");
        } catch (Exception ex) {
            System.out.println("Error in DB comm" + ex);
        }
    }
    public static boolean searchUser(String username) throws SQLException{
        
        ps1.setString(1,username);
        
        ResultSet rs=ps1.executeQuery();
        
        return rs.next();
    }
    
    public static boolean registerUser(UserDTO user) throws SQLException{
        
        ps2.setString(1, user.getUsername());
        ps2.setString(2, user.getPassword());
        ps2.setString(3, user.getUsertype());
        int ans=ps2.executeUpdate();
        
        return ans==1;
    }
        public static ArrayList<String> getUserId() throws SQLException{
        ArrayList<String> ids=new ArrayList<>();
        ResultSet rs=st.executeQuery("select username from members");
        while(rs.next()){
         ids.add(rs.getString(1));
        }
        return ids;
    } 
    public static boolean removeUser(String userName) throws SQLException{
        
        ps3.setString(1,userName);
        int ans=ps3.executeUpdate();
        System.out.println(userName+" "+ans);
        return ans==1;
    }
   
}
