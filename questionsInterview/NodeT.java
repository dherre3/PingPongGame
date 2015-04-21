package questionsInterview;

public class NodeT {
	private int value;
	private NodeT leftNode;
	private NodeT rightNode;
	
	public NodeT(int value){
		this.value=value;
	}
	public NodeT(int value, NodeT leftNode, NodeT rightNode){
		this.leftNode=leftNode;
		this.rightNode=rightNode;
		this.value=value;
	}
	public NodeT getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(NodeT leftNode) {
		this.leftNode = leftNode;
	}
	public NodeT getRightNode() {
		return rightNode;
	}
	public void setRightNode(NodeT rightNode) {
		this.rightNode = rightNode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
