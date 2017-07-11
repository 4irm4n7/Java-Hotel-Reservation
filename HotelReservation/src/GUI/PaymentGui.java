package GUI;

import Classes.Booking;
import Classes.Cash;
import Classes.Credit;
import Classes.Payment;
import Classes.Room;
import javax.swing.table.DefaultTableModel;

public class PaymentGui extends javax.swing.JPanel implements ConnectTable{
    
    DefaultTableModel tableModel;
    CreateRoom cr;
    Payment payment;

    public PaymentGui(ConnectTable pt) {
        cr = (CreateRoom) pt;
        initComponents();
    }
    public void updateTable() {
        String[] namaKolom = {"Booking ID", "User", "Fare", "Payment"};
        int z = 0;
        for(Room r : cr.roomArray){
            z += r.getArrayBooking().size();
        }
        
        Object[][] objectBooking = new Object[z][];
        int x = 0;
        for(int i = 0; i < cr.roomArray.size(); i++){
            for (Booking b : cr.roomArray.get(i).getArrayBooking()) {
                int terBayar = 0;
                for(Payment py : b.getArrayPayment()){
                    terBayar += py.pay;
                }
                String arrayBooking[] = {String.valueOf(b.getBookingId()), b.getCustomer().getName(), String.valueOf(b.getTarip()), String.valueOf(terBayar)};
                objectBooking[x] = arrayBooking;
                x++;
            }
        }
        
        tableModel = new DefaultTableModel(objectBooking, namaKolom);
        pembayaranTable.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        type = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        bayar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pembayaranTable = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        type.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit"}));
        type.setSelectedIndex(0);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Type");

        bayar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bayar.setText("Pay");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type, 0, 188, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bayar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(bayar)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pembayaranTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pembayaranTable.setRowHeight(20);
        jScrollPane1.setViewportView(pembayaranTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        int value = Integer.parseInt((String) pembayaranTable.getModel().getValueAt(pembayaranTable.getSelectedRow(), 0));
        int tarip = Integer.parseInt((String) pembayaranTable.getModel().getValueAt(pembayaranTable.getSelectedRow(), 2));
        int pay = Integer.parseInt((String) pembayaranTable.getModel().getValueAt(pembayaranTable.getSelectedRow(), 3));
        if(tarip > pay){
            for(int i = 0; i < cr.roomArray.size(); i++){
                for (Booking b : cr.roomArray.get(i).getArrayBooking()) {
                    if(value == b.getBookingId()){
                        if(type.getSelectedItem().equals("Cash")){
                            BayarCash bayarCash = new BayarCash();
                            bayarCash.setPg(this);
                            payment = b.getPayment();
                            payment = new Cash(b.getPayment().total);
                            bayarCash.setB(b);
                            bayarCash.setP(payment);
                            bayarCash.setVisible(true);
                            break;
                        }else if(type.getSelectedItem().equals("Credit")){
                            BayarCredit bayarCredit = new BayarCredit();
                            bayarCredit.setPg(this);
                            payment = b.getPayment();
                            payment = new Credit(b.getPayment().total);
                            bayarCredit.setB(b);
                            bayarCredit.setP(payment);
                            bayarCredit.setVisible(true);
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_bayarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pembayaranTable;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
