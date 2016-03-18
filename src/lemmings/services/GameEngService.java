package lemmings.services;

import java.util.List;
import lemmings.components.Lemming;

public interface GameEngService {
	
	/* Observators */
	
	/*
	 * pre: 
	 * 		obstacle(G,i,j) require i < Level::height(level(G)) and j < Level::width(level(G)) 
	 */
	public boolean isObstacle(int x, int y); 
	public int getSizeColony(); 	
	public int getSpawnSpeed(); 
	
	/*
	 * pre: 
	 * 		score(G) require gameOver(G)
	 */	
	public boolean isGameOver(); 	
	public Score getScore(); 	
	public int getNbTurns(); 	
	public List<Lemming> getLemmings(); 
	
	/*
	 * pre: 
	 * 		pre getLemming(G,i) require i >= 0 and card(lemmings(G)) > i
	 */	
	public Lemming getLemming(int n); 	
	public int getSaved(); 	
	public int getSpawned(); 

		
	/* Invariant */
	
	/*
	 *  spawned(G) min= card(lemmings(G)) + saved(G) + dead(G)
     *  gameOver(G) min= (card(lemmings(G)) == 0 && spawned(G) == sizeColony(G))
    -*  obstacle(G,x,y) min= Level::nature(level(G),x,y) != EMPTY	
	 */
	
	
	/* Initializer */
	
	/* pre: 
	 * 		sc > 0 and sp > 0
	 * post: 
	 * 		getSizeColony() = sc
	 * 		getSpawnSpeed() = sp
	 * 		getLemmingCreated() = 0
	 * 		getLemmingSaved() = 0
	 *  	getDead() = 0
     *		isGameOver() = false 
     * 		getLemmings() = empty List
	 */
	public void init(int sc, int sp); 

	
	/* Operators */
	
	/* pre: 
	 * 		spawn(G) require lemmingCreated(G) < sizeColony(G)
	 * post: 
	 * 		getLemmingCreated() = getLemmingCreated()@pre + 1
	 *  	getNbTurn() = nbTurn()@pre
     *		getSaved() = saved()@pre
     *		getDead() = dead()@pre 
     *		getLemmings() = lemmings()@pre.add(lemming)
	 */
	public void spawn(); 
	
	/* pre: 
	 * 		getLemmings().contains(l)
	 * post: 
	 * 		getNbTurn() == nbTurn()@pre
     *		getSaved() == saved()@pre
     *		getDead() == dead()@pre + 1
     *		getLemmings() == getLemmings()@pre.remove(l)
	 */	
	public void kill(Lemming l); 
	
	/* pre: 
	 * 		getLemmings().contains(l)
	 * post: 
	 * 		getNbTurn() == nbTurn()@pre
     *		getSaved() == saved()@pre + 1
     *		getDead() == dead()@pre
     *		getLemmings() == getLemmings()@pre.remove(l)	
	 */
	public void save(Lemming l); 
	
	/* post: 
	 * 		getNbTurn() == getNbTurns()@pre + 1
	 */
	public void step();
	
}
