package cn.tx.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishApp {
    // 菜单 泛型
    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> personDishList = new ArrayList<>();

    public static void main(String[] args){
        // 先初始化菜品
        initDish();
        System.out.println(dishList);
        //  展示主菜单
        // 获取输入
        Scanner scan = new Scanner(System.in);
        while (true){
            showMenu();
            int num = scan.nextInt();
            System.out.println("输入数据为：" + num);
            switch (num){
                case 1:
                    showDishMenu();
                    break;
                case 2:
                    showPersonDish();
                    break;
                case 3:
                    buy();
                    return;
            }
        }
    }

    public static  void showMenu(){
        System.out.println("-----主菜单------");
        System.out.println("菜单\t\t\t1");
        System.out.println("已点菜品\t\t2");
        System.out.println("买单\t\t\t3");
        System.out.println("---根据编号选择服务---");
    }
    public static void initDish (){
        Dish dish1 = new Dish(1, "铁锅炖大鹅", 28);
        dishList.add(dish1);
        dishList.add(new Dish(2, "炖乌龟", 59));
        dishList.add(new Dish(3, "凉菜", 12));
        dishList.add(new Dish(4, "地三鲜", 20));
    }

    public static void showDishMenu(){
        System.out.println("--请您开始点菜--");
        for (Dish dish : dishList) {
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
        Scanner scan = new Scanner(System.in);
        while (true){
            System.out.println("--请输入序号点菜，输入0返回上一级--");
            int num = scan.nextInt();
            if (num == 0){
                return;
            }else {
                Dish dish = dishList.get(num-1);
                personDishList.add(dish);
                System.out.println("成功点菜:" + dish.name);
            }
        }
    }

    public static void showPersonDish(){
        System.out.println("--已点菜品为--");
        for (Dish dish: personDishList){
            System.out.println(dish.id + "\t" + dish.name + "\t" + dish.price);
        }
    }

    public static void buy(){
        double totalPrice = 0.;
        for (Dish dish: personDishList){
            totalPrice = totalPrice + dish.price;

        }
        System.out.println("总的消费金额为：" + totalPrice);
    }
}
