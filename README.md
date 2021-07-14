# Crypto_Exchange_Simulation
A crypto exchange simulation. A console application that has Traders and one Crypto Exchange. Each trader and the exchange are separate threads, and all threads are working concurrently. The exchange (main thread) manages a ledger (thread-safe queue) shared between traders, where traders publish their offers. A ledger only records the amount(Integer) of satoshi a trader wants to sell. After each trade, each trader sleeps from 1000 to 3000 milliseconds randomly and then they wake up and generate a random value between 1 and 1000 (the amount of satoshi they want to sell) and publish the value to the exchange. This is continually repeated until the exchange closes.


An example of the 'Dining Philosophers' problem.


Still needs a bit of work to clean it up :/
