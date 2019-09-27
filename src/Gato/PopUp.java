package Gato;

import javax.swing.JOptionPane;

public class PopUp extends javax.swing.JDialog {
    

 
    private final Inicio cosa;
    private final JOptionPane msg;
 
    public int gameType = 0;
    public String difficulty;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    
    public PopUp(Inicio view) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cosa=view;
        msg = new JOptionPane();
        this.setVisible(true);
    }
    
    public boolean opciones(){

        if( this.op1.getSelectedItem().toString().equals("Humano")&& this.op2.getSelectedItem().toString().equals("Humano") ){
            gameType=1;
            //mensaje.showMessageDialog(this,"Llene el nombre del jugador 1 por favor.","[X] Error:",JOptionPane.ERROR_MESSAGE);
            return false;   
        }
        else if( this.op1.getSelectedItem().toString().equals("Compu")&& this.op2.getSelectedItem().toString().equals("Compu") ){
            JOptionPane.showMessageDialog(this,"Compu CONTRA Compu NO SE PUEDE");
        }
        else if( (this.op1.getSelectedItem().toString().equals("Compu") || this.op2.getSelectedItem().toString().equals("Compu") ) && this.opDif.getSelectedItem().toString().equals("-") ){
            JOptionPane.showMessageDialog(this,"Por favor, inicia un nuevo juego y selecciona una dificultad");
        }
        else{
            gameType=2;
        }
        System.out.println("seleccionado "+ opDif.getSelectedItem().toString());
        
        this.difficulty=opDif.getSelectedItem().toString();
  
        return true;
    }
    
    public void send(){
        cosa.componentes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn = new javax.swing.JButton();
        op2 = new javax.swing.JComboBox<>();
        op1 = new javax.swing.JComboBox<>();
        opDif = new javax.swing.JComboBox<>();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        dif = new javax.swing.JLabel();
        txt1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(490, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn.setText("Iniciar Juego");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 417, 55));

        op2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Humano", "Compu" }));
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2ActionPerformed(evt);
            }
        });
        getContentPane().add(op2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, -1));

        op1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Humano", "Compu" }));
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1ActionPerformed(evt);
            }
        });
        getContentPane().add(op1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 131, 90, -1));

        opDif.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Facil", "Echale Ganas", "Imposible" }));
        opDif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opDifActionPerformed(evt);
            }
        });
        getContentPane().add(opDif, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 90, -1));

        j1.setText("Jugador1");
        getContentPane().add(j1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        j2.setText("Jugador 2");
        getContentPane().add(j2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        dif.setText("Dificultad");
        getContentPane().add(dif, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 60, -1));

        txt1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        txt1.setText("Escoje tu modalidad y dificultad");
        getContentPane().add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 41, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gato/am.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, -10, 610, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        if( opciones() ){
            send();
            dispose();
        }
         
         this.dispose();
    }//GEN-LAST:event_btnActionPerformed

    private void op1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op1ActionPerformed

    }//GEN-LAST:event_op1ActionPerformed

    private void op2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op2ActionPerformed

    }//GEN-LAST:event_op2ActionPerformed

    private void opDifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opDifActionPerformed

    }//GEN-LAST:event_opDifActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel dif;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JComboBox<String> op1;
    private javax.swing.JComboBox<String> op2;
    private javax.swing.JComboBox<String> opDif;
    private javax.swing.JLabel txt1;
    // End of variables declaration//GEN-END:variables

    

    
    

}
