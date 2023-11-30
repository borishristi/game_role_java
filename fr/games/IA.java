package fr.games;
import java.util.Random;

public class IA {
     public IA(){
        this.vieIa = 50;
    }

    public int getVieIa(){
        return this.vieIa;
    }

    public int iaAttaque(){
        Random rd = new Random();
        int ptAttack = rd.nextInt(15);
        System.out.println("The AI has inflicted " + ptAttack + " point(s) of damage.");
        return ptAttack;
    }

    public void setVieIa(int attaque_joueur){
        this.vieIa -= attaque_joueur;
    }

    // private String name;
    // private int vie_joueur;
    private int vieIa;
    // private int potions;    
}
