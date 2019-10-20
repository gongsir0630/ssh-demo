package com.gongSir.service.impl;

import com.gongSir.dao.OrderDao;
import com.gongSir.model.Order;
import com.gongSir.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gongsir
 * 订单信息管理服务层接口实现
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

//    通过spring注入dao层接口
    @Resource
    OrderDao orderDao;

//    dao层使用了getCurrentSession，因此需要加入事务管理
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void delOrder(int orderId) {
        orderDao.delOrder(orderId);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public Order getOrderByOrderId(int orderId) {
        return orderDao.getOrderByOrderId(orderId);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderDao.getOrdersByUserId(userId);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public List<Order> getOrdersByOrderName(String keyword) {
        return orderDao.getOrdersByOrderName(keyword);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void delAllOrdersByUserId(String userId) {
        orderDao.delAllOrdersByUserId(userId);
    }
}
