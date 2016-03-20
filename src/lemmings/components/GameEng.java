package lemmings.components;

import java.util.ArrayList;
import java.util.List;
import lemmings.services.GameEngService;
import lemmings.services.LemmingService;
import lemmings.services.LevelService;
import lemmings.services.Nature;
import lemmings.services.RequireLevelService;
import lemmings.services.Score;

public class GameEng implements 
	/*provides*/GameEngService, 
	/*requires*/RequireLevelService {

	private LevelService level; 
	private int sizeColony; 
	private int spawnSpeed; 
	private ArrayList<LemmingService> lemmings; 
	private int dead; 
	private int saved; 
	private int spawned;
	private int nbTurn; 
	
	public GameEng(){
		
	}
	
	/* Observators */
	
	public LevelService getLevel() {
		return level;
	}

	public int getSizeColony() {
		return sizeColony;
	}

	public int getSpawnSpeed() {
		return spawnSpeed;
	}

	public List<LemmingService> getLemmings() {
		return lemmings;
	}

	public int getDead() {
		return dead;
	}

	public int getSaved() {
		return saved;
	}

	public int getSpawned() {
		return spawned;
	}

	public int getNbTurn() {
		return nbTurn;
	}
	
	public boolean isObstacle(int x, int y){
		return level.getNature(x, y) != Nature.EMPTY; 
	}
	
	public boolean isGameOver(){
		return (lemmings.size() == 0 && spawned == sizeColony); 
	}
	
	public Score getScore(){
		return new Score(((float)saved/(float)spawned)*100,nbTurn); 
	}
	
	/* Initializer */
	public void init(int sc, int sp){
		sizeColony = sc; 
		spawnSpeed = sp;
		spawned = 0;
		saved = 0;
		dead = 0;
		level = null; 
		nbTurn  = 0; 
		lemmings = new ArrayList<LemmingService>(); 
	}
	
	
	public void bindLevelService(LevelService level){
		this.level = level; 
	}
	
	
	public void spawn(){
		LemmingService le = new Lemming(); 
		le.init(level.getEntranceX(), level.getEntranceY()); 
		((Lemming) le).bindGameEngService(this); 
		lemmings.add(le); 
		spawned = spawned + 1; 
	}
	
	public void kill(LemmingService l){
		dead = dead + 1; 
		lemmings.remove(l); 
	}
	
	public void save(LemmingService l){
		saved = saved + 1; 
		lemmings.remove(l); 
	}
	
	public void step(){
		
		if(nbTurn % spawnSpeed == 0 && spawned < sizeColony){
			spawn(); 
		}
		
		for(int i= 0; i< lemmings.size(); i++){
			LemmingService lem = lemmings.get(i); 
			lem.step(); 
			
			if(lem.getX() == level.getExitX() && lem.getY() == level.getExitY()){
				save(lem); 
			}
		}
		nbTurn = nbTurn + 1; 
	}
	
	public void affichage(){
		char [][] cases = new char[level.getWidth()][level.getHeight()]; 
		
		for(int i =0; i < level.getWidth(); i++ ){
			for(int j=0; j < level.getHeight(); j++){
				Nature cell = level.getNature(i, j); 
				switch(cell){
				case EMPTY: 
					cases[i][j] = ' ';
					break; 
				case DIRT: 
					cases[i][j] = 'D'; 
					break; 
				case METAL: 
					cases[i][j] = 'M'; 
					break; 
				}
			}
		}
		
		cases[level.getEntranceX()][level.getEntranceY()] = 'E'; 
		cases[level.getExitX()][level.getExitY()] = 'S';
		
		for(LemmingService lem : lemmings){
			cases[lem.getX()][lem.getY()] = 'R'; 
		}

		//Printing
		
		StringBuilder sb = new StringBuilder(); 

		for(int j =0; j < level.getHeight(); j++ ){
			for(int i=0; i < level.getWidth(); i++){
				sb.append(cases[i][j]); 
			}
			sb.append("\n"); 
		}
		
		System.out.println(sb);
	}

}
