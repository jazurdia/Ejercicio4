import java.util.*;

public class Scenario {

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

        /**
         * Bueno pues... este método es el escenario entonces ajá. 
         * 
         * Necesito hacer lo siguiente:
         * 
         * 
         * En un bucle, que no deberá deternse hasta que uno ambos jugadores mueran o maten al jefe. 
         * Entonces, haré lo siguiente:
         * 
         * Para comenzar, tengo el problema de los arrays de múltiples clases. Se resuelve... no teniendo múltiples clases. 
         * Es decir, en vez de tener una clase por cada tipo de enemigo, se harán instancias con modificadores por métodos. 
         * Claro que esto me deja el problema del boss, que DEBE ser otra clase. Por esto, he pensado que en vez de enfrentar
         * todo al mismo tiempo, la pelea tendrá fases. La primera consistirá en derrotar a los esbirros y la segunda al jefe.
         * 
         * Entonces, resolvemos el problema de los arrays. Aunque es una mamada porque ya había hecho 5 clases solo para esta cosa. 
         * Y ES QUE FIJO HAY COMO RESOLVERLO, VOY A INTENTAR PREGUNTAR MAÑANA QUE PEX, pero no espero tener resultados. 
         * Mañana dice, si es en unas horas. 
         * 
         * Ah! Anoración. Sigo teniendo dos tipos de objetos, pero son héroe y enemigo. Entonces no tengo problemas, solo que uno no
         * podrá afectar al mismo tipo de objeto. O si podría pero que hueva hacer más métodos. Primero que "funcie" y despues vemos que pedo.  
         * 
         * Lo segundo! 
         * ¿Como determinamos los objetos que han muerto? Bueno, se me ocurre que puedo hacer una comprobación cada iteración del ciclo turn.
         * Si un objeto tiene vida 0 o negativa, entonces se eliminará del arraylist correspondiente. 
         * 
         * Tercero! 
         * El problema existente con el ciclo turn es como saber que ya pasó un turno y como saber a quien le toca?
         * La asignación será automática. La haremos por medio del índice en el arraylist. 
         * 
         * Cuarto! A quien afecta la acción?
         * Bueno, pues... pienso que esto es más fácil. Se mostrará el nombre por medio del getNombre(), de cada uno de los pizados del otro arraylist.
         * 
         * Si es turno del jugador, eligirá a quien atacar. SI es turno de la máquina, la máquina decidirá por medio de rand. 
         * 
         * 
         * Quinto! Como le hacemos para "pasar" o "bloquar"?
         * Pues... alm no sé. Creo que lo apropiado sería tener un método que modifique un atributo de la clase. Modificar el método getDamage() de manera que
         * ante de restar vida, compruebe si "hay escudo o no". Si hubiese escudo, no se ejecuta y se devuelve un mensaje de "ataque bloqueado" o una mamada así. 
         * 
         * Sexto! Como madres meto la segunda fase de la batalla?
         * Bueno, eso lo voy a pensar despues porque la verdad, ya no tengo muchas ideas y se me acabó el cafe. I'm a field planner, no un estratega nato so lets do whats
         * more importate, ok? bye. 
         * 
         */

        //INICO DE LA MATCH.         
        setActors(2, 1);// Llamar a la vista. 
        
        turn = new Turn(turnos_hero.size() + turnos_npc.size());

        
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
    
    //************************************************************************************** */
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

    public int menu

}
