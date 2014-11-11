package oodesign.deckofcards;

public class BlackJackCard extends Card {

	public BlackJackCard(int r, Suit s){
		super(r,s);
	}
	
	@Override
	public int value() {
		int r = super.value();
		if(r==1) return 11;
		if(r<10) return r;
		return 10;
	}

	public boolean isAce(){
		return super.value()==1;
	}
	public static void main(String[] args) {
		BlackJackCard b1 = new BlackJackCard(3, Suit.CLUBS);
		
		System.out.println(b1.value());
		System.out.println(b1.isAce());
	}

}
