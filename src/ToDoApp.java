
public class ToDoApp {

  public static void main(String[] args) {
    ToDo functions = new ToDo();

    if (args.length == 0) {
      functions.printUsage();
    } else if (args[0].equals("-l")) {
      functions.listTasks();
    } else if (args[0].equals("-a")) {
      functions.addTasks(args[1]);
    } else if (args[0].equals("-r")) {
      functions.removeTasks(Integer.parseInt(args[1]));
    } else if (args[0].equals("-c")) {
      functions.completeTasks(Integer.parseInt(args[1]));
    } else {
      System.out.println("Unsupported argument");
    }
  }
}
