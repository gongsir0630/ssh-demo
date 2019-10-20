package com.gongSir.dao;

import com.gongSir.model.Customer;

import java.util.List;

/**
 * @author 龚涛
 * 客户信息管理数据层接口
 */
public interface CustomerDao {
//    添加客户信息
    void saveCustomer(Customer customer);
//    获取单个客户信息
    Customer getCustomer(String userId);
//    获取所有客户信息
    List<Customer> getAllCustomers();
//    删除客户信息
    void delCustomer(String userId);
//    更新客户信息
    void updateCustomer(Customer customer);
//    关键字模糊查询
    List<Customer> getCustomersByKeyWord(String keyword);
}
