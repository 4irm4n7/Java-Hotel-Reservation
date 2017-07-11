package GUI;

import Classes.*;
import javax.swing.table.DefaultTableModel;

public class RoomList extends javax.swing.JPanel implements ConnectTable{

    ConnectTable pr;
    CreateRoom cr;
    PaymentGui paymenGui;
    DefaultTableModel tableModel;
    @Override
    public void updateTable() {
        String[] namaKolom = {"Room ID", "Room Number", "Class", "Beds", "Wifi", "Breakfast", "Pay/Day"};
        Object[][] objectRoom = new Object[cr.roomArray.size()][];
        int i=0;
        for (Room r : cr.roomArray) {
            String arrayRoom[] = {String.valueOf(r.getRoomId()),r.getRoomNo(),r.getRoomClass().getRoomType(),String.valueOf(r.getBedNumber()), String.valueOf(r.isHasWifi()), String.valueOf(r.isHasBreakFast()), String.valueOf(r.getRoomClass().getHargaPerHari())};
            objectRoom[i] = arrayRoom;
            i++;
        }
        tableModel = new DefaultTableModel(objectRoom, namaKolom);
        tableRoom.setModel(tableModel);
        paymenGui.updateTable();
    }
    public RoomList(ConnectTable pr, ConnectTable pt) {
        this.paymenGui = (PaymentGui) pt;
        this.cr = (CreateRoom) pr;
        initComponents();
        updateTable();
    }

    public void setPaymenGui(ConnectTable pt) {
        this.paymenGui = (PaymentGui) pt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        delete = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableRoom.setAutoCreateRowSorter(true);
        tableRoom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableRoom.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableRoom.setRowHeight(20);
        jScrollPane2.setViewportView(tableRoom);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(delete)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int value = Integer.parseInt((String) tableRoom.getModel().getValueAt(tableRoom.getSelectedRow(), 0));
        for(int i=0;i<cr.roomArray.size();i++) {
            if(value == cr.roomArray.get(i).getRoomId()){
               cr.roomArray.remove(i);
               break;
            }
        }
        
        updateTable();
        cr.getBooking().updateTable();
        cr.getBl().updateTable();
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableRoom;
    // End of variables declaration//GEN-END:variables
}
