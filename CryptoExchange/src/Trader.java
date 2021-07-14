import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;


public class Trader implements Runnable  {

	ArrayBlockingQueue<Integer> ledger;
	private int number;
	
	
	public Trader(ArrayBlockingQueue<Integer> ledger , int number) {
		
		this.ledger = ledger;
		this.number = number;
		
	}
	

	public void run() 
	{
		try {
		while(true)
		{
			produce();
		}
		}catch (Exception exp) {}
	}
	
	private void produce() throws Exception{
		
		int min = 1;
		int max = 1000;
		int satoshi = ThreadLocalRandom.current().nextInt(min, max);
		
		ledger.put(satoshi);
		
		System.out.println("Trader #" + number + " wishes to sell " + satoshi + " satoshi");
		try {
		Thread.sleep(ThreadLocalRandom.current().nextInt(max,3000));
		} catch (InterruptedException e) {}
	}
	public String toString(int number, int satoshi)
	   {
	      return String.format( "Trader #" + number + "wishes to sell" + satoshi);
	   }
	
}
