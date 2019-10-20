package com.gongSir.service;

import com.gongSir.model.Customer;

import java.util.List;

/**
 * @author gongsir
 * 客户信息管理服务层接口
 */
public interface CustomerService {
    /**
     * 新增客户信息
     * @param customer 客户信息对象
     */
    void saveCustomer(Customer customer);

    /**
     * 根据用户id查询客户信息
     * @param userId 客户id，唯一
     * @return 返回客户信息对象的封装
     */
    Customer getCustomer(String userId);

    /**
     * 查询所有客户信息
     * @return 返回客户信息集合
     */
    List<Customer> getAllCustomers();

    /**
     * 根据客户id删除客户
     * @param userId 客户id
     */
    void delCustomer(String userId);

    /**
     * 修改客户信息
     * @param customer 需要修改的客户信息
     */
    void updateCustomer(Customer customer);

    /**
     * 关键字模糊查询
     * @param keyword 客户信息关键字
     * @return 返回集合
     */
    List<Customer> getCustomersByKeyWord(String keyword);
}
