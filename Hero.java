import java.util.ArrayList;

public class Hero extends Combatiente{

    ArrayList<Item> bag = new ArrayList<Item>();
    
    public Hero(String nombre, int vida, int pts_atack, String wd_i, String wd_f) {
        super(nombre, vida, pts_atack, wd_i, wd_f);
    }


    public void addItem(Item e){
        bag.add(e);
        // Mostrar un mensaje de confirmación?
    }

    public void useItem(Item e){
        bag.remove(e);
        // Mostrar un mensaje de confirmación?
    }

    
}
