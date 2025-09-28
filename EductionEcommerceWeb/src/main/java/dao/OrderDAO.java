package dao;

import model.Order;
import model.Order.OrderItem;
import java.sql.*;
import java.util.List;

public class OrderDAO {
    public int createOrder(int userId, double total, String address, List<OrderItem> items) {
        int orderId = -1;
        Connection c = null;
        try {
            c = DBUtil.getConnection();
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("INSERT INTO orders(user_id,total,address,status) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setDouble(2, total);
            ps.setString(3, address);
            ps.setString(4, "PLACED");
            ps.executeUpdate();
            ResultSet rk = ps.getGeneratedKeys();
            if (rk.next()) orderId = rk.getInt(1);

            PreparedStatement pis = c.prepareStatement("INSERT INTO order_items(order_id,product_id,qty,price) VALUES(?,?,?,?)");
            for (OrderItem it : items) {
                pis.setInt(1, orderId);
                pis.setInt(2, it.productId);
                pis.setInt(3, it.qty);
                pis.setDouble(4, it.price);
                pis.addBatch();
            }
            pis.executeBatch();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try { if (c!=null) c.rollback(); } catch(Exception ignore){}
        } finally { try { if (c!=null) c.close(); } catch(Exception ignore){} }
        return orderId;
    }
}
