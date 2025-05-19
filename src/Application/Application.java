package Application;
import Commands.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileContext context = new FileContext();

        while(true){
            System.out.print(">");
            String[] tokens = sc.nextLine().split("\\s+");
            if (tokens[0].equalsIgnoreCase("exit")) {
                System.out.println("Exit");
                break;
            }
            Command command = CommandFactory.getCommand(tokens[0]);
            command.execute(tokens, context);
        }
    }
}