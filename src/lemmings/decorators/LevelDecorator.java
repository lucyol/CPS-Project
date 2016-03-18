package lemmings.decorators;

import lemmings.services.LevelService;
import lemmings.services.Nature;

public class LevelDecorator implements LevelService {
	
	private LevelService delegate;
	
	public LevelDecorator(LevelService delegate){
		this.delegate = delegate; 
	}

	public int getHeight() {
		return delegate.getHeight();
	}

	public int getWidth() {
		return delegate.getWidth();
	}

	public boolean isEditing() {
		return delegate.isEditing();
	}

	public Nature getNature(int x, int y) {
		return delegate.getNature(x, y);
	}

	public int getEntranceX() {
		return delegate.getEntranceX();
	}

	public int getEntranceY() {
		return delegate.getEntranceY();
	}

	public int getExitX() {
		return delegate.getExitX();
	}

	public int getExitY() {
		return delegate.getExitY();
	}

	public void init(int h, int w) {
		delegate.init(h, w);
	}

	public void setNature(int x, int y, Nature n) {
		delegate.setNature(x, y, n);
	}

	public void goPlay(int xe, int ye, int xs, int ys) {
		delegate.goPlay(xe, ye, xs, ys);
	}

	public void remove(int x, int y) {
		delegate.remove(x, y);
	}

	public void build(int x, int y) {
		delegate.build(x, y);
	} 

	
}
