package ThreadSeqesnce;

public class ThreadRunningInSequence {

	public static void main(String[] args) {

		/*
		 * here to run desired thread at desired point, we need to set a variable initially
		 * this variable will work to provide condition to run a thread or to make it go in waiting state
		 * so thread will always be waiting until its condition while condition get false.
		 * in this example we made variable value such that our first thread while loop condition get false and it will always be executed first due to this.
		 */
		
		ResourceLock lock = new ResourceLock();

		Thread a = new Thread(() -> {
			try {
				synchronized (lock) {
						while (lock.flag != 1) {
							lock.wait();
						}

						System.out.print("A ");
						Thread.sleep(1000);
						lock.flag = 2;
						lock.notifyAll();
				}
			} catch (Exception e) {}
		});
		
		Thread b = new Thread(() -> {
			try {
				synchronized (lock) {
						while (lock.flag != 2) {
							lock.wait();
						}

						System.out.print("B ");
						Thread.sleep(1000);
						lock.flag = 3;
						lock.notifyAll();
				}
			} catch (Exception e) {}
		});
		
		Thread c = new Thread(() -> {
			try {
				synchronized (lock) {
						while (lock.flag != 3) {
							lock.wait();
						}

						System.out.print("C ");
						Thread.sleep(1000);
						lock.flag = 1;
						lock.notifyAll();
				}
			} catch (Exception e) {}
		});

		a.start();
		b.start();
		c.start();
	}
}