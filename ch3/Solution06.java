import java.util.LinkedList;


public class Solution06 {
	public static void main(String[] args){
		AnimalQueue aq = new AnimalQueue();
		Dog d1 = new Dog("Happy");
		Dog d2 = new Dog("Luck");
		Cat c1 = new Cat("Snow");
		aq.enqueue(d1);
		aq.enqueue(d2);
		aq.enqueue(c1);
		
		System.out.println("The custom want to adopt an animal!");
		Animal a1 = aq.dequeueAnimal();
		System.out.println("The animal's name is : " + a1.name);
		
		System.out.println("The custom want to adopt an dog!");
		Dog a2 = aq.dequeueDog();
		System.out.println("The dog's name is : " + a2.name);
		
		System.out.println("The custom want to adopt an cat!");
		Cat a3 = aq.dequeueCat();
		System.out.println("The cat's name is : " + a3.name);
	}

}

class Animal {
	protected String name;
	public int num; // time stamp
	
	Animal(String name){
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
		
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

class AnimalQueue {
	LinkedList<Dog> dog = new LinkedList<Dog> ();
	LinkedList<Cat> cat = new LinkedList<Cat> ();
	private int num = 0;
	
	public void enqueue(Animal a){
		a.setNum(num);
		num++;
		
		if(a instanceof Dog){
			dog.addLast((Dog) a);
		}
		
		if (a instanceof Cat){
			cat.addLast((Cat) a);
		}
	}
	
	public Dog dequeueDog(){
		return dog.pollFirst();
	}
	
	public Cat dequeueCat(){
		return cat.pollFirst();
	}
	
	public Animal dequeueAnimal(){
		if (dog.size() == 0 && cat.size() == 0){
			System.out.println("There is no avaiable animal!");
		}
		
		if (dog.size() == 0){
			return dequeueCat();
		}
		
		if (cat.size() == 0){
			return dequeueDog();
		}
		
		Dog d = dog.peek();
		Cat c = cat.peek();
		if (d.num < c.num){
			return dog.pollFirst();
		}else{
			return cat.pollFirst();
		}
		
	}
	
}