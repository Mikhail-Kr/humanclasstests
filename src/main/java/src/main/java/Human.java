package src.main.java;

import java.time.LocalDate;
import java.time.Period;

/**
 * Класс, инициализирующий человека.
 */
public class Human {
  private String firstName;
  private String secondName;
  private String middleName;
  private LocalDate dateOfBirth;
  private final LocalDate lowDate = LocalDate.of(1900, 1, 1);
  private Sex sex;

  /**
   * Конструктор, создающий новый экземпляр класса.
   *
   * @param secondName фамилия.
   * @param firstName имя.
   * @param dateOfBirth дата рождения.
   * @param sex пол.
   */
  public Human(String secondName,
                  String firstName,
                  LocalDate dateOfBirth,
                  Sex sex) {
    this(firstName, secondName, null, dateOfBirth, sex);
  }

  /**
   * Конструктор, создающий новый экземпляр класса.
   *
   * @param secondName фамилия.
   * @param firstName имя.
   * @param middleName отчество.
   * @param dateOfBirth дата рождения.
   * @param sex пол.
   */
  public Human(String secondName,
               String firstName,
               String middleName,
               LocalDate dateOfBirth,
               Sex sex) {
    setFirstName(firstName);
    setSecondName(secondName);
    setDateOfBirth(dateOfBirth);
    setMiddleName(middleName);
    setSex(sex);
  }

  /**
   * Конструктор, копирующий значения полей другого объекта.
   *
   * @param human объект копирования.
   */
  public Human(Human human) {
    this(human.getFirstName(),
            human.getSecondName(),
            human.getMiddleName(),
            human.getDateOfBirth(),
            human.getSex());
  }

  /**
   * Функция устанавливает дату рождения.
   *
   * @param dateOfBirth дата рождения.
   */
  private void setDateOfBirth(LocalDate dateOfBirth) {
    if (dateOfBirth.isBefore(lowDate)) {
      throw new IllegalArgumentException(
              "Задана некорректная дата рождения человеку: '"
                      + dateOfBirth + '\'');
    } else {
      this.dateOfBirth = dateOfBirth;
    }

  }

  /**
   * Фунцкия устанавливает отчество.
   *
   * @param middleName отчество.
   */
  public void setMiddleName(String middleName) {
    if (middleName.matches("\\d+") || middleName == null || middleName.equals("")) {
      throw new IllegalArgumentException("Задано некорректное имя человеку: '"
              + middleName + '\'');
    } else {
      this.middleName = middleName;
    }
  }

  /**
   * Функция устанавливает фамилию.
   *
   * @param secondName имя.
   */
  public void setSecondName(String secondName) {
    if (secondName.matches("\\d+") || secondName == null || secondName.equals("")) {
      throw new IllegalArgumentException("Задано некорректная фамилия человеку: '"
              + secondName + '\'');
    } else {
      this.secondName = secondName;
    }
  }

  /**
   * Функция устанавливает имя.
   *
   * @param firstName имя.
   */
  public void setFirstName(String firstName) {
    if (firstName.matches("\\d+") || firstName == null || firstName.equals("")) {
      throw new IllegalArgumentException("Задано некорректное имя человеку: '"
              + firstName + '\'');
    } else {
      this.firstName = firstName;
    }
  }

  /**
   * Функция возвращает пол.
   *
   * @return sex.
   */
  public Sex getSex() {
    return sex;
  }

  /**
   * Функция задает пол.
   *
   * @param sex пол.
   */
  private void setSex(Sex sex) {
    this.sex = sex;
  }

  /**
   * Функция возвращает дату рождения.
   *
   * @return dateOfBirth.
   */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Функция возвращает отчество.
   *
   * @return middleName.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Функция возвращает фамилию.
   *
   * @return secondName.
   */
  public String getSecondName() {
    return secondName;
  }

  /**
   * Функция возвращает имя.
   *
   * @return firstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Возвращает фамилию и инициалы.
   *
   * @return строка по типу "Красноперов М.В.".
   */
  public String getShortNames() {
    return getSecondName() + " "
            + getFirstName().charAt(0) + "."
            + ("".equals(getMiddleName()) ? "" : getMiddleName().charAt(0) + ".");
  }

  /**
   * Возвращает возраст человека в годах.
   *
   * @return возраст человека.
   */
  public int getAge() {
    return Period.between(LocalDate.now(), dateOfBirth).getYears();
  }

  /**
   * Сравнение двух объектов.
   *
   * @param obj обект для сравнения.
   * @return результат сравнения, true или false.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Human human = (Human) obj;
    return firstName.equals(human.firstName)
            && secondName.equals(human.secondName)
            && middleName.equals(human.middleName)
            && dateOfBirth == human.dateOfBirth
            && sex == human.sex;
  }
}
