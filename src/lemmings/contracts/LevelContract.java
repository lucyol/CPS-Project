package lemmings.contracts;

import lemmings.contracts.Contractor;
import lemmings.components.Level;
import lemmings.decorators.LevelDecorator;
import lemmings.services.LevelService;
import lemmings.services.Nature;

public class LevelContract extends LevelDecorator  {

	public LevelContract(LevelService level) {
		super(level);
	}
	
	public void checkInvariants(){
		//Rien à verifier
	}

	@Override
	public void init(int h, int w){
		
		//pre h >= 5 && w >= 15 
		if(!(h>=5 && w >= 15)){
			Contractor.defaultContractor().preconditionError("LevelService","init","Level size");
		}
		
		//run 
		super.init(h, w); 
		
		checkInvariants(); 
		
		//post 
		if(!(getHeight() == h)){
			Contractor.defaultContractor().postconditionError("LevelService","init","Level height");
		}
		if(!(getWidth() == w)){
			Contractor.defaultContractor().postconditionError("LevelService","init","Level width");
		}
		if(!(isEditing() == true)){
			Contractor.defaultContractor().postconditionError("LevelService","init","editing == false");
		}	
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				if(!(getNature(i,j) == Nature.EMPTY)){
					Contractor.defaultContractor().postconditionError("LevelService","init","nature != EMPTY");
				}
			}
		}
		if(!(getEntranceX() == 0)){
			Contractor.defaultContractor().postconditionError("LevelService","init","entranceX != 0");
		}
		if(!(getEntranceY() == 0)){
			Contractor.defaultContractor().postconditionError("LevelService","init","entranceY != 0");
		}
		if(!(getExitX() == 0)){
			Contractor.defaultContractor().postconditionError("LevelService","init","exitX != 0");
		}
		if(!(getExitY() == 0)){
			Contractor.defaultContractor().postconditionError("LevelService","init","exitY != 0");
		}
		
		
	}
	
	@Override
	public void setNature(int x, int y, Nature n){
		//pre 
		if(!(isEditing() == true)){
			Contractor.defaultContractor().preconditionError("LevelService","setNature","editing == false");
		}
		if(!(x < getHeight())){
			Contractor.defaultContractor().preconditionError("LevelService","setNature","x > h");
		}
		if(!(y < getWidth())){
			Contractor.defaultContractor().preconditionError("LevelService","setNature","y > w");
		}
		
		//capture
		Nature nature_at_pre[][] = new Nature[getHeight()][getWidth()]; 
		for(int i = 0; i<getHeight(); i++){
			for(int j = 0; j<getWidth(); j++){
				nature_at_pre[i][j] = getNature(i,j); 
			}
		}
		boolean isEditing_at_pre = isEditing(); 
		
		checkInvariants(); 
		
		super.setNature(x,y,n); 
		
		checkInvariants(); 
		
		//post 
		if(!(isEditing() == true)){
			Contractor.defaultContractor().postconditionError("LevelService","setNature","editing == false");
		}
		
		if(!(getNature(x,y) == n)){
			Contractor.defaultContractor().postconditionError("LevelService","setNature","getNature(x,y) != n");
		}
		for(int i = 0; i<getHeight(); i++){Contractor.defaultContractor().postconditionError("LevelService","setNature","getNature(x,y) != n");
			for(int j = 0; j<getWidth(); j++){
				if(i != x && j != y){
					if(!(nature_at_pre[i][j] == getNature(i,j))){
						Contractor.defaultContractor().postconditionError("LevelService","setNature","getNature(i,j) != nature_at_pre");
					}
				}
			}
		}
	}

	@Override
	public void  goPlay(int xe, int ye, int xs, int ys){
		//pre
		if(!(isEditing() == true))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","editing == false");
		if(!(getNature(getExitX(),getExitY()) == Nature.METAL))
				Contractor.defaultContractor().preconditionError("LevelService","goPlay","La case de la sortie doit etre METAL");
		if(!(getNature(getEntranceX(),getEntranceY()) == Nature.EMPTY))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","La case de l'entree doit etre EMPTY");
		if(!(getNature(getEntranceX(),getEntranceY() - 1) == Nature.EMPTY))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","La case en dessous de l'entree doit etre EMPTY");
		if(!(getNature(getEntranceX(),getEntranceY() + 1) == Nature.EMPTY))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","La case au dessus de l'entree doit etre EMPTY");
		if(!(getNature(getExitX(),getExitY() + 1) == Nature.METAL))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","La case en dessous de la sortie doit etre METAL");
		if(!(getNature(getExitX(),getExitY() - 1) == Nature.EMPTY))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","La case au dessus de l'entree doit etre EMPTY");
		if(!(xe < getHeight()))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","xe > h");
		if(!(ye < getWidth()))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","ye > w");
		if(!(xs < getHeight()))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","xs > h");
		if(!(ye < getWidth()))
			Contractor.defaultContractor().preconditionError("LevelService","goPlay","ys > w");
		for(int i = 0; i < getHeight(); i++){
			if(!(getNature(i,0) == Nature.METAL && getNature(i, getWidth()-1) == Nature.METAL))
				Contractor.defaultContractor().preconditionError("LevelService","goPlay","Border != METAL");
		}
		for(int j=0; j < getWidth(); j++){
			if(!(getNature(0,j) == Nature.METAL && getNature(getHeight()-1, j) == Nature.METAL))				
				Contractor.defaultContractor().preconditionError("LevelService","goPlay","Border != METAL");
		}
		
		//capture
		Nature nature_at_pre[][] = new Nature[getHeight()][getWidth()]; 
		for(int i = 0; i<getHeight(); i++){
			for(int j = 0; j<getWidth(); j++){
				nature_at_pre[i][j] = getNature(i,j); 
			}
		}
		
		checkInvariants(); 
		
		super.goPlay(xe, ye, xs, ys); 
		
		checkInvariants(); 
		
		//post
		if(!(isEditing() == false)){
			Contractor.defaultContractor().postconditionError("LevelService","goPlay","editing == true");
		}
		if(!(getEntranceX() == xe)){
			Contractor.defaultContractor().postconditionError("LevelService","goPlay","entranceX != xe");
		}
		if(!(getEntranceY() == ye)){
			Contractor.defaultContractor().postconditionError("LevelService","goPlay","entranceY != ye");
		}
		if(!(getExitX() == xs)){
			Contractor.defaultContractor().postconditionError("LevelService","goPlay","exitX != xs");
		}
		if(!(getExitY() == ys)){
			Contractor.defaultContractor().postconditionError("LevelService","goPlay","exitY != ys");
		}
		for(int i = 0; i < getHeight() ; i++){
			for(int j=0; j < getWidth(); j++) {	
			  	if(!(getNature(i,j) == nature_at_pre[i][j]))
			  		Contractor.defaultContractor().postconditionError("LevelService","goPlay","nature("+i+","+j+") != nature_at_pre");	  	
			}
		}
	}
	
	public void remove(int x, int y){
		//pre
		if(!(isEditing() == false)){
			Contractor.defaultContractor().preconditionError("LevelService","remove","editing == true");
		}
		if(!(x < getHeight())){
			Contractor.defaultContractor().preconditionError("LevelService","remove","x > h");
		}
		if(!(y < getWidth())){
			Contractor.defaultContractor().preconditionError("LevelService","remove","y > w");
		}
		if(!(getNature(x, y) == Nature.DIRT)){
			Contractor.defaultContractor().preconditionError("LevelService","remove","nature != DIRT");
		}
		
		//captures
		Nature nature_at_pre[][] = new Nature[getHeight()][getWidth()]; 
		for(int i = 0; i<getHeight(); i++){
			for(int j = 0; j<getWidth(); j++){
				nature_at_pre[i][j] = getNature(i,j); 
			}
		}
		boolean isEditing_at_pre = isEditing(); 
		
		checkInvariants(); 
		
		super.remove(x, y); 
		
		//post
		if(!(isEditing() == false)){
			Contractor.defaultContractor().postconditionError("LevelService","remove","editing == true");
		}
		if(!(getNature(x,y) == Nature.EMPTY))
			Contractor.defaultContractor().postconditionError("LevelService","remove","nature(x,y) != EMPTY");
		for(int i = 0; i < getHeight(); i++){
			for(int j =0; j< getWidth(); j++){
				if(j != y || i != x){
					if(!(getNature(i, j) == nature_at_pre[i][j])){
						Contractor.defaultContractor().postconditionError("LevelService","remove","nature(i,j) != nature_at_pre");
					}
				}
			}
		}
	}

	public void build(int x, int y){
		//pre
		if(!(isEditing() == false)){
			Contractor.defaultContractor().preconditionError("LevelService","build","editing == true");
		}
		if(!(x < getHeight())){
			Contractor.defaultContractor().preconditionError("LevelService","build","x > h");
		}
		if(!(y < getWidth())){
			Contractor.defaultContractor().preconditionError("LevelService","build","y > w");
		}
		if(!(getNature(x, y) == Nature.EMPTY)){
			Contractor.defaultContractor().preconditionError("LevelService","build","nature != EMPTY");
		}
		if(!(getEntranceX() == x))
			Contractor.defaultContractor().preconditionError("LevelService","build","x == entranceX");
		if(!(getEntranceY() == y))
			Contractor.defaultContractor().preconditionError("LevelService","build","y == entranceY");
		if(!(getExitX() == x))
			Contractor.defaultContractor().preconditionError("LevelService","build","x == exitX");
		if(!(getExitY() == y))
			Contractor.defaultContractor().preconditionError("LevelService","build","y == exitY");
		if(!(getExitY() == y - 1))
			Contractor.defaultContractor().preconditionError("LevelService","build","y-1 == exitY");

		//captures
		Nature nature_at_pre[][] = new Nature[getHeight()][getWidth()]; 
		for(int i = 0; i<getHeight(); i++){
			for(int j = 0; j<getWidth(); j++){
				nature_at_pre[i][j] = getNature(i,j); 
			}
		}
		boolean isEditing_at_pre = isEditing(); 

		checkInvariants(); 

		super.build(x, y); 
		
		checkInvariants(); 

		//post
		if(!(isEditing() == false)){
			Contractor.defaultContractor().postconditionError("LevelService","build","editing == true");
		}
		if(!(getNature(x,y) == Nature.DIRT))
			Contractor.defaultContractor().postconditionError("LevelService","buils","nature(x,y) != DIRT");
		for(int i = 0; i < getHeight(); i++){
			for(int j =0; j< getWidth(); j++){
				if(j != y || i != x){
					if(!(getNature(i, j) == nature_at_pre[i][j])){
						Contractor.defaultContractor().postconditionError("LevelService","build","nature(i,j) != nature_at_pre");
					}
				}
			}
		}
	}
}
