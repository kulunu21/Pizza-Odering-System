/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom;

import java.util.ArrayList;
import lk.pitza.pos.business.SuperBO;
import lk.pitza.pos.dto.EmployeeDTO;

/**
 *
 * @author Kulunu Chamath
 */
public interface EmployeeBO extends SuperBO{

    public boolean saveEmployee(EmployeeDTO employee) throws Exception;

    public boolean updateEmployee(EmployeeDTO employee) throws Exception;
    
    public boolean deleteEmployee(String id) throws Exception;
    
    public EmployeeDTO findByID(String id)throws Exception;
    
    public ArrayList<EmployeeDTO> getAllEmployee()throws Exception;

}
