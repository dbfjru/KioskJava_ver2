import java.util.ArrayList;
public class Food extends Menu{
    private double price = 0;
    private static ArrayList<Food> foodList = new ArrayList<>();
    Food() {
        super();
    }

    Food(String name, double price, String description) {
        super(name, description);
        this.price = price;
    }

    //Getter
    public double getPrice() {
        return price;
    }
    public Food getFromList(int index){
        return foodList.get(index);
    }
    //Setter
    public void setPrice(double price) {
        this.price = price;
    }
    public void initList(){
        foodList.add(new Food("Sandwich", 6.0, "This is Sandwich"));
        foodList.add(new Food("Banana", 1.5, "This is Banana"));
        foodList.add(new Food("Cake", 6.5, "This is Cheese Cake"));
    }

    @Override
    public void printList() {
        System.out.println("    [ Food Menu ]");
        int index = 1;
        for (Food food : foodList) {
            System.out.print(index++ + ". ");
            food.printInfo();
        }
    }
    public void printInfo(){
        System.out.printf("%-10s | W %-5s |%s%n",super.getName(),price,super.getDescription());
    }
}
