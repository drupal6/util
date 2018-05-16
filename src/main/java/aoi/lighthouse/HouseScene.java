package aoi.lighthouse;

import java.util.HashMap;
import java.util.Map;

public class HouseScene {
	
	private int nodeXSize = 10;
	
	private int nodeYSize = 10;
	
	private Map<Integer, HouseNode> nodeMap = new HashMap<>();
	private Map<String, HouseEntry> entryMap = new HashMap<>();
	
	public HouseScene(int scenXSize, int scenYSize) {
		int xNodeSize = scenXSize/nodeXSize;
		int yNodeSize = scenYSize/nodeYSize;
		for(int x = 0; x <= xNodeSize; x ++) {
			for(int y = 0; y <= yNodeSize; y ++) {
				nodeMap.put((x << 16 + y), new HouseNode(this));
			}
		}
	}
	
	private int getNodeId(int x, int y) {
		return (x/nodeXSize << 16 + y/nodeYSize);
	}
	
	public void add(HouseEntry entry) {
		entryMap.put(entry.key, entry);
	}
	
	public void enter(int nodeId, HouseEntry entry) {
		nodeMap.get(nodeId).enter(entry);
	}
	
	public void leave(int nodeId, HouseEntry entry) {
		nodeMap.get(nodeId).leave(entry);
	}
	
	public void move(HouseEntry entry, int x, int y) {
		int oldNodeId = getNodeId(entry.x, entry.y);
		int newNodeId = getNodeId(x, y);
		if(oldNodeId != newNodeId) {
			leave(oldNodeId, entry);
			enter(newNodeId, entry);
		}
		entry.x = x;
		entry.y = y;
	}
	
	public void notice(String key, String msg) {
		System.out.println(entryMap.get(key).key + " msg:" + msg);
	}
	
	public static void main(String[] args) {
		HouseScene scen = new HouseScene(100, 100);
		for(int x = 1; x < 100; x++) {
			for(int y = 1; y < 100; y++) {
				int nodeId = scen.getNodeId(x, y);
				HouseEntry entry = new HouseEntry(x + "-" +y, x, y);
				scen.add(entry);
				scen.enter(nodeId, entry);
			}
		}
	}
}
