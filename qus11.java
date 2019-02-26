// Q11- Use Synchronize block to enable synchronization between multiple threads
//      trying to access method at same time.

class Table1
{
	void print(int x)
	{
		synchronized(this){
			for (int i = 1; i <= 10; i++) {
				System.out.println("By " + Thread.currentThread().getName() + " " + x * i);
			}
		}
	}
}

class Job11 extends Thread
{
	Table1 t;

	Job11(Table1 table1)
	{
		this.t = table1;
	}

	public void run()
	{
		t.print(5);
	}
}

class Job12 extends Thread
{
	Table1 t;

	Job12(Table1 table1)
	{
		this.t = table1;
	}

	public void run()
	{
		t.print(6);
	}
}

class Driver1
{
	public static void main(String[] args) {

		Table1 t = new Table1();
		Thread j1 = new Job11(t);
		Thread j2 = new Job12(t);
		//j1.start();
		j2.start();
		j1.start();
	}
}