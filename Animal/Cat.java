public class Cat extends Animal {
    private boolean likeFish;
    public Cat(String name, String food, String location, boolean likeFish){
        super(name, food, location);
        this.likeFish = likeFish;
    }
    @Override
    void makeNoise(){
        System.out.println(this.getName() + " Saying Meow, Meow!");
    }
    @Override
    void eat(){
        System.out.println(this.getName() + " Is eating: " + this.getFood());
    }
    @Override
    void sleep(){
        System.out.println(this.getName() + " Is sleeping!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "likeFish=" + likeFish +
                ", name='" + getName() + '\'' +
                ", food='" + getFood() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
//