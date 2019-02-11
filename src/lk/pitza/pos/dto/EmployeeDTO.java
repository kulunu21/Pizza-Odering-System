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
public class EmployeeDTO {

    private String E_Id;
    private String E_name;
    private String Address;
    private int Contact;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String E_Id, String E_name, String Address, int Contact) {
        this.E_Id = E_Id;
        this.E_name = E_name;
        this.Address = Address;
        this.Contact = Contact;
    }

    /**
     * @return the E_Id
     */
    public String getE_Id() {
        return E_Id;
    }

    /**
     * @param E_Id the E_Id to set
     */
    public void setE_Id(String E_Id) {
        this.E_Id = E_Id;
    }

    /**
     * @return the E_name
     */
    public String getE_name() {
        return E_name;
    }

    /**
     * @param E_name the E_name to set
     */
    public void setE_name(String E_name) {
        this.E_name = E_name;
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
        return "EmployeeDTO{" + "E_Id=" + E_Id + ", E_name=" + E_name + ", Address=" + Address + ", Contact=" + Contact + '}';
    }
    
    
}
