package aoi.link;

public class LinkScene {
	
	private LinkNode head;
	private LinkNode tail;
	
	public LinkScene() {
		head = new LinkNode("[head]", 0, 0);
		tail = new LinkNode("[tail]", 0, 0);
		
		head.xNext = tail;
		head.yNext = tail;
		tail.xPre = head;
		tail.yPre = head;
	}
	
	public LinkNode add(String key, int x, int y) {
		LinkNode node = new LinkNode(key, x, y);
		handle(node);
		return node;
	}
	
	public void leave(LinkNode node) {
		node.xPre.xNext = node.xNext;
		node.xNext.xPre = node.xPre;
		node.yPre.yNext = node.yNext;
		node.yNext.yPre = node.yPre;
		node.xPre = null;
		node.xNext = null;
		node.yPre = null;
		node.yNext = null;
	}
	
	public void move(LinkNode node, int x, int y) {
		leave(node);
		node.x = x;
		node.y = y;
		handle(node);
	}
	
	private void handle(LinkNode node) {
		LinkNode cur = head.xNext;
		while(cur != null) {
			if(cur.x > node.x || cur.key.equals("[tail]")) {
				node.xNext = cur;
				node.xPre = cur.xPre;
				cur.xPre.xNext = node;
				cur.xPre = node;
				break;
			}
			cur = cur.xNext;
		}
		
		cur = head.yNext;
		while(cur != null) {
			if(cur.y > node.y || cur.key.equals("[tail]")) {
				node.yNext = cur;
				node.yPre = cur.yPre;
				cur.yPre.yNext = node;
				cur.yPre = node;
				break;
			}
			cur = cur.yNext;
		}
	}
	
	public void preinAoi(LinkNode node, int xLen, int yLen) {
		//����
		LinkNode cur = node.xNext;
		while (false == cur.key.equals("[tail]")) {
			if(cur.x - node.x > xLen) {
				break;
			} else {
				if(Math.abs(node.y - cur.y) <= yLen) {
					System.out.println("next key:" + cur.key + " x=" + cur.x + " y=" + cur.y);
				}
			}
			cur = cur.xNext;
		}
		//��ǰ
		cur = node.xPre;
		while (false == cur.key.equals("[head]")) {
			if(node.x - cur.x > xLen) {
				break;
			} else {
				if(Math.abs(node.y - cur.y) <= yLen) {
					System.out.println("pre key:" + cur.key + " x=" + cur.x + " y=" + cur.y);
				}
			}
			cur = cur.xPre;
		}
	}
	
	public void print() {
		LinkNode cur = head.xNext;
		while(cur != null) {
			System.out.println("xkey=" + cur.key + " x=" + cur.x + " y=" + cur.y);
			cur = cur.xNext;
		}
		cur = head.yNext;
		while(cur != null) {
			System.out.println("ykey=" + cur.key + " x=" + cur.x + " y=" + cur.y);
			cur = cur.yNext;
		}
	}
	
	public static void main(String[] args) {
		int xlen = 3;
		int ylen = 3;
		LinkScene scen = new LinkScene();
		scen.add("1-1", 1, 1);
		scen.add("1-2", 1, 2);
		scen.add("1-3", 1, 3);
		scen.add("1-4", 1, 4);
		scen.add("1-5", 1, 5);
		scen.add("1-6", 1, 6);
		scen.add("1-7", 1, 7);
		scen.add("1-8", 1, 8);
		scen.add("1-9", 1, 9);
		scen.add("2-1", 2, 1);
		scen.add("2-2", 2, 2);
		scen.add("2-3", 2, 3);
		scen.add("2-4", 2, 4);
		scen.add("2-5", 2, 5);
		scen.add("2-6", 2, 6);
		scen.add("2-7", 2, 7);
		scen.add("2-8", 2, 8);
		scen.add("2-9", 2, 9);
		scen.add("3-1", 3, 1);
		scen.add("3-2", 3, 2);
		scen.add("3-3", 3, 3);
		scen.add("3-4", 3, 4);
		scen.add("3-5", 3, 5);
		scen.add("3-6", 3, 6);
		scen.add("3-7", 3, 7);
		scen.add("3-8", 3, 8);
		scen.add("3-9", 3, 9);
		scen.add("4-1", 4, 1);
		scen.add("4-2", 4, 2);
		scen.add("4-3", 4, 3);
		scen.add("4-4", 4, 4);
		scen.add("4-5", 4, 5);
		scen.add("4-6", 4, 6);
		scen.add("4-7", 4, 7);
		scen.add("4-8", 4, 8);
		scen.add("4-9", 4, 9);
		scen.add("5-1", 5, 1);
		scen.add("5-2", 5, 2);
		scen.add("5-3", 5, 3);
		scen.add("5-4", 5, 4);
		scen.add("5-5", 5, 5);
		scen.add("5-6", 5, 6);
		scen.add("5-7", 5, 7);
		scen.add("5-8", 5, 8);
		scen.add("5-9", 5, 9);
		scen.add("6-1", 6, 1);
		scen.add("6-2", 6, 2);
		scen.add("6-3", 6, 3);
		scen.add("6-4", 6, 4);
		scen.add("6-5", 6, 5);
		scen.add("6-6", 6, 6);
		scen.add("6-7", 6, 7);
		scen.add("6-8", 6, 8);
		scen.add("6-9", 6, 9);
		scen.add("7-1", 7, 1);
		scen.add("7-2", 7, 2);
		scen.add("7-3", 7, 3);
		scen.add("7-4", 7, 4);
		scen.add("7-5", 7, 5);
		scen.add("7-6", 7, 6);
		scen.add("7-7", 7, 7);
		scen.add("7-8", 7, 8);
		scen.add("7-9", 7, 9);
		scen.add("8-1", 8, 1);
		scen.add("8-2", 8, 2);
		scen.add("8-3", 8, 3);
		scen.add("8-4", 8, 4);
		scen.add("8-5", 8, 5);
		scen.add("8-6", 8, 6);
		scen.add("8-7", 8, 7);
		scen.add("8-8", 8, 8);
		scen.add("8-9", 8, 9);
		scen.add("9-1", 9, 1);
		scen.add("9-2", 9, 2);
		scen.add("9-3", 9, 3);
		scen.add("9-4", 9, 4);
		scen.add("9-5", 9, 5);
		scen.add("9-6", 9, 6);
		scen.add("9-7", 9, 7);
		scen.add("9-8", 9, 8);
		scen.add("9-9", 9, 9);
		LinkNode node = scen.add("6-6", 6, 6);
		scen.preinAoi(node, xlen, ylen);
//		scen.print();
	}
}
