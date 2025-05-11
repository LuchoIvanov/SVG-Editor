package Commands;
import Application.*;
import Shapes.*;

public class CreateCommand implements Command{

    @Override
    public void execute(String[] args, FileContext context) {
        Shape shape = null;
        String type = args[1].toLowerCase();
        switch(type){
            case "rectangle":
                shape = new Rectangle(Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]), Integer.parseInt(args[5]), args[6]);
                break;
            case "circle":
                shape = new Circle(Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]), args[5]);
                break;
            case "line":
                shape = new Line(Integer.parseInt(args[2]), Integer.parseInt(args[3]),
                        Integer.parseInt(args[4]), Integer.parseInt(args[5]), args[6]);
                break;
            default:
                System.out.println("Invalid");
                return;
        }
        context.shapes.add(shape);
        System.out.println("Successfully created " + type + " (" + context.shapes.size() + ")");
    }
}
