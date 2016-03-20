package lemmings.components;

import lemmings.services.LevelService;
import lemmings.services.Nature;

public class Level implements 
	/*provides*/ LevelService {
	
	
	private int height; 
	private int width; 
	private boolean editing; 
	private Nature[][] nature; 
	private int entranceX; 
	private int entranceY; 
	private int exitX; 
	private int exitY; 

	
	public Level(){
		
	}
	
	/* Observators */
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public boolean isEditing() {
		return editing;
	}
	public int getEntranceX() {
		return entranceX;
	}
	public int getEntranceY() {
		return entranceY;
	}
	public int getExitX() {
		return exitX;
	}
	public int getExitY() {
		return exitY;
	}
	public Nature getNature(int x, int y){
		return nature[x][y]; 
	}
	
	
	/* Initializer */
	
	public void init(int h, int w){
		height = h; 
		width = w;
		nature = new Nature[w][h]; 
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				nature[i][j] = Nature.EMPTY; 
			}
		}
		editing = true; 
	}
	
	/* Operators */
	
	public void goPlay(int xe, int ye, int xs, int ys){
		entranceX = xe; 
		entranceY = ye; 
		exitX = xs; 
		exitY = ys; 
		editing = false; 	
	}
	
	public void remove(int x, int y){
		nature[x][y] = Nature.EMPTY; 
	}
	
	public void build(int x,int y){
		nature[x][y] = Nature.DIRT;
	}

	public void setNature(int x, int y, Nature n) {
		nature[x][y] = n; 
	}
	
}
