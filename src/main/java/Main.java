import java.time.LocalDate;
import src.main.java.Human;
import src.main.java.Sex;

public class Main {
  /**
   * Проверяет работу классов, созданных
   * в рамках выполнения задания.
   *
   * @param args аргументы командной строки.
   */
  public static void main(String[] args) {
    //Проверка методов setDateOfBirth, getSex
    LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
    Human human = new Human("Иванов", "Иван", "Иванович", dateOfBirth, Sex.Male);
    if (!human.getDateOfBirth().equals(dateOfBirth)) {
      System.err.println("Некорректная работа Human.setDateOfBirth()");
    }
    if (!human.getSex().equals(Sex.Male)) {
      System.err.println("Некорректная работа Human.setSex()");
    }

    // Проверка негативного использования метода Human.setDateOfBirth()
    boolean thrown = false;
    try {
      dateOfBirth = LocalDate.of(1000, 1, 1);
      human = new Human("Иванов", "Иван", "Иванович", dateOfBirth, Sex.Male);
    } catch (IllegalArgumentException ex) {
      thrown = true;
    }
    if (!thrown) {
      System.err.println("Некорректная работа метода Human.setBirthDate()");
    }

    // Проверка позитивного использования метода Human.setSecondName()
    human.setSecondName("Красноперов");
    if (!human.getSecondName().equals("Красноперов")) {
      System.err.println("Некорректная работа позитивного использования Human.setSecondName()");
    }

    // Проверка негативного использования метода Human.setSecondName()
    thrown = false;
    try {
      human.setSecondName("");
    } catch (IllegalArgumentException ex) {
      thrown = true;
    }
    if (!thrown) {
      System.err.println("Некорректная работа негативного использования Human.setSecondName()");
    }

    // Проверка позитивного использования метода Human.setFirstName()
    human.setFirstName("John");
    if (!human.getFirstName().equals("John")) {
      System.err.println("Некорректная работа позитивного использования Human.setFirstName()");
    }

    // Проверка негативного использования метода Human.setFirstName()
    thrown = false;
    try {
      human.setFirstName("");
    } catch (IllegalArgumentException ex) {
      thrown = true;
    }
    if (!thrown) {
      System.err.println("Некорректная работа негативного использования Human.setFirstName()");
    }

    // Проверка позитивного использования метода Human.setMiddleName()
    human.setMiddleName(null);
    if (!human.getMiddleName().equals("")) {
      System.err.println("Некорректная работа позитивного использования Human.setMiddleName()");
    }
    human.setMiddleName("Андреевич");
    if (!human.getMiddleName().equals("Андреевич")) {
      System.err.println("Некорректная работа позитивного использования Human.setMiddleName()");
    }

    // Проверка метода Human.equals() сравнения экземпляра класса с другим экземпляром класса
    dateOfBirth = LocalDate.of(1990, 5, 2);
    human = new Human("Иванова", "Анна", "Ивановна", dateOfBirth, Sex.Female);
    Human human2 = new Human(human);
    if (human.equals(human2) || !human.equals(human2)) {
      System.err.println("Некорректная работа сравнения экземпляра"
              + " класса с другим экземпляром класса Human");
    }

    // Проверка метода получения инициалов
    if (!human.getShortNames().equals("Иванова А.И.")) {
      System.err.println("Некорректная работа получения инициалов");
    }
    human.setMiddleName("");
    if (!human.getShortNames().equals("Иванова А.")) {
      System.err.println("Некорректная работа получения инициалов");
    }

    // Проверка метода возврата возраста
    if (human.getAge() != 31) {
      System.err.println("Некорректная работа метода получения возраста человека");
    }
  }
}