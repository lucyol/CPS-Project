package lemmings.contracts;

import lemmings.components.Lemming;
import lemmings.decorators.LemmingDecorator;
import lemmings.services.Direction;
import lemmings.services.LemmingService;
import lemmings.services.Type;

public class LemmingContract extends LemmingDecorator{

	public LemmingContract(LemmingService delegate) {
		super(delegate);
	}

	public void checkInvariant() {

	}
	
	@Override
	public void init(int x,int y){
		
		//pre
		if (!(x >= 0) || !(x >= 0 )) {
			Contractor.defaultContractor().preconditionError("LemmingService",
					"init", "getX() <= 0 or getY() <= 0");
			}

		
		super.init(x,y);
		checkInvariant();
		
		//post
		if(!(getType()== Type.valueOf("WALKER"))){
			Contractor.defaultContractor().preconditionError("LemmingService",
					"init", "Type != WALKER");
			
		}
		if(!(getDirection()==Direction.valueOf("RIGHT"))){
			Contractor.defaultContractor().preconditionError("LemmingService",
					"init", "Direction != RIGHT");
		}
		
		if(!(getX()==x) || !(getY()==y)){
			Contractor.defaultContractor().preconditionError("LemmingService",
					"init", "getX != x or getY != y");
		}
		
	}
	
	
	public void changeDir(){
		//pre 
		//No preconditions
		
		//captures
		Direction dir_at_pre = getDirection(); 
		Type type_at_pre = getType(); 
		int x_at_pre = getX(); 
		int y_at_pre = getY(); 
		int falling_at_pre = getFalling(); 
		
		checkInvariant(); 
		super.changeDir(); 
		checkInvariant(); 
		
		//post 
		if(dir_at_pre == Direction.RIGHT){
			if(!(getDirection() == Direction.LEFT))
				Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "RIGHT => RIGHT");
		}else{
			if(!(getDirection() == Direction.RIGHT))
				Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "LEFT => LEFT");
		}
		if(getType() != type_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "type changed");
		if(getX() != x_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "x changed");
		if(getY() != y_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "y changed");
		if(getFalling() != falling_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "falling changed");
		
	}
	
	public void changeType(Type t){
		//pre 
		//No preconditions

		//captures
		Direction dir_at_pre = getDirection(); 
		Type type_at_pre = getType(); 
		int x_at_pre = getX(); 
		int y_at_pre = getY(); 
		int falling_at_pre = getFalling(); 

		checkInvariant(); 
		super.changeType(t); 
		checkInvariant(); 

		//post 
		if(getDirection() != dir_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "dir changed");		
		if(getType() != t)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "wrong type");
		if(getX() != x_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "x changed");
		if(getY() != y_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "y changed");
		if(getFalling() != falling_at_pre)
			Contractor.defaultContractor().preconditionError("LemmingService","changeDir", "falling changed");


	}

	@Override
	public void step() {
		//pre
		//no preconditions
		
		//captures
		Direction dir_at_pre = getDirection(); 
		Type type_at_pre = getType(); 
		int x_at_pre = getX(); 
		int y_at_pre = getY(); 
		int falling_at_pre = getFalling(); 
		
		checkInvariant(); 
		delegate.step();
		checkInvariant(); 

		//post 
	}
}
