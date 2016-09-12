package com.github.wdeqin.flyit.web.experiment.concurrent;

public class NewThread {
	public static void main(String[] args) {
		new Thread() {
			{
				setDaemon(true);
				start();
			}
			
			@Override
			public void run() {
				System.out.println("hello, world!");
			}
		};
		
		new Thread() {
			{
				setDaemon(true);
			}
			
			@Override
			public void run() {
				System.out.println("hello, world!");
			}
		}.start();
	}
}
