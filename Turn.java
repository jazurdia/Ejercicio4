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

}
