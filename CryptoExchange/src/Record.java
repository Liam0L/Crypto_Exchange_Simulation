import java.util.concurrent.ArrayBlockingQueue;

public class Record implements Runnable {

	ArrayBlockingQueue<Integer> ledger;
	 int recorded = -1;
	
	 
	 public Record(ArrayBlockingQueue<Integer> ledger)
	 {
		 this.ledger = ledger;
	 }
	 
	 public void run()
	 {
			try {
			while(true)
			{
				RecordSale();
			}
			}catch (Exception exp) {}
		}
	 
	 private void RecordSale() throws Exception
	 {
		 recorded = ledger.take();
		 System.out.println("Recorded = " + recorded);
		 
	 }
}
	