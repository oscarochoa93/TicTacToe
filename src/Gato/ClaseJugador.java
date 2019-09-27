package Gato;

/**
 *
 * @author pride
 */
public class ClaseJugador {
    public String nombreJug;
    private String tipoFicha;
    //public Icon imagen;
/*
    public Player(Icon imagen) {
        this.imagen = imagen;
    }
*/
    
    
    public ClaseJugador(String nombre, String g/*, Icon imagen*/ ) {
        this.nombreJug = nombre;
        this.tipoFicha = g;
        //this.imagen = imagen;
    }

    public ClaseJugador(String nombre) {
        this.nombreJug = nombre;
    }

    public String get(){
        return tipoFicha;
    }
}
