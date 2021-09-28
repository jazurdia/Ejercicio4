import java.util.*;
public class Vista {
    
    public void tryAgain(){
        System.out.println("Intenta de nuevo");
    }


    public int menu(String nom_turno)throws InputMismatchException{
        int menu = 0;
        Scanner in = new Scanner(System.in);

        boolean stop = false;
        
        while (stop == false){
            System.out.println("Turno de " + nom_turno);
            System.out.println("1. Atacar");
            System.out.println("2. Bloquar");
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


}
