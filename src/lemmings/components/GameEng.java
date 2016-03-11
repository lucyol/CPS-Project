package lemmings.components;

import lemmings.services.GameEngService;
import lemmings.services.LevelService;
import lemmings.services.RequireLevelService;

public class GameEng implements 
	/*provides*/GameEngService, 
	/*requires*/RequireLevelService {

	@Override
	public void bindLevelService(LevelService service) {
		// TODO Auto-generated method stub

	}

}
