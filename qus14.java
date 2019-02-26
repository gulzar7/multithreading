// Q14- Coordinate mulitple threads using wait() and notifyAll().
import java.util.*;
class MThread1 extends Thread
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

class MThread2 extends Thread
{
	public void run()
	{
		System.out.println("MyThread2 started");
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("MyThread2 Completed");
	}
}

class MyThread3 extends Thread
{
	public void run()
	{
		System.out.println("MyThread3 started");
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("MyThread3 Completed");
	}
}

class MyThread4 extends Thread
{
	public void run()
	{
		System.out.println("MyThread4 started");
		System.out.println("MyThread4 completed");
		notify();
	}
}



class Demo6
{
	public static void main(String[] args) {

		Thread t1 = new MThread1();
		Thread t2 = new MThread2();
		Thread t3 = new MyThread3();
		Thread t4 = new MyThread4();

		t1.start();
		t2.start();
		t3.start();
		t4.start();


	}

}