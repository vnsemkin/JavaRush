public class Animal
{
    private String name;
    private String food;
    private String location;
    static Animal lisa = new Cat("Lisa","Fish", "Kiev",true);
    static Animal boss = new Dog("Boss","Meat", "Kiev",false);
    static Animal fast = new Horse("Fast","Grass", "Kiev",false);

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public Animal(String name, String food, String location){
        this.food = food;
        this.location = location;
        this.name = name;
    }

    void makeNoise(){

    }
    void eat(){

    }
    void sleep(){
    }

    public static void main(String[] args) {
        System.out.println(lisa);
        lisa.makeNoise();
        lisa.eat();
        lisa.sleep();
        System.out.println(boss);
        boss.makeNoise();
        boss.eat();
        boss.sleep();
        System.out.println(fast);
        fast.makeNoise();
        fast.eat();
        fast.sleep();
    }
}
//

/*Задание:Создать класс Animal и расширяющие его классы Dog, Cat, Horse.
Класс Animal содержит переменные food, location и методы makeNoise, eat, sleep.
Метод makeNoise, например, может выводить на консоль "Такое-то животное спит".
Dog, Cat, Horse переопределяют методы makeNoise, eat.
Добавьте переменные в классы Dog, Cat, Horse, характеризующие только этих животных*/