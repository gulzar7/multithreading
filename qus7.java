// Q7- Submit List of tasks to ExecutorService and wait for the completion of all the tasks.

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

class Submit_task_list
{
	public static void main(String[] args) throws InterruptedException {

		ArrayList<Callable<Integer>> arrayList = new ArrayList<>();

		arrayList.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 1;
			}
		});

		arrayList.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 2;
			}
		});

		arrayList.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 3;
			}
		});

		arrayList.add(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 4;
			}
		});

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		ArrayList<Future<Integer>> futureArrayList = (ArrayList<Future<Integer>>) executorService.invokeAll(arrayList);

		futureArrayList.forEach((e)->{
			if(e.isDone())
			{
				try {
					System.out.println(e.get());
				}
				catch (ExecutionException el)
				{
					el.printStackTrace();
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}

		});

		executorService.shutdown();


	}

}