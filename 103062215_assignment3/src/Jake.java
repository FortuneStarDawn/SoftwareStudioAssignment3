import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Jake extends AbstractCharacter
{
	private File f = new File("Jake.jpg"); //read two image file
	private File f2 = new File("Jake2.jpg");
	private BufferedImage image, image2;
	private int flag;
	
	public Jake(GameStage g)
	{
		gs = g;
		flag = 0;
		//put the two file into the image and image2
		try
		{
			image = ImageIO.read(f);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			image2 = ImageIO.read(f2);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getName()
	{
		return "Jake"; //return name
	}
	
	public void initial()
	{
		//set MAXHP, NowHP, Type and skill.
		setMAXHP(200);
		setNowHP(200);
		setType(Type.DARK);
		setSkill(new HundredThousandVolt());
	}
	
	public Image getImage()
	{
		//when the character is active, image and image2 will emerge alternately. (animate)
		if(isActive())
		{
			if(flag<5)
			{
				flag++;
				return image;
			}
			else if(flag<10)
			{
				flag++;
				return image2;
			}
			else
			{
				flag=1;
				return image;
			}
		}
		//when the character is disActive, only return image
		//but if it is still at the image2 state, wait the state finish and then go back to image state (won't change again)
		else
		{
			if(flag<5)
			{
				return image;
			}
			else if(flag<10)
			{
				flag++;
				return image2;
			}
			else
			{
				flag=0;
				return image;
			}
		}
	}
}
