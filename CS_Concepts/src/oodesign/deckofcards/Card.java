package oodesign.deckofcards;

public class Card {
	public enum Suit{
		CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);
		int val;
		private Suit(int v) { this.val = v; }
	}
	
	private int card; private Suit suit;

	public Card(int card, Suit suit) {
		this.card = card;
		this.suit = suit;
	}

	public int value(){return this.card;}
	public Suit suit(){return this.suit;}

//  UNCOMMENT BELOW TO DEBUG
//	public static void main(String[] args){
//			Card c1 = new Card(1, Suit.CLUBS);
//			Card c2 = new Card(1, Suit.DIAMONDS);
//			Card c3 = new Card(1, Suit.HEARTS);
//			Card c4 = new Card(1, Suit.SPADES);
//			
//			System.out.println(c1.value());
//			System.out.println(c2.value());
//			System.out.println(c3.value());
//			System.out.println(c4.value());
//			
//	}
	
}

