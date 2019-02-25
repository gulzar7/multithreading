//  Q4- Try shutdown() and shutdownNow() and observe the difference.

/*
shutdown() will just tell the executor service that it can't accept new tasks,
but the already submitted tasks continue to run.
shutdownNow() will do the same AND will try to cancel the already submitted tasks
by interrupting the relevant threads. Note that if your tasks ignore the interruption,
shutdownNow will behave exactly the same way as shutdown.
*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Shutdown_and_Shutdown_Demo
{
	public static void main(String[] args)
	{

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" performing Job-1");
				if(Thread.currentThread().isInterrupted()==true)
					System.out.println("Inside Job-1: interupted by shutdownNow()");
			}
		});

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" performing Job-2");
				if(Thread.currentThread().isInterrupted()==true)
					System.out.println("Inside Job-2: interupted by shutdownNow()");
			}
		});



		executorService.submit(new Runnable() {
			@Override
			public void run() {
				try
				{
					System.out.println("wait for 1 sec\n");
					Thread.sleep(1000);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" performing Job-3");
				if(Thread.currentThread().isInterrupted()==true)
					System.out.println("Inside Job-3: interupted by shutdownNow()");
			}
		});

		executorService.shutdown();
		executorService.shutdownNow();

	}
}