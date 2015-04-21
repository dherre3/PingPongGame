package questionsInterview;
import java.util.*;

public class BinarySearchTree {
	private int value;
	private int height;
	private int numberOfNodes;
	private BinarySearchTree leftChild;
	private BinarySearchTree rightChild;
	
	public BinarySearchTree(int value){
		numberOfNodes=1;
		this.value=value;
		this.height=1;
	}
	public BinarySearchTree(int value, BinarySearchTree leftC, BinarySearchTree rightC){
		this.value=value;
		leftChild=leftC;
		rightChild=rightC;
	}
	public void setLeftChild(BinarySearchTree leftChild){
		this.leftChild=leftChild;
	}
	public void setRightChild(BinarySearchTree rightChild){
		this.rightChild=rightChild;
	}
	public int getValue(){
		return this.value;
	}
	public void setValue(int a){
		this.value=a;
	}
	public BinarySearchTree getLeftChild(){
		return this.leftChild;
	}
	public BinarySearchTree getRightChild(){
		return this.rightChild;
	}
	public void insert(int a){
		//System.out.println(value);
			if(a<this.value){
				if(leftChild==null){
				leftChild=new BinarySearchTree(a);
				}else{
					leftChild.insert(a);
				}
			}else if(a>=this.value){
				if(rightChild==null) rightChild=new BinarySearchTree(a);
				else{
					rightChild.insert(a);
				}
			}
	}
//	public boolean search(int value){
//		if(value!=this.value){
//			
//		}
//	}
	public void printValues(){
		//System.out.println(value);
		
		if(this.leftChild!=null){
			leftChild.printValues();
		}
		if(this.rightChild!=null){
			rightChild.printValues();
		}
		System.out.println(value);
	}
	public void bfsBst(){
		LinkedList<BinarySearchTree> bsf=new LinkedList<BinarySearchTree>();
		bsf.add(this);
		
		while(bsf.size()>=1){
			
			BinarySearchTree temp=bsf.pop();
			System.out.println(temp.value);
			if(temp.leftChild!=null){
			bsf.add(temp.leftChild);
			}
			if(temp.rightChild!=null){
			bsf.add(temp.rightChild);
			}
		}
	}
	public int findMax()
	{
		int a=value;
		BinarySearchTree temp=this;
		while(temp!=null){
			a=temp.value;
			temp=temp.rightChild;
		}
		return a;
	}
	public int getNumberOfNodes() {
		return numberOfNodes;
	}
	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}
	
}
