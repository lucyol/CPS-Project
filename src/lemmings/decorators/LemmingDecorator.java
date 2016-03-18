package lemmings.decorators;

import lemmings.components.Lemming;
import lemmings.services.Direction;
import lemmings.services.GameEngService;
import lemmings.services.LemmingService;
import lemmings.services.Type;

public class LemmingDecorator implements LemmingService {

	protected LemmingService delegate;
	
	public LemmingDecorator(LemmingService delegate){
		this.delegate = delegate; 
	}

	public Type getType() {
		return delegate.getType();
	}

	public Direction getDirection() {
		return delegate.getDirection();
	}

	public int getX() {
		return delegate.getX();
	}

	public int getY() {
		return delegate.getY();
	}

	public int getFalling() {
		return delegate.getFalling();
	}

	public GameEngService getGameEng() {
		return delegate.getGameEng();
	}

	public void init(int x, int y) {
		delegate.init(x, y);
	}

	public void changeDir() {
		delegate.changeDir();
	}

	public void changeType(Type t) {
		delegate.changeType(t);
	}

	public void step() {
		delegate.step();
	}


	

}
