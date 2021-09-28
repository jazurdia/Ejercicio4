import java.util.*;
public class Turn {
    int turn = 0;
    int no_players;

    public Turn(int no_players){
        this.no_players = no_players;
    }
    
    public int nextTurn(){
        if(turn < no_players){
            this.turn++;
        }else{
            this.turn = 0;
        }
        return turn;
    }

    public int getTurn(){
        return turn;
    }

    public String turnoDe(ArrayList<Hero> lista){

        String hero;
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getBando() == false){
                hero=lista.get(i).getNombre();
            }else{}
        }

        return hero;
    }

}
