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
  private static String tester4;
  private static String tester5;
  private static String testWord;
  private static List<String> testList1;
  private static List<String> testList2;
  private static List<String> testList3;
  private static List<String> testList4;
  private static List<String> testList5;
  private static Path testPath1;
  private static Path testPath2;
  private static Path testPath3;
  private static Path testPath4;
  private static Path testPath5;
  private static ToDo test;

  @BeforeClass
  public static void beforeAll(){
    tester1 = "testData.csv";
    tester2 = "testAdd.csv";
    tester3 = "testEmptyFile.csv";
    tester4 = "testRemove.csv";
    tester5 = "testComplete.csv";
    testPath1 = Paths.get(tester1);
    testPath2 = Paths.get(tester2);
    testPath3 = Paths.get(tester3);
    testPath4 = Paths.get(tester4);
    testPath5 = Paths.get(tester5);
    testWord = "testing";
    testList1 = new ArrayList<>();
    testList2 = new ArrayList<>();
    testList3 = new ArrayList<>();
    testList4 = new ArrayList<>();
    testList5 = new ArrayList<>();
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
    String new2 = testList2.get(testList2.size() - 1);
    assertEquals(new1, new2);
    test.removeTasks(testList2.size());
  }

  @Test
  public void removeTasks() throws Exception {
    test = new ToDo(tester4, testList4, testPath4);
    testList1 = Files.readAllLines(testPath1);
    testList4 = Files.readAllLines(testPath4);
    assertFalse(testList1.equals(testList4));
    test.removeTasks(testList4.size());
    testList4 = Files.readAllLines(testPath4);
    assertEquals(testList1.size(), testList4.size());
    test.addTasks(testWord);
  }

  @Test
  public void completeTasks() throws Exception {
    test = new ToDo(tester5, testList5, testPath5);
    test.completeTasks(2);
    testList5 = Files.readAllLines(testPath5);
    assertEquals(testList5.get(0),testList5.get(1));
    test.completeTasks(2);
    testList5 = Files.readAllLines(testPath5);
    assertTrue(testList5.get(0) != (testList5.get(1)));
  }
}