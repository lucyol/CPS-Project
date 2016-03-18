package lemmings.services;

public interface LemmingService {
	
	/* Observators */
	public Type getType();
	public Direction getDirection(); 
	public int getX(); 
	public int getY(); 
	public int getFalling(); 
	public GameEngService getGameEng(); 
	
	/* Invariants */
	/* 
	 * Pas d'invariants
	 */
	
	/* Initializers */
	
	/*	post: 
	 * 		getType() = Type.WALKER
	 *		getDirection() = Direction.RIGHT
	 *		getX() = x
	 *		getY() = y 
	 *		getGameEngine() = null
	 *		getFalling() = 0
	*/
	public void init(int x, int y);
	
	/* Operators */
	
	
	/* post:
	 *  	getType() = getType()@pre
     *	 	getDirection() = if(getDirection()@pre == RIGHT) { LEFT } else { RIGHT }
     *		getX() = getX()@pre
     *		getY() = getY()@pre
     *		getFalling() = getFalling()@pre
	 */
	public void changeDir();
	
	/* post:
	 *  	getType() = t
     *	 	getDirection() = getDirection()@pre
     *		getX() = getX()@pre
     *		getY() = getY()@pre
     *		getFalling() = getFalling()@pre
	 */
	public void changeType(Type t); 
	
	/* post: 
	 * 		if(getType == WALKER)
	 * 			if(getGameEng().isObstacle(getX()@pre, getY()@pre + 1)	
	 *  			getType() = FALLER
	 *				getDirection() = direction()@pre
	 *				getX() = getX()@pre
	 *		  		getY() = getY()@pre
	 *  			gegetX() = getX()@pre
	 *		  		getY() = getY()@pretFalling() =  0
	 *			else if (getType() == RIGHT) 
	 *  			if ((getGameEng().isObstacle(getX()@pre+1,getY()@pre-1) == true) || 
	 *				   (getGameEng().isObstacle(getX()@pre+1,getY()@pre) == true && 
	 *					getGameEng().isObstacle(getX()@pre+1,getY()@pre-2) == true)))
	 *						getType() = WALKER
	 *						getDirection() = LEFT	    
	 *						getX() = getX()@pre
	 *		  				getY() = getY()@pre
	 *						getFalling() = 0
	 *				else if (getGameEng().isObstacle(getX()@pre+1,getY()@pre) == true 
	 *  	    			&& getGameEng().isObstacle(getX()@pre+1,getY()@pre-1) == false
	 *  					&& getGameEng().isObstacle(getX()@pre+1,getY()@pre-2) == false)
	 *	    	    	    getType() = WALKER
	 *						getDirection() = RIGHT	    
	 *						getX() = getX()@pre
	 *		  				getY() = getY()@pre - 1
	 *						getFalling() = 0	  
     *
	 *  			else if (getGameEng().idObstacle(getX()@pre+1,getY()@pre) == false 
	 *  	    			&& getGameEng().idObstacle(getX()@pre+1,getY()@pre-1)== false)
	 *	       				getType() = WALKER
	 *						getDirection() = RIGHT	    
	 *						getX() = getX()@pre + 1
	 *		  				getY() = getY()@pre 
	 *						getFalling() = 0
     *			else if type(L) == LEFT then idem

     * 		if type(L) == FALLER then
     *			if (getGameEng().isObstacle(getX()@pre,getY()@pre+1) == true && getFalling() < 8)
	 *				getType() = WALKER
	 *				getDirection() = getDirction()@pre    
	 *				getX() = getX()@pre 
	 *		  		getY() = getY()@pre 
	 *				getFalling() = 0
	 *			else if (getGameEng().isObstacle(getX()@pre,getY()@pre+1) == true && getFalling() >= 8)
	     			gameEngine(step(L)) = GameEng::kill(L)
	  			else if GameEng::obstacle(gameEng(L),x(L),y(L)+1) == false then
	 *					    getType() = FALLER
	 *						getDirection() = getDirection()@pre	    
	 *						getX() = getX()@pre 
	 *		  				getY() = getY()@pre + 1
	 *						getFalling() = getFalling()@pre +1 
	 */
	public void step(); 

}
