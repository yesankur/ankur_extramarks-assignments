package PoolThread;

import java.util.concurrent.LinkedBlockingQueue;

public class MyOwnThreadPool {
	private final int poolSize;
	private final PerformerThread[] w;
	private final LinkedBlockingQueue<Runnable> queue;

	public MyOwnThreadPool(int poolSize) {
		this.poolSize = poolSize;
		queue = new LinkedBlockingQueue<Runnable>();
		w = new PerformerThread[poolSize];

		for (int i = 0; i < poolSize; i++) {
			w[i] = new PerformerThread();
			w[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	private class PerformerThread extends Thread {
		public void run() {
			Runnable task;

			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
						}
					}
					task = (Runnable) queue.poll();
				}

				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public void shutdown() {
		System.out.println("Closing Thread pool");
		for (int i = 0; i < poolSize; i++) {
			w[i] = null;
		}
	}
}
