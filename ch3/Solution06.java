import java.util.*;

class Solution06 {
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(0, "cat1");
		shelter.enqueue(1, "dog2");
		shelter.enqueue(0, "cat3");
		shelter.enqueue(0, "cat4");

		System.out.println(shelter.dequeueCat().print());
		System.out.println(shelter.dequeueDog().print());
		System.out.println(shelter.dequeue().print());
		System.out.println(shelter.dequeueCat().print());
	}
}

abstract class Animal {
	public String name;		
	public int time;
	public Animal(String name) {
		this.name = name;
	}

	public int getTime (){
		return this.time;
	}
	public String print() {
		return name;
	}
}

class Cat extends Animal {
	public Cat(String name, int time) {
		super(name);
		this.time = time;
	} 
	public String print() {
		return "Cat, " + name;
	}
}

class Dog extends Animal {
	public Dog(String name, int time) {
		super(name);
		this.time = time;
	} 
	public String print() {
		return "Dog, " + name;
	}
}

class AnimalShelter{
	public Queue<Dog> DogQueue = new LinkedList<Dog> ();
    public Queue<Cat> CatQueue = new LinkedList<Cat> ();
    public int time = 0;

	public void enqueue(int type, String name) { // type 0 cat, tpye 1 dog
		if (type < 0 || type > 1) return;
		if (type == 0) {
			Cat cat = new Cat(name, time);
			CatQueue.offer(cat);
		} else {
			Dog dog = new Dog(name, time);
			DogQueue.offer(dog);
		}
		time ++;
	}

	public Dog dequeueDog() {
		if (DogQueue.isEmpty()) {
			return null;
		} else {
			return DogQueue.poll();
		}
	}

	public Cat dequeueCat() {
		if (CatQueue.isEmpty()) {
			return null;
		} else {
			return CatQueue.poll();
		}
	}

	public Animal dequeue() {
		if (CatQueue.isEmpty()) {
			return DogQueue.poll();
		}

		if (DogQueue.isEmpty()) {
			return CatQueue.poll();
		}

		Cat cat = CatQueue.peek();
		Dog dog = DogQueue.peek();

		if (dog.getTime() < cat.getTime()) {
			return (Animal)DogQueue.poll();
		} else {
			return (Animal)CatQueue.poll();
		}
	}

}