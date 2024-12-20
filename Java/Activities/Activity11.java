import java.util.HashMap;
import java.util.Map;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer,String> colors=new HashMap<Integer, String>();
		
		colors.put(1, "blue");
		colors.put(2, "red");
		colors.put(3, "black");
		colors.put(4, "green");
		colors.put(5, "violet");
		
		System.out.println("The hashmap contains: "+colors);
		
		System.out.println("Removing red color :"+colors.remove(2));
		
		System.out.println("Is green present in hashmap : "+colors.containsValue("green"));
		
		System.out.println("The size of the map is :" +colors.size());
		
	}

}
