package com.github.wdeqin.flyit.web.experiment.designpattern;

import java.util.concurrent.TimeUnit;

public class SingletonInnerClass {
	
	private long id;
	
	private SingletonInnerClass() {
		System.out.println("new Singleton()");
		id = System.currentTimeMillis();
	}
	
	public long getId() {
		return id;
	}

	private static class InstanceHolder {
		
		private static final SingletonInnerClass instance = new SingletonInnerClass();
		
	}
	
	public static SingletonInnerClass getInstance() {
		return InstanceHolder.instance;
	}
	
	public static void main(String[] args) {
		System.out.println("waiting...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException unused) {
			// do nothing
		}
		System.out.println("started");
		int threadCnt = 5;
		for (int i = 0; i < threadCnt; i++) {
			new Thread() {
				
				@Override
				public void run() {
					long id = SingletonInnerClass.getInstance().getId();
					System.out.println(String.format("%s: %d", Thread.currentThread().getName(), id));
				}
				
			}.start();
		}
	}
	
}
