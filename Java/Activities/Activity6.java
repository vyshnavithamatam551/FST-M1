
public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    Plane plane = new Plane(10);
    plane.onboard("Vyshnavi");
    plane.onboard("Manasa");
    plane.onboard("Shilpa");
    System.out.println("The takeoff time is:"+plane.takeOff());
    System.out.println("List of passengers:" +plane.getPassengers());
    //Thread.sleep(5000);
    plane.land();
    System.out.println("The time of landing is:"+plane.getLastTimeLanded());
    System.out.println("List of passengers after landing:" +plane.getPassengers());
	}

}
