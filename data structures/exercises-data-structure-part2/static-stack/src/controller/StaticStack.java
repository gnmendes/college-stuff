package controller;

public class StaticStack {
	private int[] arr;
	private int topo;
	private int top;
	private int capacityR;
	private int capacityL;

	public StaticStack() {
		arr = new int[100];
		capacityL = capacityR = topo = 0;
		top = 99;
	}

	public boolean push(int data, int xy) {
		
		if(xy == 1 && !isFull(1) && (capacity(1) + capacity(2) < 80)) {
			arr[top--] = data;	
			capacityR++;
			return true;
		}else if(xy == 2 && !isFull(2) && (capacity(1) + capacity(2) < 80)){
			arr[topo++] = data;	
			capacityL++;
			return true;
		}
		
		return false;
	}

	public int pop(int xy) {
		int popped = -1;

		if (xy == 1 && !isEmpty(1)) {
			popped = arr[top++];
		} else if (xy == 2 && !isEmpty(2)) {
			popped = arr[topo--];
		}

		return popped;
	}

	public boolean isEmpty(int coord) {
		if (coord == 1)
			return topo == 0;
		else
			return top == 99;

	}

	private boolean isFull(int coord) {
		if (coord == 1)
			return capacityR == 50;
		else
			return capacityL == 50;
	}

	public int capacity(int x) {
		if (x == 1)
			return capacityR;
		else
			return capacityL;
	}
}
