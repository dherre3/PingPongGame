
package questionsInterview;
import java.util.*;

public class InterviewQuestions {
//Question 1
	public static int mostCommonElement(int[] a){
		int size=a.length;
		
		int largest=a[0];
		for(int i=0;i<size;i++){
			if(a[i]>largest){
				largest=a[i];
			}
		}
		int [] results=new int[largest+1];
		int mostCommon=a[0];
		for(int j=0;j<largest+1;j++){
			results[j]=0;
			}
		
		for(int k=0;k<size;k++){
			results[a[k]]++;
			if(results[a[k]]>results[mostCommon])mostCommon=a[k];
		}
		
		return mostCommon;
	}
	
//QUESTION 2
	public static void sumEqualTen(int a[]){
		for(int i=0;i<a.length;i++){
			for(int j=i+1; j<a.length;j++){
				if(a[i]+a[j]==10){
					System.out.println(i+ " "+j);
				}
			}
		}
	}
	public static void sumEqualTen2(int a[]){
		int [] b=new int[11];
		for(int k=0;k<b.length;k++){
			b[k]=0;
		}
		for(int i=0;i<a.length;i++){
			b[a[i]]++;
			
		}
		
		for(int j=0;j<b.length/2;j++){
			if(b[j]+b[b.length-1-j]==2){
				System.out.println(j+" "+(b.length-1-j));
			}
		}
		if(b[5]==2){
			System.out.println();
		}
	}
	
   public static void sumEqualTen3(int [] a){
	   Hashtable<Integer,Integer> result=new Hashtable<Integer, Integer>();
	   for(int i=0;i<a.length;i++){
		   result.put(a[i], i);
	   }
	   for(int j=0;j<a.length;j++){
		   if(result.containsKey(10-a[j])){	   
				   System.out.print("("+ (10-a[j]) + ","+ a[j]+")");
				   result.remove(10-a[j]);
				   result.remove(a[j]);
			   }
				
		   }
	   }
   //The following function return true if it is a substring of the longer string,
   //and false otherwise, it also prints Yes if it is true, No if it is false.
   public static boolean subString(String longer, String sub){
	   if(longer.length()<sub.length()){
		   subString(sub,longer);
		   return false;
	   }
	   boolean answer=true;
	   for(int i=0;i<longer.length()-sub.length()+1;i++){
		   answer=true;
		   for(int j=0;j<sub.length();j++){
			 
			   if(longer.charAt(i+j)!=sub.charAt(j)){
				   answer=false;
				   continue;
			   }
			   
			   if(j==sub.length()-1&&answer){
				   System.out.println("Yes");
				   return true;
			   }
		   }
	   }
	   System.out.println("No");
	   return false;
   }
	   

//QUESTION 3 Write Fibonacci recursively and iteratively
	public static int fibonacciRec(int n){
		if(n==1){
			return 1;
		}
		if(n==0){
			return 0;
		}
		
		return fibonacciRec(n-1)+fibonacciRec(n-2);
	}
	public static void fibonacciIter(int n){
		int[] fib=new int[n+1];
		fib[0]=0;
		fib[1]=1;
		for(int i=0;i<=n-2;i++){
			fib[i+2]=fib[i]+fib[i+1];
		}
		System.out.println(fib[n]);
	}
	
	public static void fibonacciDyn(int n){
		int tmp0=0;
		int tmp1=1;
		int ans=0;
		for(int i=0;i<=n-2;i++){
			ans=tmp0+tmp1;
			tmp0=tmp1;
			tmp1=ans;
		}
		System.out.println(ans);
	}
	
	//Questions on STRINGS
	
//Find the first non-repeated character in a string
	public static void nonReapeatedChar(String a){
		Hashtable<String, Integer> cha=new Hashtable<String, Integer>();
		boolean j=true;
		char c=' ';
		for(int i=0;i<a.length();i++){
			char b=a.charAt(i);
			if(cha.containsKey(""+b)){
				cha.remove(""+b);
				if(c==b){
					j=true;
				}
				continue;
			}
			else{
				
				cha.put(""+b,1);
				if(j){
					c=b;
					j=false;
				}
			}
		}
		System.out.println(c);
		
		
	}
	
