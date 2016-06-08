

public class Game {
	public static void main(String args[]){
		GameStage gs = new GameStage();
		Thread thread = new Thread(gs);
		thread.start();
	}
}
