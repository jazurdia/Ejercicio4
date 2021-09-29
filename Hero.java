import java.util.ArrayList;

public class Hero extends Combatiente{

    private int bagSize = 2;
    private boolean escudo = false; //
    private ArrayList<Item> bag = new ArrayList<Item>();


    public Hero(String nombre) {
        super(nombre);
    }
    
    public void setBagSize(int num){// no máximo de elementos. 
        this.bagSize = num;
    }

    public int getBagSize(){
        return bagSize;
    }

    public void addItem(Item e){
        bag.add(e);
    }

    public void useItem(Item e){
        bag.remove(e);
    }
    

    /* Esta mierda que hace?
    public ArrayList<String> insideBag(ArrayList<Item> list){
        ArrayList<String> nom_items = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++){
            nom_items.add(list.get(i).getName());
        }

        return nom_items;
    }
    */

    public void setEscudo(boolean escudo){ // No sé si la voy a usar jaja, pero bueno x. La vida sigue. 
        this.escudo = escudo;
    }
    
    public void usingEscudo(){ // true es que está arriba. 
        if(escudo == true){
            this.escudo = false;
        }
    }
    
    public boolean getEscudo(){
        return escudo;
    }

    public ArrayList<Item> getBag(){
        return bag;
    }

}
