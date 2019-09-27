package Gato;

/*
 * @author: 3 mentes brillantes: Mario, Oscar, Victor
 */

public class minimax {
      
    public static int tiradas = 0;
    Nodito arbol = new Nodito();
    int[] board;
    
    public int movDisponibles( int[] board ){
        int mov = 0;
        for ( int i = 0; i < 9; i ++ ){
            if ( board[i] == 0 ){
                mov++;
            }
        }
        return mov;
    }
    
    public int[] posVacias( int[] board ){
        int[] indices = new int[movDisponibles(board)];
        int indice = 0;
        
        for ( int i = 0; i < 9; i ++ ){
            if ( board[i] == 0 ){
                indices[indice] = i;
                indice++;
            }
        }
        return indices;
    }
    
    public int movimiento( int[] board ){
        this.board = board;
        tiradas ++;
        
        for ( int i = 0; i < 9; i ++ ){
            this.arbol.tablero[i] = this.board[i];
        }
        movCPU( arbol );
        
        
        return arbol.movOptimo;
    }

    public void movCPU( Nodito root ){
        int moves = movDisponibles(root.tablero);
        int indices[] = posVacias(root.tablero);
        root.nodito = new Nodito[moves];
        
        int winner = finish(root.tablero);
        if ( winner == 1 ) winner = -1;
        else if ( winner == 2 ) winner = 1;
  
        if ( winner!= 0 || moves == 0){
            root.gane = winner;
        }else{
            for( int i = 0; i < moves; i ++ ){
                root.nodito[i] = new Nodito();
                for ( int j = 0; j < 9; j ++ ){
                    root.nodito[i].tablero[j] = root.tablero[j];
                    if ( root.turno ){
                        root.nodito[i].tablero[indices[i]] = 1;
                    }else{
                        root.nodito[i].tablero[indices[i]] = 2;
                    }
                }
                root.nodito[i].turno = !root.turno;
                root.nodito[i].index = indices[i];
                movCPU(root.nodito[i]); 
            }
            //A PARTIR DE AQUI DEFINE EL MINI MAX. SI LE VA A ASIGNAR 1 O -1
            if (!root.turno){
                root.gane = Max(root);
            }else{
                root.gane = Min(root);
            }
       }    

    }
   
    public int Max( Nodito root ){
        int Max = -111;
        for (int i = 0; i < root.nodito.length; i++){
            if (root.nodito[i].gane > Max){
                Max = root.nodito[i].gane;
                root.movOptimo = root.nodito[i].index;
                if (Max == 1) break;
            }
         }
        root.nodito = null;
        
        return Max;
    }
    
    public int Min( Nodito root ){
        int Min = 111;
        for (int i = 0; i < root.nodito.length; i++)
          if (root.nodito[i].gane < Min ){
            Min = root.nodito[i].gane;
            root.movOptimo = root.nodito[i].index;
            if (Min == -1) break;
          }
        root.nodito = null;
        
        return Min;
    }
                
    public int finish( int[] board ){
        //---Filas
        if ( board[0] == board[1] && board[0] == board[2] && board[0] != 0 )
            return board[0];
        else if ( board[3] == board[4] && board[3] == board[5]  && board[3] != 0  )
            return board[3];
        else if ( board[6] == board[7] && board[6]== board[8]  && board[6] != 0 )
            return board[6];
        //---Columnas
        else if( board[0] == board[3] && board[0] == board[6]  && board[0] != 0 )
            return board[0];
        else if ( board[1] == board[4] && board[1] == board[7]  && board[1] != 0  )
            return board[1];
        else if ( board[2] == board[5] && board[2] == board[8]  && board[2] != 0 )
            return board[2];
        //---Diagonales
        else if ( board[0] == board[4] && board[0] == board[8] && board[0] !=0 )
            return board[0];
        else if ( board[2] == board[4] && board[2] == board[6] && board[2] != 0 )
            return board[2];
        
        return 0;
    }
}
