import java.util.*;
public class Scenario {

    Vista vista = new Vista();

    // Instancia de los actores.     
    Hero warrior;
    Hero explorador;
    Npc orco;
    Npc enano;
    Npc esqueleto;
    Boss boss;

    // Instanciamiento de Items para el uso de la clase Heroe. 
    Item item1 = new Item(2);
    Item item2 = new Item(3);
    Item item3 = new Item(6);
    Item item4 = new Item(15);
    Item item5 = new Item(10);
    Item item6 = new Item(8);

    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Hero> turnos_hero = new ArrayList<Hero>(); // Lista de Héroes (Jugadores)
    ArrayList<Npc> turnos_npc = new ArrayList<Npc>(); // Lista de Enemigos (NPC)
    {
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);   
    }
    
    //Escenario donde se llevará a cabo la pelea. 
    public void match(){
        setActors(2, 0);//MÉTODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        boolean stopMatch = false;
        boolean stopPhase1 = false;
        while(stopPhase1 == false){
            
            // Solo pelearan con el enemigo NPC
            while (stopMatch == false){
                for(int i = 0; i<turnos_hero.size(); i++){
                // MOSTRAR MENÚ
                int opcionA = vista.menu(turnos_hero.get(i).getNombre());
                switch(opcionA){// CICLO PARA LOS HÉROES
                    case 1:// Ataque de Hero a Enemy
                        menu1(turnos_npc, turnos_hero, i);
                        break;
                    
                    case 2: // Levantar un escudo.
                        menu2(turnos_hero, i);
                        break;

                    case 3: // pass.
                        menu3(turnos_hero, i);
                        break;

                    case 4: // tirar items
                        menu4(turnos_npc, turnos_hero, i);
                    }
                }

                for(int n = 0; n<turnos_npc.size(); n++){ //CICLO PARA NPCccccccccccccccc
                    Random rand = new Random();
                    int opcionB = rand.nextInt(2)+1;
                    switch (opcionB) {
                        case 1://Enemy Attacking
                            menu1b(turnos_npc, turnos_hero, n);
                            break;
                    
                        case 2:// Habilidad especial. No se puede bloquar
                            menu2b(turnos_npc, turnos_hero, n);
                            break;
                    }
                    //boss
                }
                
                stillAlive();
                if (stageOneIsDone() == true){
                    stopMatch = true;
                }
                if (stageTwoIsDone() == true){
                    stopMatch = true;
                }
                
            }

            stopPhase1 = true;
            }
            
        
    }

    public void menu1(ArrayList<Npc> listaN, ArrayList<Hero> listaH, int index_of_attacker){//The enemy is getting attacked.  
        vista.show_name_listB(listaN);
        int index_of_victim = vista.whoGetsDamaged();
        attack(index_of_victim, listaH.get(index_of_attacker).getPtsAttack(), 2);
        vista.statsOfDamaged(listaN.get(index_of_victim).getNombre(), listaH.get(index_of_attacker).getPtsAttack(), listaN.get(index_of_victim).getVida());

    }

    public void menu1c(ArrayList<Hero> heroes, int index_of_attacker){
        System.out.println("Ahora contra el jefe!");


    }
    
    public void menu1b(ArrayList<Npc> listaN, ArrayList<Hero> listaH, int index_of_attacker){
        Random rand = new Random();
        int index_of_victim = rand.nextInt(1);// VERSION DEMO
        attack(index_of_victim, listaN.get(index_of_attacker).getPtsAttack(), 1);
        vista.statsOfDamaged(listaH.get(index_of_victim).getNombre(), listaN.get(index_of_attacker).getPtsAttack(), listaH.get(index_of_victim).getVida());
    }

    public void menu2b (ArrayList<Npc> listaN, ArrayList<Hero> listaH, int index_of_attacker){
        Random rand = new Random();
        int index_of_victim = rand.nextInt(1);
        specialAttack(index_of_victim, listaN.get(index_of_attacker).specialAttack());
        vista.statsOfDamaged(listaH.get(index_of_victim).getNombre(), listaN.get(index_of_attacker).getPtsAttack(), listaH.get(index_of_victim).getVida());

    }
    
    public void menu2(ArrayList<Hero> listaH, int indexOfHero){
        // Solo los héroes pueden bloquear ataques. 
        listaH.get(indexOfHero).setEscudo(true); // escudo arriba. 
        vista.estadoDelEscudo(listaH.get(indexOfHero).getNombre());
    }

    public void menu3(ArrayList<Hero> listah, int indexOfHero){
        vista.pass(listah.get(indexOfHero).getNombre());

    }

    public int howManyTimesG(ArrayList<Hero> list){
        int howManyTimes = list.size();
        return howManyTimes;
    }

    public int howManyTimesB(ArrayList<Npc> list){
        int howManyTimes = list.size();
        return howManyTimes;
    }

    public void menu4(ArrayList<Npc> listaN, ArrayList<Hero> listaH, int index_of_attacker){
        vista.show_name_listB(listaN);
        int index_of_victim = vista.whoGetsDamaged();
        attack(index_of_victim, listaH.get(index_of_attacker).getBag().get(0).getEffect(), 2);
        vista.statsOfDamaged(listaN.get(index_of_victim).getNombre(), listaH.get(index_of_attacker).getPtsAttack(), listaN.get(index_of_victim).getVida());
    }
     
    public void menuBoss(Boss boss, ArrayList<Hero> hero){
        Random rand = new Random();
        int opcion = rand.nextInt(1)+1;
        switch (opcion) {
            case 1:// ataca
                int index = rand.nextInt(1);
                attack(index, boss.getPtsAttack(), 1);
                vista.statsOfDamaged(hero.get(index).getNombre(), boss.getPtsAttack(), hero.get(index).getVida());
                break;
        
            case 2: 
                int index2 = rand.nextInt(1);
                specialAttack(rand.nextInt(), boss.specialAttack());
                vista.statsOfDamaged(hero.get(index2).getNombre(), boss.getPtsAttack(), hero.get(index2).getVida());
                break;
        }
    }

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
    
    public void fillBag(Hero hero){
        for (int i = 0; i<hero.getBagSize(); i++){
            Random rand = new Random();
            hero.addItem(items.get(rand.nextInt(6)));
        }
    }

    //Métodos individuales para inicializar las instancias de actores. 
    public void instanceOfOrco(){
        this.orco = new Npc("Marcus Orco");
        orco.setVida(15);
        orco.setPtsAttack(3);
        turnos_npc.add(orco);
    }

    public void instanceOfEnano(){
        this.enano = new Npc("Eduardo Enano");
        enano.setVida(5);
        enano.setPtsAttack(1);
        turnos_npc.add(enano);
    }

    public void instanceOfEsqueleto(){
        this.esqueleto = new Npc("Julia Esqueleto");
        esqueleto.setVida(3);
        esqueleto.setPtsAttack(3);
        turnos_npc.add(esqueleto);
    }

    public void instanceOfWarrior(){
        this.warrior = new Hero("Manuel Warrior");
        warrior.setPtsAttack(5);
        warrior.setVida(20);
        warrior.setBagSize(2);
        fillBag(warrior);
        turnos_hero.add(warrior);

    }

    public void instanceOfExplorador(){
        this.explorador = new Hero("Sophie Explorer");
        explorador.setBagSize(4);
        fillBag(warrior);
        turnos_hero.add(explorador);
    }

    public void instanceOfBoss(){
        this.boss = new Boss("Rey_Orco");
        // no hay lista porque va solin solito. 
    }    
    
    //Métodos de accion (métodos de batalla)
    public void attack(int index, int pts_attack, int a){
        if(a == 1){// daño a hero
            if(turnos_hero.get(index).getEscudo() == false){
                turnos_hero.get(index).getsDamage(pts_attack);

            }else{
                turnos_hero.get(index).usingEscudo();
                vista.usoEscudo(turnos_hero.get(index).getNombre());
            }
            
            
        }else if(a==2){// daño a enemy
            turnos_npc.get(index).getsDamage(pts_attack);
        }
    }

    public void specialAttack(int index, int pts_attack){// un ataque especial que solo pueden hacer los npcs, el escudo no lo bloquea. 
            turnos_npc.get(index).getsDamage(pts_attack);
    }

    public void stillAlive(){ //Se revisa la vida de todos para eliminarlos o no de las listas. 
        for (int i = 0; i<turnos_hero.size(); i++){
            if(turnos_hero.get(i).getVida() <= 0){
               turnos_hero.remove(i);
            }
        }

        for (int i = 0; i<turnos_npc.size(); i++){
            if(turnos_npc.get(i).getVida() <= 0){
                turnos_npc.remove(i);
             }
        }
    }

    public boolean stageOneIsDone(){ //Se revisa si se puede pasar a la siguiente fase. 
        boolean stageOneIsDone;
        if(turnos_npc.size() <= 0){
            stageOneIsDone = true;
        }else{
            stageOneIsDone = false;
        }
    return stageOneIsDone;
    }

    public boolean stageTwoIsDone(){
        boolean stageTwoIsDone;
        if(turnos_hero.size() <= 0){
            stageTwoIsDone = true;
        }else{
            stageTwoIsDone = false;
        }

        return stageTwoIsDone;
    }

    public void showStatistics(){

    }
}
