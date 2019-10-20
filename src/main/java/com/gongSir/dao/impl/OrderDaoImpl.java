package com.gongSir.dao.impl;

import com.gongSir.dao.OrderDao;
import com.gongSir.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author gongsir
 * 订单信息管理数据层接口实现
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
//    spring注入session
    @Resource
    SessionFactory sessionFactory;
    @Override
    public void addOrder(Order order) {
        System.out.println("=====> dao层向数据库添加Order信息："+order);
        Serializable id = sessionFactory.getCurrentSession().save(order);
        System.out.println("=====> 数据添加成功,新增数据的主键id："+id);
    }

    @Override
    public void delOrder(int orderId) {
        System.out.println("=====> dao层删除Order信息，orderID为："+orderId);
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class,orderId);
        session.delete(order);
        System.out.println("=====> 数据删除成功");
    }

    @Override
    public void updateOrder(Order order) {
        System.out.println("=====> dao层更新Order信息：");
        Session session = sessionFactory.getCurrentSession();
        Order order1 = session.get(Order.class, order.getOrderId());
        System.out.println("=====> 原数据："+order1);
//        修改商品数量
        order1.setOrderCount(order.getOrderCount());
//        修改总价
        order1.setOrderMoney(order.getOrderMoney());
//        修改订单名称
        order1.setOrderName(order.getOrderName());
        session.update(order1);
        System.out.println("=====> 数据更新成功，新数据："+order1);
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
        System.out.println("=====> dao层查询Order订单信息，orderID："+orderId);
        Order order = sessionFactory.getCurrentSession().get(Order.class, orderId);
        System.out.println("=====> 数据查询成功："+order);
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        System.out.println("=====> dao层查询指定客户的所有订单信息，客户id："+userId);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Order where userId=?");
        query.setParameter(0,userId);
        List<Order> orders = query.list();
        System.out.println("=====> 查询成功，list数据个数："+orders.size());
        return orders;
    }

    @Override
    public List<Order> getAllOrders() {
        System.out.println("=====> dao层查询所有Order信息：");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Order");
        List<Order> list = query.list();
        System.out.println("=====> 查询成功，list数据个数："+list.size());
        return list;
    }

    @Override
    public List<Order> getOrdersByOrderName(String keyword) {
        System.out.println("=====> dao层根据订单名称查询所有相关Order信息，订单名称关键字："+keyword);
        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Order where orderName like '%" + keyword + "%' ");
        Query query = session.createQuery("from Order where orderName like concat('%',?,'%') ");
        query.setParameter(0,keyword);
        List<Order> list = query.list();
        System.out.println("=====> 查询成功，list数据个数："+list.size());
        return list;
    }

    @Override
    public void delAllOrdersByUserId(String userId) {
        System.out.println("=====> dao层根据客户id删除客户的所有订单信息，客户id："+userId);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Order where userId=?");
        query.setParameter(0,userId);
        int rs = query.executeUpdate();
        System.out.println("=====> 订单信息删除成功，共删除"+rs+"条数据");
    }
}
