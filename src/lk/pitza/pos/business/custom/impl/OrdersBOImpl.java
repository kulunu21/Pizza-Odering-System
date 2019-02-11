/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom.impl;

import java.util.ArrayList;
import lk.pitza.pos.business.custom.OrdersBO;
import lk.pitza.pos.dto.OrdersDTO;

/**
 *
 * @author Maheshwarie
 */
public class OrdersBOImpl implements OrdersBO{


    @Override
    public boolean saveOrders(OrdersDTO orders) throws Exception {
        return false;
    }

    @Override
    public boolean updateOrders(OrdersDTO orders) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrders(String id) throws Exception {
        return false;
    }

    @Override
    public OrdersDTO findById(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() throws Exception {
        return null;
    }
}
