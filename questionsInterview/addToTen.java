package questionsInterview;

import java.util.Hashtable;
import java.util.Set;
//This class assumes that the list inputed into the sumEqualten will 
//made of positive numbers only
public class addToTen {
	
	//The class contains one private property, which is the list that the method returns
	
	
	private Hashtable<Integer,Integer> result;
	
	//The constructor will simply initialize the property
	public addToTen(){
		result=new Hashtable<Integer, Integer>();
	}
	
	
	/*This is a getter of the property, the setter is not there as only the method sumEqualTen should
	  change the value of the list
	*/
	public Hashtable<Integer,Integer> getList(){
		return result;
	}
	
	
	/*The sumEqualTen assumes that the list is an array and the function returns a 
	  hashtable, which creates pairs via key, value.*/
	 public Hashtable<Integer,Integer> sumEqualTen(int [] a){
		   Hashtable<Integer,Integer> elements=new Hashtable<Integer, Integer>();
		   //Any time the 
		   result.clear();
		   boolean flag=false;
		   for(int i=0;i<a.length;i++){
			   if(a[i]==5&&flag==false){
				   flag=true;
				   continue;
			   }
			   elements.put(a[i], i); 
		   }
		   
		   for(int j=0;j<a.length;j++){
			   if(elements.containsKey(10-a[j])){	
				   	   result.put(10-a[j], a[j]);
					   elements.remove(10-a[j]);
					   elements.remove(a[j]);
				   }
					
			   }
		   return result; //Values return will not be repeated
		   }
	 
	 //Public method to print the results from the list of numbers that add up to ten
	 public void printList(Hashtable<Integer,Integer> result){
		 Set<Integer> keys = result.keySet();
		 int sizeSet=keys.size();
		 for(Integer key: keys){
			 if(sizeSet==1){
				 System.out.print("("+key+","+ result.get(key)+")"); 
			 }else{
				 System.out.print("("+key+","+ result.get(key)+"),");
			 }
			 sizeSet--;
		 }
		 
	 }
}
