package bcsx.innerclasses;
/**
 * ����ʹ��������ǽӿڣ��������������Ҫĳ���ӿڣ�������˽��������򣬲����Ȳ����ѣ���Ҫ����ŵ��������С�
 * */
interface Game{boolean move();}
interface GameFactory{Game getGame();}
class Checkers implements Game{
	private int moves = 0;
	private static final int MOVES = 3;
	@Override
	public boolean move() {
		System.out.println("Checkers move "+moves);
		return ++moves != MOVES;
	}
	public static GameFactory factory = new GameFactory() {
		@Override
		public Game getGame() {
			return new Checkers();
		}
	};
	
}

class Chess implements Game{
	private int moves = 0;
	private static final int MOVES = 4;
	
	@Override
	public boolean move() {
		System.out.println("Chess move "+moves);
		return ++moves != MOVES;
	}
	
	public static GameFactory factory = new GameFactory() {
		@Override
		public Game getGame() {
			return new Chess();
		}
	};
}


public class Games {
	public static void playGame(GameFactory fact){
		Game g = fact.getGame();
		while(g.move())
			;
	}

	public static void main(String[] args) {
		playGame(Checkers.factory);
		playGame(Chess.factory);
	}

}
