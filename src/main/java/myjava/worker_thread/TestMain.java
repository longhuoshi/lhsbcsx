package main.java.myjava.worker_thread;

/**
 * https://blog.csdn.net/smartdt/article/details/79350970
 * 
 * 会创建一个雇佣了2个工人线程的Channel实例，并将其共享给三个ClientThread实例
 * 
 * */
public class TestMain {

	public static void main(String[] args) {
		
		Channel channel = new Channel(2);
		channel.startWorkers();

		new CliectThread("Steve Nash", channel).start();
		new CliectThread("Michael Jordan", channel).start();
		new CliectThread("Ronaldo", channel).start();
		
	}

}
