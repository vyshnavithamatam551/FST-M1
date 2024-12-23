
public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Addable ad1 = (num1,num2) -> (num1+num2);
		Addable ad2 = (int num1,int num2) -> {
			return (num1+num2);
		};
		
       System.out.println("The result from ad1 object is: "+ad1.add(5, 16));
       System.out.println("The result from ad2 object is: "+ad2.add(90, 220));
	}

}
