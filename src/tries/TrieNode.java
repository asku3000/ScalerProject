package tries;

public class TrieNode {

	char data;
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;
	int freq;
	public TrieNode(char data, TrieNode[] children, boolean isEnd, int freq) {
		this.data = data;
		this.children = children;
		this.isEnd = isEnd;
		this.freq = freq;
	}

}
