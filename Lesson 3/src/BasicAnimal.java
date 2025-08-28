// All classes extend Object class array of Object[] can have any type in it.
// A class that represents any animal
class Animal {
  // The name of the animal
  private String name;

  // The constructor method          What is the default constructor?
  public Animal(String name) {
    // Sets the name of the animal
    this.name = name;
  }
  
  Animal myAnimal = new Animal("dog");
  myAnimal.getName() = "cat";

  public void speak() {
    System.out.println(this.name + " says: some sound");
  }
  

  public void setName(String name) {
    this.name = name;
  }

  private void getName() {
    // this.name
    // Similar to array.length
    System.out.println(this.name);
  }
}

class Dog extends Animal {

  public Dog(String name) {
    // Calls the constructor of Animal class, since Dog extends the Animal class
    super(name);
  }

  public void speak() {
    System.out.println(this.name + " says: Woof!");
  }
}

class HouseDog extends Dog {
  String breed;
  
  public HouseDog(String name, String breed) {
    super(name);
    this.breed = breed;
  }
  
  public HouseDog(String name) {
    super(name);
    this.breed = "Mutt";
  }
  
  public void speak() {
    System.out.println(this.name + ", a " + this.breed + " says: Woof!");
  }
}

class Cat extends Animal {

  public Cat(String name) {
    super(name);
  }

  public void speak() {
    System.out.println(this.name + " says: Meow!");
  }
}

public class BasicAnimal {
  public static void main(String[] args) {
    //testAnimals();
    //baseAnimalTest();
    testAnimalEquality();
    //testAnimalMutation();
    //testAnimalMutationComplex();
    //testHouseDogOverloading();
  }

  public static void baseAnimalTest() {
    Animal basicAnimal = new Animal("Basic");
    basicAnimal.speak();
  }

  // Test creating animals, making them speak
  public static void testAnimals() {
    Animal[] animals = new Animal[] { new Dog("Tessie"), new Cat("Pesky") };

    for (Animal animal : animals) {
      animal.speak();
      System.out.println();
    }
  }
  
  // Examples comparing animal equality
  public static void testAnimalEquality() {
    Animal tessieDog = new Dog("Tessie");
    Animal peskyCat = new Cat("Pesky");
    Animal secondTessieDog = new Dog("Tessie");

    System.out.println("TessieDog == PeskyCat: " + (tessieDog == peskyCat));

    System.out.println("TessieDog == TessieDog: " + (tessieDog == tessieDog));

    System.out.println("TessieDog == SecondTessieDog: " + (tessieDog == secondTessieDog));

    Animal copyPeskyCat = peskyCat;

    System.out.println("peskyCat == copyPeskyCat: " + (peskyCat == copyPeskyCat));
  }

  public static void testAnimalMutation() {
    Animal dog = new Dog("Rex");
    dog.getName();

    dog.setName("Cammy");
    dog.getName();
  }

  public static void testAnimalMutationComplex() {
    Animal dog = new Dog("Rex");

    Animal secondDog = dog;

    secondDog.setName("Buska");

    secondDog.getName();
    dog.getName();
  }
  
  public static void testHouseDogOverloading() {
    Animal dalmationHouseDog = new HouseDog("Charlie", "Dalmation");
    Animal muttHouseDog = new HouseDog("Lucky");
    
    dalmationHouseDog.speak();
    muttHouseDog.speak();
  }
}