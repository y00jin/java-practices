package prob6;

public class Div {
	private int rVal = 0;
	private int lVal = 0;
	
	public void setValue(int r, int l) {
		this.rVal = r;
		this.lVal = l;
	}
	
	public double calculate() {
		return (double)this.rVal / (double)this.lVal;
	}
}
