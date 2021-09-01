package bcsx.net.mindview.util;

public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	public BasicGenerator(Class<T> type){
		this.type = type;
	}
	
	@Override
	public T next() {
		try {
			// Assumes type is a public class:
			return type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> BasicGenerator<T> create(Class<T> type){
		return new BasicGenerator<>(type);
	}
	
	
}
