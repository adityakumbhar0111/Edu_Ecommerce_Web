package model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int userId;
    private double total;
    private String address;
    private String status;
    private Date createdAt;
    private List<OrderItem> items;

    public static class OrderItem {
        public int productId;
        public String productName;
        public int qty;
        public double price;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }
}
