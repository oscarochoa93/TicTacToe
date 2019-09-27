package Gato;
import java.awt.Color;
import java.util.Arrays;
import javafx.scene.image.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Brain {
    
    //public ImageIcon imagen=new ImageIcon(getClass().getResource("tablero.png").toExternalForm());
    //public ImageIcon imagen2=new ImageIcon(getClass().getResource("Azul.jpg").toExternalForm());
    JLabel[] fichas;
    
    public int[] tablero = new int[9];
    public boolean analizando = false;
    public final int soloHum = 1;
    public final int compuJuega = 2;
    public final int jug1 = 1;
    public final int jug2 = 2;
    public int turno = 0;
    public int turnoG = 0;
    public boolean jugar, acabo;
    
    //clases
    public PopUp menuIni;
    public minimax mini;
    public ClaseJugador j1, j2;  
    
    //fill
    public Brain() {
        Arrays.fill(tablero,0);
    }    
    //inicializar juego
    public JLabel[] empezar(JLabel fichas[]){
        //llenas el trablero con ceros para que quede "vacio"
        Arrays.fill(tablero,0);
        //borramos los iconos
        for ( int i = 0; i < 9; i ++ ){
            fichas[i].setText(null);
        }
        /*Reinciamos el turn.*/
        turno = 1;
        jugar = false;
        acabo = false;
        /*Borramos jugadores.*/
        j1 = null;
        j2 = null;
        return fichas;
    }
    //inserta el mejor mov de minimax y cambio de turno
    public JLabel[] escogerCuadro( int index,JLabel fichas[]){
        
        if( index == -1 );
        switch ( index ){
            //asigna fichas a compu junto con color
            case 0: fichas[0].setText(j2.get() );fichas[0].setForeground(Color.RED); break;
            case 1: fichas[1].setText(j2.get() );fichas[1].setForeground(Color.RED); break;
            case 2: fichas[2].setText(j2.get() );fichas[2].setForeground(Color.RED);break;
            case 3: fichas[3].setText(j2.get() );fichas[3].setForeground(Color.RED); break;
            case 4: fichas[4].setText(j2.get() );fichas[4].setForeground(Color.RED) ;break;
            case 5: fichas[5].setText(j2.get() );fichas[5].setForeground(Color.RED); break;
            case 6: fichas[6].setText(j2.get() );fichas[6].setForeground(Color.RED); break;
            case 7: fichas[7].setText(j2.get() );fichas[7].setForeground(Color.RED);break;
            case 8: fichas[8].setText(j2.get() );fichas[8].setForeground(Color.RED); break;        
        }
        this.tablero[index] = 2;
        
        
        turno = ( turno == jug1 ) ? jug2 : jug1;
      return fichas;
    }
    //nos ayuda a saber si el tablero esta lleno
    public boolean lleno( int lugarTablero ){
        return ( tablero[lugarTablero] != 0 );
    }
    //pone caracteristicas de fichas para ambos jugadores
    public void poner( JLabel ficha ){
      
       
       int lugarTablero = Integer.parseInt(""+ficha.getName().charAt(3)) - 1;
        if ( lleno(lugarTablero ) ){
            return;
        }
        if ( turno == jug1 ){
            //ficha.setIcon(imagen);
            ficha.setText(j1.get() );
            ficha.setForeground(Color.GREEN);
        }else{
            //ficha.setIcon(imagen2);
            ficha.setText(j2.get() );
            ficha.setForeground(Color.RED);
        }
        tablero[lugarTablero] = turno;
        
        
        turno =( turno == jug1 ) ? jug2 : jug1;
    }
    //revisa el gane por fila, columna o diagonal
    public int finish(){

        
        if ( tablero[0] == tablero[4] && tablero[0] == tablero[8] && tablero[0] !=0 )
            return tablero[0];
        else if ( tablero[2] == tablero[4] && tablero[2] == tablero[6] && tablero[2] != 0 )
            return tablero[2];
        else if( tablero[0] == tablero[3] && tablero[0] == tablero[6]  && tablero[0] != 0 )
            return tablero[0];
        else if ( tablero[1] == tablero[4] && tablero[1] == tablero[7]  && tablero[1] != 0)
            return tablero[1];
        else if ( tablero[2] == tablero[5] && tablero[2] == tablero[8]  && tablero[2] != 0 )
            return tablero[2];
        else if ( tablero[0] == tablero[1] && tablero[0] == tablero[2] && tablero[0] != 0 )
            return tablero[0];
        else if ( tablero[3] == tablero[4] && tablero[3] == tablero[5]  && tablero[3] != 0  )
            return tablero[3];
        else if ( tablero[6] == tablero[7] && tablero[6]== tablero[8]  && tablero[6] != 0 )
            return tablero[6];        

        
        return 0;
        
    }
    //retorna booleano para saber si el tablero esta lleno
    public boolean completo(){
        boolean bool = true;
        for ( int i = 0; i < tablero.length; i ++ ){
            if ( tablero[i] == 0 ){
                bool = false;
            }
        }
        return bool;
    }
    //crea todo lo necesrio para el juego, como tablero lleno de null
    public void iniciar(JLabel[] fichas){

                Arrays.fill(tablero,0);
        for ( int i = 0; i < 9; i ++ ){
            fichas[i].setText(null);
        }
        this.j1 = new ClaseJugador( "Jugador 1", "V"/*, imagen*/);
        this.j2 = new ClaseJugador( "Jugador 2", "X"/*, imagen2*/);
        mini = new minimax();
        this.turno = 1;
        this.turnoG = jug1;     
        jugar = true;
        acabo = false;
    }
    //restablece todo
    public void resetear(JLabel [] fichas){
        Arrays.fill(tablero,0);
        for ( int i = 0; i < 9; i ++ ){
            fichas[i].setText(null);
        }
        if ( this.menuIni.gameType == compuJuega ){
            turnoG = jug1;
        }else{
            turnoG = ( turnoG == jug1 ) ? jug2 : jug1;
        }
        turno = turnoG;
        jugar = true;
        acabo = false;
    }

}//----------fin de la clase
