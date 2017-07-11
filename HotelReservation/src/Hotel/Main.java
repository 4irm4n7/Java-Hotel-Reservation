package Hotel;

import Classes.Booking;
import Classes.Customer;
import Classes.Room;
import Classes.RoomFare;
import GUI.*;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Main extends javax.swing.JFrame {
    Object[] obj = new Object[6];
    UserList userList;
    CreateRoom createRoom;
    PaymentGui paymenGui;
    RoomList roomList;
    BookingGui booking;
    BookingList bookingList;
    
    public Main() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        ImageIcon bookingIcon = new ImageIcon(getClass().getResource("/Gambar/booking.png"));
        ImageIcon userIcon = new ImageIcon(getClass().getResource("/Gambar/user.png"));
        ImageIcon roomIcon = new ImageIcon(getClass().getResource("/Gambar/room.png"));
        ImageIcon paymentIcon = new ImageIcon(getClass().getResource("/Gambar/payment.png"));
        
        userList = new UserList();
        createRoom = new CreateRoom();
        paymenGui = new PaymentGui(createRoom);
        roomList = new RoomList(createRoom, paymenGui);
        createRoom.setRl(roomList);
        booking = new BookingGui(createRoom, userList);
        createRoom.setBooking(booking);
        bookingList = new BookingList(createRoom, paymenGui);
        createRoom.setBl(bookingList);
        createRoom.updateTable();
        userList.setBg(booking);
        
        JScrollPane jspBookingList = new JScrollPane(bookingList);
        JScrollPane jspBooking = new JScrollPane(booking);
        JScrollPane jspUserList = new JScrollPane(userList);
        JScrollPane jspCreateRoom = new JScrollPane(createRoom);
        JScrollPane jspRoomList = new JScrollPane(roomList);
        JScrollPane jspPaymenGui = new JScrollPane(paymenGui);
        
        
        jTabbedPane.addTab("Booking List ", bookingIcon, jspBookingList);
        jTabbedPane.addTab("Booking ", bookingIcon, jspBooking);
        jTabbedPane.addTab("User List ", userIcon, jspUserList);
        jTabbedPane.addTab("Create Room ", roomIcon, jspCreateRoom);
        jTabbedPane.addTab("Room List ", roomIcon, jspRoomList);
        jTabbedPane.addTab("Payment ", paymentIcon, jspPaymenGui);
        
        setLayout(new GridLayout(1, 1));
    }
    public final void save() throws IOException{
        try{
            obj[0] = createRoom.getRoomArray();
            obj[1] = createRoom.getRoomType();
            obj[2] = userList.arrayCustomers;
            obj[3] = Room.getCount();
            obj[4] = Customer.getCount();
            obj[5] = Booking.getCount();
            
            FileOutputStream fileOut = new FileOutputStream("/opt/HotelReservation/tmp.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            
            JOptionPane.showMessageDialog(this, "Saving is success","Mesage", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException i){
            JOptionPane.showMessageDialog(this, "Saving is failed","Mesage", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void load(){
        try{
            FileInputStream fileIn = new FileInputStream("/opt/HotelReservation/tmp.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            this.obj = (Object[]) in.readObject();
            createRoom.setRoomArray((ArrayList<Room>) obj[0]);
            createRoom.setRoomType((ArrayList<RoomFare>) obj[1]);
            userList.arrayCustomers = (ArrayList<Customer>) obj[2];
            Room.setCount((AtomicInteger) obj[3]);
            Customer.setCount((AtomicInteger) obj[4]);
            Booking.setCount((AtomicInteger) obj[5]);
            
            in.close();
            fileIn.close();
            
            userList.updateTable();
            createRoom.updateTable();
            paymenGui.updateTable();
            roomList.updateTable();
            booking.updateTable();
            booking.updateUserList();
            bookingList.updateTable();
            
            JOptionPane.showMessageDialog(this, "Load is success","Mesage", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException i){
            JOptionPane.showMessageDialog(this, "Load is failed, I/O is error","Mesage", JOptionPane.INFORMATION_MESSAGE);
        }catch(ClassNotFoundException c){
            JOptionPane.showMessageDialog(this, "Load is failed, Class not found","Mesage", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        saveData = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        loadData = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Reservation");
        setLocation(new java.awt.Point(0, 0));

        jTabbedPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane.setAutoscrolls(true);
        jTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        file.setText("File");

        saveData.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveData.setText("Save");
        saveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataActionPerformed(evt);
            }
        });
        file.add(saveData);

        jMenuBar1.add(file);

        edit.setText("Edit");

        loadData.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        loadData.setText("Load");
        loadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataActionPerformed(evt);
            }
        });
        edit.add(loadData);

        jMenuBar1.add(edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataActionPerformed
        try {
            save();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveDataActionPerformed

    private void loadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataActionPerformed
        load();
    }//GEN-LAST:event_loadDataActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu edit;
    private javax.swing.JMenu file;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JMenuItem loadData;
    private javax.swing.JMenuItem saveData;
    // End of variables declaration//GEN-END:variables
}
