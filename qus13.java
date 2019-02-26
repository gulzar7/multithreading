// Q13- Coordinate 2 threads using wait() and notify().

class MyThreadd1 extends Thread
{
	public void run()
	{
		System.out.println("MyThread1 started");
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("MyThread1 Completed");
	}
}

class MyThreadd2 extends Thread
{
	public void run()
	{
		System.out.println("MyThread2 started");
		System.out.println("MyThread2 completed");
		notify();
	}
}

class Demo2
{
	public static void main(String[] args) {

		Thread t1 = new MThread1();
		Thread t2 = new MThread2();

		t1.start();
		t2.start();

	}

}