package lemmings.services;

public interface GameEngService {
	
	/* Observators */
	
	public boolean isObstacle(int x, int y); 
	
	public int getSizeColony(); 
	
	public int getSpawnSpeed(); 
	
	public boolean isGameOver(); 
	
	public Score getScore(); 
	
	public int getNbTurns(); 
	
	public List<Lemming> getColony(); 
	
	public Lemming getLemming(int n); 
	
	public int getSaved(); 
	
	public int getSpawned(); 
	
	
	
	/* Invariant */
	
	//getScore = (getLemmingCreated/getSizeColony*100, getNbTurns)
	
	
	
	/* Initializer */
	
	/* pre: sc > 0 and sp > 0
	 * post: getSizeColony() = sc
	 * post: getSpawnSpeed() = sp
	 * post: getLemmingCreated() = 0
	 * post: getLemmingSaved() = 0
	 * 
	 */
	public void init(int sc, int sp); 

	
	/* Operators */
	
	/* pre: spawn(G) require lemmingCreated(G) < sizeColony(G)
	 * post: getLemmingCreated() = getLemmingCreated()@pre + 1
	 * post: 
	 */
	
	public void spawn(); 
	
}
