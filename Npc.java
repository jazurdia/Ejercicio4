import java.util.*;

public class Npc extends Combatiente{

    public Npc(String nombre) {
        super(nombre);
    }

    public int specialAttack(){
        Random rand = new Random();
        int bonus = pts_attack * (rand.nextInt(2)+1);
        return bonus;
    }


    
    
}
