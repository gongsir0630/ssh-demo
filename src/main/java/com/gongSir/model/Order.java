package com.gongSir.model;

import javax.persistence.*;
import java.io.Serializable;

/*
    使用IDEA自动生成的Order实体类
    author: 龚涛
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private int orderId;
    private String userId;
    private String orderName;
    private double orderMoney;
    private int orderCount;

//    主键自动增加
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "order_name")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "order_money")
    public double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(double orderMoney) {
        this.orderMoney = orderMoney;
    }

    @Basic
    @Column(name = "order_count")
    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (Double.compare(order.orderMoney, orderMoney) != 0) return false;
        if (orderCount != order.orderCount) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        if (orderName != null ? !orderName.equals(order.orderName) : order.orderName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderName != null ? orderName.hashCode() : 0);
        temp = Double.doubleToLongBits(orderMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + orderCount;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderMoney=" + orderMoney +
                ", orderCount=" + orderCount +
                '}';
    }
}
