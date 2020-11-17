package service;

import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import dto.MapDto;

public class MapService {

	List<MapDto> MapList = new ArrayList<MapDto>();
	int levelNum = 0; 
	
	public MapService() {
		
		try {
			MapList = Dao.getInstance().getMapList();
			levelNum = MapList.size();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// getter
	public List<MapDto> getMapList() {
		return MapList;
	}

	public int getLevelNum() {
		return levelNum;
	}
	
	
	
}
