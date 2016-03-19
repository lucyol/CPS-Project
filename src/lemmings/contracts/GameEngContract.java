package lemmings.contracts;

import java.awt.List;
import java.util.ArrayList;

import lemmings.components.GameEng;
import lemmings.decorators.GameEngDecorator;
import lemmings.services.LemmingService;
import lemmings.services.Nature;

public class GameEngContract extends GameEngDecorator {

	public GameEngContract(GameEng delegate) {
		super(delegate);

	}
	
	public void checkInvariants(){
		
		if(!(getSpawned() == getLemmings().size() + getSaved() + getDead())){
			Contractor.defaultContractor().invariantError("GameEngService", "spawned");
		} 
		if(!(isGameOver() == (getLemmings().size() ==0) && (getSpawned() == getSizeColony()))){
			Contractor.defaultContractor().invariantError("GameEngService", "gameOver");
		}
		for(int i=0; i < getLevel().getHeight(); i++){
			for(int j=0; j < getLevel().getWidth(); j++ ){
				if(!(isObstacle(i,j) == (getLevel().getNature(i,j) != Nature.EMPTY))){
					Contractor.defaultContractor().invariantError("GameEngService", "isObstacle("+i+","+j+")");
				}
			}
		}		
	}
	
	public void init(int sc, int sp){
		
		//pre
		if(!(sp > 0))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "sp <= 0"); 
		if(!(sc > 0))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "sc <= 0");
		
		super.init(sc, sp); 
		
		//post
		if(!(getSizeColony() == sc))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "sizeColony != sc");
		if(!(getSpawnSpeed() == sc))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "spawnSpeed != sp");	
		if(!(getSpawned() == 0))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "spawned != 0");
		if(!(getSaved() == 0))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "saved != 0");
		if(!(getDead() == 0))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "dead != 0");
		if(!(getNbTurn() == 0))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "nbTurn != 0");
		if(!(isGameOver() == false))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "gameOver == false");
		if(!(getLevel() == null))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "level != null");
		if(!(getLemmings().isEmpty() == true))
			Contractor.defaultContractor().preconditionError("GameEng", "init", "lemmins != empty");
		
	}

	
	public void spawn(){
		//pre
		if(!(getSpawned() < getSizeColony())){
			Contractor.defaultContractor().preconditionError("GameEng", "spawn", "spawned < sizeColony"); 
		}
		
		//capture
		ArrayList<LemmingService> lemmings_at_pre = (ArrayList<LemmingService>) getLemmings();  
		int dead_at_pre = getDead();
		int saved_at_pre = getSaved(); 
		int nbTurn_at_pre = getNbTurn(); 
		
		checkInvariants(); 
		
		super.spawn(); 
		
		checkInvariants(); 
		
		//post
		if(!(dead_at_pre == getDead()))
			Contractor.defaultContractor().preconditionError("GameEng", "spawn", "dead != dead_at_pre");
		if(!(saved_at_pre == getSaved()))
			Contractor.defaultContractor().preconditionError("GameEng", "spawn", "saved != saved_at_pre");
		if(!(getNbTurn() == nbTurn_at_pre))
				Contractor.defaultContractor().preconditionError("GameEng", "spawn", "nbTurn != nbTurn_at_pre");
	}
	
	public void kill(LemmingService l){
		//pre
		if(!(getLemmings().contains(l)))
			Contractor.defaultContractor().preconditionError("GameEng", "kill", "lemming not in lemmings");

		//captures
		int dead_at_pre = getDead();
		int saved_at_pre = getSaved(); 
		int nbTurn_at_pre = getNbTurn(); 
				
		checkInvariants();
		super.kill(l); 
		checkInvariants(); 
		
		//post
		if(!(nbTurn_at_pre == getNbTurn()))
			Contractor.defaultContractor().postconditionError("GameEng", "kill", "nbTurn != nbTurn@pre");
		if(!(getSaved() == saved_at_pre))
			Contractor.defaultContractor().postconditionError("GameEng", "kill", "saved != saved@pre ");
		if(!(getDead() == dead_at_pre +1))
				Contractor.defaultContractor().postconditionError("GameEng", "kill", "dead != dead@pre +1");
		
	}
	
	public void save(LemmingService l){
		//pre
		if(!(getLemmings().contains(l)))
			Contractor.defaultContractor().preconditionError("GameEng", "save", "lemming not in lemmings");
		
		//captures
		int dead_at_pre = getDead();
		int saved_at_pre = getSaved(); 
		int nbTurn_at_pre = getNbTurn(); 
		
		checkInvariants(); 
		super.save(l); 
		checkInvariants(); 
		
		//post
		if(!(nbTurn_at_pre == getNbTurn()))
			Contractor.defaultContractor().postconditionError("GameEng", "save", "nbTurn != nbTurn@pre");
		if(!(getSaved() == saved_at_pre + 1))
			Contractor.defaultContractor().postconditionError("GameEng", "save", "saved != saved@pre + 1");
		if(!(getDead() == dead_at_pre))
				Contractor.defaultContractor().postconditionError("GameEng", "save", "dead != dead@pre");
		
	}
	
	public void step(){
		//pre
		if(isGameOver())
			Contractor.defaultContractor().preconditionError("GameEng", "step", "gameOver"); 
		
		//captures
		int nbTurn_at_pre = getNbTurn(); 
		
		checkInvariants(); 
		super.step(); 
		checkInvariants(); 
		
		//post
		if(!(nbTurn_at_pre +1 == getNbTurn()))
			Contractor.defaultContractor().postconditionError("GameEng", "step", "nbTurn != nbTurn@+1");
	}
}
