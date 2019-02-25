

import java.util.concurrent.*;

class ExecuterServiceSchedulingTasks {

	public static void main(String[] args){

		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		executorService.schedule(new Callable() {

			@Override
			public Object call() throws Exception {
				System.err.println("by Schedule()");
				System.out.println("I took 1 second in execution ;-)");
				return null;
			}
		},1,
				TimeUnit.SECONDS);
		executorService
				.scheduleWithFixedDelay(new Runnable() {
					                        @Override
					                        public void run() {
						                        try {
							                        Thread.sleep(2000L);
							                        System.out.println("ScheduleWithFixedDelay Scheduled Task to executed after fixed interval");
						                        } catch (InterruptedException e) {
							                        e.printStackTrace();
						                        }

					                        }
				                        }
						,
						0,
						1,
						TimeUnit.SECONDS);

		executorService
				.scheduleAtFixedRate(new Runnable() {
					                     @Override
					                     public void run() {
						                     try {
							                     Thread.sleep(2000L);
							                     System.out.println("ScheduleAtFixedRate Scheduled Task to executed after fixed interval");
						                     } catch (InterruptedException e) {
							                     e.printStackTrace();
						                     }
					                     }
				                     }
						,
						0,
						1,
						TimeUnit.SECONDS);



	}
}
