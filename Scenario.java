import java.util.*;

public class Scenario {

    Vista vista = new Vista();

    // Instancia de los actores. 
    Turn turn;
    
    Hero warrior;
    Hero explorador;

    Npc orco;
    Npc enano;
    Npc esqueleto;
    Boss boss;

    ArrayList<Hero> turnos_hero = new ArrayList<Hero>();
    ArrayList<Npc> turnos_npc = new ArrayList<Npc>();

     
    public void match(){//Inicialización de la partida. Dentro de este método pasará todo lo chido. 

        int choosen_hero = 0;
        int no_heroes = vista.settingHeroes();
        boolean stop = false;
        while(stop == false){
            if(no_heroes == 1){
                choosen_hero = vista.choosingHero();
                stop = true;
            }else if(no_heroes ==2){
                choosen_hero = 0;
                stop = true;
            }else{
                vista.tryAgain();
            }
        }

        setActors(no_heroes, choosen_hero);// Llamar a la vista. 
        turn = new Turn(turnos_hero.size() + turnos_npc.size());
        
    }

    /**
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */


    


    //Métodos de inicialización Masiva
    public void setActors (int num_heroes, int hero1){
        
        if(num_heroes == 1){// Solo un jugador
            
            if(hero1 == 1){// warrior
                instanceOfWarrior();
            }else if(hero1 == 2){// explorador
                instanceOfExplorador();
            }
       
        }else if(num_heroes == 2){// dos jugadores
            instanceOfWarrior();
            instanceOfExplorador();
        }
    
        //Inicialización de las tres posibles combinaciones de formacion enemiga.
        Random rand = new Random();
        int random_num = rand.nextInt(2)+1;
        
        instanceOfBoss();
        if(random_num == 1){
            instanceOfOrco();
            instanceOfEnano();
        
        }else if(random_num == 2){
            instanceOfEnano();
            instanceOfEsqueleto();
        
        }else if(random_num == 3){
            instanceOfEsqueleto();
            instanceOfOrco();
        }
    }
    
    //Métodos individuales para inicializar las instancias de actores. 
    public void instanceOfOrco(){
        this.orco = new Npc("Marcus");
        orco.setVida(15);
        orco.setAttack(3);
        turnos_npc.add(orco);
    }

    public void instanceOfEnano(){
        this.enano = new Npc("Eduardo");
        enano.setVida(5);
        enano.setAttack(1);
        turnos_npc.add(enano);
    }

    public void instanceOfEsqueleto(){
        this.esqueleto = new Npc("Julia");
        esqueleto.setVida(3);
        esqueleto.setAttack(3);
        turnos_npc.add(esqueleto);
    }

    public void instanceOfWarrior(){
        this.warrior = new Hero("Marcus");
        warrior.setAttack(5);
        warrior.setVida(20);
        turnos_hero.add(warrior);
    }

    public void instanceOfExplorador(){
        this.explorador = new Hero("Sophie");
        explorador.setSize(6);
        turnos_hero.add(explorador);
    }

    public void instanceOfBoss(){
        this.boss = new Boss("Rey_Orco");
        // no hay lista porque va solin solito. 
    }

    //Métodos de accion (métodos de batalla)
    public void attack(int index, int pts_attack, int a){
        if(a == 1){
            turnos_hero.get(index).getsDamage(pts_attack);
        }else if(a==2){
            turnos_npc.get(index).getsDamage(pts_attack);
        }
    }


}
