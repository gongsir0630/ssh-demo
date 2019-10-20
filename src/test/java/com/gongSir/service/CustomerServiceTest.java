package com.gongSir.service;

import com.gongSir.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CustomerServiceTest {

//    通过soring注入service层接口
    @Resource
    CustomerService customerService;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer();
        customer.setRealName("龚涛");
        customer.setUserAddr("四川成都");
        customer.setUserId("201731061426");
        customer.setUserPass("123456");
        customer.setUserPhone("12345678909");
        customerService.saveCustomer(customer);
    }

    @Test
    public void getCustomer() {
        System.out.println(customerService.getCustomer("201731061426"));
    }

    @Test
    public void getAllCustomers(){
        for (Customer cus :
                customerService.getAllCustomers()) {
            System.out.println(cus);
        }
    }

    @Test
    public void delCustomer() {
        customerService.delCustomer("201731061426");
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setRealName("李诗雅");
        customer.setUserAddr("四川成都");
        customer.setUserId("201731061426");
        customer.setUserPass("123456");
        customer.setUserPhone("12345678909");
        customerService.updateCustomer(customer);
    }

    @Test
    public void getCustomersByKeyWord() {
        customerService.getCustomersByKeyWord("test");
    }
}