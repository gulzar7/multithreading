// Q6- Return a Future from ExecutorService by using callable and use get(), isDone(),
// isCancelled() with the Future object to know the status of task submitted.

import java.util.concurrent.*;


class Future_Demo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Future<String> stringFuture = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {

				String s = "String returned from Future";
				return s;
			}
		});


		executorService.shutdown();


		if(stringFuture.isDone())
			System.out.println(stringFuture.get());

		if(stringFuture.isCancelled())
			System.out.println("Task has been cancelled");




	}
}