/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom.impl;

import java.util.ArrayList;
import lk.pitza.pos.business.custom.OrderDetailBO;
import lk.pitza.pos.dto.OrderDetailDTO;

/**
 *
 * @author Maheshwarie
 */
public class OrderDetailsBOImpl implements OrderDetailBO{


    @Override
    public boolean saveOrderdetail(OrderDetailDTO orderdetail) throws Exception {
        return false;
    }

    @Override
    public boolean updateOrderdetail(OrderDetailDTO orderdetail) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrderdetail(String id) throws Exception {
        return false;
    }

    @Override
    public OrderDetailDTO findById(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAllOD() throws Exception {
        return null;
    }
}
