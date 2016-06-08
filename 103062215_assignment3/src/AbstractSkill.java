

public abstract class AbstractSkill {
	private int power,accuracy;
	private Type type;
	protected GameStage gs;
	abstract public void launch(AbstractCharacter ch);
	abstract public String getName();
	public void setType(Type t){
		type = t;
	}
	public Type getType(){
		return type;
	}
	public void setPower(int p){
		power = p;
	}
	public int getPower(){
		return power;
	}
	public void setAccuracy(int a){
		accuracy = a;
	}
	public int getAccuracy(){
		return accuracy;
	}
}
