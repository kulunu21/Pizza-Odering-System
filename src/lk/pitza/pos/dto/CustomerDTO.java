/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.dto;

/**
 *
 * @author Kulunu Chamath
 */
public class CustomerDTO {
    private String C_Id;
    private String C_name;
    private String Address;
    private int Contact;

    public CustomerDTO() {
    }

    public CustomerDTO(String C_Id, String C_name, String Address, int Contact) {
        this.C_Id = C_Id;
        this.C_name = C_name;
        this.Address = Address;
        this.Contact = Contact;
    }

    /**
     * @return the C_Id
     */
    public String getC_Id() {
        return C_Id;
    }

    /**
     * @param C_Id the C_Id to set
     */
    public void setC_Id(String C_Id) {
        this.C_Id = C_Id;
    }

    /**
     * @return the C_name
     */
    public String getC_name() {
        return C_name;
    }

    /**
     * @param C_name the C_name to set
     */
    public void setC_name(String C_name) {
        this.C_name = C_name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Contact
     */
    public int getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    @Override
    public String toString() {
        return "Customer{" + "C_Id=" + C_Id + ", C_name=" + C_name + ", Address=" + Address + ", Contact=" + Contact + '}';
    }
    
    
}
