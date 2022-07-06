public class Horse extends Animal {
    private boolean isWild;

    public Horse(String name, String food, String location, boolean isWild) {
        super(name, food, location);
        this.isWild = isWild;
    }
    @Override
    void makeNoise(){
        System.out.println(this.getName() + " Saying Go, Go!");
    }
    @Override
    void eat(){
        System.out.println(this.getName() + " Is eating : " + this.getFood());
    }
    @Override
    void sleep(){System.out.println(this.getName() + " Is sleeping!");}

    @Override
    public String toString() {
        return "Horse{" +
                "isWild=" + isWild +
                ", name='" + getName() + '\'' +
                ", food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
//
