package questionsInterview;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterviewQuestionsTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	@Test
	public void test() {
		InterviewQuestions myTest=new InterviewQuestions();	
		String str="DavidHerrera";
		String subStr="vid";
		assertTrue(myTest.subString(str,subStr));
		addToTen list =new addToTen();
		int[] a={1,2,5,6,2,4,7};
		int[] b={2,5,6,8,4,7,3};
		int[] c={10,0,1,2,9,2,8};
		int[] d={2,9,8,1,6,4,3,7};
		int[] e={1,3,4,5,6,7,3,2};
	 	list.sumEqualTen(a);
	 	list.printList(list.getList());
		
	}

}
