/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.entity;



import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author Kulunu Chamath
 */
@Entity
public class OrderDetail {

//    @Id
//    private String OD_Id;
    @EmbeddedId
    private OrderDetail_PK orderDetail_pk;

    @ManyToOne
    @JoinColumn(name = "itemId",referencedColumnName = "I_Id",insertable = false,updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name ="orderId",referencedColumnName = "O_Id",insertable = false,updatable = false)
    private Orders order;
    private String Description;
    private int Qty;
    private BigDecimal Amount;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetail_PK orderDetail_pk, String description, int qty, BigDecimal amount) {
//        this.OD_Id = OD_Id;
        this.orderDetail_pk = orderDetail_pk;
        Description = description;
        Qty = qty;
        Amount = amount;
    }

    public OrderDetail(String orderId,String itemId,String description, int qty, BigDecimal amount) {
//        this.OD_Id = OD_Id;
        this.orderDetail_pk = new OrderDetail_PK(orderId, itemId);
        Description = description;
        Qty = qty;
        Amount = amount;
    }

//    /**
//     * @return the OD_Id
//     */
//    public String getOD_Id() {
//        return OD_Id;
//    }
//
//    /**
//     * @param OD_Id the OD_Id to set
//     */
//    public void setOD_Id(String OD_Id) {
//        this.OD_Id = OD_Id;
//    }
//

    public OrderDetail_PK getOrderDetail_pk() {
        return orderDetail_pk;
    }

    public void setOrderDetail_pk(OrderDetail_PK orderDetail_pk) {
        this.orderDetail_pk = orderDetail_pk;
    }

    /**
     * @return the Description
     */

    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Qty
     */
    public int getQty() {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     */
    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    /**
     * @return the Amount
     */
    public BigDecimal getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +

                ", orderDetail_pk=" + orderDetail_pk +
                ", Description='" + Description + '\'' +
                ", Qty=" + Qty +
                ", Amount=" + Amount +
                '}';
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
