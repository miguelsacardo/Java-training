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

            Enemy[] goblins = new Enemy[3]; //here, I only created an array with three objects, but not the individuals objects that will be used
            for(int i = 0; i < goblins.length; i++){
                goblins[i] = new Enemy(); //here I am creating each individual object
                goblins[i].chooseEnemy("GOBLIN");
            }

            goblins[0].exibirAtributos();
            goblins[1].exibirAtributos();
            goblins[2].exibirAtributos();
            

            // //updade level system
            // System.out.println("You find a small stone. Do you want to pick it?");
            // String pick = input.nextLine().toUpperCase();

            // if (pick.equals("Y")){
            //     newPlayer.level += 3;
            //     newPlayer.updateLevel();
            //     newPlayer.exibirAtributos();
            // }

            // System.out.println("AAA");
            // String pick2 = input.nextLine().toUpperCase();

            // if(pick2.equals("Y")){
            //     newPlayer.level += 1;
            //     newPlayer.updateLevel();
            //     newPlayer.exibirAtributos();
            // }

            // System.out.println("Your new level is: " + newPlayer.level);

            // //testing instancing different objects to make sure that they will have its own attributes
            // Enemy goblin = new Enemy();
            // goblin.enemyType = "Goblin";
            // Enemy trasgo = new Enemy();
            // do{
            //     System.out.println("An enemy is comming! Get ready for the attack!");
            //     newPlayer.attack(goblin.armorClass,goblin, newPlayer.diceD20());

            //     System.out.println("The enemy1s life now is: " + goblin.life);

            //     System.out.println("Now, it is the enemy's time!");
            //     newEnemy.attack(newPlayer.armorClass,newPlayer, goblin.diceD20());

            //     System.out.println("Hero, your life is now: " + newPlayer.life);

            //     System.out.println("\nVida do goblin: " + goblin.life + "Vida trasgo: " + trasgo.life);

            //     if(newPlayer.life == 0 || newPlayer.life < 0){
            //         System.out.println("The enemy wins");
            //         break;
            //     }else if(goblin.life == 0 || goblin.life < 0){
            //         System.out.println("The player wins");
            //         break;
            //     }

            // }while(newPlayer.life > 0 && goblin.life > 0);

            


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
    public int life = 0;
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
                        this.guild = "STRONGHAND";
                        break;

                    case "EAGLES":
                        this.life += 10;
                        this.armorClass += 14;
                        this.attack += 15;
                        this.guild = "EAGLES";
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
    public void attack(int enemyArmorClass,Enemy enemyLife, int diceResult){ //I can pass a class as a paramter and then the function will take care of the rest
        System.out.println(diceResult);
        
        if(diceResult >= enemyArmorClass && diceResult < 20){
            System.out.println("Você acertou, mas não foi crítico");
            enemyLife.life -= this.attack; //with the object passed as a paramter, i can access the attributes and the functions from it
        }else if(diceResult == 20){
            System.out.println("Você critou!");
            enemyLife.life -= (this.attack * 2);
        }
        else if(diceResult < enemyArmorClass && diceResult > 1){
            System.out.println("Você não acertou");
        }
        else{
            System.out.println("Você tirou 1");
        }
    }

    public void updateLevel(){
        if (this.level == 2){
            this.life += 3;
            this.attack += 2;
            this.armorClass += 1;
        }else if(this.level == 3){
            this.life += 4;
            this.attack += 3;
            this.armorClass += 1;
        }else if(this.level == 4){
            this.life += 6;
            this.attack += 5;
            this.armorClass += 3;
        }else if(this.level == 5){
            this.life += 9;
            this.attack += 8;
            this.armorClass += 3;
        }
    }
}

class Enemy extends Player{
    public int life = 0;
    public int level = 1; //the level always will start in 1
    public int armorClass = 0;

    public double attack = 0;
    public String enemyType;

    // public String[] bossEnemy = {"BLACK-KNIGHT","FALLEN-LIGHT"," "}

    public void chooseEnemy(String enemyType){
        switch (enemyType) {
            case "GOBLIN":
                this.life += 8;
                this.armorClass += 12;
                this.attack += 7;
                this.enemyType = "GOBLIN";
                break;

            case "WOLF":
                this.life += 10;
                this.armorClass += 9;
                this.attack += 10;
                this.enemyType = "WOLF";
                break;
            
            case "ZOMBIE":
                this.life += 18;
                this.armorClass += 11;
                this.attack += 11;
                this.enemyType = "ZOMBIE";
                break;

            case "DEPRAVED":
                this.life += 20;
                this.armorClass += 15;
                this.attack += 14;
                this.enemyType = "DEPRAVED";
                break;

            case "POOR-MAGE":
                this.life += 12;
                this.armorClass += 13;
                this.attack += 15;
                this.enemyType = "POOR-MAGE";
                break;
        }
    }

    //this method subscribes the Player's attack method
    public void attack(int playerArmorClass, Player playerLife, int diceResult){
        System.out.println(diceResult);
        
        if(diceResult >= playerArmorClass && diceResult < 20){
            System.out.println("O inimigo te acertou, mas não foi crítico");
            playerLife.life -= this.attack;
        }else if(diceResult == 20){
            System.out.println("O inimigo critou!");
            playerLife.life -= (this.attack * 2);
        }
        else if(diceResult < playerArmorClass && diceResult > 1){
            System.out.println("O inimigo não acertou");
        }
        else{
            System.out.println("O inimigo tirou 1");
        }
    }

    public void exibirAtributos(){
        System.out.printf("Name: %s\nArmor Class: %d\nLife: %d\nLevel: %d\nAttack: %.0f\nEnemy Type: %s",this.namePlayer,this.armorClass,this.life, this.level, this.attack, this.enemyType);
    }
}