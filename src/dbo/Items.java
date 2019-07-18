/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbo;

import java.sql.*;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Do Ngoc Huu
 */
public class Items extends Vector<Item> {

    final int SUPPLYING = 1; // mặt hàng còn bán
    final int NOTSUPPLYING = 2; // mặt hàng đã ngưng bán

    public Items() {
    }

    public int find(String itemCode) {
        for (int i = 0; i < this.size(); i++) {
            if (itemCode.equals(this.get(i).getItemCode())) {
                return i;
            }
        }
        return -1;
    }

    public Item findItem(String itemCode) {
        int i = find(itemCode);
        return i < 0 ? null : this.get(i);
    }
    
    public void loadFromDB(ItemDBAccess dbObj, Suppliers suppliers, int supply) {
        String itemCode, itemName, supplierCode, unit;
        int price;
        boolean supplying;
        String sql = ""; // get items from the table Items in database
        if(supply == SUPPLYING) sql = "select * from Items where supplying=true";
        else if (supply == NOTSUPPLYING) sql = "select * from Items where supplying=false";
        else sql = "select * from Items";
        try {
            ResultSet rs = dbObj.executeQuery(sql);
            while(rs.next()) {
                itemCode = rs.getString(1);
                itemName = rs.getString(2);
                supplierCode = rs.getString(3);
                Supplier supplier = suppliers.findSupplier(supplierCode);
                unit = rs.getString(4);
                price = rs.getInt(5);
                supplying = rs.getBoolean(6);
                Item item = new Item(itemCode, itemName, supplier, unit, price, supplying);
                this.add(item);
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
}
