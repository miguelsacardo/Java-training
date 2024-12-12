//this study simulates a small rpg game, where there is a player and an enemy.
//it contains a combat system inspired by D&D 5th 

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Player p = new Player();
        //Enemy e = new Enemy();
        p.exibirAtributos();
       
        while(true){
            System.out.println("Escreva o nome do seu jogador: ");
            p.namePlayer = input.nextLine();

            System.out.println("Nome do jogador: " + p.namePlayer);
            break;
            
        }
    }
}

class Player{
    public String namePlayer;
    public int life = 10;
    public int level = 1;
    public int armorClass = 15;

    public Double attack = 10.0;
    public Double defense = 10.0;


    public void exibirAtributos(){
        System.out.printf("Life: %d\nLevel: %d\nAttack: %f\nDefense: %f", this.life, this.level, this.attack, this.defense);
    }
}

// class Enemy extends Player{

// }