import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;

public class GameStage extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CharacterPanel ch1,ch2;
	private AbstractCharacter[] charaList, allList; //allList have 3 characters, and choose two to put in charaList
	private int skill;
	private int[] select; //store two different random numbers (between 0~2)
	
	public GameStage(){
		setLayout(null);
		setSize(1000,500);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		select = new int[2];
		select = getRandom(); //get random numbers by calling getRandom
		//put three characters into allList
		allList = new AbstractCharacter[3];
		allList[0] = new DefaultCharacter(this);
		allList[1] = new Jake(this);
		allList[2] = new Poro(this);
		//put two characters into charaList from allList, the random numbers come from select[]
		charaList = new AbstractCharacter[2];
		charaList[0] = allList[select[0]];
		charaList[0].initial();
		ch1 = new CharacterPanel(charaList[0],this);
		ch1.setBounds(0, 0, 500, 500);
		add(ch1);
		charaList[1] = allList[select[1]];
		charaList[1].initial();
		ch2 = new CharacterPanel(charaList[1],this);
		ch2.setBounds(500,0,500,500);
		add(ch2);
		setSkill(-1);
		charaList[0].setActive();
		charaList[1].disActive();
		ch1.update();
		ch2.update();
		setVisible(true);
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		int isEnding = 0,turn = 0;
		int state = 0;
		while(isEnding == 0){
			if(state == 0){	// attack phase
				if(skill != -1){
					state = 1;
				}
			}else if(state == 1){ //effect phase
				charaList[turn].getSkills().get(skill).launch(charaList[1-turn]);
				state = 2;
			}else if(state == 2){ //change phase
				setSkill(-1);
				turn = (1-turn);				
				charaList[turn].setActive();
				charaList[1-turn].disActive();
				ch1.update();
				ch2.update();
				state = 0;
				if(charaList[0].getNowHP() <= 0){
					JOptionPane.showMessageDialog(this,charaList[1].getName()+
						    " wins the game.");
					isEnding = 1;
				}
				if(charaList[1].getNowHP() <= 0){
					JOptionPane.showMessageDialog(this,charaList[0].getName()+
						    " wins the game.");
					isEnding = 1;
				}
			}
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	public void setSkill(int num){
		skill = num;
	}
	
	public static int[] getRandom()
	{
		int i, get, temp;
		int[] box, out;
		Random random = new Random();
		box = new int[3];
		out = new int[2];
		for(i=0; i<3; i++) box[i]=i; //box have 0~2
		for(i=0; i<2; i++)
		{
			get = random.nextInt(3-i); //choose two number from box, and no repeat.
			out[i] = box[get];
			temp = box[get];
			box[get] = box[2-i];
			box[2-i] = temp;
		}
		return out; //return two different random numbers (between 0~2)
	}
}
