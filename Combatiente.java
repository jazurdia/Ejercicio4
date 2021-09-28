/**
 * @author: Alejandro Azurdia
 */

public class Combatiente{
    
    protected String nombre = null;
    protected int vida = 10;
    protected int pts_attack = 2;
    protected String wd_i = "Aquí vamos!";
    protected String wd_f = "He... terminado";

    /**
     * 
     * @param nombre name of the character
     * @param vida life points of the character
     * @param pts_atack attack poins of the character
     * @param wd_i a message that will be shown at the beggining of the game by this user. 
     * @param wd_f a message that will be shown at the end of the character's life or at the end of the match. 
     */
    
    public Combatiente (String nombre){
        this.nombre=nombre;
        
    }

    public void getsDamage(int num){
       this.vida = vida - num;

    }

    public void getsHealed(int num){
        this.vida = vida + num;
    }

    public void setVida(int num){
        this.vida = num;
    }

    public int getVida(){
        return vida;
    }

    public void setPtsAttack(int num){
        this.pts_attack = num;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPtsAttack(){
        return pts_attack;
    }
    
}