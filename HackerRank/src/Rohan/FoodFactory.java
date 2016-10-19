package Rohan;

public class FoodFactory {
	public String name;
	//public Food food;
	
	public Food getFood(String name) {
	Food food =  new Food(name);
		return food;
	}
	public void serveFood(){
		System.out.println("I'm serving "+getName());
	}
	public String getName() {
		return name;
	}

	
}
