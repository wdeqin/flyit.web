package com.github.wdeqin.flyit.web.experiment.concurrent;

public class ThreadRunnable extends Thread implements Runnable {
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread t = new ThreadRunnable(100, i);
			t.start();
		}
	}
	private int max;
	private int min;
	
	public ThreadRunnable(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	
	@Override
	public void run() {
		int cur = max;
		while(cur > min) {
			System.out.println(String.format("%s: %d", this.getName(), cur--));
		}
	}

}
