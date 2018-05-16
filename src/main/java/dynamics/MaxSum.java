package dynamics;

/**
 * ��ȡ����������
 * @author Administrator
 *
 */
public class MaxSum {
	private int[] d = {-1, 4, -1, 2, -3, 2, 2, 4};
	
	public static void main(String[] args) {
		MaxSum maxSum = new MaxSum();
		maxSum.dynamics();
	}
	
	public void dynamics() {
		int osum = 0;
		int ostart = 0;
		int oend = 0;
		
		int tsum = 0;
		int tstart = 0;
		for(int tend = 1; tend <= d.length; tend++) {
			int sum1 = sum(tstart, tend);
			if(sum1 < 0) {
				tstart = tend;
				continue;
			}
			if(sum1 > tsum) {
				tsum = sum1;
				if(osum < tsum) {
					osum = tsum;
					ostart = tstart;
					oend = tend;
				}
			}
		}
		
		System.out.println("osum=" + osum + " ostart=" + ostart + " oend=" + oend);
	}
	
	public int sum(int start, int end) {
		int sum = 0;
		for(int i = start; i < end; i++) {
			sum += d[i];
		}
		return sum;
	}
}
