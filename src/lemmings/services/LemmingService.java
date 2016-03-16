package lemmings.services;

public interface LemmingService {
	
	/* Observators */
	public Status getStatus();
	public int getX(); 
	public int getY(); 
	public Direction getDirection(); 
	
	/* Constructor */
	public void init(int x, int y);
	
	
	/* Operators */
	public void action(); 

}
