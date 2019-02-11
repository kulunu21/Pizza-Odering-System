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
public class ItemDTO {

    private String I_Id;
    private String It_name;
    private String Description;
    private BigDecimal Price;

    public ItemDTO() {
    }

    public ItemDTO(String I_Id, String It_name, String Description, BigDecimal Price) {
        this.I_Id = I_Id;
        this.It_name = It_name;
        this.Description = Description;
        this.Price = Price;
    }

    /**
     * @return the I_Id
     */
    public String getI_Id() {
        return I_Id;
    }

    /**
     * @param I_Id the I_Id to set
     */
    public void setI_Id(String I_Id) {
        this.I_Id = I_Id;
    }

    /**
     * @return the It_name
     */
    public String getIt_name() {
        return It_name;
    }

    /**
     * @param It_name the It_name to set
     */
    public void setIt_name(String It_name) {
        this.It_name = It_name;
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
     * @return the Price
     */
    public BigDecimal getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" + "I_Id=" + I_Id + ", It_name=" + It_name + ", Description=" + Description + ", Price=" + Price + '}';
    }
     
    

}
