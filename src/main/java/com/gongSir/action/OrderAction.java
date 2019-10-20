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

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport {
    @Resource
    private OrderService orderService;
    @Resource
    private CustomerService customerService;

//    获取form数据
    private Order order;
    private Customer customer;
    private List<Order> list = new ArrayList<>();
    private String keyword;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

//    订单信息集合
    public String list(){
        list = orderService.getAllOrders();
        return "list";
    }

    public String addPage(){
        return "addPage";
    }

//    添加订单信息
    public String add(){
        this.order.setOrderMoney(Double.valueOf(this.order.getOrderMoney()));
        this.order.setOrderCount(Integer.valueOf(this.order.getOrderCount()));
        Customer customer1 = customerService.getCustomer(this.order.getUserId());
//        判断客户信息是否存在
        if (customer1 == null){
            this.msg = "客户信息不存在，请先添加客户信息";
            return "temp";
        }
        this.msg = "订单信息添加成功";
        orderService.addOrder(this.order);
        return "temp";
    }

    public String editPage(){
        this.order = this.orderService.getOrderByOrderId(this.order.getOrderId());
        return "editPage";
    }

//    更新订单信息
    public String edit(){
        orderService.updateOrder(order);
        return "reList";
    }

//    删除订单信息
    public String del(){
        orderService.delOrder(this.order.getOrderId());
        return "reList";
    }

//    关键字搜索
    public String search(){
//        根据名称关键字查询
        List<Order> list1 = orderService.getOrdersByOrderName(keyword);
//        根据客户ID查询
        List<Order> list2 = orderService.getOrdersByUserId(keyword);
//        合并两个查询结果
        list.addAll(list1);
        list.addAll(list2);
        return "list";
    }

//    清空订单信息
    public String clear(){
        orderService.delAllOrdersByUserId(this.customer.getUserId());
        return "clear";
    }
}
