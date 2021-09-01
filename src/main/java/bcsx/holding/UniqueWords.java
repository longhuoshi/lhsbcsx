package main.java.bcsx.holding;

import java.util.Set;
import java.util.TreeSet;

import main.java.bcsx.net.mindview.util.TextFile;

public class UniqueWords {

	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(new TextFile("tempfile\\SetOperations.java","\\W+"));
		System.out.println(words);
	}
}
