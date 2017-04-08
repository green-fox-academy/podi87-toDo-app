import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDo {

  String FILE_NAME;
  String usage;
  List<String> allToDo;
  int num;
  Path path;

  public ToDo(String FILE_NAME, List<String> allToDo, Path path) {
  this.FILE_NAME = FILE_NAME;
  this.allToDo = allToDo;
  this.path = path;
  }

  public ToDo() {
  }

  public void printUsage(String usage) {
    System.out.println(usage);
  }

  public void listTasks(List<String> allToDo) {
    path = Paths.get(FILE_NAME);
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
        System.out.println(i + 1 + " - " +  allToDo.get(i));
      }
    }
  }

  public void addTasks(String task) {
    path = Paths.get(FILE_NAME);
    try {
      allToDo = Files.readAllLines(path);
      allToDo.add("[ ]" + " " + task);
      Files.write(path, allToDo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void removeTasks(int num) {
    path = Paths.get(FILE_NAME);
    try {
      allToDo = Files.readAllLines(path);
      allToDo.remove(num - 1);
      Files.write(path, allToDo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void completeTasks(int num) {
    path = Paths.get(FILE_NAME);
    try {
      allToDo = Files.readAllLines(path);
      String partOfList = new String(allToDo.get(num - 1));
      allToDo.remove(num - 1 );
      Files.write(path, allToDo);
      char[] partOfListChar = partOfList.toCharArray();
      boolean x = partOfList.contains("[ ]");
      if (x){
        partOfListChar[1] = 'x';
      } else {
        partOfListChar[1] = ' ';
      }
      partOfList = String.valueOf(partOfListChar);
      allToDo.add(num - 1, partOfList);
      Files.write(path, allToDo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
