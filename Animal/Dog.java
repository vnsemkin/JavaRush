public class Dog extends Animal{
    private boolean canBite;
    public Dog(String name, String food, String location, boolean canBite){
        super(name, food, location);
        this.canBite = canBite;
    }

    @Override
    void makeNoise() {System.out.println(this.getName() + " Saying Gav, Gav!");}
    @Override
    void eat(){
        System.out.println(this.getName() + " Is eating : " + this.getFood());
    }
    @Override
    void sleep(){
        System.out.println(this.getName() + " Is sleeping!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "canBite=" + canBite +
                ", name='" + getName() + '\'' +
                ", food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
//

