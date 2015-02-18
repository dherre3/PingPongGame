
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
	public static void main(String[] args){
		int[] b={1,3,9,7,5,2,8};
		int a=mostCommonElement(b);
		System.out.println(fibonacciRec(20)+ " ");
		fibonacciIter(20);
		fibonacciDyn(20);
		String n="lllloovveeee";
		nonReapeatedChar(n);
		
		
	
	}
}
