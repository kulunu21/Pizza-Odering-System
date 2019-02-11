/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom;

import java.util.ArrayList;
import lk.pitza.pos.business.SuperBO;
import lk.pitza.pos.dto.OrderDetailDTO;

/**
 *
 * @author Kulunu Chamath
 */
public interface OrderDetailBO extends SuperBO{
    
    public boolean saveOrderdetail(OrderDetailDTO orderdetail) throws Exception;
    
    public boolean updateOrderdetail(OrderDetailDTO orderdetail) throws Exception;
    
    public boolean deleteOrderdetail(String id) throws Exception;
    
    public OrderDetailDTO findById(String id) throws Exception;
    
    public ArrayList<OrderDetailDTO> getAllOD() throws Exception;
    
}
