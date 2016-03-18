package lemmings.decorators;

import java.util.List;

import lemmings.components.GameEng;
import lemmings.components.Lemming;
import lemmings.services.GameEngService;
import lemmings.services.LevelService;
import lemmings.services.Score;

public class GameEngDecorator implements GameEngService {

	private GameEngService delegate;
	
	public GameEngDecorator(GameEngService ge){
		this.delegate = ge; 
	}

	public boolean isObstacle(int x, int y) {
		return delegate.isObstacle(x, y);
	}

	public int getSizeColony() {
		return delegate.getSizeColony();
	}

	public int getSpawnSpeed() {
		return delegate.getSpawnSpeed();
	}

	public boolean isGameOver() {
		return delegate.isGameOver();
	}

	public Score getScore() {
		return delegate.getScore();
	}

	public int getNbTurns() {
		return delegate.getNbTurns();
	}

	public List<Lemming> getLemmings() {
		return delegate.getLemmings();
	}

	public Lemming getLemming(int n) {
		return delegate.getLemming(n);
	}

	public int getSaved() {
		return delegate.getSaved();
	}

	public int getSpawned() {
		return delegate.getSpawned();
	}

	public LevelService getLevel() {
		return delegate.getLevel();
	}

	public void init(int sc, int sp) {
		delegate.init(sc, sp);
	}

	public void spawn() {
		delegate.spawn();
	}

	public void kill(Lemming l) {
		delegate.kill(l);
	}

	public void save(Lemming l) {
		delegate.save(l);
	}

	public void step() {
		delegate.step();
	} 
	

}
