
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Demo7 {

	Lock lock1 = new ReentrantLock(true);


	Lock lock2 = new ReentrantLock(true);

	public void acquireLock(Lock lock1, Lock lock2){

		boolean acquireLock1= lock1.tryLock();
		boolean acquireLock2= lock2.tryLock();

		if(acquireLock1 && acquireLock2){
			return;
		}

		if(acquireLock1){
			lock1.unlock();
		}

		if(acquireLock2){
			lock2.unlock();
		}

	}

	public void worker1(){
		acquireLock(lock1,lock2);
		System.out.println("lock 1 worker 1");

		System.out.println("lock 2 worker 1");
		lock2.unlock();
		lock1.unlock();
	}

	public void worker2(){
		acquireLock(lock2,lock1);
		System.out.println("lock 1 worker 2");
		System.out.println("lock 2 worker 2");
		lock1.unlock();
		lock2.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		Demo7 demo = new Demo7();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo.worker1();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo.worker2();
			}
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}
}
