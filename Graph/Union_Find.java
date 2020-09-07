public class Union_Find{

	int[] parents = new int[10];

	public static void main(String[] args){

		Union_Find obj = new Union_Find();

		for(int i = 0; i<10; i++){
			obj.parents[i] = i;
		}

		obj.unionParent(1,2);
		obj.unionParent(2,3);
		obj.unionParent(3,4);
		obj.unionParent(5,6);
		obj.unionParent(6,7);
		obj.unionParent(7,8);

		System.out.println(obj.sameParent(1,2));
		System.out.println(obj.sameParent(5,8));
		System.out.println(obj.sameParent(1,8));
		obj.unionParent(1,8);
		System.out.println(obj.sameParent(1,8));

	}


	// FIND
	int getParent(int index){
		if(index == parents[index])
			return index;
		return parents[index] = getParent(parents[index]);
	}

	// UNION
	void unionParent(int a, int b){
		a = getParent(a);
		b = getParent(b);
		if(a < b)	parents[b] = a;
		else parents[a] = b;
	}

	boolean sameParent(int a, int b){
		a = getParent(a);
		b = getParent(b);
		return a == b;
	}
}
