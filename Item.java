public class Item {
    
    int effect;
    
    public Item(int effect){// Builder
        this.effect = effect;
    }

    public int getEffect(){
        return effect;
    }
}
