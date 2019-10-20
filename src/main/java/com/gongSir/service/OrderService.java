package com.gongSir.service;

import com.gongSir.model.Order;

import java.util.List;

/**
 * @author gongsir
 * 订单信息管理服务层接口
 */
public interface OrderService {
    //    添加订单信息
    void addOrder(Order order);
    //    删除订单信息
    void delOrder(int orderId);
    //    修改订单信息
    void updateOrder(Order order);
    //    查询单个订单，根据订单id查询
    Order getOrderByOrderId(int orderId);
    //    查询某一客户的所有订单信息
    List<Order> getOrdersByUserId(String userId);
    //    查询库中所有订单信息
    List<Order> getAllOrders();
    //    根据订单名称模糊查询订单信息
    List<Order> getOrdersByOrderName(String keyword);
    //    删除某一客户的全部订单信息
    void delAllOrdersByUserId(String userId);
}
