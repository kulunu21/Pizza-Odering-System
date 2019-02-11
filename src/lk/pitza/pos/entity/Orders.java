/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.entity;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Kulunu Chamath
 */
@Entity
public class Orders {
    @Id
    private String O_Id;

    @ManyToOne
    @JoinColumn(name = "Cust_Id",referencedColumnName = "C_Id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "Emp_Id",referencedColumnName = "E_Id")
    private Employee employee;
    @Temporal(TemporalType.DATE)
    private Date Date;

    public Orders() {
    }

    public Orders(String O_Id, Customer customer,Employee employee,Date Date) {
        this.O_Id = O_Id;
        this.customer = customer;
        this.employee = employee;
        this.Date = Date;
    }

    /**
     * @return the O_Id
     */
    public String getO_Id() {
        return O_Id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @param O_Id the O_Id to set
     */


    public void setO_Id(String O_Id) {
        this.O_Id = O_Id;
    }


    /**
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Orders{" + "O_Id=" + O_Id +", Date=" + Date + '}';
    }


}
