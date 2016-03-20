package lemmings.main;

import lemmings.components.GameEng;
import lemmings.components.Level;
import lemmings.contracts.LevelContract;
import lemmings.services.LevelService;
import lemmings.services.Nature;

public class LemmingsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Level level = new Level(); 
		GameEng gameEng = new GameEng(); 
		
		level.init(6,50); 
		gameEng.init(10, 3); 
		
		gameEng.bindLevelService(level); 
		
		for(int i =0; i<level.getWidth(); i++){
			level.setNature(i, 0, Nature.METAL); 
			level.setNature(i, level.getHeight()-1,Nature.METAL); 
		}
		for(int j = 0; j<level.getHeight(); j++){
			level.setNature(0, j, Nature.METAL); 
			level.setNature(level.getWidth()-1, j, Nature.METAL); 
		}
		
		level.goPlay(5, 3, 48, 4); 
		gameEng.affichage(); 
		
		while(!gameEng.isGameOver()){
			gameEng.step(); 
			gameEng.affichage(); 
		}
		System.out.println("GAME OVER!!");
		System.out.println("Votre score est : "+gameEng.getScore().toString()); 
	}

}
