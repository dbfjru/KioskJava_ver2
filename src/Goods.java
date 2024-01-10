import java.util.ArrayList;

public class Goods extends Menu {
    private double price = 0;
    private static ArrayList<Goods> goodsList = new ArrayList<>();
    Goods() {
        super();
    }

    Goods(String name, double price, String description) {
        super(name, description);
        this.price = price;
    }

    //Getter
    public double getPrice() {
        return price;
    }
    public Goods getFromList(int index){
        return goodsList.get(index);
    }
    //Setter
    public void setPrice(double price) {
        this.price = price;
    }
    public void initList(){
        goodsList.add(new Goods("Mug", 7.0, "This is Mug"));
        goodsList.add(new Goods("Tumbler", 15.0, "This is Tumbler"));
        goodsList.add(new Goods("Plate", 10.0, "This is Tungsten Plate"));
    }

    @Override
    public void printList() {
        System.out.println("    [ Goods Menu ]");
        int index = 1;
        for (Goods goods : goodsList) {
            System.out.print(index++ + ". ");
            goods.printInfo();
        }
    }

    public void printInfo(){
        System.out.printf("%-10s | W %-5s |%s%n",super.getName(),price,super.getDescription());
    }
}
