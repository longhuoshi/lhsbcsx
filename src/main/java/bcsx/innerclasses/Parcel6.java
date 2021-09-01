package bcsx.innerclasses;

/**
 * 展示了如何在任意作用域内嵌入一个内部类。
 * */
public class Parcel6 {

	private void internalTracking(boolean b) {
		if (b) {
			class TrackingSlip {
				private String id;

				TrackingSlip(String s) {
					this.id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
		// Can't use it here! Out of scope;
		// TrackingSlip ts = new TrackingSlip("slip");
	}

	public void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		Parcel6 p = new Parcel6();
		p.track();
	}

}
