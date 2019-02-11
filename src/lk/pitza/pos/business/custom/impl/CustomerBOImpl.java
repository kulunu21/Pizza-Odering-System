/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.pitza.pos.business.custom.CustomerBO;
import lk.pitza.pos.dao.custom.CustomerDAO;

import lk.pitza.pos.dto.CustomerDTO;
import lk.pitza.pos.entity.Customer;
import org.hibernate.HibernateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kulunu Chamath
 */
@Component
@Transactional
public class CustomerBOImpl implements CustomerBO {

    @Autowired

    private CustomerDAO customerDAO;
//    private SessionFactory sessionFactory;

    public CustomerBOImpl() {
//        this.customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);
//        sessionFactory = HibernateUtil.getSessionFactory();
    }


    public boolean saveCustomer(CustomerDTO customer) throws Exception {
        try{


            Customer customer1 = new Customer(customer.getC_Id(),customer.getC_name(),customer.getAddress(),customer.getContact());
            customerDAO.save(customer1);

            return true;

        }catch (HibernateException exp){
            return false;
        }
    }


    public boolean updateCusomer(CustomerDTO customer) throws Exception {
        return false;
    }


    public boolean deleteCustomer(String id) throws Exception {
          try{

            customerDAO.delete(id);

            return true;
        }catch (HibernateException exp){
            return false;
        }
    }


    public CustomerDTO findByID(String id) throws Exception {
        return null;
    }


    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        try{


            List<Customer> allCustomers = customerDAO.getAll();



            ArrayList<CustomerDTO> dtos = new ArrayList<>();

            for (Customer customer : allCustomers){
                CustomerDTO customerDTO = new CustomerDTO(customer.getC_Id(),customer.getC_name(),customer.getAddress(),customer.getContact());
                dtos.add(customerDTO);
            }
            return dtos;
        }catch (HibernateException exp){
            return null;
        }
    }
}