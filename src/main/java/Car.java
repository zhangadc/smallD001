/**
 * @author Administrator
 */
public class Car {
    private int x;
    private int y;
    private static int max_x;
    private static int max_y;
    private String direction;
    private static final String arrays = "ESWN";

    public Car() {
    }

    public Car(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**改变方向的方法
     *
     * @param LR
     */
    public void changeDir(String LR){
        int positon = arrays.indexOf(direction);
        int index;//改变方向后的索引
        if ("R".equalsIgnoreCase(LR)){
            positon++;
        }
        if ("L".equalsIgnoreCase(LR)){
            positon=positon+3;
        }
        index = positon % 4;
        direction = String.valueOf(arrays.charAt(index));
    }

    /**输入M后执行动作（视方向而定）
     *
     */
    public void move(){
        if ("E".equalsIgnoreCase(direction)){
            x++;
        }else if ("W".equalsIgnoreCase(direction)){
            x--;
        }else if ("S".equalsIgnoreCase(direction)){
            y--;
        }else {
            y++;
        }
    }

    public int getX() {
        /**
         *
         * 功能描述:
         *
         * @param: []
         * @return: int
         * @auther: Administrator
         * @date: 2018/9/20 23:10
         */
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public static int getMax_x() {
        return max_x;
    }

    public static void setMax_x(int max_x) {
        Car.max_x = max_x;
    }

    public static int getMax_y() {
        return max_y;
    }

    public static void setMax_y(int max_y) {
        Car.max_y = max_y;
    }

    @Override
    public String toString() {
        return x + "" + y + " " + direction;
    }
}
