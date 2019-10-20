package com.gongSir.service.impl;

import com.gongSir.dao.CustomerDao;
import com.gongSir.model.Customer;
import com.gongSir.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gongsir
 * 客户信息管理服务层接口实现
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

//    注入dao
    @Resource
    CustomerDao customerDao;

//    注入事务管理
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }


//    在dao层使用了getCurrentSession创建session，则必须加入事务管理，否则会出错
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public Customer getCustomer(String userId) {
        Customer customer =  customerDao.getCustomer(userId);
        return customer;
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = customerDao.getAllCustomers();
        return list;
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void delCustomer(String userId) {
        customerDao.delCustomer(userId);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Transactional(rollbackFor = {Exception.class,RuntimeException.class})
    @Override
    public List<Customer> getCustomersByKeyWord(String keyword) {
        return customerDao.getCustomersByKeyWord(keyword);
    }
}
