/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom;

import java.util.ArrayList;
import lk.pitza.pos.business.SuperBO;
import lk.pitza.pos.dto.OrderDetailDTO;
import lk.pitza.pos.dto.OrdersDTO;

/**
 *
 * @author Kulunu Chamath
 */
public interface PlaceOrderBO extends SuperBO{
    
    public boolean placeOrder(OrdersDTO ordersDTO, ArrayList<OrderDetailDTO>orderitems) throws Exception;
    
}
