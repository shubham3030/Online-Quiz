import java.util.*;
public class header {
  
  public static void main(String args[]){
	  
	  Scanner scan=new Scanner(System.in);
	  System.out.println("Enter your Age::");
	  int age=scan.nextInt();
	  if(age>=18){
		  System.out.println("***********You Are Entered into Login Page**********");
		 //char pass[] = Otp(5);
		  new LoginPage("LOGIN PAGE");
		 // new OnlineExam("Online Quiz Portal");
	  }
	  else
	  {
		  System.out.println("\n\n\t**********Your are not Eligible for Online Quiz**********\n\n");
		  System.exit(0);
	  }
}
}
/*	  static char[] Otp(int len){
	    	 System.out.println("Generating Unique code :: ");
	         System.out.print("Your Unique Code  is : ");
	         Random random=new Random();
	         char[] otp =new char[len];
	         String numbers="0123456789";
	         for(int i=0; i<len;i++){
	        	 otp[i]=numbers.charAt(random.nextInt(numbers.length()));
	         }
	         return otp;
 }
}*/
