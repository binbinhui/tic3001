package sg.edu.nus.comp.tic3001.kwic_assignment2;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class ExtensionsTest extends TestCase {
	
	public void test() {
		
		Extensions exten = new Extensions();
		List<String> sup = Arrays.asList("sup1", "sup2", "sup3");
		boolean output = exten.checkIfFileIsEmpty(true, sup, "hihi");
		System.out.print(output);
		assertEquals(false, output);
	}     
	public void test2() {
		
		Extensions exten = new Extensions();
		List<String> sup = Arrays.asList("sup1", "sup2", "sup3");
		boolean output = exten.checkIfFileIsEmpty(sup, "haha", "hihi");
		System.out.print(output);
		assertEquals(false, output);
	}

}
