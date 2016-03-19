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
	public boolean isGameOver();
	
	/*
	 * pre: 
	 * 		score(G) require gameOver(G)
	 */		 	
	public Score getScore(); 	
	public int getNbTurn(); 	
	public List<LemmingService> getLemmings(); 	
	public int getSaved(); 	
	public int getSpawned(); 
	public int getDead(); 
	public LevelService getLevel(); 
		
	/* Invariant */
	
	/*
	 *  getSpawned() min= getLemmings().size() + getSaved() + getDead()
     *  isGameOver() min= (lemmings().size() == 0 && getSpawned() == getSizeColony())
    -*  obstacle(x,y) min= getLevel().getNature(x,y) != EMPTY	
	 */
	
	
	/* Initializer */
	
	/* pre: 
	 * 		sc > 0 and sp > 0
	 * post: 
	 * 		getSizeColony() = sc
	 * 		getSpawnSpeed() = sp
	 * 		getSpawned() = 0
	 * 		getSaved() = 0
	 *  	getDead() = 0y
     *		isGameOver() = false 
     * 		getLemmings() = empty List
     * 		getnbTurn() = 0
	 */
	public void init(int sc, int sp); 

	
	/* Operators */
	
	/* pre: 
	 * 		spawn(G) require getSpawned() < getSizeColony()
	 * post: 
	 * 		getSpawned() = getSpawned()@pre + 1
	 *  	getNbTurn() = nbTurn()@pre
     *		getSaved() = saved()@pre
     *		getDead() = dead()@pre 
     *		getLemmings() = getLemmings()@pre.add(lemming)
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
	public void kill(LemmingService l); 
	
	/* pre: 
	 * 		getLemmings().contains(l)
	 * post: 
	 * 		getNbTurn() == nbTurn()@pre
     *		getSaved() == saved()@pre + 1
     *		getDead() == dead()@pre
     *		getLemmings() == getLemmings()@pre.remove(l)	
	 */
	public void save(LemmingService l); 
	
	/* post: 
	 * 		getNbTurn() == getNbTurns()@pre + 1
	 */
	public void step();
	
}
