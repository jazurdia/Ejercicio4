import java.util.*;
public class Vista {
    
    public void tryAgain(){
        System.out.println("Intenta de nuevo");
    }

    public void usoEscudo(String nombre){
        System.out.println("" + nombre + " ha usado escudo, no ha recibido daño!");
    }

    public void estadoDelEscudo(String nombre){
        System.out.println("El héroe " + nombre + " está usando su escudo." );
    }

    public void statsOfDamaged(String name, int damage, int newVida){
        System.out.println("" + name + " ha recibido " + damage + " de daño");
        System.out.println("Ahora tiene: " + newVida + " de vida.");
    }

    public int whoGetsDamaged(){
        Scanner in = new Scanner(System.in);
        boolean stop = false;
        int indexOfDamaged = 0;
        while (stop == false){
            try { 
                System.out.println("Ingresa el número del enemigo que atacarás");
                indexOfDamaged = in.nextInt();
                stop = true;
            } catch (Exception e) {
                tryAgain();
                in = new Scanner(System.in);
            }
        }
        return indexOfDamaged;
    }

    public int menu(String nom_turno)throws InputMismatchException{
        int menu = 0;
        Scanner in = new Scanner(System.in);

        boolean stop = false;
        
        while (stop == false){
            System.out.println("Turno de " + nom_turno);
            System.out.println("1. Atacar");
            System.out.println("2. Bloquear");
            System.out.println("3. Pasar");

            try {
                menu = in.nextInt();
                stop = true;
            } catch (InputMismatchException e) {
                in = new Scanner(System.in);
                System.out.println("Intenta de nuevo");
            }

        }

        return menu;
    }

    public int settingHeroes(){
        boolean stop = false;
        int no_heroes = 0;
        Scanner in = new Scanner(System.in);
        while(stop == false){
            System.out.println("Ingresa la cantidad de jugadores: \n 1 o 2 : ");
            
            try {
                no_heroes = in.nextInt();
                stop = true;
                 
            } catch (Exception e) {
                in = new Scanner(System.in);
                System.out.println("Intenta de nuevo");
            }
        }
        return no_heroes;

    }

    public int choosingHero(){
        boolean stop = false;
        int choosen_hero = 0;
        Scanner in = new Scanner(System.in);
        while(stop == false){
            System.out.println("Ingresa el dígito del Heroe que desea usar.");
            System.out.println("1. Warrior \n2. Explorador \n-> ");            
            try {
                choosen_hero = in.nextInt();
                stop = true;
                 
            } catch (Exception e) {
                in = new Scanner(System.in);
                System.out.println("Intenta de nuevo");
            }
        }
        return choosen_hero;

    }

    public void show_name_listA(ArrayList<Hero> names){// Muestra un ArrayList de Hero
        for(int i = 0; i < names.size(); i++){
            System.out.println("" + i + ":  " + names.get(i).getNombre());
        }

    }

    public void show_name_listB(ArrayList<Npc> names){// Muestra un ArrayList de NPC
        for(int i = 0; i < names.size(); i++){
            System.out.println("" + i + ":  " + names.get(i).getNombre());
        }

    }

    public void pass(String name){
        System.out.println("El héroe " + name + " ha decidido no hacer nada. ");
    }

}
