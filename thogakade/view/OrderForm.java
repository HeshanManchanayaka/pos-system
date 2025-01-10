/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thogakade.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import thogakade.Controller.CustomerController;
import thogakade.Controller.ItemController;
import thogakade.Controller.OrderController;
import thogakade.model.Item;

public class OrderForm extends javax.swing.JFrame {

    public OrderForm() {
        initComponents();
        // load order date
        loadDate();
        //load all customer ids
        loadAllCustomerIds();
        // load item codes
        loadAllItemCodes();
        // load Order Id
        setOrderId();
    }

    private void loadDate() {
        txtOrderDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    private void loadAllCustomerIds() {
        try {
            for (String tempId : CustomerController.getAllCustomerIds()) {
                cmbCustomerId.addItem(tempId);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void loadAllItemCodes() {
        try {
            for (String tempId : ItemController.loadAllItemCodes()) {
                cmbItemCode.addItem(tempId);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void setOrderId() {
        try {
            String lastOrderId = OrderController.getLastOrderId();
            if (lastOrderId != null) {
                lastOrderId = lastOrderId.split("[A-Z]")[1]; // D001==> 001
                System.out.println(lastOrderId);
                lastOrderId = String.format("D%03d", (Integer.parseInt(lastOrderId) + 1));
                lblOrderId.setText(lastOrderId);
            } else {
                lblOrderId.setText("D001");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblOrderId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOrderDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbCustomerId = new javax.swing.JComboBox<>();
        addNewCustomerButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtQty = new javax.swing.JTextField();
        lblQtyOnHand = new javax.swing.JLabel();
        lblUnitPrice = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        cmbItemCode = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnCommit = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemDetails = new javax.swing.JTable();
        lblCustomerName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel1.setText("Place Order Form");

        lblOrderId.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblOrderId.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel5.setText("Order Date :");

        txtOrderDate.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel6.setText("Customer ID : ");

        cmbCustomerId.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        cmbCustomerId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCustomerIdItemStateChanged(evt);
            }
        });
        cmbCustomerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerIdActionPerformed(evt);
            }
        });

        addNewCustomerButton.setText("New");
        addNewCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCustomerButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel2.setText("Order ID : ");

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel13.setText("Qty. on Hand ");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel8.setText("Code :");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel9.setText("Description");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel11.setText("Unit Price");

        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel15.setText("Qty. ");

        txtQty.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtyKeyPressed(evt);
            }
        });

        lblQtyOnHand.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblQtyOnHand.setForeground(new java.awt.Color(0, 153, 251));
        lblQtyOnHand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQtyOnHand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblUnitPrice.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblUnitPrice.setForeground(new java.awt.Color(0, 153, 251));
        lblUnitPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUnitPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDescription.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(0, 153, 251));
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbItemCode.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        cmbItemCode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbItemCodeItemStateChanged(evt);
            }
        });
        cmbItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbItemCodeActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Total : ");

        lblTotal.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 0, 0));

        btnCommit.setText("Commit");
        btnCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommitActionPerformed(evt);
            }
        });

        btnPlaceOrder.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        tblItemDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Description", "qty", "unit Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblItemDetails);

        lblCustomerName.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblCustomerName.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        jLabel7.setText("Customer Name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(addNewCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cmbItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel9))
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel13)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblQtyOnHand, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(btnCommit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlaceOrder)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblOrderId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cmbCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addNewCustomerButton)
                                .addComponent(jLabel7))
                            .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(cmbItemCode))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQtyOnHand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQty, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(btnPlaceOrder)
                        .addComponent(btnCommit)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomerIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCustomerIdItemStateChanged
        String customerId = cmbCustomerId.getSelectedItem().toString();
        try {
            lblCustomerName.setText(CustomerController.searchCustomer(customerId).getName());
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbCustomerIdItemStateChanged

    private void cmbCustomerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerIdActionPerformed
    }//GEN-LAST:event_cmbCustomerIdActionPerformed

    private void addNewCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCustomerButtonActionPerformed
        new AddCustomer().setVisible(true);
    }//GEN-LAST:event_addNewCustomerButtonActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyPressed

    }//GEN-LAST:event_txtQtyKeyPressed
    
    private int isAlreadyExists(String code) {
        DefaultTableModel dtm = (DefaultTableModel) tblItemDetails.getModel();
        for (int i = 0; i < tblItemDetails.getRowCount(); i++) {
            String tempCode = (String) dtm.getValueAt(i, 0);
            if (tempCode.equals(code)) {
                return i;
            }
        }
        return -1;
    }
    
    private void cmbItemCodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbItemCodeItemStateChanged
        try {
            Item item = ItemController.searchItem(cmbItemCode.getSelectedItem().toString());
            lblDescription.setText(item.getDescription());
            lblUnitPrice.setText(String.valueOf(item.getUnitPrice()));
            lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmbItemCodeItemStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tblItemDetails.getModel();

        int qty = Integer.parseInt(txtQty.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = unitPrice * qty;
        String code = cmbItemCode.getSelectedItem().toString();
        System.out.println(code);
        int row = isAlreadyExists(code);
        
        if (row == -1) {
            Object[] rowData = {
                cmbItemCode.getSelectedItem().toString(),
                lblDescription.getText(),
                qty,
                unitPrice,
                total
            };

            dtm.addRow(rowData);

        } else {
            qty += (int) dtm.getValueAt(row, 2);
            total += qty * unitPrice;

            tblItemDetails.setValueAt(qty, row, 2);
            tblItemDetails.setValueAt(total, row, 4);
       }

        txtQty.setText("");

        calculateTotal();
        cmbItemCode.requestFocus();

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed


    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommitActionPerformed

    }//GEN-LAST:event_btnCommitActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed

    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void cmbItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbItemCodeActionPerformed

    }//GEN-LAST:event_cmbItemCodeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewCustomerButton;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCommit;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cmbCustomerId;
    private javax.swing.JComboBox<String> cmbItemCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JLabel lblQtyOnHand;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JTable tblItemDetails;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables

    private void calculateTotal() {
        DefaultTableModel dtm = (DefaultTableModel) tblItemDetails.getModel();
        double total = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            total += (double) dtm.getValueAt(i, 4);
        }
        lblTotal.setText(String.valueOf(total));
    }

}
