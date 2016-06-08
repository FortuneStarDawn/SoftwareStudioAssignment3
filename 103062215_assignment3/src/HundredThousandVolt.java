import java.util.Random;
import javax.swing.JOptionPane;

public class HundredThousandVolt extends AbstractSkill
{
	public HundredThousandVolt()
	{
		//set the Type and Power
		setType(Type.LIGHT);
		setPower(50);
	}
	public void launch(AbstractCharacter ch)
	{
		Random r = new Random();
		//generate a random number between 0~2, and set it into accuracy
		setAccuracy(r.nextInt(3));
		//if the number is not 0, the attack will succeed (2/3 probability)
		if(getAccuracy()!=0)
		{
			if(ch.getType() == getType()) //if two Types are same, create a normal damage. 
			{
				ch.setNowHP(ch.getNowHP()-getPower()); //nowHP = nowHP - Power
			    JOptionPane.showMessageDialog(null, ch.getName() + " get " + getPower() + " points of damage.", "Message",JOptionPane.INFORMATION_MESSAGE);
			}
			else //if two Types are different, create a weakness damage
			{
				ch.setNowHP(ch.getNowHP()-getPower()*3/2); //nowHP = nowHP - (Power*1.5)
				JOptionPane.showMessageDialog(null, "Weakness! " + ch.getName() + " get " + getPower()*3/2 + " points of damage.", "Message",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		//the number is 0, attack fail
		else 
		{
			JOptionPane.showMessageDialog(null, ch.getName() + " avoid the attack.", "Message",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public String getName()
	{
		return "100,000 Volts"; //return the skill name
	}
}
