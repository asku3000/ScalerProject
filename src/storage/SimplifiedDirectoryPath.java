package storage;

import java.util.Stack;

public class SimplifiedDirectoryPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "/../";
		System.out.println(simplifyPath(A));

	}

	public static String simplifyPath(String A) {

		String[] paths = A.split("/");
		Stack<String> res = new Stack();
		for (int i = 0; i < paths.length; i++) {
			if (paths[i].equalsIgnoreCase("")) {
				continue;
			} else if (paths[i].equalsIgnoreCase(".")) {
				continue;
			} else if (paths[i].equalsIgnoreCase("..") && res.isEmpty()) {
				continue;
			} else if (paths[i].equalsIgnoreCase("..")) {
				res.pop();
			} else {
				res.push(paths[i]);
			}
		}
		
		if(res.isEmpty()) {
			return "/";
		}
		StringBuilder sb = new StringBuilder("");
		for (String s : res) {
			sb = sb.append("/" + s);
		}
		
		return sb.toString();
	}

}
