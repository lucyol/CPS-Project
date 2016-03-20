package lemmings.components;

import lemmings.services.Direction;
import lemmings.services.GameEngService;
import lemmings.services.RequireGameEngService;
import lemmings.services.LemmingService;
import lemmings.services.Type;

public class Lemming implements 
	/*provides*/ LemmingService, 
	/*requires*/ RequireGameEngService{
	private Type type; 
	private int x;
	private int y;
	private Direction direction;
	private int falling; 
	private GameEngService gameEng; 
	
	public Lemming(){	
	}		
	
	
	@Override
	public Type getType() {	
		return type;
	}

	@Override
	public int getX() {	
		return x;
	}

	@Override
	public int getY() {	
		return y;
	}

	@Override
	public Direction getDirection() {	
		return direction;
	}
	
	public int getFalling(){
		return falling; 
	}
	
	public GameEngService getGameEng(){
		return gameEng;
	}

	@Override
	public void init(int x, int y) {
		this.x=x;
		this.y=y;
		type = Type.WALKER; 
		direction = Direction.RIGHT; 
		gameEng = null; 
		falling = 0; 
	}
	
	public void bindGameEngService(GameEngService gameEng){
		this.gameEng = gameEng; 
	}
	
	public void changeDir(){
		if(direction == Direction.RIGHT){
			direction = Direction.LEFT; 
		}else{
			direction = Direction.RIGHT; 
		}
	}
	
	public void changeType(Type t){
		type = t; 
	}

	@Override
	public void step() {

		switch(type){
		case WALKER: 
			if(!gameEng.isObstacle(getX(), getY() + 1)){
				type = Type.FALLER; 				
			}else if (direction == Direction.RIGHT){
				if ((gameEng.isObstacle(getX()+1,getY()-1)) 
						|| (gameEng.isObstacle(getX()+1,getY()) && gameEng.isObstacle(getX()+1,getY()-2))){

					changeDir(); 	

				}else if (getGameEng().isObstacle(getX()+1,getY()) == true 
							&& getGameEng().isObstacle(getX()+1,getY()-1) == false
							&& getGameEng().isObstacle(getX()+1,getY()-2) == false){
					x = x+1;
					y = y-1;  

				}else if (getGameEng().isObstacle(getX()+1,getY()) == false 
						&& getGameEng().isObstacle(getX()+1,getY()-1)== false){

					x = x+1; 
				}
			}else if (direction == Direction.LEFT){
				if ((gameEng.isObstacle(getX()-1,getY()-1)) 
						|| (gameEng.isObstacle(getX()-1,getY()) && gameEng.isObstacle(getX()-1,getY()-2))){

					changeDir(); 	

				}else if (getGameEng().isObstacle(getX()-1,getY()) == true 
							&& getGameEng().isObstacle(getX()-1,getY()-1) == false
							&& getGameEng().isObstacle(getX()-1,getY()-2) == false){
					x = x-1;
					y = y-1;  

				}else if (getGameEng().isObstacle(getX()-1,getY()) == false 
							&& getGameEng().isObstacle(getX()-1,getY()-1)== false){

					x = x-1; 
				}
			}
			break; 
		case FALLER: 
			if (getGameEng().isObstacle(getX(),getY()+1)){
				if(getFalling() < 8){

					type = Type.WALKER; 
					falling = 0; 

				}else{

					gameEng.kill(this); 
				}

			}else{
				falling = falling + 1;
				y = y +1 ;
			}
			break;
		default : 
			System.out.println("Wrong type!");
			break; 
		}
	}
}
