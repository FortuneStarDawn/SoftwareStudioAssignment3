import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CharacterPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AbstractCharacter ch;
	private JLabel name,hp;
	private Vector<JButton> buttons;
	private GameStage frame;
	public CharacterPanel(AbstractCharacter c,GameStage f){
		ch = c;
		frame = f;
		setLayout(null);
		initLabel();
		initButton();
	}
	private void initLabel(){
		name = new JLabel("My Name is: " + ch.getName());
		name.setBounds (300, 130, 200, 30);
		add(name);
		hp = new JLabel("HP: " + ch.getNowHP()+"/"+ch.getMAXHP());
		hp.setBounds (300, 160, 100, 30);
		add(hp);
	}
	public void update(){
		updateLabel();
		updateButton();
	}
	public void updateButton(){
		if(ch.isActive()){
			for(JButton but: buttons){
				but.setEnabled(true);
			}
		}else{
			for(JButton but: buttons){
				but.setEnabled(false);
			}
		}
	}
	public void updateLabel(){
		hp.setText("HP: " + ch.getNowHP()+"/"+ch.getMAXHP());
	}
	private void initButton(){
		buttons = new Vector<JButton>();
		int skillnum = ch.getSkills().size();
		for(int i = 0;i < skillnum; i++){
			buttons.add(new JButton());
			final int snum = i;
			buttons.get(i).addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			    int dialogButton = 0; 
			    dialogButton = JOptionPane.showConfirmDialog (null, "Use " + ch.getSkills().get(snum).getName(),"Confirm", dialogButton);
			    if(dialogButton == JOptionPane.YES_OPTION){
			    	frame.setSkill(snum);
			    }
			  }
			});
		}
		for(int i = 0;i < skillnum;i++){
			buttons.get(i).setBounds(getX(),getY()+300+100*i,200,30);
			buttons.get(i).setText(ch.getSkills().get(i).getName());
		}
		for(int i = 0;i < skillnum; i++){
			add(buttons.get(i));
		}
	}
	 @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(ch.isActive()){
        	setBackground(Color.cyan);
        }else{
        	setBackground(Color.gray);
        }
        g.drawImage(ch.getImage(),0,0,300,300,null);
    }
}
