/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom.impl;

import java.util.ArrayList;
import java.util.List;

import lk.pitza.pos.business.custom.ItemBO;
import lk.pitza.pos.dao.custom.ItemDAO;

import lk.pitza.pos.dto.ItemDTO;
import lk.pitza.pos.entity.Item;
import org.hibernate.HibernateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maheshwarie
 */
@Component
@Transactional
public class ItemBOImpl implements ItemBO{

    @Autowired
    private ItemDAO itemDAO;
//    private SessionFactory sessionFactory;

    public ItemBOImpl() {
//        this.itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ITEM);
//        sessionFactory = HibernateUtil.getSessionFactory();
    }


    public boolean saveItem(ItemDTO item) throws Exception {
       try{


           Item item1 = new Item(item.getI_Id(),item.getIt_name(),item.getDescription(),item.getPrice());
           itemDAO.save(item1);



           return true;
       }catch (HibernateException exp){
           return false;
       }
    }


    public boolean updateItem(ItemDTO item) throws Exception {
        return false;
    }


    public boolean deleteItem(String id) throws Exception {
        try{

            itemDAO.delete(id);

            return true;
        }catch (HibernateException exp){
            return false;
        }
    }


    public ItemDTO findByID(String id) throws Exception {
        return null;
    }


    public ArrayList<ItemDTO> getAllItem() throws Exception {
        try{


            List<Item> allItems = itemDAO.getAll();

            ArrayList<ItemDTO> dtos = new ArrayList<>();

            for (Item item : allItems){
                ItemDTO itemDTO = new ItemDTO(item.getI_Id(),item.getIt_name(),item.getDescription(),item.getPrice());
                dtos.add(itemDTO);
            }



            return dtos;

        }catch (HibernateException exp){
            return null;
        }
    }
}
