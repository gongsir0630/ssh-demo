package com.gongSir.model;

import javax.persistence.*;
/*
    使用IDEA自动生成的Customer实体类
    author: 龚涛
 */
@Entity
//通过@Table注解来绑定要操作的数据表
@Table(name = "customer")
public class Customer {
    private String userId;
    private String userPass;
    private String realName;
    private String userPhone;
    private String userAddr;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_pass")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_addr")
    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (userId != null ? !userId.equals(customer.userId) : customer.userId != null) return false;
        if (userPass != null ? !userPass.equals(customer.userPass) : customer.userPass != null) return false;
        if (realName != null ? !realName.equals(customer.realName) : customer.realName != null) return false;
        if (userPhone != null ? !userPhone.equals(customer.userPhone) : customer.userPhone != null) return false;
        if (userAddr != null ? !userAddr.equals(customer.userAddr) : customer.userAddr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (userAddr != null ? userAddr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", userPass='" + userPass + '\'' +
                ", realName='" + realName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }
}
