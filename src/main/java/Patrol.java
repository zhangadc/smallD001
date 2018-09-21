import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patrol {
    public static void main(String[] args) {
        //初始化一队机器人漫游车
        Scanner sc = new Scanner(System.in);
        List<Car> carList = new ArrayList<Car>();
        System.out.println("(请输入平台右上角坐标)");
        int point = sc.nextInt();
        Car.setMax_x(point / 10);
        Car.setMax_y(point % 10);
        //sc.close();
        Car c1 = new Car(1, 2, "N");
        //System.out.println(Car.getMax_x()+"   "+Car.getMax_y());
        Car c2 = new Car(3, 3, "E");
        carList.add(c1);
        carList.add(c2);
        // System.out.println(carList.get(0));

        task(carList);//考虑到任务可能不只执行一次，所以指令任务封装成方法，以便多次执行
        while (true) {
            System.out.println("输入：1000    退出程序");
            System.out.println("输入其他内容    继续发布指令");
            int finalTask = sc.nextInt();
            if (finalTask == 1000) {
                System.out.println("程序已关闭");
                sc.close();//关流
                break;
            } else {
                task(carList);
            }
        }
    }

    //封装指令
    private static void task(List<Car> carList) {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("(请输入指令,双击Enter结束)");
        List<String> list1 = new ArrayList<>();//收集多行指令
        String s = null;
        while (!(s = sc2.nextLine()).equals("")) {
            list1.add(s);
        }
        //System.out.println(list1);

        //编译指令
        Car car = null;
        outterLoop:
        for (int i = 0; i < list1.size(); i++) {
            //单数行指定小车
            String str = list1.get(i);
            if (i % 2 == 0) {
                for (Car c : carList) {
                    if (str.equalsIgnoreCase(c.toString())) {
                        car = c;
                        break;
                    }
                }
                if (car == null) {
                    System.out.println("无此巡逻车，请核对信息");
                    break;
                }
            }
            //双数行为行动指令
            else {
                String[] task = str.split("");
                for (int j = 0; j < task.length; j++) {
                    if (task[j].equalsIgnoreCase("L") || "R".equalsIgnoreCase(task[j])) {
                        car.changeDir(task[j]);
                    } else if ("M".equalsIgnoreCase(task[j])) {
                        //获得行动前的坐标，发生错误时回档；
                        int currentX = car.getX();
                        int currentY = car.getY();
                        car.move();
                        //判断移动后，位置是否合法
                        if (car.getX() < 0 || car.getX() > Car.getMax_x()) {
                            System.out.println("error:X坐标越界");
                            car.setX(currentX);
                            break outterLoop;
                        }
                        if (car.getY() < 0 || car.getY() > Car.getMax_y()) {
                            System.out.println("error:Y坐标越界");
                            car.setY(currentY);
                            break outterLoop;
                        }

                    } else {
                        System.out.println("非法指令");
                        break outterLoop;
                    }
                }
            }
        }
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i));
        }
    }
}
