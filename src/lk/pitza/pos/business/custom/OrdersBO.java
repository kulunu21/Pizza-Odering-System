/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom;

import java.util.ArrayList;
import lk.pitza.pos.business.SuperBO;
import lk.pitza.pos.dto.OrdersDTO;

/**s
 *
 * @author Kulunu Chamath
 */
public interface OrdersBO extends SuperBO{
    
    public boolean saveOrders(OrdersDTO orders) throws Exception;
    
    public boolean updateOrders(OrdersDTO orders) throws Exception;
    
    public boolean deleteOrders(String id) throws Exception;
    
    public OrdersDTO findById(String id) throws Exception;
    
    public ArrayList<OrdersDTO> getAllOrders() throws Exception;
    
}
