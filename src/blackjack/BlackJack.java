package blackjack;


import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
        

public class BlackJack {
    
    int[] values = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    
    public class Card {
        
        String rank;
        String suit;
        int value;

        Card(String r, String s){
            rank = r;
            suit = s;
            value = values[Arrays.asList(ranks).indexOf(rank)];
        }
        
        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }
    
    public class Deck {
        
        ArrayList<Card> cards = new ArrayList<>();
        
        Deck() {
            for(int i = 0; i < 13; i++) {
                for(int j = 0; j < 4; j++) {
                    cards.add(new Card(ranks[i], suits[j]));
                }            
            }
            Collections.shuffle(cards);
            
        }
    }
    
    public class Player {
        int chips, bet;
        String name;
        ArrayList<Card> hand;
        boolean busted;
        
       public Player(String n) {
           chips = 500;
           name = n;
           bet = 0;
           busted = false;
           hand = new ArrayList<>();
       } 
       
       public void hit(Card c){
           hand.add(c);
       }
       public void fold(){
           hand.clear();
           bet = 0;
           busted = true;
       }
       public void placeBet(int b){
           bet = b;
       }
    }
    
 public static void main(String[] args) {
     
     boolean mainloop = true;
     ArrayList<Player> players = new ArrayList<>();
     Scanner scn = new Scanner(System.in);
     
     int player_num;
     int offset = 0;
     String playerInput = "";
     Player playerNow;
     
     //START
     System.out.println("Welcome to BlackJack, made by Martin");
     
     //Num of players
     while(true) {
        System.out.printf("Enter the number of players(1-4): ");

        try{
            player_num = scn.nextInt();
        }
        catch (java.util.InputMismatchException e) {
            System.err.println("Wrong input! Enter an integer!");
            scn.nextLine();
            continue;
        }
        catch (Exception e){
            System.err.println(e);
            scn.nextLine();
            continue;
        }
        finally {
            scn.nextLine();
        }
        if(0 < player_num && player_num < 5){
            break;
        }
        else {
            System.err.println("Wrong range! Input an integer in range from 1 to 4");
        }
     }
         
    BlackJack bj = new BlackJack();
    BlackJack.Deck deck = bj.new Deck();
    for(int i = 0; i < player_num; i++){
        System.out.printf("Enter the name of player %d%n", i+1);
        players.add(bj.new Player(scn.nextLine()));
    }
    
    while(mainloop){
              
        //Betting phase
        for(int i = 0; i < player_num; i++){
            playerNow = players.get(((i+1+offset) % (player_num+1))-1);
            
            if(playerNow.chips == 0){
                continue;
            }
            
            System.out.printf("%s, you've got %d chips%nPlace a bet: ", playerNow.name, playerNow.chips);
            try{
                playerNow.bet = scn.nextInt();
            }
            catch(Exception e){
                System.out.println(e);
                i-= 1;
                continue;
            }
            finally{
                scn.nextLine();
            }
            //Too much?
            if(playerNow.bet > playerNow.chips){
                System.out.println("You have insufficient amount of chips!");
                i-= 1;
                continue;
            }
            //Too nothing?
            else if(playerNow.bet == 0){
                i-=1;
                System.out.println("Bet... something?");
                continue;
            }
            //Too negative?
            else if(playerNow.bet < 0){
                i-=1;
                System.out.println("Try using positive numbers");
                continue;
            }
            
            //Deal hands
            for(i = 0; i < player_num; i++){
                players.get(i).hit(deck.cards.remove(0));
                players.get(i).hit(deck.cards.remove(0));
            }
            
            //Play phase
            for(i = 0; i < player_num; i++){
            playerNow = players.get(((i+1+offset) % (player_num+1))-1);
            
                System.out.printf("%s, (H)it or (S)tand?%n");
                playerInput = scn.nextLine();
                if(playerInput.contains("H") || playerInput.contains("Hit") || playerInput.contains("hit")){
                    
                }
                else if(playerInput.contains("S") || playerInput.contains("Stand") || playerInput.contains("stand")){
                    
                }
            }
        }
    break;
    }
    }
    
}
