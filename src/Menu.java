import java.util.ArrayList;

public class Menu {
    private String name = "";
    private String description = "";
    private static ArrayList<Menu> menuList = new ArrayList<>();

    Menu() {
    }

    Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setter
    public void setName(String _name) {
        name = _name;
    }

    public void setDescription(String _description) {
        description = _description;
    }

    public void initList() {
        menuList.add(new Menu("Coffee", "Enjoy Coffee"));
        menuList.add(new Menu("Food", "Enjoy Food"));
        menuList.add(new Menu("Goods", "Enjoy Goods"));
        menuList.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        menuList.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));
        menuList.add(new Menu("End", "키오스크를 종료합니다."));
    }

    public void printList() {
        int index = 1;
        for (Menu menu : menuList) {
            if (index == 1) { //Category display
                System.out.println("    [ Starbucks Menu ]");
            } else if (index == 4) {
                System.out.println("    [ Order Menu ]");
            } else if (index == 6) {
                System.out.printf("%s%n", "    [ Administrator ]");
            }
            System.out.print(index++ + ". ");
            menu.printInfo();
        }
    }
    private void printInfo() { //개별 메뉴 출력 메소드
        System.out.printf("%-10s | %s%n", name, description);
    }


}
