package Sky.Cat;


import Sky.DateModel.DateSpinnerDataModel;
import Sky.Listener.Event;
import Sky.Listener.EventListener;
import Sky.Listener.EventType;
import dbConnect.DBConnect;
import dbConnect.models.ITRequest;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UpdateRequest extends javax.swing.JFrame {
    DateSpinnerDataModel dateSpinnerDataModel = new DateSpinnerDataModel();
    public UpdateRequest() {
        initComponents();
        getContentPane().setBackground(new Color(165,196,221));
        loadDateSelector();
        fillComboBox();
    }

    public UpdateRequest(int id) {
        initComponents();

        getContentPane().setBackground(new Color(165,196,221));

        loadDateSelector();

        fillComboBox(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        updateRequestButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        requestNameField = new javax.swing.JTextField();
        requestEmailField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        requestTypeField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestDetailField = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        requestIdCombox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        DateSpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        requestDateField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Request");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        updateRequestButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateRequestButton.setText("Update Request");
        updateRequestButton.setToolTipText("Update the selected request from the database");
        updateRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRequestButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Requester's Name");

        jLabel4.setText("Requester's Email");

        requestTypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTypeFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Request Type");

        jLabel7.setText("Request details");

        requestDetailField.setColumns(20);
        requestDetailField.setLineWrap(true);
        requestDetailField.setRows(3);
        jScrollPane1.setViewportView(requestDetailField);

        jLabel9.setText("Request ID");

        requestIdCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestIdComboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Select an ID");

        clearButton.setText("Clear selection");
        clearButton.setToolTipText("Reset the selected choice");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        DateSpinner.setToolTipText("Select a day for when the request took place.");
        DateSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DateSpinnerStateChanged(evt);
            }
        });

        jLabel5.setText("Day of request");

        jLabel8.setText("Date");

        requestDateField.setEditable(false);
        requestDateField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(requestDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel3)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(requestNameField)
                                .addComponent(requestEmailField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(requestTypeField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(requestIdCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(clearButton)))
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(updateRequestButton)
                            .addGap(18, 18, 18)
                            .addComponent(cancelButton)
                            .addGap(100, 100, 100)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(requestIdCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton))
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(requestNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(DateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(requestEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(requestTypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateRequestButton)
                            .addComponent(cancelButton)))
                    .addComponent(jLabel7))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void requestTypeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTypeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_requestTypeFieldActionPerformed

    private void updateRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRequestButtonActionPerformed
        updateRequest();

        EventListener.inform(new Event(EventType.DataEvent));
    }//GEN-LAST:event_updateRequestButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearFormFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void requestIdComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestIdComboxActionPerformed
        ITRequest itRequest = (ITRequest) requestIdCombox.getSelectedItem();

        if (itRequest != null) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                String reqDate =String.valueOf(itRequest.getReqDate());

                Date date = dateFormat.parse(reqDate);

                dateSpinnerDataModel.setValue(date);
            } catch (ParseException e) {
                System.out.println("I messed up the data, skipping date parsing");
            }

            requestDateField.setText(String.valueOf(itRequest.getReqDate()));
            requestEmailField.setText(itRequest.getReqEmail());
            requestNameField.setText(itRequest.getReqName());
            requestDetailField.setText(itRequest.getReqDetails());
            requestTypeField.setText(itRequest.getReqType());

        }
    }//GEN-LAST:event_requestIdComboxActionPerformed

    private void DateSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DateSpinnerStateChanged
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) DateSpinner.getValue();
        if (date != null) {
            String format = dateFormat.format(date);
            requestDateField.setText(format);
        }
    }//GEN-LAST:event_DateSpinnerStateChanged

    private void clearFormFields() {
        requestTypeField.setText(null);
        requestDateField.setText(null);
        requestDetailField.setText(null);
        requestEmailField.setText(null);
        requestNameField.setText(null);
        requestIdCombox.setSelectedIndex(-1);
    }

    private void fillComboBox() {
        try {
            List<ITRequest> itRequestList = DBConnect.retrieveAll(ITRequest.class);
            for (ITRequest itRequest : itRequestList) {
                requestIdCombox.addItem(itRequest);
            }
            clearFormFields();
        } catch (Exception e) {
            System.out.println("There was issue loading combo box\'s content");
            e.printStackTrace();
        }
    }

    private void fillComboBox(int id) {
        try {
            String condition = "ReqID = ?";
            List<ITRequest> itRequestList = DBConnect.retrieve(ITRequest.class, condition, id);
            for (ITRequest itRequest : itRequestList) {
                requestIdCombox.addItem(itRequest);
            }
        } catch (Exception e) {
            System.out.println("There was issue loading combo box\'s content");
            e.printStackTrace();
        }
    }

    private void updateScreen() {
        requestIdCombox.removeAllItems();
        fillComboBox();
    }

    private void loadDateSelector() {
        DateSpinner.setModel(dateSpinnerDataModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(DateSpinner, "yyyy-MM-dd");
        DateSpinner.setEditor(editor);
    }

    private void updateToDataBase(int id, String name, String email, java.sql.Date date, String type, String detail)  {
        ITRequest itRequest = new ITRequest(id, name, date, email, type, detail);
        boolean success = DBConnect.update(itRequest);
        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Request updated in database!", "Successes", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            updateScreen();
            clearFormFields();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Cannot update request", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRequest() {
        try {
            ITRequest it = (ITRequest) requestIdCombox.getSelectedItem();
            int id = it.getReqID();
            String name = requestNameField.getText();
            String type = requestTypeField.getText();
            String detail = requestDetailField.getText();
            String email = requestEmailField.getText();
            java.sql.Date date = java.sql.Date.valueOf(requestDateField.getText());

            updateToDataBase(id, name, email, date, type, detail);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cannot update request. Problem founded: \n >" + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner DateSpinner;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField requestDateField;
    private javax.swing.JTextArea requestDetailField;
    private javax.swing.JTextField requestEmailField;
    private javax.swing.JComboBox<ITRequest> requestIdCombox;
    private javax.swing.JTextField requestNameField;
    private javax.swing.JTextField requestTypeField;
    private javax.swing.JButton updateRequestButton;
    // End of variables declaration//GEN-END:variables
}