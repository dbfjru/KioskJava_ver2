import java.util.ArrayList;
import java.util.Scanner;

public class KioskApp { // 키오스크의 본체는 이곳
    static Scanner sc = new Scanner(System.in);
    private Menu menu = new Menu();
    private Coffee coffee = new Coffee();
    private Food food = new Food();
    private Goods goods = new Goods();
    private Order customer = new Order();
    static private ArrayList<Order> customerList = new ArrayList<>();
    private boolean eachOrder;
    private boolean onOFF = true; //true == ON, false == OFF

    KioskApp() {
        //Itialize List
        menu.initList();
        coffee.initList();
        food.initList();
        goods.initList();
    }

    void printGreeting() { //Greeting Message!
        System.out.println("===========================");
        System.out.println("|  Welcome to Starbucks!  |");
        System.out.println("|   Please choose menu    |");
        System.out.println("===========================");
    }

    int userInput() {
        return sc.nextInt();
    }

    void printMenu() {
        menu.printList();
    }

    void printProduct(int caseNum) {
        switch (caseNum) {
            case 1: //Coffee case
                coffee.printList();
                chooseProduct(coffee, userInput());
                break;
            case 2: //Food case
                food.printList();
                chooseProduct(food, userInput());
                break;
            case 3: //Food case
                goods.printList();
                chooseProduct(goods, userInput());
                break;
            case 4: //Order case
                customer.printList();
                System.out.println("1. 주문       2.메뉴판");
//                int user_input = sc.nextInt();
                if (userInput() == 1) {//주문 결정
                    customerList.add(customer);
                    System.out.println("대기번호는 [" + customerList.size() + "] 번 입니다.");
                    System.out.println("메뉴판으로 돌아갑니다.");
                    System.out.println();
                    eachOrder = false; // 1명 주문 끝
                }else{
                    System.out.println("메뉴판으로 돌아갑니다.");
                }
                break;
            case 5:
                eachOrder = false; // 주문취소
                break;
            default:
                System.out.println("...Kiosk Terminated...");
                onOFF = false;
        }
    }

    void chooseProduct(Menu category, int choice) {
        if (category instanceof Coffee) {
            ((Coffee) category).getFromList(choice - 1).printInfo();
            if (confirm() == 1) {
                customer.orderProduct(((Coffee) category).getFromList(choice - 1));
                System.out.println("Coffeee 가 장바구니에 추가되었습니다.");
            }
        } else if (category instanceof Food) {
            ((Food) category).getFromList(choice - 1).printInfo();
            if (confirm() == 1) {
                customer.orderProduct(((Food) category).getFromList(choice - 1));
                System.out.println("Food 가 장바구니에 추가되었습니다.");
            }
        } else if (category instanceof Goods) {
            ((Goods) category).getFromList(choice - 1).printInfo();
            if (confirm() == 1) {
                customer.orderProduct(((Goods) category).getFromList(choice - 1));
                System.out.println("Goods 가 장바구니에 추가되었습니다.");
            }
        }
    }

    int confirm() {
        System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");
        System.out.println("     1. 확인      2. 취소     ");
        int choice = sc.nextInt();
        if (choice == 1) {
            return 1;
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
            return 0;
        }
    }

    boolean coreApp() {
        customer = new Order();
        eachOrder = true;
        while (eachOrder) {
            printGreeting(); // Welcome message
            printMenu();
            printProduct(userInput());
            if(!onOFF){
                break;
            }
        }
        return onOFF;
    }

}