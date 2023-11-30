package fr.games;

import java.util.Scanner;

public class Lunch_game {

    Players pl = new Players();
    IA ia = new IA();

    public void game(){
        System.out.println("************Welcome to the role game************");
        pl.setPlayersName();
        System.out.println("name : " + pl.getName());
        System.out.println("potions : " + pl.getPotions());
        System.out.println("live player : " + pl.getVieJoueur());
        System.out.println("live IA : " + ia.getVieIa());
        lunch_game();
    }
    public void lunch_game(){
        while (this.play == true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Are you want to play? Y/N : ");
            String str = sc.nextLine();
            sc.close();
            // System.out.println("Your response is : " + str);
            if (str.equals("y") || str.equals("Y")) {
                System.out.println("Yes, I want to play! ");
                choiceToPlay();
            }
            else if (str.equals("n") || str.equals("N")){
                System.out.println("No, I wan't to play! ");
                System.out.println("Good Buy");
                System.exit(0);
            }
            else{
                System.out.println("Bad choice!!! Try again");
                lunch_game();
            }
        }

    }

    public void choiceToPlay(){
        System.out.println("What do you want to do?");
        System.out.println("(1) for Attack | (2) for Potion");
        Scanner sc = new Scanner(System.in);
        int choicePlayer = sc.nextInt();
        sc.close();
        // System.out.println("You have chosen " + choice);
        if (choicePlayer == 1 && partyPass == false) {
            // System.out.println(pl.getName() + " a " + pl.getViejoueur() + " points de vie");
            ia.setVieIa(pl.joueurAttaque());
            // potion_use = 2;
            // System.out.println("Apres consommations de potions " + pl.getName() + " a " + pl.getViejoueur() + " points de vie");
        }
        // partyPass = false;
        if(choicePlayer == 2 && pl.getPotions() > 0){
            pl.use_potion();
            // partyPass = true;
        }
        pl.setVieJoueur(ia.iaAttaque());
        
        recap_game();
    }

    public void recap_game(){
        if (verifyPoint()) {
            System.out.println("*****Statistiques*****");
            System.out.println(pl.getName() + " : " + pl.getVieJoueur() + " Points de vie et Potions : " + pl.getPotions());
            System.out.println("IA : " + ia.getVieIa());
            choiceToPlay(); 
        }
        else
            System.out.println("*****END GAME*****");
            System.exit(0);
    }

    public boolean verifyPoint(){
        boolean verify = true;
        if (pl.getVieJoueur() <= 0) {
            System.out.println("You are lost this game...");
            verify = false;
            return verify;
        }
        else if (ia.getVieIa() <= 0) {
            System.out.println("You are win this game...");
            verify = false;
            return verify;
        }
        else
            return verify;
    }
    private boolean play = true;
    private boolean partyPass = false;

}
