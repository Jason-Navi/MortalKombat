import java.util.*;
import javax.swing.*; 
/**
 * Jason Navi
 * 01/10/17
 * Client class of the Mortal Kombat game that instantiates objects of the Fighter classes and uses JOptionPanes to enhance the visuals of the game
 * All user interactive parts of the game are located in this class
 * Simply run the main method of this class to start playing the game
 */
public class mortalKombatClient
{
    public static void main(String[] args){
        //declares and initializes the user's fighter to null
        Fighter userFighter = null;
        //calls beginGame method to initialize the user's fighting stats
        userFighter = beginGame(userFighter);
        //begins the fight
        fight(userFighter);
    }

    /**starts the beginning of the game, prompts user to select a fighter, displays the rules of the game and returns the user's fighter*/
    public static Fighter beginGame(Fighter userFighter){
        //creates buttons for user to pick fighter type
        Object[] fighters = {"Human", "Goblin", "Beast"};
        //creates the mortal kombat icon to be added to the JOptionPane window
        ImageIcon mortalKombatIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\welcomePicture.jpg");
        //sets up a window with the mortal kombat icon and custom buttons for user to click on and stores the result 
        int userClicked = JOptionPane.showOptionDialog(null,"Welcome to Mortal Kombat! The fighters are listed below with their respective stats. Please Pick a fighter from the following list:\n Humans: Average in Health, Attack, and Defense \n Goblins: High defense, high attack, and low health \n Beast: High Attack, high health,and low defense", "Mortal Kombat", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, mortalKombatIcon, fighters, null);

        //initializes the user's fighter to the fighter type they clicked on
        if(userClicked == 0)
            userFighter = new Human();
        else if(userClicked == 1)
            userFighter = new Goblin();
        else userFighter = new Beast();

        //increase user's max health by 50% and give them 10 free gold to give them an edge in battle
        userFighter.addMaxHealth((int)(userFighter.getMaxHealth() * .50));
        userFighter.addGold(10);
        //displays a JOptionPane that shows the user's fighting stats and player type
        JOptionPane.showMessageDialog(null, "Congrats on picking a fighter! Listed below are your fighting stats: \n" + userFighter.toString(), "Stats", JOptionPane.INFORMATION_MESSAGE, userFighter.getFighterIcon());

        //stores rules of the game and stores it in a String
        String rules = "\n 1)This is a turn based game \n 2) Every turn you can choose to attack, eat food, run away(small chance), view your stats, view your enemies stats, or view the rules again \n 3) Every time you kill an enemy you get 8-12 EXP and when you hit 80 EXP you evolve to your next form, increase your stats, and gain full HP back \n 4) You will gain 5 health points back in between fights \n 5) Each time you kill 4 enemies you will come across a town where you will gain full health back from sleeping and can shop for items at \n 6) If you escape a fight, you will not get experience points or added health";
        //creates a custom button
        Object[] startGame = {"Begin the Journey"};
        //creates a bookIcon to put in the JOptionPane
        ImageIcon bookIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\book.png");
        //displays a JOptionPane with the startGame button and bookIcon 
        JOptionPane.showOptionDialog(null, rules, "Rules of the Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, bookIcon, startGame, null);
        //returns user's fighter with all of it's stats
        return userFighter;
    }

    /**serves as the main portion of the fighting game in which the user can evolve, fight, eat food, etc*/
    public static void fight(Fighter userFighter){
        //sets the enemyFighter to null
        Fighter enemyFighter = null;

        //declares and initializes all custom buttons used throughout the game
        Object[] battleOptions = {"Attack", "Run away", "Eat food", "View your stats", "View opponent stats", "Rules of kombat"};
        Object[] backToFightButton = {"Back to the Fight!"};
        Object[] beginFightButton = {"Begin Fight!"};
        Object[] gameOptions = {"Continue", "Quit"};
        Object[] exitGameButton = {"Exit Game"};
        Object[] foodChoices = {"Chicken", "Lobster", "Dragon Egg", "Back to the fight!"};
        Object[] eatOptions = {"Eat", "Go back"};
        Object[] backOption = {"Go back"};
        Object[] tavernOptions = {"Go to sleep", "Buy food"};
        Object[] buyFoodOptions = {"Chicken", "Lobster", "Dragon Egg", "Back"};
        Object[] amountOfFood = {"1", "2", "3", "4", "5"};

        //declares and initializes all custom icons used throughout the game
        ImageIcon warningIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\warning_icon.png");
        ImageIcon battleIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\Battle_Icon.png");
        ImageIcon escapeDeniedIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\escapeDenied.png");
        ImageIcon escapeIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\escape.png");
        ImageIcon bookIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\book.png");
        ImageIcon winIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\crown.png");
        ImageIcon deathIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\death.png");
        ImageIcon questionIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\question.png");
        ImageIcon goodByeIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\bye.png");
        ImageIcon updateStatsIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\statsUp.png");
        ImageIcon foodIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\food.png");
        ImageIcon chickenIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\chicken.png");
        ImageIcon lobsterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\lobster.png");
        ImageIcon dragonEggIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\dragonEgg.png");
        ImageIcon noFoodIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\hungry.png");
        ImageIcon villageIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\village.png");
        ImageIcon tavernIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\tavern.png");
        ImageIcon buyFoodIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\buyingFood.png");
        ImageIcon successIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\success.png");
        ImageIcon errorIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\error.png");
        ImageIcon forestIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\forest.png");
        ImageIcon evolveIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\evolve.png");

        //declares and initializes variables to keep track of various events that take place throughout the game. Description detailing specifics further along in the code
        int userDamage = 0, enemyDamage = 0, userClicked = -1, foodChoice = -1, eatChoice = -1, foodHealth = 0, visitTown = 0, tavernChoice = -1, buyOption = -1, foodCost = 0;
        //declares escaped to keep track of whether user has escaped or not
        boolean escaped, hasEvolved = false;
        //declares and initializes the rules to the preset message and food to null which will be updated when the user selects what he/she wants
        String rules = "\n 1)This is a turn based game \n 2) Every turn you can choose to attack, eat food, run away(small chance), view your stats, view your enemies stats, or view the rules again \n 3) Every time you kill an enemy you get 8-12 EXP and when you hit 80 EXP you evolve to your next form, increase your stats, and gain full HP back \n 4) You will gain 5 health points back in between fights \n 5) Each time you kill 4 enemies you will come across a town where you will gain full health back from sleeping and can shop for items at \n 6) If you escape a fight, you will not get experience points or added health";
        String food = "", userAmount = null, fighterType = "";

        //If the game just started or while the user did not click on the "quit" button and wants to continue fighting after the last enemy he/she killed
        while(userClicked != 1){
            //for every four turns that have passed the user will visit a town
            if(visitTown / 4 == 1){
                //reset visitTown so that on the 4th turn, the user can go back to the town
                visitTown = 0;

                //display visit town window
                JOptionPane.showMessageDialog(null, "Among your travels in the woods, you have unexpectedly \ncome across a thriving village!", "Town!", JOptionPane.INFORMATION_MESSAGE, villageIcon); 
                //display tavern visit window and prompt user to either go to sleep or buy food
                tavernChoice = JOptionPane.showOptionDialog(null, "Upon entering the local tavern, the bartender happily greets you and offers you a place to sleep free of charge. \nYou happily accept his offer and he also offers you some food he has for sale in the kitchen! What do you want\nto do?", "Town!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, tavernIcon, tavernOptions, null); 

                //while the user has not chosen to go to sleep
                while(tavernChoice != 0 ){
                    //user selects food he/she wants to buy or goes back to Tavern window
                    buyOption = JOptionPane.showOptionDialog(null,"Please select something to buy! Listed below are your options \nCurrent gold pouch: " + userFighter.getGold(), "Buy Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, buyFoodIcon, buyFoodOptions, null);

                    //if the user selects "Chicken", "Lobster", or "Dragon Egg" display the appropriate window and initialize foodCost and food to the food items' respective stats
                    if(buyOption == 0){
                        userAmount = (String)JOptionPane.showInputDialog(null, "Description: An absolute classic. Who doesn't love a tasty chicken with just the right amount of seasoning!\nHealth Boost: +10 health\nCost: 15 gold \nPlease select how many Chicken(s) you want to buy.", "Buy Food", JOptionPane.QUESTION_MESSAGE, chickenIcon, amountOfFood, "0");
                        foodCost = 15;
                        food = "Chicken";
                    }
                    else if(buyOption == 1){
                        userAmount = (String)JOptionPane.showInputDialog(null, "Description: A lobster so fresh it will practically pinch you with it's claws if you're not fast enough to eat it!\nHealth Boost: +15 health \nCost: 20 gold \nPlease select how many Lobster(s) you want to buy.", "Buy Food", JOptionPane.QUESTION_MESSAGE, lobsterIcon, amountOfFood, "0");
                        foodCost = 20;
                        food = "Lobster";
                    }
                    else if(buyOption == 2){
                        userAmount = (String)JOptionPane.showInputDialog(null, "Description: A mysterious Dragon egg stolen from a mother's nest. Be careful not to keep it too long or the egg will hatch!\nHealth Boost: +20 health\nCost: 25 gold\nPlease select how many Dragon Egg(s) you want to buy.", "Buy Food", JOptionPane.QUESTION_MESSAGE, dragonEggIcon, amountOfFood, "0");
                        foodCost = 25;
                        food = "Dragon Egg";
                    }
                    //else the user has chosen to go back and display the tavern window again
                    else tavernChoice = JOptionPane.showOptionDialog(null, "Upon entering the local tavern, the bartender happily greets you and offers you a place to sleep free of charge. \nYou happily accept his offer and he also offers you some food he has for sale in the kitchen! What do you want\nto do?", "Town!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, tavernIcon, tavernOptions, null);

                    //if the user has selected one of the food items(chicken, lobster, or Dragon Egg) and he/she can afford the amount of that specific food they want, execute the following code:
                    if(userAmount != null && userFighter.enoughMoney(foodCost * Integer.parseInt(userAmount))){
                        //cost is equal to the price of the food multiplied by how many of that item he/she wants. Call the buyItem method to subtract the foodCost from the user's fighter
                        foodCost *= Integer.parseInt(userAmount);
                        userFighter.buyItem(foodCost);

                        //add the specific food and quantity to the user's inventory
                        userFighter.addFood(food, Integer.parseInt(userAmount));

                        //display a window to successfully show that the user has bought the food and the quantity he/she wants
                        JOptionPane.showOptionDialog(null, "You have successfully bought " + userAmount + " " + food + "('s)", "Purchase Complete", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, successIcon, backOption, null);
                    }
                    //if the user clicked on a specific amount of food but could not afford it print a window telling them
                    else if(userAmount != null) {
                        JOptionPane.showOptionDialog(null, "Sorry, but you do not have enough money to buy " + userAmount + " " + food + "('s)", "Purchase Error", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, errorIcon, backOption, null);
                    }
                    //reset userAmount used in loop to default value to prevent any unwanted side effects when looping again
                    userAmount = null;
                }
                //reset all variables used in loop to default values to prevent any unwanted side effects 
                userAmount = null;
                foodCost = 0;
                food = "";
                tavernChoice = -1;
                buyOption = -1;

                //restore user's current health to max
                userFighter.addHealth(1000);

                //display a window to tell user he/she has entered back into the forest and that their health is fully restored
                JOptionPane.showMessageDialog(null, "After a nice day of rest, you thank the bartender and you gain full HP back\nas you head back into the forest to continue your journey.", "Journey Continued!", JOptionPane.INFORMATION_MESSAGE, forestIcon);
                JOptionPane.showOptionDialog(null, "Your health has been fully restored", "Stats Update", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, updateStatsIcon, backToFightButton, null);
            }
            
            //reset escaped to false just incase the user has escaped
            escaped = false;

            //randomly pick either a "0" or a "1" 
            int pickEnemy = (int)(Math.random() * 3);
            //Depending on the result, initialize the enemy fighter to that value (0 = human, 1 = goblin, 2 = beast)
            if(pickEnemy == 0)
                enemyFighter = new Human();
            else if (pickEnemy == 1)
                enemyFighter = new Goblin();
            else enemyFighter = new Beast();

            //set the enemy's weapon icon and fighter icon to something different than the user's preset icons just incase they have the same fighter
            enemyFighter.setEnemyWeaponIcon();
            enemyFighter.setEnemyFighterIcon();

            //set up a JOptionPane to display to the user the that the enemy that was just created has approached them and he/she is entering a new fight
            JOptionPane.showOptionDialog(null,"You have encountered a wild " + enemyFighter.getFighterType() + " lurking in the wilderness! \nIt is beginning to charge at you! Do something quick!", "Approaching Enemy!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, warningIcon, beginFightButton, null);

            //while both the user and enemy are not dead and the user hasn't escaped execute the following part of the game
            while(!userFighter.isDead() && !enemyFighter.isDead() && !escaped){
                //sets up and stores the result of the main fighting JOptionPane with the custom buttons that allow the user to: attack, run away, eat food, view his/her stats, view the enemy's stats, and look at the kombat rules again
                userClicked = JOptionPane.showOptionDialog(null, "You are currently fighting a " + enemyFighter.getFighterType() + ". What do you want to do? \nYour Health: " + userFighter.getHealth() + " / " + userFighter.getMaxHealth() + "\nEnemy Health: " + enemyFighter.getHealth() + " / " + enemyFighter.getMaxHealth(), "Battle!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, battleIcon, battleOptions, null);

                //if the user clicked on "Attack"
                if(userClicked == 0){
                    //substract the user's damage dealt by the enemy's defense
                    userDamage = userFighter.getAttack() - enemyFighter.getDefense();

                    //Display the user's method of attacking an enemy
                    if(userFighter.getFighterType().equals("Human"))
                        JOptionPane.showMessageDialog(null, "You slashed the " + enemyFighter.getFighterType() + " and dealt " + userDamage + " Damage!", "Attack!", JOptionPane.INFORMATION_MESSAGE, userFighter.getWeaponIcon()); 
                    else if(userFighter.getFighterType().equals("Goblin"))
                        JOptionPane.showMessageDialog(null, "You clubbed the " + enemyFighter.getFighterType() + " and dealt " + userDamage + " Damage!", "Attack!", JOptionPane.INFORMATION_MESSAGE, userFighter.getWeaponIcon());
                    else if(userFighter.getFighterType().equals("Beast"))
                        JOptionPane.showMessageDialog(null, "You clawed the " + enemyFighter.getFighterType() + " and dealt " + userDamage + " Damage!", "Attack!", JOptionPane.INFORMATION_MESSAGE, userFighter.getWeaponIcon());
                    else if(userFighter.getFighterType().equals("Ogre"))
                        JOptionPane.showMessageDialog(null, "You smashed the " + enemyFighter.getFighterType() + " with your giant club and dealt " + userDamage + " Damage!", "Attack!", JOptionPane.INFORMATION_MESSAGE, userFighter.getWeaponIcon());
                    else if(userFighter.getFighterType().equals("Knight"))
                        JOptionPane.showMessageDialog(null, "You lacerated the " + enemyFighter.getFighterType() + " with your Mithril sword and dealt " + userDamage + " Damage!", "Attack!", JOptionPane.INFORMATION_MESSAGE, userFighter.getWeaponIcon());
                    else if(userFighter.getFighterType().equals("Dragon"))
                        JOptionPane.showMessageDialog(null, "You scorched the " + enemyFighter.getFighterType() + " with your fiery breath and dealt " + userDamage + " Damage!", "Attack!", JOptionPane.INFORMATION_MESSAGE, userFighter.getWeaponIcon());
                    //substract the enemy's health by the user's total damage given
                    enemyFighter.loseHealth(userDamage);
                    //if you killed the enemy
                    if(enemyFighter.isDead()){
                        //add 8 - 12 EXP to the user's stats
                        int exp = (int)(Math.random() * 5) + 8;
                        userFighter.addExperiencePoints(exp);

                        //adds 5 - 15 gold to the user's pouch
                        int gold = (int)(Math.random() * 11) + 5;
                        userFighter.addGold(gold);

                        //add 5 health as a bonus for every time the user kills an enemy
                        userFighter.addHealth(5);

                        //display a victory JOptionPane and an increase in health and exp stats JOptionPane
                        JOptionPane.showMessageDialog(null, "You have slayed a " + enemyFighter.getFighterType() + "! \nCongratulations on your victory!", "Victor", JOptionPane.INFORMATION_MESSAGE, winIcon);
                        JOptionPane.showMessageDialog(null, "Your experience has increased by " + exp + " points! \nYour health has increased by 5 points! \nYou have found " + gold + " pieces of Gold!", "Stats Update", JOptionPane.INFORMATION_MESSAGE, updateStatsIcon);

                        //if the user has not evolved before and has over 100XP
                        if(!hasEvolved && userFighter.evolve()){
                            fighterType = userFighter.getFighterType();

                            /*update the user's fighter to it's evolved form and update it's stats as well.
                            note that the getDefense() and getAttack() methods return an interval with a deviation of one so the stat boost may increase by one or two points*/
                            if(fighterType.equals("Goblin"))
                                userFighter = new Ogre((int)(userFighter.getMaxHealth() * 1.25), (int)(userFighter.getAttack() + 1), (int)(userFighter.getDefense() + 1), (int)(userFighter.getExperiencePoints()), userFighter.getGold(), "Ogre", userFighter.getInventory());
                            //if the user is a Human, update the user's fighting information to a Knight and give the respective stat boosts
                            else if(fighterType.equals("Human")){
                                userFighter = new Knight((int)(userFighter.getMaxHealth() * 1.25), (int)(userFighter.getAttack() + 1), (int)(userFighter.getDefense() + 1), (int)(userFighter.getExperiencePoints()), userFighter.getGold(), "Knight", userFighter.getInventory());
                            }
                            else userFighter = new Dragon((int)(userFighter.getMaxHealth() * 1.25), (int)(userFighter.getAttack() + 1), (int)(userFighter.getDefense() + 1), (int)(userFighter.getExperiencePoints()), userFighter.getGold(), "Dragon", userFighter.getInventory());

                            //update hasEvolved so the user can't evolve anymore
                            hasEvolved = true;
                            //display in a window that the user's fighter has evolved 
                            JOptionPane.showMessageDialog(null, "Your " + fighterType + " has evolved into a " + userFighter.getFighterType() + "!", "Evolve!", JOptionPane.INFORMATION_MESSAGE, evolveIcon);
                            //display in another window the user's new evolved gif and stats
                            JOptionPane.showOptionDialog(null, "Listed below are your fighting stats: \n" + userFighter.toString(), "Stats", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, userFighter.getFighterIcon(), backToFightButton, null);
                        }
                    }
                }
                //if the user clicked on "escape"
                else if(userClicked == 1){
                    //user has a 1/8 chance of escaping and if he does not display a failed JOptionPane otherwise display a success JOptionPane and update escaped to true
                    if((int)(Math.random() * 8) + 1 != 8)
                        JOptionPane.showMessageDialog(null, "Attempt to run away has failed!", "Escape", JOptionPane.INFORMATION_MESSAGE, escapeDeniedIcon);
                    else{
                        JOptionPane.showMessageDialog(null, "You have successfully escaped the enemy! ", "Escape", JOptionPane.INFORMATION_MESSAGE, escapeIcon);
                        escaped = true;
                    }
                }
                //if the user clicked on "eat food"
                else if(userClicked == 2){
                    //while the user does not click on "back to fight"
                    while(foodChoice != 3){
                        //display a window giving the user the option to eat a "Chicken", "Lobster", "Dragon Egg" or just go back to the fight
                        foodChoice = JOptionPane.showOptionDialog(null,"Please select something to eat! Listed below are your options \n and your current food inventory: " + "\n" + userFighter.getFoodInventory(), "Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, foodIcon, foodChoices, null);

                        //if the user clicked on any of the food items, pop up the appropriate window with the information about that specific food item as well as setting foodHealth and food variables to their respective values of that food item 
                        if(foodChoice == 0){
                            eatChoice = JOptionPane.showOptionDialog(null, "An absolute classic. Who doesn't love a tasty chicken with just \nthe right amount of seasoning! Gives a +10 health boost", "Eat Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, chickenIcon, eatOptions, null);
                            foodHealth = 10; 
                            food = "Chicken";
                        }
                        if(foodChoice == 1){
                            eatChoice = JOptionPane.showOptionDialog(null, "A lobster so fresh it will practically pinch you with it's claws \nif you're not fast enough to eat it! Gives a +15 health boost", "Eat Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, lobsterIcon, eatOptions, null);
                            foodHealth = 15;
                            food = "Lobster";
                        }
                        if(foodChoice == 2){
                            eatChoice = JOptionPane.showOptionDialog(null, "A mysterious Dragon egg stolen from a mother's nest. Be careful \nnot to keep it too long or the egg will hatch! Gives a +20 health boost", "Eat Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, dragonEggIcon, eatOptions, null);
                            foodHealth = 20;
                            food = "Dragon Egg";
                        }

                        //if the user has selected to eat the food item
                        if(eatChoice == 0){
                            //if the user's Fighter has that food item left then remove one from its inventory
                            if(userFighter.eatFood(food)){
                                //add to the user's health that specific food item
                                userFighter.addHealth(foodHealth);

                                //display in a window to the user how much his/her figher's health points have gone up and their current health
                                JOptionPane.showOptionDialog(null, "Your health has increased by " + foodHealth + " points! \nCurrent Health: " + userFighter.getHealth() + " / " + userFighter.getMaxHealth(), "Stats Update", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, updateStatsIcon, backOption, null);
                            }
                            //else display that the user did not have any more quantity left of that specific food item 
                            else JOptionPane.showOptionDialog(null,"Sorry but you do not have anymore " + food + "s left. ", "No Food", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, noFoodIcon, backOption, null);
                            //reset eatChoice used in loop to default value to prevent any unwanted side effects when looping again
                            eatChoice = -1;
                        }
                    }
                    //reset all variables used in loop to default values to prevent any unwanted side effects
                    eatChoice = -1;
                    foodChoice = -1;
                    foodHealth = 0;
                    food = "";
                }
                //if user clicked on "Your stats" display in a window all of the user's fighting stats of his/her character
                else if(userClicked == 3){
                    JOptionPane.showOptionDialog(null, "Listed below are your fighting stats: \n" + userFighter.toString(), "Stats", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, userFighter.getFighterIcon(), backToFightButton, null);
                }
                //if the user clicked on "enemy stats" display in a window all of the enemy's fighting stats
                else if(userClicked == 4){
                    JOptionPane.showOptionDialog(null, "Listed below are your enemy's fighting stats: \n" + enemyFighter.toString(), "Enemy Stats", JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, enemyFighter.getFighterIcon(), backToFightButton, null);
                }
                //if the user clicked on "Rules of Kombat" display in a window the rules of the game
                else if(userClicked == 5){
                    JOptionPane.showOptionDialog(null, rules, "Rules of the Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, bookIcon, backToFightButton, null);
                }
                //if the enemy is not dead and the user clicked on either attack or escape(both take up a turn) and the user has not escaped
                if(!enemyFighter.isDead() && userClicked <= 1 && !escaped){
                    //calculate enemy damage 
                    enemyDamage = enemyFighter.getAttack() - userFighter.getDefense();
                    //If your defense is too high and blocks out all of the enemies attack give them a 1 attack hit
                    if(enemyDamage <= 0) 
                        enemyDamage = 1;

                    //display enemy damage dealt to you in a window with the correct verb for attack based on Fighter type
                    if(enemyFighter.getFighterType().equals("Human"))
                        JOptionPane.showMessageDialog(null, "The enemy " + enemyFighter.getFighterType() + " slashed you and dealt " + enemyDamage + " Damage!", "Enemy Attack!", JOptionPane.INFORMATION_MESSAGE, enemyFighter.getWeaponIcon()); 
                    else if(enemyFighter.getFighterType().equals("Goblin"))
                        JOptionPane.showMessageDialog(null, "The enemy " + enemyFighter.getFighterType() + " whacked you and dealt " + enemyDamage + " Damage!", "Enemy Attack!", JOptionPane.INFORMATION_MESSAGE, enemyFighter.getWeaponIcon());
                    else if(enemyFighter.getFighterType().equals("Beast"))
                        JOptionPane.showMessageDialog(null, "The enemy " + enemyFighter.getFighterType() + " clawed you and dealt " + enemyDamage + " Damage!", "Enemy Attack!", JOptionPane.INFORMATION_MESSAGE, enemyFighter.getWeaponIcon());   
                    
                    //substract user's health by enemy damage given
                    userFighter.loseHealth(enemyDamage);

                    //if the user is dead then display a window telling the user and exit the game
                    if(userFighter.isDead()){
                        JOptionPane.showOptionDialog(null, "You have died in battle with great honor and dignity. \nMay you rest in peace fellow warrior.", "Death!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, deathIcon, exitGameButton, null);   
                        System.exit(0);
                    }
                }
            }
            //for every turn that has passed, increment visitTown by one
            visitTown++;
            //after every battle ask the user if he/she wants to continue
            userClicked = JOptionPane.showOptionDialog(null, "Do you want to continue fighting or exit the game?", "User Prompt", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, questionIcon, gameOptions, null);
        }
        //thank the user for playing the game after quitting
        JOptionPane.showMessageDialog(null, "Thank you for playing Mortal Kombat! Have a nice day!", "Goodbye", JOptionPane.INFORMATION_MESSAGE, goodByeIcon);
    }
}
