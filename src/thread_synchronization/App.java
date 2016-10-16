package thread_synchronization;

import java.util.Scanner;

class Processor extends Thread {
	
	public volatile boolean running = true;
	private int count = 0;
	public void run(){
		while (running) {
			count++;
			System.out.println("Running... " + count);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
}

public class App {
	public static void main(String[] args){
		Processor p1 = new Processor();
		p1.start();
		
		System.out.println("Press return to stop ...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		sc.close();
		p1.shutdown();
	}
}
