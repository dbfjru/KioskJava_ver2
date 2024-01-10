import java.util.ArrayList;

public class Coffee extends Menu {
    private double price = 0;
    private static ArrayList<Coffee> coffeeList = new ArrayList<>();
    Coffee() {
        super();
    }

    Coffee(String name, double price, String description) {
        super(name, description);
        this.price = price;
    }

    //Getter
    public double getPrice() {
        return price;
    }
    public Coffee getFromList(int index){
        return coffeeList.get(index);
    }

    //Setter
    public void setPrice(double price) {
        this.price = price;
    }
    public void initList(){
        coffeeList.add(new Coffee("Americano",3.5, "This is Americano."));
        coffeeList.add(new Coffee("Latte",4.5, "This is Latte."));
        coffeeList.add(new Coffee("Espresso",3.0, "This is Espresso."));
    }

    @Override
    public void printList() {
        System.out.println("    [ Coffee Menu ]");
        int index = 1;
        for (Coffee coffee : coffeeList) {
            System.out.print(index++ + ". ");
            coffee.printInfo();
        }
    }

    public void printInfo(){
        System.out.printf("%-10s | W %-5s |%s%n",super.getName(),price,super.getDescription());
    }
}
