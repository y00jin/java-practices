package prob6;

public class Add {

	private int rVal = 0;
	private int lVal = 0;
	
	public void setValue(int r, int l) {
		this.rVal = r;
		this.lVal = l;
	}
	
	public int calculate() {
		return this.rVal + this.lVal;
	}
	
}
