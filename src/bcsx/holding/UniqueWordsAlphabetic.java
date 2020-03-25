package bcsx.holding;

import java.util.Set;
import java.util.TreeSet;

import bcsx.net.mindview.util.TextFile;

public class UniqueWordsAlphabetic {

	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		words.addAll(new TextFile("tempfile\\SetOperations.java","\\W+"));
		System.out.println(words);
	}
}
