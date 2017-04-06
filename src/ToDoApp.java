import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {

  private final static String FILE_NAME = "data.csv";
  private final static String FILE_NAME2 = "addList.csv";
  private static List<String> allToDo = new ArrayList<>();
  private static int num;
  private static String done = "x";
  private static String undone = "[ ]";

  public static void main(String[] args) {

    if (args.length == 0) {
      printUsage();
    } else if (args[0].equals("-l")) {
      listTasks();
    } else if (args[0].equals("-a")) {
      addTasks(args[1]);
    } else if (args[0].equals("-r")) {
      removeTasks(Integer.parseInt(args[1]));
    } else if (args[0].equals("-c")) {
      completeTasks(Integer.parseInt(args[1]));
    }
  }

  public static void printUsage() {
    System.out.println("\n" +"Java myTodo application\n" +
            "=======================\n" +
            "\n" +
            "Command line arguments:\n" +
            " -l   Lists all the tasks\n" +
            " -a   Adds a new task\n" +
            " -r   Removes an task\n" +
            " -c   Completes an task");
  }
  public static void listTasks() {
    Path todoFile = Paths.get(FILE_NAME);
    try {
      allToDo = Files.readAllLines(todoFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (allToDo.size() == 0) {
      System.out.println("No todos for today");
    }
    else {
      for (int i = 0; i < allToDo.size(); i++) {
        System.out.println(i + 1 + " - " +  allToDo.get(i));
      }
    }
  }
  public static void addTasks(String task) {
    Path todoFile = Paths.get(FILE_NAME);

    try {
      allToDo = Files.readAllLines(todoFile);
      allToDo.add("[ ]" + " " + task);
      Files.write(todoFile, allToDo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void removeTasks(int num) {
    Path todoFile = Paths.get(FILE_NAME);
    try {
      allToDo = Files.readAllLines(todoFile);
      allToDo.remove(num - 1);
      Files.write(todoFile, allToDo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void completeTasks(int num) {
    Path todoFile = Paths.get(FILE_NAME);
    try {
      allToDo = Files.readAllLines(todoFile);
      String partOfList = new String(allToDo.get(num - 1));
      allToDo.remove(num - 1 );
      Files.write(todoFile, allToDo);
      char[] partOfListChar = partOfList.toCharArray();
      boolean x = partOfList.contains("[ ]");
      if (x){
        partOfListChar[1] = 'x';
      } else {
        partOfListChar[1] = ' ';
      }
      partOfList = String.valueOf(partOfListChar);
      allToDo.add(num - 1, partOfList);
      Files.write(todoFile, allToDo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
