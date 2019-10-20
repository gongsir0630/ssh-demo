package com.gongSir.service;

import com.gongSir.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class OrderServiceTest {

    @Resource
    OrderService orderService;
    @Test
    public void addOrder() {
        Order order = new Order();
        order.setUserId("201731061426");
        order.setOrderName("MacBook Pro2019");
        order.setOrderCount(1);
        order.setOrderMoney(12999.99);
        orderService.addOrder(order);
    }

    @Test
    public void delOrder() {
        orderService.delOrder(4);
    }

    @Test
    public void updateOrder() {
        Order order = new Order();
        order.setOrderId(3);
        order.setUserId("201731061426");
        order.setOrderName("MacBook Pro2019");
        order.setOrderCount(1);
        order.setOrderMoney(99);
        orderService.updateOrder(order);
    }

    @Test
    public void getOrderByOrderId() {
        orderService.getOrderByOrderId(3);
    }

    @Test
    public void getOrdersByUserId() {
        List<Order> list = orderService.getOrdersByUserId("201731061426");
        for (Order o :
                list) {
            System.out.println(o);
        }
    }

    @Test
    public void getAllOrders() {
        List<Order> all = orderService.getAllOrders();
        for (Order o :
                all) {
            System.out.println(o);
        }
    }

    @Test
    public void getOrdersByOrderName() {
        List<Order> list = orderService.getOrdersByOrderName("book");
        for (Order o :
                list) {
            System.out.println(o);
        }
    }

    @Test
    public void delAllOrdersByUserId() {
        orderService.delAllOrdersByUserId("201731061426");
    }
}