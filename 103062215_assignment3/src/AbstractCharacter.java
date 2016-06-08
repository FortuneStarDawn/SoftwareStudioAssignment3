import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Vector;


public abstract class AbstractCharacter {
	private int MAX_HP,now_HP;
	private boolean isActive;
	private Type type;
	private Vector<AbstractSkill> skills = new Vector<AbstractSkill>();
	private BufferedImage image;
	protected GameStage gs;
	abstract public String getName();	//return the name of the character
	abstract public void initial(); // initial the parameter of the character
	public void setActive(){
		isActive = true;
	}
	public void disActive(){
		isActive = false;
	}
	public boolean isActive(){
		return isActive;
	}
	public int getNowHP(){
		return now_HP;
	}
	public int getMAXHP(){
		return MAX_HP;
	}
	public void setNowHP(int now){
		now_HP = now;
	}
	public void setMAXHP(int max){
		MAX_HP = max;
	}
	public void setImage(BufferedImage bi){
		image = bi;
	}
	public Image getImage(){
		return image;
	}
	public void setSkill(AbstractSkill s){
		skills.add(s);
	}
	public Vector<AbstractSkill> getSkills(){
		return skills;
	}
	public void setType(Type t){
		type = t;
	}
	public Type getType(){
		return type;
	}
}
