//this study simulates a small rpg game, where there is a player and an enemy.
//it contains a combat system inspired by D&D 5th 

import java.util.Scanner;

public class App {
    public static void main(String[] args){

        //variables declaration
        Scanner input = new Scanner(System.in);

        //object instances
        Player newPlayer = new Player();
        Enemy newEnemy = new Enemy();

            
        //"screen" of the game
        while(true){
    
            //introducing the story for the player
            System.out.println("\n----------------***---------------\n");
            System.out.println("Hello Adventurer! Your help is claimed in the north Kingdom.\nThe north Kingdom is known by your great gold reservations\nAnd the enemies are comming to stole it!\nYou need to stop them!");
            System.out.println("\n----------------***---------------");
            System.out.println("\n~~~~~+ CHARACHER'S * SHEET +~~~~~");

            //player's name input
            System.out.println("Hero, write your name!");
            newPlayer.namePlayer = input.nextLine().toUpperCase();
            
            System.out.println("\n----------------***---------------\n");
            

            // //testing function
            // newPlayer.exibirAtributos();
            //System.out.println("\n----------------***---------------");

            //guild system
            while(true){
                System.out.println("Choose your guild:\nClothfeet\nWilsons\nStronghand\nEagles\nYour Choice: ");
                String choiceGuild = input.nextLine().toUpperCase();

                if (choiceGuild.equals("CLOTHFEET") || choiceGuild.equals("WILSONS") || choiceGuild.equals("STRONGHAND") ||choiceGuild.equals("EAGLES")){
                    System.out.println("\n----------------***---------------\n");
                    newPlayer.chooseGuild(choiceGuild);
                    newPlayer.exibirAtributos();

                    break;
                }
                else{
                    System.out.println("\n----------------***---------------\n");
                    System.out.println("Choose a valid guild!");
                    System.out.println("\n----------------***---------------\n");
                    continue;
                }
            }

            do{
                System.out.println("An enemy is comming! Get ready for the attack!");
                newPlayer.attack(newEnemy.armorClass, newPlayer.diceD20());

                System.out.println("The enemy1s life now is: " + newEnemy.life);

                System.out.println("Now, it is the enemy's time!");
                newEnemy.attack(newPlayer.armorClass, newEnemy.diceD20());

                System.out.println("Hero, your life is now: " + newPlayer.life);

            }while(newPlayer.life > 0 && newEnemy.life > 0);

            


            // System.out.println(newPlayer.playerGuild);
        
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
    public static int life = 0;
    public int level = 1; //the level always will start in 1
    public int armorClass = 0;

    public double attack = 0;

    public String guilds[] = {"CLOTHFEET","WILSONS","STRONGHAND","EAGLES"};

    public String guild;


    public void exibirAtributos(){
        System.out.printf("Name: %s\nArmor Class: %d\nLife: %d\nLevel: %d\nAttack: %.0f\n",this.namePlayer,this.armorClass,this.life, this.level, this.attack);
    }

    public void chooseGuild(String playerGuild){
        for(String guild : guilds){
            if(playerGuild.equals(guild)){ //I must use equals because guild is an object
                
                //show the choosen guild
                System.out.printf("Your guild is: %s\n", playerGuild);
                
                //make the character sheet based on the choosen guild
                switch (playerGuild) {
                    case "CLOTHFEET":
                        this.life += 20;
                        this.armorClass += 9;
                        this.attack += 5;
                        this.guild = "CLOTHFEET";
                        break;

                    case "WILSONS":
                        this.life += 24;
                        this.armorClass += 10;
                        this.attack += 8;
                        this.guild = "WILSONS";
                        break;

                    case "STRONGHAND":
                        this.life += 30;
                        this.armorClass += 16;
                        this.attack += 12;
                        this.guild = "WILSONS";
                        break;

                    case "EAGLES":
                        this.life += 8;
                        this.armorClass += 14;
                        this.attack += 15;
                        this.guild = "WILSONS";
                        break;
                }
            }
        }
    }

    //D20 dice simulates rolling a twenty-sided dice
    public int diceD20(){
        java.util.Random diceD20 = new java.util.Random();
        return diceD20.nextInt(21);
    }

    //player's attack
    public void attack(int enemyArmorClass, int diceResult){
        System.out.println(diceResult);
        
        if(diceResult >= enemyArmorClass && diceResult < 20){
            System.out.println("Você acertou, mas não foi crítico");
            Enemy.life -= this.attack;
        }else if(diceResult == 20){
            System.out.println("Você critou!");
            Enemy.life -= (this.attack * 2);
        }
        else if(diceResult < enemyArmorClass && diceResult > 1){
            System.out.println("Você não acertou");
        }
        else{
            System.out.println("Você tirou 1");
        }
    }
}

class Enemy extends Player{
    public static int life = 100;
    public int level = 3; //the level always will start in 1
    public int armorClass = 14;

    public double attack = 5;

    //this method subscribes the Player's attack method
    public void attack(int playerArmorClass, int diceResult){
        System.out.println(diceResult);
        
        if(diceResult >= playerArmorClass && diceResult < 20){
            System.out.println("O inimigo te acertou, mas não foi crítico");
            Player.life -= this.attack;
        }else if(diceResult == 20){
            System.out.println("O inimigo critou!");
            Player.life -= (this.attack * 2);
        }
        else if(diceResult < playerArmorClass && diceResult > 1){
            System.out.println("O inimigo não acertou");
        }
        else{
            System.out.println("O inimigo tirou 1");
        }
    }
}