import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;
public class LoginPage extends JFrame implements ActionListener {
	JLabel l1,l2;
	JTextField tf1,tf2; 
	
	JButton b,bb;
	JPasswordField value;
	LoginPage(String s1){
		super(s1);// it is must calling the constructor of frame class System.out.println("Generating Unique code :: ");
		l1=new JLabel("Email Id :>");
		l1.setBounds(30, 30, 400, 30);
		Font font = new Font("Century Schoolbook", Font.BOLD,14);
        l1.setFont(font);
		add(l1);
		tf1=new JTextField();
		tf1.setBounds(30,70,400,30);
		tf1.setToolTipText("Enter your email id(case sensitive)");
		add(tf1);
		//String s1=tf1.getText();
		l2=new JLabel("Password :>");
		l2.setBounds(30, 110, 400, 30);
		l2.setFont(font);
		add(l2);
		/*tf2=new JTextField();
		tf2.setBounds(30,140,400,30);
		add(tf2);*/
		  value = new JPasswordField();   
	     value.setBounds(30,150,400,30);    
	     value.setToolTipText("Enter your Password");  
	     add(value);
	     //String s2= new String(value.getPassword());
	     b=new JButton("LOGIN");
	     bb=new JButton("REGISTER");
	     b.addActionListener(this);
	     bb.addActionListener(this);
	     b.setBounds(50, 210, 100, 50);
	     bb.setBounds(180, 210, 100, 50);
	     add(b);
	     add(bb);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setLayout(null);
	     setLocation(250,100);
	     setVisible(true);
		 setSize(600,350);
		// goTofun(s1,s2);
	}
 public void actionPerformed(ActionEvent e){
	 if(e.getSource()==b)
	  {
	   String data1 = " "+tf1.getText()+" "+new String(value.getPassword())+" "; 
      // String data2=new String(value.getPassword());   
      // System.out.println(data1);
       //System.out.println(data2);
     /* try{
        FileWriter fw=new FileWriter("C:\\Users\\SHUBHAM MITTAL\\workspace\\OnlineExam\\src\\submit.txt"); 
	    fw.write(data);
	    fw.close();
      }catch(Exception e1){System.out.println(e1);}*/
     try{
      FileReader fr=new FileReader("C:\\Users\\SHUBHAM MITTAL\\workspace\\OnlineQuiz\\legal1.txt");
      BufferedReader br=new BufferedReader(fr);   
    
        String add;//=br.readLine();
      // String words[]=add.split("\\n");
       int flag=0;
       while((add=br.readLine())!=null)
       {
    	   if(data1.equals(add)){
    		   flag=1;
    		   break;
    	  
       }}
       if(flag==1){
    	    JOptionPane.showMessageDialog(this,"Hello, Welcome to Online  Quiz Portal.");
    	   // System.exit(0);
    	   new OnlineQuiz("Online Quiz Portal");
       }
       else{
   
    	    JOptionPane.showMessageDialog(this,"Invalid Email or Password");
    	   int a=JOptionPane.showConfirmDialog(this,"Do You Want to Login Again?");
    	   if(a==JOptionPane.YES_OPTION){  
    		   new LoginPage("LOGIN PAGE"); 
    	   }
    	   else{
    		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		   System.exit(0);
    	   }
       } 
       br.close();
       fr.close();
	}catch(Exception e1){System.out.println(e1);}
	  }
     if(e.getSource()==bb){
    	 String newdata=" "+tf1.getText()+" "+new String(value.getPassword())+" ";
    	try{
    	 BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\SHUBHAM MITTAL\\workspace\\OnlineQuiz\\legal1.txt", true));
           bw.write(newdata);
           JOptionPane.showMessageDialog(this,"Successfully Registered");
           
           bw.newLine();
           bw.close();
           System.exit(0);
         }catch(Exception e2){System.out.println(e2);}
    	//JOptionPane.showMessageDialog(this,"Successfully Registered");
     
}
 }
}
