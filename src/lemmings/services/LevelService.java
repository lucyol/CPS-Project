package lemmings.services;

public interface LevelService {
	
	/* Observators */
	
	public int getHeight(); 
	public int getWidth(); 
	public boolean isEditing(); 
	public Nature getNature(int x, int y);
	
	/* Invariants */

	
	/* Initializer */
	
	//pre :  h > 10 && w > 10
	
	public void init(int h, int w); 
	
	//post: getHeight(init(h,w)) = h
	//post: getWidth(init(h,w)) = w
	//post: editing(init(h,w)) = true
	//post: nature(init(h,w),x,y) = Nature.EMPTY
	
	
	/* Operators */
	
	/*pre: isEditing() == true
	 *post: isEditing() == true
	 *post: for i == x and j == y  getNature(i,j) = n   
	 *      for i != x or j != y getNature(i,j) = getNature(i,j)@pre 
	 */
	public void setNature(int x, int y, Nature n);
	
	/* pre: 
	 * post: editing() = false
	 * post: getNature(i,j) = getNature(i,j)@pre
	 */
	public void goPlay(); 
	
	
	/* pre: getNature(x,y) == Nature.DIRT
	 * pre: isEditing() == false 
	 * post: isEditing() == false
	 * post: for i == x and j == y  getNature(i,j) = Nature.EMPTY  
	 *       for i != x or j != y getNature(i,j) = getNature(i,j)@pre 
	 */
	public void remove(int x, int y); 
	
	
	/* pre: getNature(x,y) == Nature.EMPTY
	 * pre: isEditing() == false
	 * post: isEditing() == false
	 * post: for i == x and j == y  getNature(i,j) = Nature.DIRT 
	 *       for i != x or j != y getNature(i,j) = getNature(i,j)@pre 
	 */
	public void build(int x, int y); 
	
}
