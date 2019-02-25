// Q2- Use sleep and join methods with thread.
class Ram implements Runnable
{
	public void run()
	{
		Thread.currentThread().setName("Thread Ram");


		try
		{ Thread.sleep(2000); }
		catch (Exception e){};


		System.out.println("\nYou've waited for 2 sec for me so here I am");
		for(int i=1; i<=5;i++)
			System.out.println("By "+Thread.currentThread().getName()+": "+5*i);
	}
}

class Shyam implements Runnable
{
	public void run()
	{

		Thread.currentThread().setName("Thread Shyam");

		for(int i=1;i<=5;i++)
			System.out.println("By "+Thread.currentThread().getName()+": "+i*100);
	}
}

class Alibaba implements Runnable
{
	public void run()
	{

		Thread.currentThread().setName("Thread Alibaba");

		for(int i=1;i<=5;i++)
			System.out.println("By "+Thread.currentThread().getName()+": "+i*1000);
	}
}



class Demo5
{
	public static void main(String[] args) {

		Ram R1 = new Ram();
		Shyam S1 = new Shyam();
		Alibaba A1 = new Alibaba();

		Thread thread_ram = new Thread(R1);
		Thread thread_shyam = new Thread(S1);
		Thread thread_alibaba = new Thread(A1);

		thread_ram.start();

		try{
			thread_alibaba.join();
		}catch(Exception e){System.out.println(e);}

		thread_shyam.start();
		thread_alibaba.start();



	}
}