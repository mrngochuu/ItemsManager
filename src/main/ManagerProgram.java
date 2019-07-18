/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dbo.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Do Ngoc Huu
 */
public class ManagerProgram extends javax.swing.JFrame {

    final int RECORD_IN_PAGE = 5;

    ItemDBAccess dbAccess = null;
    Suppliers suppliers;

    Items items;
    Items pageItems;
    Items searchItems;
    ArrayList<Integer> indexSearch;

    ItemFullModel itemModel;
    boolean addNewItem = false;
    int totalPage;
    int page = 1;

    /**
     * Creates new form ManagerProgram
     */
    public ManagerProgram() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        disableItemDetails();
        dbAccess = new ItemDBAccess();
        suppliers = new Suppliers();
        suppliers.loadFromDB(dbAccess);
        items = new Items();

        int getAll = 3;
        items.loadFromDB(dbAccess, suppliers, getAll);
        Collections.sort(items);
        pageItems = new Items();
        itemModel = new ItemFullModel(pageItems);
        paging(items);
        setupModel();
        tblItems.getColumnModel().getColumn(1).setPreferredWidth(230);

    }

    public void disableItemDetails() {
        chkSupplying.setEnabled(false);
        txtItemCode.setEnabled(false);
        txtItemName.setEnabled(false);
        txtPrice.setEnabled(false);
        txtUnit.setEnabled(false);
        cbSuppliers.setEnabled(false);
    }

    public void enableItemDetails() {
        chkSupplying.setEnabled(true);
        txtItemCode.setEnabled(true);
        txtItemName.setEnabled(true);
        txtPrice.setEnabled(true);
        txtUnit.setEnabled(true);
        cbSuppliers.setEnabled(true);
    }

    public void paging(Items items) {
        updateTotalPage(items);
        //add item to vector pageItems
        itemModel.getItems().clear();
        page = Integer.parseInt(lblPage.getText());
        for (int i = (page - 1) * RECORD_IN_PAGE; i < page * RECORD_IN_PAGE && i < items.size(); i++) {
            itemModel.getItems().add(items.get(i));
        }
    }

    public void updateTotalPage(Items items) {
        //compute totalPage
        totalPage = items.size() / RECORD_IN_PAGE;
        if ((items.size() % RECORD_IN_PAGE) != 0) {
            totalPage++;
        }

        if (totalPage <= 0) {
            totalPage = 1;
        }

        lblTotalPage.setText("" + totalPage);
    }

    public void setupModel() {
        tblItems.setModel(itemModel);
        this.cbSuppliers.setModel(new DefaultComboBoxModel(suppliers));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chkSupplying = new javax.swing.JCheckBox();
        cbSuppliers = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        lblTotalPage = new javax.swing.JLabel();
        lblPage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Manage Suppliers", jPanel1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Item List");

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblItemsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblItems);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Item Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setText("Item code:");

        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });

        jLabel3.setText("Item name:");

        jLabel4.setText("Supplier:");

        jLabel5.setText("Unit:");

        txtUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitActionPerformed(evt);
            }
        });

        jLabel6.setText("Price:");

        jLabel7.setText("Supplying:");

        chkSupplying.setSelected(true);

        cbSuppliers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrice)
                    .addComponent(txtUnit)
                    .addComponent(txtItemName)
                    .addComponent(txtItemCode)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkSupplying)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbSuppliers, 0, 175, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(chkSupplying))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("Add");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        lblTotalPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalPage.setText("1");

        lblPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPage.setText("1");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("/");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("Seach items name:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(10, 10, 10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalPage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNew)
                            .addComponent(btnSave)
                            .addComponent(btnDelete)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalPage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext)
                            .addComponent(btnPrev))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Items", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitActionPerformed

    private void tblItemsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMouseReleased
        int row = tblItems.getSelectedRow();
        int col = tblItems.getSelectedColumn();
        tblItems.getCellEditor(row, col).cancelCellEditing();
    }//GEN-LAST:event_tblItemsMouseReleased

    private void tblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMouseClicked
        addNewItem = false;
        int pos = tblItems.getSelectedRow();
        Item item = itemModel.getItems().get(pos);
        enableItemDetails();
        txtItemCode.setText(item.getItemCode());
        txtItemCode.setEditable(false);
        txtItemName.setText(item.getItemName());
        int index = suppliers.find(item.getSupplier().getSupCode());
        cbSuppliers.setSelectedIndex(index);
        txtUnit.setText("" + item.getUnit());
        txtPrice.setText("" + item.getPrice());
        chkSupplying.setSelected(item.isSupplying());
    }//GEN-LAST:event_tblItemsMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (!validItems()) {
            return;
        }

        String itemCode = txtItemCode.getText().trim().toUpperCase();
        String itemName = txtItemName.getText().trim();
        Supplier supplier = (Supplier) cbSuppliers.getSelectedItem();
        String supCode = supplier.getSupCode().trim();
        String unit = txtUnit.getText().trim();
        int price = Integer.parseInt(txtPrice.getText());
        boolean supplying = chkSupplying.isSelected();
        Item item = new Item(itemCode, itemName, supplier, unit, price, supplying);

        String sql = "";
        if (addNewItem == true) {
            sql = "insert into items values('" + itemCode + "','" + itemName + "','" + supCode + "','"
                    + unit + "'," + price + "," + (supplying ? 1 : 0) + ")";
        } else {
            sql = "update items set itemName='" + itemName + "',supCode='" + supCode + "',unit='" + unit
                    + "',price=" + price + ",supplying=" + (supplying ? 1 : 0) + " where itemCode='" + itemCode + "'";
        }

        JOptionPane.showMessageDialog(this, sql);
        String msg = "An item has been added/updated.";
        try {
            int n = dbAccess.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(this, msg);
                if (addNewItem == false) {
                    int pos = tblItems.getSelectedRow();
                    itemModel.getItems().set(pos, item);
                    if (txtSearch.getText().trim().isEmpty()) {
                        items.set(pos + ((page - 1) * RECORD_IN_PAGE), item);
                    } else {
                        items.set(indexSearch.get(pos + (page - 1) * RECORD_IN_PAGE).intValue(), item);
                    }
                } else {
                    items.add(item);
                    Collections.sort(items);
                }
                search();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
        }
        //remove all content
        addNewItem = false;
        txtItemCode.setText("");
        txtItemName.setText("");
        cbSuppliers.setSelectedIndex(0);
        txtUnit.setText("");
        txtPrice.setText("");
        chkSupplying.setSelected(true);
        disableItemDetails();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int pos = tblItems.getSelectedRow();
        String itemCode = txtItemCode.getText();
        String sql = "Delete from items where itemcode='" + itemCode + "'";
        if (JOptionPane.showConfirmDialog(this, sql) != JOptionPane.YES_OPTION) {
            return;
        }
        String msg = "The item " + itemCode + " has been deleted from DB!";
        try {
            int n = dbAccess.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(this, msg);
                itemModel.getItems().removeElementAt(pos);
                if (txtSearch.getText().trim().isEmpty()) {
                    items.remove(pos + ((page - 1) * RECORD_IN_PAGE));
                } else {
                    items.remove(indexSearch.get(pos + ((page - 1) * RECORD_IN_PAGE)).intValue());
                }

                if (itemModel.getItems().isEmpty() && page > 1) {
                    lblPage.setText("" + (--page));
                }

                search();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
        }

        //remove all content
        addNewItem = false;
        disableItemDetails();
        txtItemCode.setText("");
        txtItemCode.requestFocus();
        txtItemName.setText("");
        cbSuppliers.setSelectedIndex(0);
        txtUnit.setText("");
        txtPrice.setText("");
        chkSupplying.setSelected(true);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        addNewItem = true;
        enableItemDetails();
        txtItemCode.setText("");
        txtItemCode.requestFocus();
        txtItemName.setText("");
        cbSuppliers.setSelectedIndex(0);
        txtUnit.setText("");
        txtPrice.setText("");
        chkSupplying.setSelected(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        page = Integer.parseInt(lblPage.getText());
        if (page == totalPage) {
            return;
        } else {
            lblPage.setText("" + (++page));
        }
        search();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        page = Integer.parseInt(lblPage.getText());
        if (page == 1) {
            return;
        } else {
            lblPage.setText("" + (--page));
        }
        search();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        lblPage.setText("1");
        search();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemCodeActionPerformed
    public void search() {
        String s = txtSearch.getText().trim();
        if (s.isEmpty()) {
            paging(items);
        } else {
            // add the same word to vector searchItems
            searchItems = new Items();
            indexSearch = new ArrayList<>();

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItemName().toUpperCase().indexOf(s.toUpperCase()) == 0) {
                    searchItems.add(items.get(i));
                    indexSearch.add(i);
                }
            }

            paging(searchItems);
        }
        tblItems.updateUI();
    }

    public boolean validItems() {
        String itemCode = txtItemCode.getText().trim().toUpperCase();
        String itemName = txtItemName.getText().trim();
        String unit = txtUnit.getText().trim();
        String price = txtPrice.getText().trim();
        if (addNewItem) {
            if (!itemCode.matches("E\\d{4}")) {
                JOptionPane.showMessageDialog(this, "Item code 's format is E0001!");
                return false;
            }

            //check code exist
            if (items.find(itemCode) != -1) {
                JOptionPane.showMessageDialog(this, "Item code already exists!");
                return false;
            }
        }

        if (itemName.length() < 0 || itemName.length() > 50) {
            JOptionPane.showMessageDialog(this, "Length of item name is from 1 to 50");
            return false;
        }

        if (unit.length() < 0 ||unit.length() > 10) {
            JOptionPane.showMessageDialog(this, "Length of item unit is from 1 to 10");
            return false;
        }

        if (!price.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Price is a digit!");
            return false;
        }

        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbSuppliers;
    private javax.swing.JCheckBox chkSupplying;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblTotalPage;
    private javax.swing.JTable tblItems;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
