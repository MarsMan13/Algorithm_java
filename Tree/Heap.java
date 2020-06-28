// Heap : parent > child always.
// Max Heap
public class Heap{

	final static int MAX_SIZE = 100;
	int size = 0;
	HeapNode[] heap = new HeapNode[Heap.MAX_SIZE];

	public static void main(String[] args){

		Heap hp = new Heap();

		hp.insert(new HeapNode(4));
		hp.insert(new HeapNode(2));
		hp.insert(new HeapNode(9));
		hp.insert(new HeapNode(5));
		hp.insert(new HeapNode(7));
		hp.insert(new HeapNode(1));
		hp.insert(new HeapNode(8));
		hp.insert(new HeapNode(3));
		hp.insert(new HeapNode(6));

		hp.showHeap();

		System.out.println("\n============\n");

		System.out.println(hp.pop());
		System.out.println(hp.pop());
		System.out.println(hp.pop());
		System.out.println(hp.pop());
		System.out.println(hp.pop());
		System.out.println(hp.pop());
		System.out.println(hp.pop());
		System.out.println(hp.pop());
	}

	public void insert(HeapNode node){	//INSERT
		int index = ++size;
		while((index != 1) && (node.data > heap[index/2].data)){
			heap[index] = heap[index/2];
			index/=2;
		}
		heap[index] = node;
	}

	public HeapNode pop(){	//DELETE(POP MAX)
		HeapNode ret = heap[1];
		
		HeapNode temp = heap[size--];
		int index = 1;
		int child = 2;
		while(child<=size){
			if((child < size) && (heap[child].data < heap[child+1].data))
				child++;
			if(temp.data >= heap[child].data)	
				break;
			heap[index] = heap[child];
			index = child;
			child *= 2;
		}
		heap[index] = temp;
		return ret;
	}

	public void showHeap(){	//PRINT HEAP...
		int level = 2;
		for(int i = 1; i<= size; i++){
			System.out.print(heap[i]+"\t");
			if(i == level-1){
				System.out.println();
				level *= 2;
			}
		}
	}

}

class HeapNode{

	int data;
	public HeapNode(int data){
		this.data = data;
	}

	@Override
	public String toString(){
		return "" + data;
	}
}
