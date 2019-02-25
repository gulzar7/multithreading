// Q5- Use isShutDown() and isTerminate() with ExecutorService.

/*
isShutdown() : Returns true when executer service is shutdown.
isTerminated() : Returns true when all active tasks are completed.
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class isShutdown_and_isTerminated_Demo
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
					System.out.println("\nwait for 1 sec");
					Thread.sleep(1000);
				}

				catch (Exception e)
				{
					System.err.println("SLEEP Exception Caughed");
				}
				System.out.println(Thread.currentThread().getName()+" performing Job-3");
			}
		});

		executorService.shutdown();
		executorService.shutdownNow();
		if(executorService.isShutdown()==true)
			System.out.println("\nExecutorService Shutdown status: SUCCEED\n");
		else
			System.out.println("\nExecutorService Shutdown status: FAILED\n");

		if(executorService.isTerminated()==true)
			System.out.println("\nActive Tasks completion status: COMPLETED\n");
		else
			System.out.println("\nActive Tasks completion status: INTERUPTED\n");


	}
}