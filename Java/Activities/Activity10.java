import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> hs = new HashSet<String>();
		
		hs.add("apple");
		hs.add("mango");
		hs.add("orange");
		hs.add("grape");
		hs.add("papaya");
		hs.add("watermelon");
		
			
		System.out.println("The size of the hashset: "+hs.size());
		System.out.println("Removing one item : "+hs.remove("mango"));
		System.out.println("Removing item which is not present : "+hs.remove("strawberry"));
		System.out.println("Checking whether the papaya is present in list: "+hs.contains("papaya"));
		System.out.println("The set contains :"+hs);

	}

}
