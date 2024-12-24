import java.util.ArrayList;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Activity1 {

	static ArrayList<String> list;
	
	@BeforeAll
	public static void setUp() {
		// Initialize a new ArrayList
		list = new ArrayList<String>();

		// Add values to the list
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1
	}
	
	@Test
	public void insertTest() {
		
		assertEquals(2,list.size(),"Wrong size");
		list.add("beta2");
		assertEquals(3,list.size(),"Wrong size");
		
		assertEquals("alpha",list.get(0),"Wrong element");
		assertEquals("charlie",list.get(1),"Wrong element");
		assertEquals("beta2",list.get(2),"Wrong element");
	
	}
	
	@Test
	public void replaceTest() {
		list.set(1,"charlie");
		assertEquals(2,list.size(),"Wrong size");
		assertEquals("alpha",list.get(0),"Wrong element");
		assertEquals("charlie",list.get(1),"Wrong element");
		
	}
}
