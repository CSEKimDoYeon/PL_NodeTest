import ast.IntNode;
import ast.ListNode;
import ast.Node;
import compile.TreeFactory;

public class nodeTest {

	public static int sum = 0; 
	// sum �Լ� ȣ�� �� IntNode Value ���� ���� ������ ����.

	public static int max(Node node) {
		int maxValue = -10000000; // maxValue �� ���� ���� �� ���� ����.
		while (node != null) { // node�� null�� �ƴ� �� ���� �����Ѵ�.
			if (node instanceof IntNode) { // node�� type�� IntNode �̸�.
				if (maxValue < ((IntNode) node).value) { 
					// �ش� IntNode�� value�� maxValue ���� ũ�ٸ�.
					maxValue = ((IntNode) node).value;
					// maxValue�� �ش� ������ �ʱ�ȭ�Ѵ�.
				}
			}
			else { // node�� IntNode�� �ƴ϶��.
				int tmpValue;
				tmpValue = max(((ListNode) node).value);
				// �ش� ListNode ������ �ִ밪�� ã�� ���� max�Լ��� ȣ���ϰ�,
				// �ִ� ���� ã���� tmpValue ������ �����Ѵ�.
				if (maxValue < tmpValue) {
					// ���� ���� ������� tmpValue �� �� ũ�ٸ�.
					maxValue = tmpValue;
					// maxValue�� �ش� ������ �ʱ�ȭ���ش�.
				}
			}
			node = node.getNext();
			// ��� �۾��� ������ Node�� null�� �� �� ���� ���� Node�� �̵��Ѵ�.
		}
		return maxValue; // while���� ������ ���������� ����� maxValue�� return �Ѵ�.
	}

	public static int sum(Node node) {
		while (node != null) { // Node�� null �� �� ���� �����Ѵ�.
			if (node instanceof IntNode) { 
				// �ش� Node�� IntNode �� ���.
				sum = sum + ((IntNode) node).value;
				// IntNode�� value�� �����ش�.
			}
			else {
				// �ش� Node�� IntNode�� �ƴ� ���.
				sum(((ListNode) node).value);
				// ListNode�� IntValue���� ��� ���ϱ� ���� sum �Լ��� ȣ���Ѵ�.
			}
			node = node.getNext();
			// ��� �۾��� ������ ��� ���� Node �� �̵��Ѵ�.
		}
		return sum;
		// ���������� ����� sum ���� return�Ѵ�.
	}

	public static void main(String args[]) {
		Node node = TreeFactory.createtTree("( ( 3 ( ( 10 ) ) 6 ) 4 1 ( ) -2 ( ) )");
		System.out.println("�ִ밪 :" + max(node));
		System.out.println("���� :" + sum(node));
	}

}
