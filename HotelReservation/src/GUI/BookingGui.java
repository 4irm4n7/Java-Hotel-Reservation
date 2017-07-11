package GUI;

import Classes.Booking;
import Classes.Customer;
import Classes.GetRoomFare;
import Classes.Room;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookingGui extends javax.swing.JPanel implements ConnectTable{
    private CreateRoom cr;
    private UserList ul;
    Booking booking;
    Customer customer;
    DefaultTableModel tableModel;
    @Override
    public void updateTable() {
        tableRoom.setModel(cr.getRl().tableModel);
        itemRoomList();
    }

    public void setCr(CreateRoom cr) {
        this.cr = cr;
    }

    public CreateRoom getCr() {
        return cr;
    }
    public void itemRoomList(){
        ArrayList item = new ArrayList();
        for (Room r : cr.roomArray) {
             item.add(r.getRoomId());
        }
        roomList.setModel(new DefaultComboBoxModel(item.toArray()));
        roomList1.setModel(new DefaultComboBoxModel(item.toArray()));
    }
    public void updateUserList(){
        userList.setModel(new javax.swing.DefaultComboBoxModel(ul.arrayCustomers.toArray()));
    }
    
    public BookingGui(ConnectTable pr, ConnectTable ul) {
        this.ul = (UserList) ul;
        this.cr = (CreateRoom) pr;
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        checkOutDate = new com.toedter.calendar.JDateChooser();
        checkInDate = new com.toedter.calendar.JDateChooser();
        Save = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        noTlp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        roomList = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        userList = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        save1 = new javax.swing.JButton();
        checkInDate1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        checkOutDate1 = new com.toedter.calendar.JDateChooser();
        roomList1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Check In");

        jLabel7.setText("Check Out");

        jLabel2.setText("Name");

        jLabel3.setText("Address");

        jLabel4.setText("Phone");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("Booking");

        jLabel9.setText("Room Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkInDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noTlp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(address)
                            .addComponent(name)
                            .addComponent(checkOutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Save, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roomList, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkInDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(checkOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(roomList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableRoom.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tableRoom.setRowHeight(20);
        jScrollPane1.setViewportView(tableRoom);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("ID-UserName");

        save1.setText("Save");
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Check In");

        jLabel11.setText("Check Out");

        jLabel12.setText("Room Id");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(save1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(checkOutDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(checkInDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roomList1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(userList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(checkInDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkOutDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(roomList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        int value = Integer.parseInt((roomList.getSelectedItem().toString()));
        for(int i=0;i<cr.roomArray.size();i++) {
            if(value == cr.roomArray.get(i).getRoomId()){
                if(!cr.roomArray.get(i).getArrayBooking().isEmpty()){
                    for(Booking bk : cr.roomArray.get(i).getArrayBooking()){
                        if((bk.getCheckInDate().after(checkInDate.getDate()) && bk.getCheckInDate().before(checkOutDate.getDate())) || (bk.getCheckOutDate().after(checkInDate.getDate()) && bk.getCheckOutDate().before(checkOutDate.getDate())) || (checkInDate.getDate().after(bk.getCheckInDate()) && checkInDate.getDate().before(bk.getCheckOutDate())) || (checkOutDate.getDate().after(bk.getCheckInDate()) && checkOutDate.getDate().before(bk.getCheckOutDate())) || bk.getCheckInDate().equals(checkInDate.getDate()) || bk.getCheckInDate().equals(checkOutDate.getDate()) || bk.getCheckOutDate().equals(checkInDate.getDate()) || bk.getCheckOutDate().equals(checkOutDate.getDate())){
                            JOptionPane.showMessageDialog(this, "Can't booking", "Mesage", JOptionPane.WARNING_MESSAGE);
                        }else{
                            customer = new Customer(name.getText(), address.getText(), noTlp.getText());
                            ul.arrayCustomers.add(customer);
                            booking = new Booking(customer, checkInDate.getDate(), checkOutDate.getDate());
                            GetRoomFare grf = booking;
                            grf.getRoomFare(cr.roomArray.get(i).getRoomClass());
                            cr.roomArray.get(i).getArrayBooking().add(booking);
                            break;
                        }
                    }
                }else{
                    customer = new Customer(name.getText(), address.getText(), noTlp.getText());
                    ul.arrayCustomers.add(customer);
                    booking = new Booking(customer, checkInDate.getDate(), checkOutDate.getDate());
                    GetRoomFare grf = booking;
                    grf.getRoomFare(cr.roomArray.get(i).getRoomClass());
                    cr.roomArray.get(i).getArrayBooking().add(booking);
                    break;
                }
            }
        }
        cr.bl.updateTable();
        ul.updateTable();
        updateUserList();
    }//GEN-LAST:event_SaveActionPerformed

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
        int value = Integer.parseInt((roomList1.getSelectedItem().toString()));
        for(int i=0;i<cr.roomArray.size();i++) {
            if(value == cr.roomArray.get(i).getRoomId()){
                if(!cr.roomArray.get(i).getArrayBooking().isEmpty()){
                    for(Booking bk : cr.roomArray.get(i).getArrayBooking()){
                        if((bk.getCheckInDate().after(checkInDate1.getDate()) && bk.getCheckInDate().before(checkOutDate1.getDate())) || (bk.getCheckOutDate().after(checkInDate1.getDate()) && bk.getCheckOutDate().before(checkOutDate1.getDate())) || (checkInDate1.getDate().after(bk.getCheckInDate()) && checkInDate1.getDate().before(bk.getCheckOutDate())) || (checkOutDate1.getDate().after(bk.getCheckInDate()) && checkOutDate1.getDate().before(bk.getCheckOutDate())) || bk.getCheckInDate().equals(checkInDate1.getDate()) || bk.getCheckInDate().equals(checkOutDate1.getDate()) || bk.getCheckOutDate().equals(checkInDate1.getDate()) || bk.getCheckOutDate().equals(checkOutDate1.getDate())){
                            JOptionPane.showMessageDialog(this, "Can't booking", "Mesage", JOptionPane.WARNING_MESSAGE);
                        }else{
                            for(int z=0;z<ul.arrayCustomers.size();z++) {
                                if(ul.arrayCustomers.get(z).toString().equals(userList.getSelectedItem().toString())){
                                    booking = new Booking(ul.arrayCustomers.get(z), checkInDate1.getDate(), checkOutDate1.getDate());
                                    GetRoomFare grf = booking;
                                    grf.getRoomFare(cr.roomArray.get(i).getRoomClass());
                                    cr.roomArray.get(i).getArrayBooking().add(booking);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }else{
                    for(int z=0;z<ul.arrayCustomers.size();z++) {
                        if(ul.arrayCustomers.get(z).toString().equals(userList.getSelectedItem().toString())){
                            booking = new Booking(ul.arrayCustomers.get(z), checkInDate1.getDate(), checkOutDate1.getDate());
                            GetRoomFare grf = booking;
                            grf.getRoomFare(cr.roomArray.get(i).getRoomClass());
                            cr.roomArray.get(i).getArrayBooking().add(booking);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        cr.bl.updateTable();
        ul.updateTable();
        updateUserList();
    }//GEN-LAST:event_save1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JTextField address;
    private com.toedter.calendar.JDateChooser checkInDate;
    private com.toedter.calendar.JDateChooser checkInDate1;
    private com.toedter.calendar.JDateChooser checkOutDate;
    private com.toedter.calendar.JDateChooser checkOutDate1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField noTlp;
    private javax.swing.JComboBox<String> roomList;
    private javax.swing.JComboBox<String> roomList1;
    private javax.swing.JButton save1;
    private javax.swing.JTable tableRoom;
    private javax.swing.JComboBox<String> userList;
    // End of variables declaration//GEN-END:variables
}
