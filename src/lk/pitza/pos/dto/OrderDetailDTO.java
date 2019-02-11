/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.dto;

import java.math.BigDecimal;

/**
 *
 * @author Kulunu Chamath
 */
public class OrderDetailDTO {


    private String Item_Id;
    private String Description;
    private int Qty;
    private BigDecimal Amount;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String Item_Id, String Description, int Qty, BigDecimal Amount) {

        this.Item_Id = Item_Id;
        this.Description = Description;
        this.Qty = Qty;
        this.Amount = Amount;
    }

    /**
     * @return the OD_Id
     */
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

    /**
     * @return the Item_Id
     */
    public String getItem_Id() {
        return Item_Id;
    }

    /**
     * @param Item_Id the Item_Id to set
     */
    public void setItem_Id(String Item_Id) {
        this.Item_Id = Item_Id;
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
        return "OrderDetailDTO{" +
                "Item_Id='" + Item_Id + '\'' +
                ", Description='" + Description + '\'' +
                ", Qty=" + Qty +
                ", Amount=" + Amount +
                '}';
    }
}
