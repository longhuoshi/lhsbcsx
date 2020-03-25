package bcsx.innerclasses;

class Parcel4{
    private class PContents implements Contents{
        private int value = 11;
        @Override
        public int value() {
            return value;
        }
        
    }
    
    protected class PDestination implements Destination{
        private String label;
        private PDestination(String whereTo){
            label = whereTo;
        }
        @Override
        public String readLabel() {
            // TODO Auto-generated method stub
            return label;
        }
    }
    
    public Destination destination(String s){
        return new PDestination(s);
    }
    
    public Contents contents(){
        return new PContents();
    }
    
}

public class TestParcel {

    public static void main(String[] args) {
        Parcel4  p = new Parcel4();
        Contents c= p.contents();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
        // Illegal -- can't access private class:
//        Parcel4.PContents = p.new PContents();
        
    }

}
