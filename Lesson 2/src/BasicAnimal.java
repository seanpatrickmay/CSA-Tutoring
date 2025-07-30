// A class that represents any animal
class Animal {
  // The name of the animal
  String name;
  
  // The constructor method
  public Animal(String name) {
    // Sets the name of the animal
    this.name = name;
  }
  
  public void speak() {
    System.out.println(name + " says: some sound");
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void getName() {
    System.out.println(this.name);
  }
}

class Dog extends Animal {
  
  public Dog(String name) {
    // Calls the constructor of Animal class, since Dog extends the Animal class
    super(name);
  }
  
  public void speak() {
    System.out.println(name + " says: Woof!");
  }
}

class Cat extends Animal {
  
  public Cat(String name) {
    super(name);
  }
  
  public void speak() {
    System.out.println(name + " says: Meow!");
  }
}

public class BasicAnimal {
  public static void main(String[] args) {

  }
  
  // Test creating animals, making them speak
  public static void testAnimals() {
    Animal[] animals = new Animal[] {
        new Dog("Tessie"),
        new Cat("Pesky")
    };
    
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
    
    System.out.println("TessieDog == PeskyCat: " +
    (tessieDog == peskyCat));
    
    System.out.println("TessieDog == TessieDog: " +
    (tessieDog == tessieDog));
    
    System.out.println("TessieDog == SecondTessieDog: " +
    (tessieDog == secondTessieDog));
    

    Animal copyPeskyCat = peskyCat;
    
    System.out.println("peskyCat == copyPeskyCat: " +
    (peskyCat == copyPeskyCat));
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
}