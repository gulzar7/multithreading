//qus9 - Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Thread1 implements Runnable
{
	int id;

	public Thread1(int i)
	{
		this.id =i;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"\n");
		try
		{
			Thread.sleep(1000L);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class Demo1
{
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService1 = Executors.newFixedThreadPool(2);

		for (int i = 0; i <=7; i++) {
			executorService1.submit(new Thread1(i));
		}
		executorService.shutdown();

	}
}
