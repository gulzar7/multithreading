// Q3- Use a singleThreadExecutor to submit multiple threads.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class SingleExecutorServiceDemo
{
	public static void main(String[] args)
	{

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" performing Job-1");
			}
		});

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" performing Job-2");
			}
		});

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				try
				{
					System.out.println("wait for 2 sec\n");
					Thread.sleep(3000);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" performing Job-3");
			}
		});

		executorService.shutdown();
	}
}