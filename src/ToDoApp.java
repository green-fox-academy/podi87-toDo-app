import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {

  private final static String FILE_NAME = "data.csv";

  public static void main(String[] args) {
    List<String> allToDo = new ArrayList<>();
    List<String> done = new ArrayList<>();
    List<String> undone = new ArrayList<>();

    //System.out.println(allToDo.get(0));
    if (args.length == 0) {
      System.out.println("\n" +"Java myTodo application\n" +
              "=======================\n" +
              "\n" +
              "Command line arguments:\n" +
              " -l   Lists all the tasks\n" +
              " -a   Adds a new task\n" +
              " -r   Removes an task\n" +
              " -c   Completes an task");
    }
    else if (args[0].equals("-l")) {
      Path path = Paths.get(FILE_NAME);
      try {
        allToDo = Files.readAllLines(path);
      } catch (IOException e) {
        e.printStackTrace();
      }
       if (allToDo.size() == 0) {
         System.out.println("No todos for today");
       }
       else {
        for (int i = 0; i < allToDo.size(); i++) {
          System.out.println(i + 1 + " - " + allToDo.get(i));
        }
       }
    }



  }

}
