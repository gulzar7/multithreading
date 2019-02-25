// Q1(a)- Create and Run a Thread using Thread class.
class MyThread1 extends Thread
{
	public void run()
	{
		System.out.println("Inside Thread 1");
		for(int i=1; i<=5;i++)
			System.out.println(5*i);
	}
}

class MyThread2 extends Thread
{
	public void run()
	{
		System.out.println("Inside Thread 2");
		for(int i=1;i<=5;i++)
			System.out.println(i*10);
	}
}

class Demo3
{
	public static void main(String[] args) {

		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		t1.start();
		t2.start();
	}
}