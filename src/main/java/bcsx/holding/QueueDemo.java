package bcsx.holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * ���У��Ƚ��ȳ�����������õ�
 * */
public class QueueDemo {
	public static void printQ(Queue queue){
		while(queue.peek() !=null){
			System.out.print(queue.remove()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue  = new LinkedList<Integer>();
		Random r = new Random(47);
		for(int i=0; i<10;i++){
			queue.offer(r.nextInt(i+10));
		}
		printQ(queue);
		
		Queue<Character> qc = new LinkedList<Character>();
		for(Character c : "Brontosaurus".toCharArray())
			qc.offer(c);
		printQ(qc);
		
	}

}
