package org.example.food;

public class Customer {

    public void order(String menuName, Menu menu, Cooking cooking){
        // 메뉴 선택 후, 해당 메뉴를 만듦
        MenuItem menuItem = menu.choose(menuName);
        Cook cook = cooking.makeCook(menuItem);
    }
}
