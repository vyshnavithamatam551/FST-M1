
public class MountainBike extends Bicycle {
	
	public int seatHeight;
	
	public MountainBike(int gears,int speed,int startheight) {
		// TODO Auto-generated constructor stub
		super(gears,speed);
		seatHeight=startheight;
	}
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }  
}
