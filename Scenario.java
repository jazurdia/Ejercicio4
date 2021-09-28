import java.util.*;

public class Scenario {

    // Instancia de los actores. 
    Warrior warrior;
    Explorador explorador;

    Orco orco;
    Enano enano;
    Esqueleto esqueleto;

     
    public void match(){//Inicialización de la partida. Dentro de este método pasará todo lo chido. 

        //setActors(num_heroes, hero1); LLAMAR LOS MÉTODOS DE LA VISTA
    
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
        //  FALTA METER EN LA LISTA PARA LOS TURNOS!!!!!!!!!!!! 
        Random rand = new Random();
        int random_num = rand.nextInt(2)+1;
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
        this.orco = new Orco("Marcus");
    }

    public void instanceOfEnano(){
        this.enano = new Enano("Eduardo");
    }

    public void instanceOfEsqueleto(){
        this.esqueleto = new Esqueleto("Julia");
    }

    public void instanceOfWarrior(){
        this.warrior = new Warrior("Marcus");
    }

    public void instanceOfExplorador(){
        this.explorador = new Explorador("Sophie");
    }


}
