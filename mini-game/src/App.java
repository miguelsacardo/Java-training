//this study simulates a small rpg game, where there is a player and an enemy.
//it contains a combat system inspired by D&D 5th 

import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Player newPlayer = new Player();
        //Enemy e = new Enemy();
        // p.exibirAtributos();
       
        while(true){

            //introducing the story for the player
            System.out.println("\n----------------***---------------");
            System.out.println("Hello Adventurer! Your help is claimed in the north Kingdom.\nThe north Kingdom is known by your great gold reservations\nAnd the enemies are comming to stole it!\nYou need to stop them!");
            System.out.println("----------------***---------------");

            //player's name input
            System.out.println("Hero, write your name!");
            newPlayer.namePlayer = input.nextLine().toUpperCase();
            
            System.out.println("----------------***---------------");
            

            //testing function
            newPlayer.exibirAtributos();
            System.out.println("\n----------------***---------------");

            //MAYBE I SHOULD PUT A LOOP HERE
            System.out.println("Choose your guild:\nClothfeet\nWilsons\nStronghand\nEagles\nYour Choice: ");
            String choiceGuild = input.nextLine().toUpperCase();

            if (choiceGuild.equals("CLOTHFEET") || choiceGuild.equals("WILSONS") || choiceGuild.equals("STRONGHAND") ||choiceGuild.equals("EAGLES")){
                newPlayer.chooseGuild(choiceGuild);
                newPlayer.exibirAtributos();
            }
            else{
                System.out.println("Choose a valid guild!");
                continue;
            }
            /////////////////////////////////
            // System.out.println(guild);
    
            // p.namePlayer = input.nextLine();

            // System.out.println("Nome do jogador: " + p.namePlayer);
            input.close();
            break;
            
        }
    }
}

class Player{
    public String namePlayer;
    public int life = 10;
    public int level = 1;
    public int armorClass = 15;

    public double attack = 10;
    public double defense = 10;

    public String guilds[] = {"CLOTHFEET","WILSONS","STRONGHAND","EAGLES"};



    public void exibirAtributos(){
        System.out.printf("Name: %s\nArmor Class: %d\nLife: %d\nLevel: %d\nAttack: %.0f\nDefense: %.0f",this.namePlayer,this.armorClass,this.life, this.level, this.attack, this.defense);
    }

    public void chooseGuild(String playerGuild){
        for(String guild : guilds){
            if(playerGuild.equals(guild)){ //I must use equals because guild is an object
                System.out.printf("Your guild is: %s", playerGuild);

                switch (playerGuild) {
                    case "CLOTHFEET":
                        this.life += 5;
                        this.armorClass += 2;
                        this.attack += 5;
                        this.defense += 5;
                        break;
                }
            }
        }
    }
}

// class Enemy extends Player{

// }