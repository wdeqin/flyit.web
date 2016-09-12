package com.github.wdeqin.flyit.web.experiment.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadCatchEx implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run() by " + t.getName());
		System.out.println("eh = " + t.getUncaughtExceptionHandler());
		throw new RuntimeException("I'm a runtime exception.");
	}
	
	private class SimpleUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("caught " + e);
		}
		
	}
	
	private class HandlerThreadFactory implements ThreadFactory {

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setUncaughtExceptionHandler(new SimpleUncaughtExceptionHandler());
			return t;
		}
		
	}
	
	public static void main(String[] args) {
		ThreadCatchEx r = new ThreadCatchEx();
		ExecutorService exec = Executors.newCachedThreadPool(r.new HandlerThreadFactory());
		exec.execute(r);
	}

}
