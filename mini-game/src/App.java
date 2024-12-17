//this study simulates a small rpg game, where there is a player and an enemy.
//it contains a combat system inspired by D&D 5th 

import java.util.Scanner;


public class App {
    public static void main(String[] args) throws InterruptedException{

        //variables declaration
        boolean choices = true;
        boolean isGameRunning = true;

        //object instances
        Player newPlayer = new Player();
        Enemy[] newEnemy = new Enemy[1]; //create an array of enemies
        Scanner input = new Scanner(System.in);

        //create the game's enemies
        for(int i = 0; i < newEnemy.length; i++){
            newEnemy[i] = new Enemy();
        }

            
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


                //verify if the guild is valid
                if (choiceGuild.equals("CLOTHFEET") || choiceGuild.equals("WILSONS") || choiceGuild.equals("STRONGHAND") ||choiceGuild.equals("EAGLES")){
                    System.out.println("\n----------------***---------------\n");
                    newPlayer.chooseGuild(choiceGuild);
                    newPlayer.exibirAtributos();
                    System.out.println("\n----------------***---------------\n");

                    //stops the guild system
                    break;
                }
                else{
                    System.out.println("\n----------------***---------------\n");
                    System.out.println("Choose a valid guild!");
                    System.out.println("\n----------------***---------------\n");

                    //restarts the guild system if the player choose an invalid guild
                    continue;
                }
            }//end guild system

            //story of game
            while(isGameRunning){
                System.out.printf("Hello, %s. \nYou arrived at the right time!\nYour story starts in a small village next to the north Kingdom.\n", newPlayer.namePlayer);
                System.out.println("Here it is your house,\nA comfortable place to rest and get calm down.");
                System.out.println("\n----------------***---------------\n");
                System.out.println("There is some things that you can do here.\n[1]Explore\n[2]Leave House\nYour choice: ");
                System.out.println("\n----------------***---------------\n");
                
                //choice -> explore the house and get or not a sword
                while(choices){
                    switch(input.nextLine()){

                        case "1":
                            System.out.printf("Your best friend Sword is next to your bed and you take it! Your attack has increased!\nYour attack is now: %.0f", newPlayer.attack += 4.0);
                            System.out.println("\nThen, you finally leave your house...");
                             
                            //stops the choices loop
                            choices = false;
                            break;

                        case "2":
                            System.out.println("You leave the house, but unfortunatelly without your best friend Sword...");

                            //stops the choices loop
                            choices = false;
                            break;

                        default:
                            System.out.printf("%s, please select a valid option!\n[1]Explore\n[2]Leave House\nYour choice: ", newPlayer.namePlayer);

                            //restart the choices loop if the player choose an invalid option
                            continue;
                    }
                }// end choices
                
                //the variable "choices" must be true again
                choices = true;

                //delay the introduce of dialogue
                Thread.sleep(5000);
                System.out.println("\n----------------***---------------\n");
                System.out.println("The day seems beautiful.\nYou see the mailman from the North Kingdom approaching your house.\n");
                System.out.println("Mailman: Hello Sir. I have a mail for you.\nMailman: Here, take it.");
                System.out.println("You take the mail and open it.\nThe mail is from the King Sans III, and he needs to see you.");
                System.out.println("\n----------------***---------------\n");

                Thread.sleep(5000);
                System.out.printf("%s, the North Kingdom needs help. The monsters from the Tenth Axis are starting a war with us to stole our natural resources!", newPlayer.namePlayer);
                System.out.println("\nYou are our old knight. Please, consider our offer.\nWe are going to give you everything that you want.\nWe will give you a new place to live, money and fame!\nYou know that you are the pride of the Kingdom.");
                System.out.println("\n----------------***---------------\n");

                Thread.sleep(5000);
                System.out.printf("%s, will you accept this order?\n[Y]Yes\n[N]No\nYour choice: ", newPlayer.namePlayer);

                //choice -> accept the request of the kingdom
                while(choices){
                    switch (input.nextLine().toUpperCase()){
                        case "Y":
                            System.out.println("Good, hero. Everyone know that you are going to give the best help.");
                            
                            //updates the player's level if the player accepts
                            newPlayer.level += 1;
                            newPlayer.updateLevel();

                            System.out.printf("For your corage, now your level is: %d\n", newPlayer.level);

                            //stops the choices loop
                            choices = false;
                            break;
                            
                        case "N":

                            //this while is to make the player accept the request
                            int i = 0;
                            while(i < 5){
                                System.out.println("Please, consider the offer.\n[Y]Yes\n[N]No\nYour choice: ");

                                String playerOption = input.nextLine().toUpperCase();
                                if(playerOption.equals("Y")){
                                    System.out.printf("Thanks, Hero. At least in the %d time...", i + 2);
                                    
                                    //updates the player's level if the player accepts the request
                                    newPlayer.level += 1;
                                    newPlayer.updateLevel();

                                    System.out.printf("\nFor your corage, now your level is: %d", newPlayer.level);

                                    choices = false; //stops the choices loop
                                    break; //stops this while (i < 5)
                                }else{

                                    //if the player refuses, the "i" is incremented
                                    System.out.println("OMG Hero! Don't do this way!");
                                    i++; 
                                }
                            }

                            //ends the game if the player refuses for 5 times
                            if(i == 5){
                                System.out.println("Ok. See you next time.");
                                
                                //stops the game
                                isGameRunning = false;

                                //stops the choices loop
                                choices = false;
                            }
                            break;

                        default:

                            //restarts the loop if the player chooses an invalid option
                            System.out.println("Hero, please select a valid option!\n[Y]Yes\n[N]No\nYour choice: ");
                            continue;
                    }
                }//end choices

                //stops the game story if the player don't accept the request
                if(isGameRunning == false){
                    break;
                }

                Thread.sleep(5000);
                System.out.println("\n----------------***---------------\n");
                System.out.println("In the same night, you take your horse and come in the north direction.\nThe breeze hits your face and you\nFeel excited that you are\nGoing to save\nYour homeland.");
                System.out.println("The North Kingdom is not far away,\nSo it won't take you long to arrive.");

                Thread.sleep(5000);
                System.out.println("\n----------------***---------------\n");
                System.out.println("Did you hear that?\nThere was a noise in the bush.\nYou stop and pay attention.");
                System.out.println("A GOBLIN JUMPS IN FRONT OF YOU.");

                

                



                //test print
                newPlayer.exibirAtributos();

                
                
                break;
            }

            // Enemy[] goblins = new Enemy[3]; //here, I only created an array with three objects, but not the individuals objects that will be used
            // for(int i = 0; i < goblins.length; i++){
            //     goblins[i] = new Enemy(); //here I am creating each individual object
            //     goblins[i].chooseEnemy("GOBLIN");
            // }

            // goblins[0].exibirAtributos();
            // goblins[1].exibirAtributos();
            // goblins[2].exibirAtributos();
            

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
                        this.life += 25;
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

class Story{
   
}