/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import lk.pitza.pos.dao.CrudDAOImpl;
import lk.pitza.pos.dao.custom.OrderDetailDAO;
import lk.pitza.pos.entity.OrderDetail;
import lk.pitza.pos.entity.OrderDetail_PK;
import org.springframework.stereotype.Component;

/**
 *
 * @author Kulunu Chamath
 */
@Component
public class OrderDetailsDAOImpl extends CrudDAOImpl<OrderDetail, String> implements OrderDetailDAO{

    
}
