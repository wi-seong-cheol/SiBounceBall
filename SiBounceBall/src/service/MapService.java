package service;

import java.util.ArrayList;
import java.util.List;

import dto.MapDto;

public class MapService {
	List<MapDto> MapList = new ArrayList<MapDto>();
	int levelNum = 0; 
	
	public MapService() {
	      
	      /* DB O 
	      try {
	         MapList = Dao.getInstance().getMapList();
	         levelNum = MapList.size();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      */
	      
	      /* DB X */
	      MapList tmp = new MapList();
	      MapList = tmp.getMapList();
	      levelNum = MapList.size();
	      
	   }

	// getter
	public List<MapDto> getMapList() {
		return MapList;
	}

	public int getLevelNum() {
		return levelNum;
	}
}
