package com.gongSir.dao.impl;

import com.gongSir.dao.CustomerDao;
import com.gongSir.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gongsir
 * 客户信息管理数据层接口实现
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

//    spring注入sessionFactory
    @Resource
    SessionFactory sessionFactory;
    @Override
    public void saveCustomer(Customer customer) {
//        推荐使用getCurrentSession方法获取session
        System.out.println("=====> dao层向数据库添加Customer信息："+customer);
        sessionFactory.getCurrentSession().save(customer);
        System.out.println("=====> 添加成功");
    }

    @Override
    public Customer getCustomer(String userId) {
        System.out.println("=====> dao层查询Customer信息，userId为："+userId);
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class,userId);
        System.out.println("=====> 查询成功："+customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("=====> dao层查询所有Customer信息：");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        System.out.println("=====> 查询成功，list数据个数："+list.size());
        return list;
    }

    @Override
    public void delCustomer(String userId) {
        System.out.println("=====> dao层删除Customer信息，userId为："+userId);
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class,userId);
        session.delete(customer);
        System.out.println("=====> 删除成功");
    }

    @Override
    public void updateCustomer(Customer customer) {
        System.out.println("=====> dao层更新Customer信息，：");
        Session session = sessionFactory.getCurrentSession();
        Customer cus = session.get(Customer.class,customer.getUserId());
        System.out.println("=====> 原数据："+cus);
        cus.setUserPass(customer.getUserPass());
        cus.setRealName(customer.getRealName());
        cus.setUserPhone(customer.getUserPhone());
        cus.setUserAddr(customer.getUserAddr());
        session.update(cus);
        System.out.println("=====> 更新成功，新数据："+customer);
    }

    @Override
    public List<Customer> getCustomersByKeyWord(String keyword) {
        System.out.println("=====> dao层根据关键字查询客户信息，关键字："+keyword);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where userId like concat('%',?,'%') or realName like concat('%',?,'%')");
        query.setParameter(0,keyword);
        query.setParameter(1,keyword);
        List<Customer> list = query.list();
        System.out.println("=====> 查询成功，list数据个数："+list.size());
        return list;
    }
}
