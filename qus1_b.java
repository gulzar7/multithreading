// Q1(b)- Create and Run a Thread using Runnable Interface.
class Job1 implements Runnable
{
	public void run()
	{
		System.out.println("Inside Thread 1");
		for(int i=1; i<=5;i++)
			System.out.println(5*i);
	}
}

class Job2 implements Runnable
{
	public void run()
	{
		System.out.println("Inside Thread 2");
		for(int i=1;i<=5;i++)
			System.out.println(i*100);
	}
}

class Demo4
{
	public static void main(String[] args) {

		Job1 j1 = new Job1();
		Job2 j2 = new Job2();

		Thread t1 = new Thread(j1);
		Thread t2 = new Thread(j2);
		t1.start();
		t2.start();
	}
}