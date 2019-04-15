
package shoppingcatalog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.Pair;
import shoppingcatalog.dbutil.DBConnection;
import shoppingcatalog.dto.ItemDTO;
import shoppingcatalog.dto.ItemInfoDTO;
import shoppingcatalog.dto.OrderDTO;

public class StoreDAO {
    private static Statement st, st1, st2, st3;
    private static PreparedStatement ps1, ps2, ps3, ps4, ps5, ps6, ps7, ps8, ps9, ps10;
    static {
        try {
            Connection conn = DBConnection.getConnection();
            st = conn.createStatement();
            st1 = conn.createStatement();
            st2 = conn.createStatement();
            st3 = conn.createStatement();
            ps1 = conn.prepareStatement("Select id,item_name from store_items where item_type=?");
            ps2 = conn.prepareStatement("Select * from store_items where id=?");
            ps3 = conn.prepareStatement("Insert into order_master values(?,?,?,?)");
            ps4 = conn.prepareStatement("Insert into order_details values(?,?,?)");
            ps5 = conn.prepareStatement("select order_id,order_amount,order_date from order_master where cust_name=?");
            ps6 = conn.prepareStatement("select item_name,item_price from order_details where order_id=?");
            ps7 = conn.prepareStatement("Select cust_name from order_master where order_id=?");
            ps8 = conn.prepareStatement("Insert into store_items values(?,?,?,?,?,?)");
            ps9 = conn.prepareStatement("Delete from store_items where id=?");
            ps10 = conn.prepareStatement("Update store_items set item_type=?,item_name=?,item_price=?,item_desc=?,item_image=? where id=?");
            
        } catch (Exception ex) {
            System.out.println("Error in DB comm" + ex);
            ex.printStackTrace();
        }
    }
    public static List<String> getItemTypes() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT distinct item_type from store_items");
        ArrayList<String> items = new ArrayList<>();
        while (rs.next()) {
            items.add(rs.getString(1));
        }
        return items;
    }
    public static List<ItemInfoDTO> getItemsByType(String itemType) throws SQLException {
        ps1.setString(1, itemType);
        ResultSet rs = ps1.executeQuery();
        ArrayList<ItemInfoDTO> itemList = new ArrayList<>();
        while (rs.next()) {
            ItemInfoDTO obj = new ItemInfoDTO();
            obj.setItemId(rs.getInt(1));
            obj.setItemName(rs.getString(2));
            itemList.add(obj);
        }
        return itemList;
    }
    public static ItemDTO getItemDetails(int itemId) throws SQLException {
        ps2.setInt(1, itemId);
        ResultSet rs = ps2.executeQuery();
        ItemDTO item = new ItemDTO();
        if (rs.next()) {
            item.setItemId(rs.getInt(1));
            item.setItemType(rs.getString(2));
            item.setItemName(rs.getString(3));
            item.setItemPrice(rs.getDouble(4));
            item.setItemDesc(rs.getString(5));
            item.setItemImage(rs.getString(6));
        }
        return item;
    }
    public static boolean addOrder(String custName, ArrayList<ItemDTO> itemList, double totalAmount) throws SQLException {
        ResultSet rs = st1.executeQuery("Select count(*) as count from order_master");
        rs.next();
        int lastId = rs.getInt(1);
        String nextId = "ORD-00" + (lastId + 1);
        ps3.setString(1, nextId);
        ps3.setString(2, custName);
        ps3.setDouble(3, totalAmount);
        java.util.Date today = new java.util.Date();
        long ms = today.getTime();
        java.sql.Date currDate = new java.sql.Date(ms);
        ps3.setDate(4, currDate);
        int ans1 = ps3.executeUpdate();
        int count = 0;
        System.out.println("Recored inserted in order master:" + ans1);
        for (ItemDTO item : itemList) {
            ps4.setString(1, nextId);
            ps4.setString(2, item.getItemName());
            ps4.setDouble(3, item.getItemPrice());
            int ans2 = ps4.executeUpdate();
            if (ans2 == 1) {
                count++;
            }
            System.out.println("Record inserted in order details:" + ans2);
        }
        return (ans1 == 1 && count == itemList.size());
    }
    public static ArrayList<OrderDTO> getOrdersByCustomer(String custName) throws SQLException {
        ps5.setString(1, custName);
        ResultSet rs = ps5.executeQuery();
        ArrayList<OrderDTO> orders = new ArrayList<>();
        while (rs.next()) {
            OrderDTO obj = new OrderDTO();
            obj.setOrderId(rs.getString(1));
            obj.setOrderAmount(rs.getDouble(2));
            obj.setOrderDate(rs.getDate(3));
            orders.add(obj);
        }
        return orders;
    }
    public static ArrayList<ItemDTO> getItemsInOrder(String orderId) throws SQLException {
        ps6.setString(1, orderId);
        ResultSet rs = ps6.executeQuery();
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        while (rs.next()) {
            ItemDTO item = new ItemDTO();
            item.setItemName(rs.getString(1));
            item.setItemPrice(rs.getDouble(2));
            itemList.add(item);

        }
        return itemList;
    }
    public static ArrayList<OrderDTO> getAllOrders() throws SQLException {
        ResultSet rs = st2.executeQuery("SELECT * from order_master");
        ArrayList<OrderDTO> items = new ArrayList<>();
        while (rs.next()) {
            OrderDTO o = new OrderDTO();
            o.setOrderId(rs.getString(1));
            o.setOrderAmount(rs.getDouble(3));
            o.setOrderDate(rs.getDate(4));
            items.add(o);
        }
        return items;
    }
    public static Pair<String, ArrayList<ItemDTO>> getOrderDetailsAdmin(String orderId) throws SQLException {
        ps7.setString(1, orderId);
        ResultSet rs = ps7.executeQuery();
        String custName = null;
        ps6.setString(1, orderId);
        System.out.println("lalalla " + orderId);
        while (rs.next()) {
            System.out.println(rs.getString(1));
            custName = rs.getString(1);
        }
        ResultSet rs1 = ps6.executeQuery();
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        while (rs1.next()) {
            ItemDTO item = new ItemDTO();
            item.setItemName(rs1.getString(1));
            item.setItemPrice(rs1.getDouble(2));
            itemList.add(item);
        }
        return new Pair<String, ArrayList<ItemDTO>>(custName, itemList);
    }
    public static ArrayList<Integer> getId() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT id  from store_items");
        ArrayList<Integer> id = new ArrayList<>();
        while (rs.next()) {
            id.add(rs.getInt(1));
        }
        Collections.sort(id);
        return id;
    }
    public static boolean addItem(ItemDTO item) throws SQLException {
        ResultSet rs = st1.executeQuery("SELECT id FROM (SELECT * FROM store_items ORDER BY id DESC) WHERE ROWNUM = 1");
        rs.next();
        int lastId = rs.getInt(1);
        int nextId = lastId + 1 ;
        ps8.setInt(1, nextId);
        ps8.setString(2, item.getItemType());
        ps8.setString(3, item.getItemName());
        ps8.setDouble(4, item.getItemPrice());
        ps8.setString(5, item.getItemDesc());
        ps8.setString(6, item.getItemImage());
        int ans1 = ps8.executeUpdate();
        int count = 0;
        System.out.println("haha yaha "+(ans1==1));
        System.out.println("Record inserted in database:" + ans1);
        return ans1 == 1;
    }
    public static int deleteItem(int id) throws SQLException {
        ps9.setInt(1, id);
        return ps9.executeUpdate();
    }
    public static int updateItem(ItemDTO item) throws SQLException {
        ps10.setString(1, item.getItemType());
        ps10.setString(2, item.getItemName());
        ps10.setDouble(3, item.getItemPrice());
        ps10.setString(4, item.getItemDesc());
        ps10.setString(5, item.getItemImage());
        ps10.setInt(6, item.getItemId());
        return ps10.executeUpdate();
    }
}
