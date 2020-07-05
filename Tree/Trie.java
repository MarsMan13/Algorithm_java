import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;


public class Trie{

	final static int ALPHA = 27;
	
	char alpha;
	Trie[] child = new Trie[ALPHA+1];
	int childsNum = 0;
	int count = 0;
	boolean leaf = false;



	public static void main(String[] args){


		Trie root = new Trie();
		root.putString("aa");
		root.putString("ab");
		root.putString("adfsf");
		root.putString("aois");
		root.putString("abis");
		root.putString("ad");
		System.out.println(root.searchCompletion("aaaaa"));
		System.out.println(root.searchCompletion("ab"));
	}

	Trie(){
	}

	Trie(char c){
		this.alpha = c;
	}
	
	int putString(String str){
		Trie newNode = new Trie();
		
		Trie pointer = this;
		for(int i = 0; i<str.length(); i++){
			char eleChar = str.charAt(i);
			
			if(pointer.child[eleChar - 'a'] == null){
				pointer.child[eleChar - 'a'] = new Trie(eleChar);
			}
			pointer.childsNum++;
			pointer = pointer.child[eleChar - 'a'];

		}
		pointer.count++;
		pointer.leaf = true;
		return 1;
	}
	
	int searchCompletion(String str){

		Trie pointer = this;

		for(int i = 0; i<str.length(); i++){
			char eleChar = str.charAt(i);
			if(pointer.child[eleChar - 'a'] == null){
				return 0;
			}
			pointer = pointer.child[eleChar - 'a'];
		}
		return pointer.childsNum + pointer.count;
		
	}


	Trie getString(String str){
		
		Trie pointer = this;

		for(int i = 0; i<str.length(); i++){
			char eleChar = str.charAt(i);
			if(pointer.child[eleChar - 'a'] == null){
				return null;
			}
			pointer = pointer.child[eleChar - 'a'];
		}
		
		if(pointer.leaf){
			return pointer;
		}
		return null;
	}

	@Override
	public String toString(){
		return "" + this.alpha;
	}
}
