public class Item {
    
    int effect;
    String name;
    
    public Item(String name, int effect){// Builder
        this.name = name;
        this.effect = effect;
    }
    
    public String getName(){
        return name;
    }

    public int effect(){
        return effect;
    }
}