	public static void nonRepeatedChar2(String a){
		Hashtable<Character, Character> result =new Hashtable<Character, Character>();
		for(int i=0;i<a.length();i++){
			if(result.containsKey(a.charAt(i))){
				result.remove(a.charAt(i));
			}
			else{
				result.put(a.charAt(i),a.charAt(i));
			}
		}
		Set<Character> keys=result.keySet();
		for(Character key:keys){
			System.out.println(key);
			break;	
		}
		
	}
	
	//Question: Write a function that multiples two numbers without using * operator
	
	public static int multiplyNoOperator(int a, int  b){
		if(a==1){
			return b;
		}
		return b+multiplyNoOperator(a-1,b); 
	}
	//Question: Reverse String Iteratively and Recursively
	
	public static void reverseStringIteratively(String a){
		String b="";
		for(int i=a.length()-1;i>=0;i--){
			b=b+a.charAt(i);
		}
		System.out.println(b);
	}
	public static String reverseStringRecursively(String b){
		if(b.length()==1){
			return b;
		}
		return b.charAt(b.length()-1)+reverseStringRecursively(b.substring(0,b.length()-1 ));
	}
	
//Implement a function that prints out the binary form of an int
	
	public static void binaryRep(int a){
		if(a==0){
			System.out.print(0);
		}
		else if(a==1){
			System.out.print(1);
		}else{
			int b=a/2;
			System.out.print(a-2*b);
			binaryRep(b);
		}
		
	}
	
	public static boolean binarySearch(int[] a, int b, int low, int high){
		int middle=(high+low)/2;
		if(a[middle]==b){
			System.out.println(middle);
			return true;
		}else if(a[middle]>b&&high-low>=1){
			System.out.println(middle);
			return binarySearch(a,b,low,middle);
		}else if(a[middle]<b&&high-low>=1){
			System.out.println(middle);
			return binarySearch(a,b,middle+1,high);
		}
		
		
		return false;
		
	}
	
	public static void bubbleSort(int []a){
		boolean swap=true;
		while(swap){
			swap=false;
			for(int i=0;i<a.length-1;i++){
				if(a[i]>a[i+1]){
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					swap=true;
				}
			}
		}
		
	}
	public static void selectionSort(int[] b){
		int c=0;
		int min;
		for(int i=0;i<b.length;i++){
			min=b[i];
			for(int j=i;j<b.length;j++){
				if(b[j]<min){
					min=b[j];
					c=j;
				}
			}
			if(min!=b[i]){
				int tmp=b[i];
				b[i]=min;
				b[c]=tmp;
			}
			
		}
		
	}
	public static void quickSort(int [] a,int low,int hi){
		if(low<hi){
		int pivot=a[hi];
		int storeIndex=low;
		for(int i=low;i<=hi-1;i++){
			if(a[i]<pivot){
				int tempo=a[i];
				a[i]=a[storeIndex];
				a[storeIndex]=tempo;
				storeIndex++;
			}
		}
		int tempo2=a[storeIndex];
		a[storeIndex]=a[hi];
		a[hi]=tempo2;
		for(int j=0;j<a.length;j++){
			System.out.print(a[j]);
		}
		System.out.println(" ");
		quickSort(a, low,storeIndex-1);
		quickSort(a,storeIndex+1,hi);
		}
	}
	
//Reverse a linkedlist iteratively and recursively
	
	
	public static void main(String[] args){

		//int [] a={1,2,4,6,8,9,10,11};
		//if(binarySearch(a,5,0,7)) System.out.print("yes");
		//binaryRep(0);
		//reverseStringIteratively("David");
		//System.out.println(reverseStringRecursively("David"));
//		int a=mostCommonElement(b);
//		System.out.println(fibonacciRec(20)+ " ");
//		fibonacciIter(20);
//		fibonacciDyn(20);
//		String n="lllloovveeee";
//		nonReapeatedChar(n);
		//sumEqualTen3(b);
//		BinarySearchTree love=new BinarySearchTree(7);
//		love.insert(3);
//		love.insert(5);
//		love.insert(4);
//		love.insert(6);
//		love.insert(2);
//		love.insert(8);
//		love.insert(9);
//		love.insert(10);
		int[] p={3,7,5,8,2,1,9,5,4};
		//bubbleSort(p);
		//selectionSort(p);
		quickSort(p,0,p.length-1);
//		for(int j=0;j<p.length;j++){
//			System.out.print(p[j]);
//		}
		
		
		
		
		//love.printValues();
		//System.out.println(love.getNumberOfNodes());
		
		//a:
	 	//b:
	 	//c:
	 	//d:
	 	//e:
	}
}
