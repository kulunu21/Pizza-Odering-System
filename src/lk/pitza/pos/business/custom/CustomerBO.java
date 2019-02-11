/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom;

import java.util.ArrayList;
import lk.pitza.pos.business.SuperBO;
import lk.pitza.pos.dto.CustomerDTO;

/**
 *
 * @author Kulunu Chamath
 */
public interface CustomerBO extends SuperBO{
    
    public boolean saveCustomer(CustomerDTO customer) throws Exception;
    
    public boolean updateCusomer(CustomerDTO customer) throws Exception;
    
    public boolean deleteCustomer(String id) throws Exception;
    
    public CustomerDTO findByID(String id) throws Exception;
    
    public ArrayList<CustomerDTO> getAllCustomer()throws Exception;
}
