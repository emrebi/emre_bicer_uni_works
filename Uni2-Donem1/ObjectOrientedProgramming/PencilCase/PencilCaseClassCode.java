package PencilCase;

public class PencilCase {
	
	public final double Maxcapacity = 20;
	public double capacity;
    public boolean zipper;
	
    public boolean openzipper() {
    	
    	if(zipper!=true) 
    		return true;
    	return true;
    	
    	}
    	
    public boolean closezipper() {
    	if(zipper==true) {
    		return false;
    	}
    	return false;
    }
    
	public void Addpencil() {
		
		capacity++;
		System.out.println("Number of pencils"+capacity);
		if(capacity==Maxcapacity) {
			System.out.println("Pencilcase is full!");
		}}

    public void Deletepencil() {
		
		capacity--;
		System.out.println("Number of pencils"+capacity);
		if(capacity==0) {
			System.out.println("Pencilcase is empty!!");
		}}
	
	
}