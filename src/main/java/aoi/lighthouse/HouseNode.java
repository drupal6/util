package aoi.lighthouse;

import java.util.ArrayList;
import java.util.List;

public class HouseNode {

	private HouseScene scen;
	
	List<String> entryKeyList;
	
	public HouseNode(HouseScene scen) {
		this.scen = scen;
		entryKeyList = new ArrayList<>();
	}
	
	public void enter(HouseEntry entry) {
		entryKeyList.add(entry.key);
		noticeAll(entry.key + " enter");
	}
	public void leave(HouseEntry entry) {
		entryKeyList.remove(entry.key);
		noticeAll(entry.key + " leave");
	}
	
	public void noticeAll(String msg) {
		for(String key : entryKeyList) {
			scen.notice(key, msg);
		}
	}
}
