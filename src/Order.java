import java.util.ArrayList;
public class Order {
    private double totalFee;
    private ArrayList<Menu> orderList = new ArrayList<>();
    Order(){}
    void orderProduct(Menu orderedMenu){
        //orderedMenu : 고객이 고른 메뉴, 타입 : (Coffee, Food, Goods) <- Menu를 extends
        orderList.add(orderedMenu);
    }
    void printList(){
        totalFee = 0; // 초기화
        //고객의 장바구니 출력
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("    [Orders]");
        for(Menu menu : orderList){ // orderList 의 요소들이 어떤 타입인지 확인 후 printInfo
            if(menu instanceof Coffee){
                ((Coffee) menu).printInfo();
                totalFee += ((Coffee) menu).getPrice();
            }else if(menu instanceof Food){
                ((Food) menu).printInfo();
                totalFee += ((Food) menu).getPrice();
            }else{
                ((Goods) menu).printInfo();
                totalFee += ((Goods) menu).getPrice();
            }
        }
        System.out.printf("%s%n W %s%n","    [Total]", totalFee);
    }
}
