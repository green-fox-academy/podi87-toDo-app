import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {
  private static String FILE_NAME = "data.csv";
  private static Path todoFile = Paths.get(FILE_NAME);
  private static List<String> allToDo = new ArrayList<>();
  private static String usage = "\n" +"Java myTodo application\n" +
          "=======================\n" +
          "\n" +
          "Command line arguments:\n" +
          " -l   Lists all the tasks\n" +
          " -a   Adds a new task\n" +
          " -r   Removes a task\n" +
          " -c   Completes a task";

  public static void main(String[] args) {
    ToDo toDo = new ToDo(FILE_NAME, allToDo,todoFile);

    if (args.length == 0) {
      toDo.printUsage(usage);
    } else if (args[0].equals("-l")) {
      toDo.listTasks(allToDo);
    } else if (args[0].equals("-a")) {
      toDo.addTasks(args[1]);
    } else if (args[0].equals("-r")) {
      toDo.removeTasks(Integer.parseInt(args[1]));
    } else if (args[0].equals("-c")) {
      toDo.completeTasks(Integer.parseInt(args[1]));
    } else {
      System.out.println("Unsupported argument");
    }
  }
}
