import ast.IntNode;
import ast.ListNode;
import ast.Node;
import compile.TreeFactory;

public class nodeTest {

	public static int sum = 0; 
	// sum 함수 호출 시 IntNode Value 들의 합을 저장할 변수.

	public static int max(Node node) {
		int maxValue = -10000000; // maxValue 는 가장 작은 수 부터 시작.
		while (node != null) { // node가 null이 아닐 때 까지 실행한다.
			if (node instanceof IntNode) { // node의 type이 IntNode 이면.
				if (maxValue < ((IntNode) node).value) { 
					// 해당 IntNode의 value가 maxValue 보다 크다면.
					maxValue = ((IntNode) node).value;
					// maxValue를 해당 값으로 초기화한다.
				}
			}
			else { // node가 IntNode가 아니라면.
				int tmpValue;
				tmpValue = max(((ListNode) node).value);
				// 해당 ListNode 내에서 최대값을 찾기 위해 max함수를 호출하고,
				// 최대 값을 찾으면 tmpValue 변수에 저장한다.
				if (maxValue < tmpValue) {
					// 위와 같은 방식으로 tmpValue 가 더 크다면.
					maxValue = tmpValue;
					// maxValue를 해당 값으로 초기화해준다.
				}
			}
			node = node.getNext();
			// 모든 작업이 끝나면 Node가 null이 될 때 까지 다음 Node로 이동한다.
		}
		return maxValue; // while문이 끝나면 최종적으로 저장된 maxValue를 return 한다.
	}

	public static int sum(Node node) {
		while (node != null) { // Node가 null 일 때 까지 수핸한다.
			if (node instanceof IntNode) { 
				// 해당 Node가 IntNode 일 경우.
				sum = sum + ((IntNode) node).value;
				// IntNode의 value를 더해준다.
			}
			else {
				// 해당 Node가 IntNode가 아닐 경우.
				sum(((ListNode) node).value);
				// ListNode의 IntValue들을 모두 더하기 위해 sum 함수를 호출한다.
			}
			node = node.getNext();
			// 모든 작업이 끝났을 경우 다음 Node 로 이동한다.
		}
		return sum;
		// 최종적으로 저장된 sum 값을 return한다.
	}

	public static void main(String args[]) {
		Node node = TreeFactory.createtTree("( ( 3 ( ( 10 ) ) 6 ) 4 1 ( ) -2 ( ) )");
		System.out.println("최대값 :" + max(node));
		System.out.println("총합 :" + sum(node));
	}

}
