package bcsx.innerclasses;
/**
 * 优先使用类而不是接口，如果你的设计中需要某个接口，你必须了解它。否则，不到迫不得已，不要将其放到你的设计中。
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
