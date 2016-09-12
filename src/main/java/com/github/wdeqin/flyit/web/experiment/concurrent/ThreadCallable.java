package com.github.wdeqin.flyit.web.experiment.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadCallable implements Callable<Integer> {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newCachedThreadPool();
		int cnt = 10;
		ArrayList<Future<Integer>> fs = new ArrayList<Future<Integer>>(cnt);
		for (int i = 0; i < cnt; i++) {
			Callable<Integer> c = new ThreadCallable(i + 10, i);
			Future<Integer> futureSum = service.submit(c);
			fs.add(futureSum);
		}
		
		int complete = 0;
		while (complete < cnt) {
			for (int i = cnt - 1; i >= 0; i--) {
				if (fs.get(i).isDone()) {
					try {
						System.out.println(String.format("Sum(%d, %d) = %d", i, i + 10, fs.get(i).get().intValue()));
					} catch (InterruptedException e) {
						throw e;
					} catch (ExecutionException e) {
						throw e;
					} finally {
						complete++;
						if (complete >= cnt) {
							break;
						}
					}
				}
			}
		}
	}
	
	private int max;
	private int min;
	
	public ThreadCallable(int max, int min) {
		super();
		this.max = max;
		this.min = min;
	}
	
	@Override
	public Integer call() throws Exception {
		int cur = max;
		int total = 0;
		while (cur >= min) {
			total += cur;
			cur--;
		}
		TimeUnit.SECONDS.sleep(max / 10);
		return total;
	}
}
