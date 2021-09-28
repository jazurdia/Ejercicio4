import java.util.ArrayList;

public class Hero extends Combatiente{

    int max_size = 3;
    protected ArrayList<Item> bag = new ArrayList<Item>();


    public Hero(String nombre) {
        super(nombre);
    }

    
    public void setSize(int num){// no máximo de elementos. 
        this.max_size = num;
    }

    public void addItem(Item e){
        if (bag.size()<max_size){
            bag.add(e);
        }else{
            // LLAMAR MÉTODO DE LA VISTA PARA DECIR QUE NO SE PUDO. SE PUEDE PONER TRY-CATCH. 
        }
        
    }

    public void useItem(Item e){
        bag.remove(e);
    }

    public ArrayList<String> insideBag(ArrayList<Item> list){
        ArrayList<String> nom_items = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++){
            nom_items.add(list.get(i).getName());
        }

        return nom_items;
    }

    
}
