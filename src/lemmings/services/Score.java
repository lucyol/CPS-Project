package lemmings.services;

public class Score {
	
	private float rate; 
	private int nbTurn; 
	
	public Score(float rate, int t){
		this.rate = rate; 
		this.nbTurn = t; 
	}

	public float getRate() {
		return rate;
	}

	public int getNbTurn() {
		return nbTurn;
	}

	public String toString(){
		return "("+rate+","+nbTurn+")"; 
	}
}
