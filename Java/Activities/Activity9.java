import java.util.ArrayList;
import java.util.List;


public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> myList=new ArrayList<String>();
		myList.add("Vyshnavi");
		myList.add("Shilpa");
		myList.add("Manasa");
		myList.add("Chethana");
		myList.add("Suma");
		
		myList.add(4,"Deepthi");
		for(String i:myList) {
			System.out.println(i);
		}
		
		System.out.println("The third item in list is:" +myList.get(2));
		
		System.out.println("Vyshnavi exists:"+myList.contains("Vyshnavi"));
		
		System.out.println("The size of list is: " +myList.size());
		
		myList.remove(2);
		
		System.out.println("size of list after removing one item: "+myList.size());
		
		
	}

}
