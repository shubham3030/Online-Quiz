import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
class OnlineQuiz extends JFrame implements ActionListener
{
	JLabel lb1,lb2;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	public static  String str;
	int count=0,current=0;
	OnlineQuiz(String s){
		super(s);
		 System.out.print("Your Unique Code  is(*) : ");
	        Random random=new Random();
	        char[] otp =new char[5];
	        String numbers="0123456789";
	        for(int i=0; i<5;i++){
	       	 otp[i]=numbers.charAt(random.nextInt(numbers.length()));}
	        str=String.valueOf(otp);
			 System.out.println(str);
			
		Font font2 = new Font("Castellar", Font.BOLD,15);
		lb1=new JLabel(".........ONLINE QUIZ PORTAl..........");
		lb1.setBounds(150, 5, 400, 20);
		lb1.setFont(font2);
		add(lb1);
		lb2=new JLabel();
		Font font1 = new Font("Century Schoolbook", Font.BOLD,14);
		add(lb2);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton("Century Schoolbook",true);	
			add(jb[i]);
			bg.add(jb[i]);// added in button group so as to select one radio button at a time
            jb[i].setFont(font1);
		}
		b1=new JButton("Next>>");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		setQues();
		lb2.setBounds(30,60,450,20);
		lb2.setFont(font1);
		jb[0].setBounds(50,90,400,20);
		jb[1].setBounds(50,120,400,20);
		jb[2].setBounds(50,150,400,20);
		jb[3].setBounds(50,180,400,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(700,350);
	}
	int x=1,i=0,y=1,temp;
	int m[]=new int[10];
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			if(checkCount()){
				count++;
			}
			current++;
			setQues();
			if(current==9){
				b1.setEnabled(false);
				b2.setText("RESULT");
			}
			
		}
		if(e.getActionCommand().equals("Bookmark")) {
			// used when single button is used for more than one purpose. returns the  intended action associated
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			setQues();
			if(current==9)
				b2.setText("RESULT");
			setVisible(false);
			setVisible(true);
		}
		for(i=0,y=1;i<x;i++,y++){
			if(e.getActionCommand().equals("Bookmark"+y)){
				if(checkCount()){
					count++;
				}
				temp=current;
				current=m[y];
				setQues();
				((JButton)e.getSource()).setEnabled(false);// this condition is to disable the buttons of bookmarks
				//getsource() returns the object on which action initially occured
				current=temp;
			}
		}
		if(e.getActionCommand().equals("RESULT")){
			if(checkCount()){
				count++;
			}
			current++;
			String unique_code=JOptionPane.showInputDialog(this,"Enter Ur Code to get Results!!");
			if(str.equals(unique_code))
			{JOptionPane.showMessageDialog(this,"Your Score="+count);// creates an additional dilog box
			 System.exit(0);
		}
			else{
				JOptionPane.showMessageDialog(this,"Invalid Code!!!");// creates an additional dilog box
				 System.exit(0);
			}
	}
}
	void setQues()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			lb2.setText("Que1: Who is the Developer of Java ?");
			jb[0].setText("Shubham Mittal");jb[1].setText("James Gosling");jb[2].setText("Dennis Ritchie");
			jb[3].setText("Rajpal Yadhav");	
		}
		if(current==1)
		{
			lb2.setText("Que2: In Which year Java is Developed ?");
			jb[0].setText("1996");jb[1].setText("2012");jb[2].setText("1995");jb[3].setText("1980");
		}
		if(current==2)
		{
			lb2.setText("Que3: Which is not a keyword in java ?");
			jb[0].setText("Final");jb[1].setText("Abstract");jb[2].setText("Run");jb[3].setText("Static");
		}
		if(current==3)
		{
			lb2.setText("Que4: String class is defined in which package ?");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			lb2.setText("Que5: What is the full form of JDK ?");
			jb[0].setText("JAVA DEVELOPMENT KIT");
			jb[1].setText("JOINT DEVELOPMENT KIT");
			jb[2].setText("JOINT DESIGN KIT");
			jb[3].setText("JAVA DEMAND KEY");
		}
		if(current==5)
		{
			lb2.setText("Que6: What is of the following is immutable class ?");
			jb[0].setText("String");jb[1].setText("StringBuilder");jb[2].setText("StringBuffer");jb[3].setText("None");
		}
		if(current==6)
		{
			lb2.setText("Que7: Which one among these is not a class ?");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			lb2.setText("Que8: which one among these is not a function of Object class ?");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			lb2.setText("Que9: which function is not present in Applet class ?");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			lb2.setText("Que10: Which one among these is not a valid component ?");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}
}
	boolean checkCount(){
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[2].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[0].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	
		
	}
}
