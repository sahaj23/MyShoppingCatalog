
package shoppingcatalog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import shoppingcatalog.dbutil.DBConnection;
import shoppingcatalog.dto.UserDTO;

public class LoginDAO {

    private static PreparedStatement ps;

    static {
        try {
            Connection conn = DBConnection.getConnection();
            ps = conn.prepareStatement("Select * from members where username=? and password=? and membertype=?");
        } catch (Exception ex) {
            System.out.println("Error in DB comm" + ex);
        }
    }

    public static boolean validateUser(UserDTO user) throws SQLException {
       
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsertype());
        ResultSet rs = ps.executeQuery();
         //System.out.println(rs.next()+" from dao");
        return rs.next();
    }

}
