package fr.games;

import java.util.Random;
import java.util.Scanner;

/*
 * au debut du jeu on entre le nom de joueur
 * chaque joueur dispose d'un nombre limite de point de vie
 * chaque joueur a la possibilite de prendre soit une potion de vie soit d'effectuer une attaque
 * lorsque le joueur choisi de prendre une potion il saute un tour t'attaque
 * 
 * l'ordinateur n'a pas droit a la potion mais il a une marche de point d'attaque plus elevee
 * 
 * chaque fois que le joueur choisi une attaque ou une potion l'ordinateur attaque ensuite
 * 
 * A chaque tour on rappelle le nombre de point de vie qu'il reste a chacun
 * le premier a avoir un nombre de vie <= 0 perd le jeux.
 * 
 * avant d'attaquer on verifie qu'il te reste des points de vie.
 */
public class Players {

    public Players(){
        this.vieJoueur = 50;
        this.potions = 2;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getVieJoueur(){
        return this.vieJoueur;
    }
    public void setVieJoueur(int iaAttack){
        this.vieJoueur -= iaAttack;
    }

    public int getPotions(){
        return this.potions;
    }

    public void setVie_joueu_r(int vie_joueur){
        this.vieJoueur += vie_joueur;
    }
    
    public int joueurAttaque(){
        Random rd = new Random();
        int ptAttack = rd.nextInt(10);
        System.out.println("You have inflicted " + ptAttack + " of damage on the AI.");
        return ptAttack;
    }

    public void use_potion(){
        if(!potionEmpty()){
            // System.out.println("---------------------------------");
            this.potions--;
            Random rd = new Random();
            int ptLive = rd.nextInt(50);
            this.vieJoueur += ptLive;
            System.out.println("You have gained " + ptLive + " Health point(s) ");
            this.setVieJoueur(ia.iaAttaque());
            System.out.println("You will be skipped next turn");
            // System.out.println("---------------------------------");
        }
        else{
            System.out.println("---------------------------------");
            System.out.println("You are out of potion");
            System.out.println("You will be skipped next turn");
            System.out.println("---------------------------------");
            // return 0;
        }
    }

    public void setPlayersName(){
        System.out.println("What is your name? :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();
        this.setName(name);
    }

    public boolean potionEmpty(){
        boolean state_potion = false;
        if (this.potions <= 0) {
            state_potion = true;
        }
        return state_potion;
    }

    private String name;
    private int vieJoueur;
    private int potions;
    IA ia = new IA();
}
