package Dustbin;
import java.util.Random;

public class Dustbin {

	
		
            public final double capacity = 10;
			public double A = 0;
			public double B = 0;
			
			
			
			public void playgame() {
				
				System.out.println("Welcome to the Dustbin basket race");
				
			}
			
			
			public void throwGarbageA() {
			
				
		    int a;
			
		   Random rand = new Random();	
			a = rand.nextInt(2);
		   
		    
			if(a==1) {
				 A++;
		    System.out.println("Player A score:"+A);
			}
		else if (a!=1) { 
			System.out.println("Player A missed");
			}
		
			}
				
			public void throwGarbageB() {
				
				
			    int a;
				
			   Random rand = new Random();	
				a = rand.nextInt(2);
			   
			    
				if(a==1) {
					 B++;
			    System.out.println("Player B score:"+B);
				}
			else if (a!=1) { 
				System.out.println("Player B missed");
				}
				}
					
					
			}
			