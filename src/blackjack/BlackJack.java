package blackjack;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        
//        Card[] cards = new ArrayList(Card[52]);
        ArrayList<Card> cards = new ArrayList<Card>();
        
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
        
       public Player(String n) {
           chips = 500;
           name = n;
           bet = 0;
       } 
    }

 public static void main(String[] args) {
     
     boolean mainloop = true;
     ArrayList<Player> players = new ArrayList<>();
     Scanner scn = new Scanner(System.in);
     
     int player_num;
     
     
     System.out.println("Welcome to BlackJack, made by Martin");
     while(true) {
     System.out.printf("Enter the number of players(1-4): ");         
     player_num = scn.nextInt();
     break;
     }
     
     while(mainloop){
         
         break;
     }
     
     
    BlackJack bj = new BlackJack();
    BlackJack.Deck deck = bj.new Deck();
    Card myCard = deck.cards.remove(0);
    System.out.println(myCard);
    }
    
}
