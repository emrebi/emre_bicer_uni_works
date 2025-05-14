package Dustbin;

public class Main {

	public static void main(String[] args) {
		
		Dustbin a= new Dustbin();
	
		a.playgame();
		
	while(1!=0) {
		a.throwGarbageA();
		a.throwGarbageB();
		
		if(a.A==a.capacity) {
			System.out.println("Congrats Player A win");
			break;
			}
		
			else if(a.B==a.capacity) {
				System.out.println("Congrats Player B win");
				break;
				
			}
		}
	}
		
		
	

}