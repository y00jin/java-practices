package prob5;

public class MyStack {
	private int top;
	private String[] buffer;
	
	public MyStack(int capacity) {
		top = -1;
		buffer = new String[capacity];
	}
	
	public void push(String s) {
		if(top == buffer.length - 1) {
			resize();
		}
		buffer[++top] = s;
	}
	
	public String pop() throws MyStackException {
		if(isEmpty()) {
			throw new MyStackException();
		}
		String result = buffer[top];
		buffer[top--] = null;
	
		return result;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void resize() {
		String[] temp = new String[buffer.length*2];
		for(int i = 0; i < buffer.length; i++) {
			temp[i] = buffer[i];
		}
		buffer = temp;
	}
}

/*public class MyStack {
	private int top;
	private String[] buffer;
	private int maxSize;
	private int size;
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public MyStack(int size) {
		this.top = -1;
		setSize(size);
		setMaxSize(size);
		this.buffer = new String[size];
	}
	
	public void push(String str) {
		if(top == buffer.length-1) {
			String[] bufferTemp = (String[])buffer.clone();
			setMaxSize(this.maxSize + this.size);
			this.buffer = new String[getMaxSize()];
			for(int i = 0; i<buffer.length;i++) {
				if(i<size)
					this.buffer[i] = bufferTemp[i];
				else 
					this.buffer[i] = null;
			}
		}
		this.buffer[++top] = str;
	}
	
	public String pop() throws MyStackException {
		if(isEmpty() == true)
			throw new MyStackException();
		else
			return buffer[top--];
	}

	public boolean isEmpty(){
		if(top == -1) 
			return true;
		else 
			return false;
	}
	
}*/