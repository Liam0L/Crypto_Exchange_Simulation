
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

import java.util.logging.*;



public class CryptoExchange {
	
	private final static Logger marketlog = Logger.getLogger("market.log");
	
	public static void main(String[] args) throws InterruptedException, SecurityException, IOException
	{
		LogManager.getLogManager().reset();
		marketlog.setLevel(Level.ALL);
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.ALL);
		marketlog.addHandler(ch);
		
		try {
			FileHandler fh = new FileHandler("market.log", true);
			fh.setFormatter(new SimpleFormatter());
			fh.setLevel(Level.ALL);
			marketlog.addHandler(fh);
		}catch (IOException e) {
			marketlog.log(Level.SEVERE, "Log File not found", e);
		}
		
		
		marketlog.log(Level.INFO, "Cyrpto Exchange Log");
		
		
		
		
		ArrayBlockingQueue<Integer> ledger = new ArrayBlockingQueue<Integer>(10);
		
		Trader trader1 = new Trader(ledger, 1);
		Trader trader2 = new Trader(ledger, 2);
		Trader trader3 = new Trader(ledger, 3);
		Trader trader4 = new Trader(ledger, 4);
		Trader trader5 = new Trader(ledger, 5);
		
		Record rec1 = new Record(ledger);
		Thread rec1Thread = new Thread(rec1);
		
		Thread t1Thread = new Thread(trader1);
		Thread t2Thread = new Thread(trader2);
		Thread t3Thread = new Thread(trader3);
		Thread t4Thread = new Thread(trader4);
		Thread t5Thread = new Thread(trader5);
		
		
		t1Thread.start();
		t2Thread.start();
		t3Thread.start();
		t4Thread.start();
		t5Thread.start();
		rec1Thread.start();
		
		marketlog.log(Level.INFO, trader1.toString());
		
		
	}

}
