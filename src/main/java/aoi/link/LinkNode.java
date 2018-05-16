package aoi.link;

public class LinkNode {
	
	public LinkNode(String key, int x, int y) {
		this.key = key;
		this.x = x;
		this.y = y;
	}

	String key;
	int x;
	int y;
	
	LinkNode xPre;
	LinkNode xNext;
	
	LinkNode yPre;
	LinkNode yNext;
}
