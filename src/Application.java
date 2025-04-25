import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static List<Shape> shapes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print(">");
            String cmd[] = sc.nextLine().split("\\s+");
            switch (cmd[0]){
                case "open":
                    open(cmd[1]);
                    break;
                case "print":
                    print();
                    break;
                case "create":
                    create(cmd);
                    break;
                case "erase":
                    erase(Integer.parseInt(cmd[1]));
                    break;
                case "translate":
                    translate(cmd);
                    break;
                case "within":
                    break;
                case "save":
                    break;
                case "saveas":
                    break;
                case "close":
                    break;
                case "help":
                    help();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
    }

    static void open(String filename){

    }

    static void print(){
        for(int i = 0; i < shapes.size(); i++){
            System.out.printf("%d. %s \n", i + 1, shapes.get(i));
        }
    }

    static void create(String[] cmd){
        Shape shape = null;
        switch(cmd[1]){
            case "rectangle":
                shape = new Rectangle(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                                      Integer.parseInt(cmd[4]), Integer.parseInt(cmd[5]), cmd[6]);
                break;
            case "circle":
                shape = new Circle(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                        Integer.parseInt(cmd[4]), cmd[5]);
                break;
            case "line":
                shape = new Line(Integer.parseInt(cmd[2]), Integer.parseInt(cmd[3]),
                        Integer.parseInt(cmd[4]), Integer.parseInt(cmd[5]), cmd[6]);
                break;
            default:
                System.out.println("Invalid");
                return;
        }
        shapes.add(shape);
        System.out.println("Successfully created " + cmd[1] + " (" + shapes.size() + ")");
    }
    static void erase(int index){
        if(index < 1 || index > shapes.size()){
            System.out.println("No such index");
        }
        else{
            System.out.println("Erased a " + shapes.get(index - 1));
        }
    }

    static void translate(String cmd[]){
        int dx = 0;
        int dy = 0;
        for (String part : cmd) {
            if (part.startsWith("horizontal=")) dx = Integer.parseInt(part.split("=")[1]);
            if (part.startsWith("vertical=")) dy = Integer.parseInt(part.split("=")[1]);
        }
        shapes.get(Integer.parseInt(cmd[1]) - 1).translate(dx, dy);
        System.out.println("Shape translated successfully");
    }

    static void within(){

    }

    static void save(){

    }

    static void saveas(){

    }

    static void close(){

    }

    static void help(){
        System.out.println("Supported commands: open, print, create, erase, translate, within, save, saveas, close, help, exit");
    }

    static void exit(){

    }
}