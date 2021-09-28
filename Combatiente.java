/**
 * @author: Alejandro Azurdia
 */

public class Combatiente{
    
    protected String nombre = null;
    protected int vida = (Integer) null;
    protected int pts_atack = (Integer) null;
    protected String wd_i = null;
    protected String wd_f = null;

   public Combatiente (String nombre, int vida, int pts_atack, String wd_i, String wd_f){

        this.nombre=nombre;
        this.vida = vida;
        this.pts_atack = pts_atack;
        this.wd_i = wd_i;
        this.wd_f = wd_f;

   }
    
}