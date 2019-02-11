/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pitza.pos.business.custom;

import java.util.ArrayList;
import lk.pitza.pos.business.SuperBO;
import lk.pitza.pos.dto.ItemDTO;

/**
 *
 * @author Kulunu Chamath
 */
public interface ItemBO extends SuperBO{

    public boolean saveItem(ItemDTO item) throws Exception;

    public boolean updateItem(ItemDTO item) throws Exception;

    public boolean deleteItem(String id) throws Exception;

    public ItemDTO findByID(String id) throws Exception;

    public ArrayList<ItemDTO> getAllItem() throws Exception;

}