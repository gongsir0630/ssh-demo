package com.gongSir.action;

import com.gongSir.model.Customer;
import com.gongSir.model.Order;
import com.gongSir.service.CustomerService;
import com.gongSir.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport {
    @Resource
    private CustomerService customerService;
    @Resource
    private OrderService orderService;

//    获取form数据
    private Customer customer;
    private List<Customer> list = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private String keyword;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * 查询客户信息以及他的所有订单
     * @return 返回客户信息对象和订单的list集合
     */
    public String query(){
        System.out.println(this.customer);
        this.customer = customerService.getCustomer(this.customer.getUserId());
        this.orders = orderService.getOrdersByUserId(this.customer.getUserId());
        System.out.println("customer:"+customer);
        return "query";
    }

    /**
     * 返回所有客户信息
     * @return list集合
     */
    public String list(){
        list = customerService.getAllCustomers();
        return "list";
    }

    /**
     * 删除客户信息
     */
    public String del(){
//        删除个人信息
        customerService.delCustomer(this.customer.getUserId());
//        同时清空他的所有订单
        orderService.delAllOrdersByUserId(this.customer.getUserId());
        return "reList";
    }

    /**
     * 返回信息添加页面
     * @return 页面
     */
    public String addPage(){
        return "addPage";
    }

    /**
     * 添加客户信息
     * @return 刷新list
     */
    public String add(){
        customerService.saveCustomer(this.customer);
        return "reList";
    }

    /**
     * 返回信息编辑页面
     * @return 页面
     */
    public String editPage(){
        this.customer = customerService.getCustomer(this.customer.getUserId());
        return "editPage";
    }

    /**
     * 更新客户信息
     * @return 刷新数据
     */
    public String edit(){
        customerService.updateCustomer(this.customer);
        return "reList";
    }

    /**
     * 关键字搜索
     * @return list集合
     */
    public String search(){
        list = customerService.getCustomersByKeyWord(this.keyword);
        return "list";
    }
}
