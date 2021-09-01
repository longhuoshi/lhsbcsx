package bcsx.holding;

import java.util.Set;
import java.util.TreeSet;

import bcsx.net.mindview.util.TextFile;

public class UniqueWords {

	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(new TextFile("tempfile\\SetOperations.java","\\W+"));
		System.out.println(words);
	}
}
