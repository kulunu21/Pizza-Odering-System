/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.view.util.tblmodel;

import java.util.Date;

/**
 *
 * @author Maheshwarie
 */
public class OrdersTM {
    private String O_Id;
    private String Cust_Id;
    private String Emp_Id;
    private Date Date;

    public OrdersTM() {
    }

    public OrdersTM(String O_Id, String Cust_Id, String Emp_Id, Date Date) {
        this.O_Id = O_Id;
        this.Cust_Id = Cust_Id;
        this.Emp_Id = Emp_Id;
        this.Date = Date;
    }

    /**
     * @return the O_Id
     */
    public String getO_Id() {
        return O_Id;
    }

    /**
     * @param O_Id the O_Id to set
     */
    public void setO_Id(String O_Id) {
        this.O_Id = O_Id;
    }

    /**
     * @return the Cust_Id
     */
    public String getCust_Id() {
        return Cust_Id;
    }

    /**
     * @param Cust_Id the Cust_Id to set
     */
    public void setCust_Id(String Cust_Id) {
        this.Cust_Id = Cust_Id;
    }

    /**
     * @return the Emp_Id
     */
    public String getEmp_Id() {
        return Emp_Id;
    }

    /**
     * @param Emp_Id the Emp_Id to set
     */
    public void setEmp_Id(String Emp_Id) {
        this.Emp_Id = Emp_Id;
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
        return "OrdersTM{" + "O_Id=" + O_Id + ", Cust_Id=" + Cust_Id + ", Emp_Id=" + Emp_Id + ", Date=" + Date + '}';
    }
    
    
}
