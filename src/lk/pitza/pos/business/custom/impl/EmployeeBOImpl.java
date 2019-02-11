/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.pitza.pos.business.custom.EmployeeBO;
import lk.pitza.pos.dao.custom.EmployeeDAO;

import lk.pitza.pos.dto.EmployeeDTO;
import lk.pitza.pos.entity.Employee;
import org.hibernate.HibernateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 *
 * @author Maheshwarie
 */

@Component
@Transactional
public class EmployeeBOImpl implements EmployeeBO{

    @Autowired
    private EmployeeDAO employeeDAO;
//    private SessionFactory sessionFactory;

    public EmployeeBOImpl(){
//        this.employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.EMPLOYEE);
//        sessionFactory = HibernateUtil.getSeqssionFactory();
    }


    public boolean saveEmployee(EmployeeDTO employee) throws Exception {
        try {

            Employee employee1 = new Employee(employee.getE_Id(),employee.getE_name(),employee.getAddress(),employee.getContact());
            employeeDAO.save(employee1);

            return true;
        }catch (HibernateException exp){
            return false;

        }
    }


    public boolean updateEmployee(EmployeeDTO employee) throws Exception {
        return false;
    }


    public boolean deleteEmployee(String id) throws Exception {
        try{

            employeeDAO.delete(id);

            return true;
        }catch (HibernateException exp){
            return false;
        }
    }


    public EmployeeDTO findByID(String id) throws Exception {
        return null;
    }


    public ArrayList<EmployeeDTO> getAllEmployee() throws Exception {
        try{



            List<Employee> allEmployees = employeeDAO.getAll();

            ArrayList<EmployeeDTO> dtos = new ArrayList<>();

            for (Employee employee : allEmployees){
                EmployeeDTO employeeDTO = new EmployeeDTO(employee.getE_Id(),employee.getE_name(),employee.getAddress(),employee.getContact());
                dtos.add(employeeDTO);

            }
            return dtos;
        }catch (HibernateException exp){
            return null;
        }
    }
}
