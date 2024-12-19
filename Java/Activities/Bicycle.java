
public class Bicycle implements BicycleParts,BicycleOperations {
	
	public int gears;
	public int speed;
	
	Bicycle(int gears,int speed){
		gears=gears;
		speed=speed;
	}

	public void applyBrake(int decrement) {
		speed-=decrement;
		System.out.println("Current Speed: "+speed);
	}
	
	public void speedUp(int increment) {
		speed+=increment;
		System.out.println("Current Speed: "+speed);
	}
	
	public String bicycleDesc() {
		return ("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
	}
}
