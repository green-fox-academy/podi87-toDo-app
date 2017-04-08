import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ToDoTest {

  private static String tester1;
  private static String tester2;
  private static String tester3;
  private static String testWord;
  private static List<String> testList1;
  private static List<String> testList2;
  private static List<String> testList3;
  private static int testnum;
  private static Path testPath1;
  private static Path testPath2;
  private static Path testPath3;
  private static ToDo test;

  @BeforeClass
  public static void beforeAll(){
    tester1 = "testData.csv";
    tester2 = "testData1.csv";
    tester3 = "testEmptyFile";
    testPath1 = Paths.get(tester1);
    testPath2 = Paths.get(tester2);
    testPath3 = Paths.get(tester3);
    testWord = "testing";
    testList1 = new ArrayList<>();
    testList2 = new ArrayList<>();
    testList3 = new ArrayList<>();


  }

  @Test
  public void printUsage() throws Exception {
    test = new ToDo();
    test.printUsage(testWord);
  }

  @Test
  public void listTasks() throws Exception {
    test = new ToDo(tester3, testList3, testPath3);
    testList3 = Files.readAllLines(testPath3);
    test.listTasks(testList3);
    test = new ToDo(tester1, testList1, testPath1);
    testList1 = Files.readAllLines(testPath1);
    test.listTasks(testList1);
  }

  @Test
  public void addTasks() throws Exception {
    test = new ToDo(tester2, testList2, testPath2);
    testList1 = Files.readAllLines(testPath1);
    test.addTasks(testWord);
    testList2 = Files.readAllLines(testPath2);
    String new1 = testList1.get(1);
    System.out.println(new1);
    String new2 = testList2.get(1);
    System.out.println(new2);
    assertEquals(new1, new2);
  }


  @Test
  public void removeTasks() throws Exception {
    test = new ToDo(tester2, testList2, testPath2);
    testList1 = Files.readAllLines(testPath1);
    test.addTasks(testWord);
    testList2 = Files.readAllLines(testPath2);
    String new1 = testList1.get(1);
    System.out.println(new1);
    String new2 = testList2.get(1);
    System.out.println(new2);
    assertEquals(new1, new2);
  }

  @Test
  public void completeTasks() throws Exception {

  }

}