package lemmings.services;

public interface LevelService {
	
	/* Observators */
	
	public int getHeight(); 
	public int getWidth(); 
	public boolean isEditing(); 
	public Nature getNature(int x, int y);
	public int getEntranceX(); 
	public int getEntranceY(); 
	public int getExitX(); 
	public int getExitY(); 
	
	/* Invariants */

	
	/* Initializer */
	
	/*
	 * pre :  h > 5 && w > 10
	 */	
	public void init(int h, int w); 
	
	/* post: 
	 *		getHeight() = h
	 *		getWidth() = w
	 *		editing() = true
	 * 		nature(x,y) = Nature.EMPTY
	 * 		getEntranceX() = null
	 * 		getEntranceY() = null
	 * 		getExitX() = null
	 * 		getExitY() = null
	*/
	
	
	/* Operators */
	
	/*pre: 
	 * 		isEditing() == true
	 * 		x < getWidth()
	 * 		y < getHeight()
	 *post: 
	 *		isEditing() == true
	 *		for i == x and j == y  getNature(i,j) = n   
	 *      for i != x or j != y getNature(i,j) = getNature(i,j)@pre 
	 *      getEntranceX() == 0
	 *      getEntranceY() == 0
	 *      getExitX() == 0
	 *      getExitY() == 0
	 */
	public void setNature(int x, int y, Nature n);
	
	/* pre: 
	 *  	xe < getWidth()
	 * 		ye < getHeight()
	 * 		xs < getWidth()
	 * 		ys < getHeight()
	 * 		getNature(xe, ye) == EMPTY 
	 *  	getNature(xs, ys) == EMPTY
	 *     	getNature(xe, ye - 1) == EMPTY 
	 *     	getNature(xe, ye + 1) == EMPTY
	 *		getNature(xs, ys - 1) == EMPTY 
	 *		getNature(xs, ys + 1) == METAL
	 *		isEditing() == true
	 *		for(int i = 0; i < getHeight(); i++){
	 *			getNature(i,0) == METAL && getNature(i, getWidth()-1) == METAL
	 *		}
	 *		for(int j = 0; j < getWidth(); j++){
	 *			getNature(0,j) == METAL && getNature(getHeight()-1, j) == METAL
	 *		}
	 * 
	 * post: 
	 *  	editing() = false
	 * 		for(int i = 0; i < getHeight() ; i++)
	 * 			for(int j=0; j < getWidth(); j++)
	 * 				getNature(i,j) = getNature(i,j)@pre
	 * 		getEntranceX() = xe
	 * 		getEntranceY() = ye
	 * 		getExitX() = se
	 * 		getExitY() = ye
	 */
	public void goPlay(int xe, int ye, int xs, int ys); 
	
	
	/* pre: 
	 * 		getNature(x,y) == DIRT
	 * 		isEditing() == false 
	 * 		x < getWidth()
	 * 		y < getHeight()
	 * post: 
	 * 		isEditing() == false
	 * 		for i == x and j == y  getNature(i,j) == EMPTY  
	 *      for i != x or j != y getNature(i,j) == getNature(i,j)@pre 
	 * 		getEntranceX() = getEntranceX()@pre
	 * 		getEntranceY() = getEntranceY()@pre
	 * 		getExitX() = getExitX()@pre
	 * 		getExitY() = getExitY()@pre
	 */
	public void remove(int x, int y); 
	
	
	/* pre: 
	 * 		getNature(x,y) == EMPTY
	 * 		isEditing() == false
	 * 		x < getWidth()
	 * 		y < getHeight()
	 * 		x != getEntranceX()
	 * 		x != getExitX()
	 * 		y != getEntranceY()
	 * 		y != getExitY()
	 * 		y != getExitY() - 1
	 * post: 
	 * 		isEditing() == false
	 *  	for i == x and j == y  getNature(i,j) = Nature.DIRT 
	 *      for i != x or j != y getNature(i,j) = getNature(i,j)@pre  
	 *      getEntranceX() = getEntranceX()@pre
	 * 		getEntranceY() = getEntranceY()@pre
	 * 		getExitX() = getExitX()@pre
	 * 		getExitY() = getExitY()@pre
	 */
	public void build(int x, int y); 
	
}
