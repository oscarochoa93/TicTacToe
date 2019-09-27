package Gato;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public final class Inicio extends javax.swing.JFrame {
   
    
    JLabel[] fichas;
    Brain cerebro;
    boolean flag=false;
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Inicio dialog = new Inicio();
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
        
    public Inicio() {
        initComponents();
        init();
        cerebro = new Brain();
        
    }
    
        public void init(){
        //---Referenciamos todas las etiquetas.
        fichas = new JLabel[9];
        fichas[0] = btn1; fichas[1] =btn2; fichas[2] = btn3;
        fichas[3] = btn4; fichas[4] = btn5; fichas[5] =btn6;
        fichas[6] = btn7; fichas[7] = btn8; fichas[8] = btn9;
        for (JLabel ficha : fichas) {
            ficha.setFont(new Font("Calibri", Font.PLAIN, 70));
        }
    }
    
    public void componentes(){
         cerebro.iniciar(this.fichas);
    }
    
    public void humanoJugando(JLabel ficha){
     ArrayList<Integer> list=new ArrayList();

     
        if (cerebro.jugar) {
   
            if (!flag) {
                cerebro.poner(ficha);
                flag=true;
                txtOut.setText("Es turno de: "+cerebro.j2.nombreJug);
                
            }else{
                cerebro.poner(ficha);
                flag=false;
                txtOut.setText("Es turno de: "+cerebro.j1.nombreJug);
            }
        }
        
        if (cerebro.acabo) {
            cerebro.resetear(fichas);
            txtOut.setText("");
        }
     

        if(cerebro.finish () !=0) {
            if (cerebro.finish()==1) {
                txtOut.setText(cerebro.j1.nombreJug +" ha ganado!");
                
            }else{
                txtOut.setText(cerebro.j2.nombreJug +" ha ganado!");
                
            }
        cerebro.jugar=false;
        cerebro.acabo=true;
        }
    
    
    
    }
    
    public void computadora( JLabel ficha){
        ArrayList<Integer> list=new ArrayList();
        Random cambio = new Random();
        int d = 0;
        switch (cerebro.menuIni.difficulty) {
            case "-":
                if (rootPaneCheckingEnabled) {
                    
                }
                break;
            case "Facil":
                if ( cerebro.jugar ){
                    if( ! cerebro.analizando ){
                         cerebro.poner( ficha );
                    }
                    if (  cerebro.menuIni.gameType ==  cerebro.compuJuega &&  cerebro.turno ==  cerebro.jug2 ){
                        for (int i = 0; i < fichas.length; i++) { 
                            if (fichas[i].getText() == null) {
                                     list.add(i);
                                }
                        } 
                        if (list.isEmpty()) {
                            this.txtOut.setText("Empate");
                            cerebro.jugar = false;
                            cerebro.acabo = true;
                            break;
                        }else{
                        d = list.get(cambio.nextInt(list.size()));
                         cerebro.analizando = true;
                         fichas = cerebro.escogerCuadro(d,fichas);
                         cerebro.analizando = false;
                     }
                    }
                }
                if(  cerebro.acabo ){
                     cerebro.resetear(fichas);
                     this.txtOut.setText("");
                    return;
                }
                if (  cerebro.finish() != 0){
                    if (  cerebro.finish() == 1 ){
                        this.txtOut.setText(cerebro.j1.nombreJug + " ha ganado!");
                    }else{
                       this.txtOut.setText(cerebro.j2.nombreJug + " ha ganado!");
                    }
                     cerebro.jugar = false;
                     cerebro.acabo = true;
                }
                break;
            case "Echale Ganas":
                if ( cerebro.jugar ){
                    if( ! cerebro.analizando ){
                         cerebro.poner( ficha );
                    }
                    if (  cerebro.menuIni.gameType ==  cerebro.compuJuega &&  cerebro.turno ==  cerebro.jug2 ){
                        for (int i = 0; i < fichas.length; i++) { 
                            if (fichas[i].getText() == null) {
                                     list.add(i);
                                }
                        } 
                        if (list.isEmpty()) {
                            this.txtOut.setText("Empate");
                            cerebro.jugar = false;
                            cerebro.acabo = true;
                            break;
                        }else{
                        d = list.get(cambio.nextInt(list.size()));
                         cerebro.analizando = true;
                         //---Una vez tira random y la otra con el arbol IA 
                         //---(Combinacion de ambas para nivel Medio)
                            if (!flag) {
                                fichas = cerebro.escogerCuadro(d,fichas);
                                flag=true;
                            }else{
                                fichas = cerebro.escogerCuadro(cerebro.mini.movimiento(cerebro.tablero ),fichas);
                                flag=false;
                            }
                         cerebro.analizando = false;
                     }
                    }
                }
                if(  cerebro.acabo ){
                     cerebro.resetear(fichas);
                     this.txtOut.setText("");
                    return;
                }
                if (  cerebro.finish() != 0){
                    /*Asignamos resultados.*/
                    if (  cerebro.finish() == 1 ){
                        this.txtOut.setText(cerebro.j1.nombreJug + " ha ganado!");
                    }else{
                       this.txtOut.setText(cerebro.j2.nombreJug + " ha ganado!");
                    }
                     cerebro.jugar = false;
                     cerebro.acabo = true;
                }
                break;
            case "Imposible":
                if ( cerebro.jugar ){
                    if( ! cerebro.analizando ){
                         cerebro.poner( ficha );
                    }
                    if (  cerebro.menuIni.gameType ==  cerebro.compuJuega &&  cerebro.turno ==  cerebro.jug2 ){
                         cerebro.analizando = true;
                         fichas = cerebro.escogerCuadro(cerebro.mini.movimiento(cerebro.tablero ),fichas);
                         cerebro.analizando = false;
                    }
                }
                if(  cerebro.acabo ){
                     cerebro.resetear(fichas);
                     this.txtOut.setText("");
                    return;
                }
                if (  cerebro.finish() != 0){

                    /*Asignamos resultados.*/
                    if (  cerebro.finish() == 1 ){
                        this.txtOut.setText(cerebro.j1.nombreJug + " ha ganado!");
                    }else{
                       this.txtOut.setText(cerebro.j2.nombreJug + " ha ganado!");
                    }
                     cerebro.jugar = false;
                     cerebro.acabo = true;

                } else if (  cerebro.completo() ){
                     this.txtOut.setText("Empate");
                     cerebro.jugar = false;
                     cerebro.acabo = true;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "error");
        }
    }


  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        txtOut = new javax.swing.JLabel();
        btn1 = new javax.swing.JLabel();
        btn2 = new javax.swing.JLabel();
        btn3 = new javax.swing.JLabel();
        btn4 = new javax.swing.JLabel();
        btn5 = new javax.swing.JLabel();
        btn6 = new javax.swing.JLabel();
        btn7 = new javax.swing.JLabel();
        btn8 = new javax.swing.JLabel();
        btn9 = new javax.swing.JLabel();
        tablero = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 51, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnExit.setText("Salir del juego");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        getContentPane().add(btnExit);
        btnExit.setBounds(1030, 850, 220, 50);

        btnMenu.setText("Comenzar");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu);
        btnMenu.setBounds(1010, 180, 220, 50);

        txtOut.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txtOut.setForeground(new java.awt.Color(51, 51, 255));
        txtOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtOut);
        txtOut.setBounds(1010, 80, 300, 90);

        btn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn1.setName("btn1"); // NOI18N
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        getContentPane().add(btn1);
        btn1.setBounds(910, 340, 110, 90);

        btn2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn2.setName("btn2"); // NOI18N
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        getContentPane().add(btn2);
        btn2.setBounds(1080, 340, 90, 90);

        btn3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn3.setName("btn3"); // NOI18N
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        getContentPane().add(btn3);
        btn3.setBounds(1230, 340, 90, 90);

        btn4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn4.setName("btn4"); // NOI18N
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        getContentPane().add(btn4);
        btn4.setBounds(920, 490, 90, 90);

        btn5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn5.setName("btn5"); // NOI18N
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        getContentPane().add(btn5);
        btn5.setBounds(1080, 490, 90, 90);

        btn6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn6.setName("btn6"); // NOI18N
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });
        getContentPane().add(btn6);
        btn6.setBounds(1230, 490, 90, 90);

        btn7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn7.setName("btn7"); // NOI18N
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });
        getContentPane().add(btn7);
        btn7.setBounds(930, 640, 90, 90);

        btn8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn8.setName("btn8"); // NOI18N
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        getContentPane().add(btn8);
        btn8.setBounds(1080, 640, 90, 90);

        btn9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn9.setName("btn9"); // NOI18N
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });
        getContentPane().add(btn9);
        btn9.setBounds(1230, 640, 90, 90);

        tablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gato/tableroamarillo.png"))); // NOI18N
        getContentPane().add(tablero);
        tablero.setBounds(900, 260, 790, 550);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gato/Start.jpg"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, -50, 1450, 1100);

        getAccessibleContext().setAccessibleName("Victor");

        setSize(new java.awt.Dimension(1441, 1040));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn9);
        }else{
            computadora(btn9);
        }   
    }//GEN-LAST:event_btn9MouseClicked

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn8);
        }else{
            computadora(btn8);
        }   
         
    }//GEN-LAST:event_btn8MouseClicked

    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn7);
        }else{
            computadora(btn7);
        }   
        
    }//GEN-LAST:event_btn7MouseClicked

    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn6);
        }else{
            computadora(btn6);
        }   
        
    }//GEN-LAST:event_btn6MouseClicked

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn5);
        }else{
            computadora(btn5);
        }   
        
    }//GEN-LAST:event_btn5MouseClicked

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn4);
        }else{
            computadora(btn4);
        }   
    }//GEN-LAST:event_btn4MouseClicked

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn3);
        }else{
            computadora(btn3);
        }   
        
    }//GEN-LAST:event_btn3MouseClicked

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn2);
        }else{
            computadora(btn2);
        }   
        
    }//GEN-LAST:event_btn2MouseClicked

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        if (cerebro.menuIni.gameType==1) {
            humanoJugando(btn1);
        }else{
            computadora(btn1);
        }   
        
    }//GEN-LAST:event_btn1MouseClicked

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        cerebro.menuIni = new PopUp(this);
        cerebro.iniciar(this.fichas);
    }//GEN-LAST:event_btnMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn1;
    private javax.swing.JLabel btn2;
    private javax.swing.JLabel btn3;
    private javax.swing.JLabel btn4;
    private javax.swing.JLabel btn5;
    private javax.swing.JLabel btn6;
    private javax.swing.JLabel btn7;
    private javax.swing.JLabel btn8;
    private javax.swing.JLabel btn9;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel tablero;
    private javax.swing.JLabel txtOut;
    // End of variables declaration//GEN-END:variables
        
    
    

     
     
   
    







}
