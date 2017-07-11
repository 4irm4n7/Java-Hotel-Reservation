package GUI;

import Classes.Booking;
import Classes.Room;
import javax.swing.table.DefaultTableModel;

public class BookingList extends javax.swing.JPanel implements ConnectTable{
    CreateRoom cr;
    PaymentGui pg;

    DefaultTableModel tableModel;
    @Override
    public void updateTable() {
        roomTable();
        bookingTableAll();
        pg.updateTable();
    }

    public BookingList(ConnectTable cr, ConnectTable pg) {
        this.cr = (CreateRoom) cr;
        this.pg = (PaymentGui) pg;
        initComponents();
    }
    
    public void bookingTableAll() {
        String[] namaKolom = {"Booking ID", "Room ID", "User", "Check In", "Check Out"};
        int z = 0;
        for(Room r : cr.roomArray){
            z += r.getArrayBooking().size();
        }
        
        Object[][] objectBooking = new Object[z][];
        int x = 0;
        for(int i = 0; i < cr.roomArray.size(); i++){
            for (Booking b : cr.roomArray.get(i).getArrayBooking()) {
                String checkInDate = b.getDateFormat().format(b.getCheckInDate());
                String checkOutDate = b.getDateFormat().format(b.getCheckOutDate());
                String arrayBooking[] = {String.valueOf(b.getBookingId()), String.valueOf(cr.roomArray.get(i).getRoomId()), b.getCustomer().getName(),checkInDate,checkOutDate};
                objectBooking[x] = arrayBooking;
                x++;
            }
        }
        
        tableModel = new DefaultTableModel(objectBooking, namaKolom);
        bookingList.setModel(tableModel);
    }
    
    public void bookingTable(int i) {
        String[] namaKolom = {"Booking ID","Room ID", "User", "Check In", "Check Out"};
        Object[][] objectBooking = new Object[cr.roomArray.get(i).getArrayBooking().size()][];
        int x = 0;
        for (Booking b : cr.roomArray.get(i).getArrayBooking()) {
            String checkInDate = b.getDateFormat().format(b.getCheckInDate());
            String checkOutDate = b.getDateFormat().format(b.getCheckOutDate());
            String arrayBooking[] = {String.valueOf(b.getBookingId()), String.valueOf(cr.roomArray.get(i).getRoomId()),b.getCustomer().getName(),checkInDate,checkOutDate};
            objectBooking[x] = arrayBooking;
            x++;
        }
        tableModel = new DefaultTableModel(objectBooking, namaKolom);
        bookingList.setModel(tableModel);
    }
    public void roomTable() {
        String[] namaKolom = {"Room ID", "Room No", "Class", "Beds"};
        Object[][] objectRoom = new Object[cr.roomArray.size()][];
        int i=0;
        for (Room r : cr.roomArray) {
            String arrayRoom[] = {String.valueOf(r.getRoomId()),r.getRoomNo(),r.getRoomClass().getRoomType(),String.valueOf(r.getBedNumber())};
            objectRoom[i] = arrayRoom;
            i++;
        }
        tableModel = new DefaultTableModel(objectRoom, namaKolom);
        roomList.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomList = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingList = new javax.swing.JTable();
        tampilBookingAll = new javax.swing.JButton();
        deleteBooking = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        roomList.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        roomList.setRowHeight(20);
        roomList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(roomList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bookingList.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        bookingList.setRowHeight(20);
        jScrollPane1.setViewportView(bookingList);

        tampilBookingAll.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tampilBookingAll.setText("Show All");
        tampilBookingAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilBookingAllActionPerformed(evt);
            }
        });

        deleteBooking.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        deleteBooking.setText("Delete");
        deleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tampilBookingAll)
                .addGap(18, 18, 18)
                .addComponent(deleteBooking)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tampilBookingAll)
                    .addComponent(deleteBooking))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void roomListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomListMouseClicked
        int value = Integer.parseInt((String) roomList.getModel().getValueAt(roomList.getSelectedRow(), 0));
        for(int i=0;i<cr.roomArray.size();i++) {
            if(value == cr.roomArray.get(i).getRoomId()){
                bookingTable(i);
                break;
            }
        }
    }//GEN-LAST:event_roomListMouseClicked

    private void tampilBookingAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilBookingAllActionPerformed
        roomTable();
        bookingTableAll();
    }//GEN-LAST:event_tampilBookingAllActionPerformed

    private void deleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookingActionPerformed
        int value = Integer.parseInt((String) bookingList.getModel().getValueAt(bookingList.getSelectedRow(), 0));
        for(int i = 0; i < cr.roomArray.size(); i++){
            for (Booking b : cr.roomArray.get(i).getArrayBooking()) {
                if(value == b.getBookingId()){
                    cr.roomArray.get(i).getArrayBooking().remove(b);
                    break;
                }
            }
        }
        updateTable();
    }//GEN-LAST:event_deleteBookingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookingList;
    private javax.swing.JButton deleteBooking;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable roomList;
    private javax.swing.JButton tampilBookingAll;
    // End of variables declaration//GEN-END:variables
}
