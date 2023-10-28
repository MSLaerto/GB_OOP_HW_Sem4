package sem4hw;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Teacher {
    String firstName;
    String secondName;
    String patronymic;
    LocalDate dateOfBirth;

   public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
       this.firstName = firstName;
       this.secondName = secondName;
       this.patronymic = patronymic;
       this.dateOfBirth = dateOfBirth;
   }

   public String getFirstName() {
       return firstName;
   }

   public String getSecondName() {
       return secondName;
   }

   public String getPatronymic() {
       return patronymic;
   }

   public LocalDate getDateOfBirth() {
       return dateOfBirth;
   }
}
class TeacherService {
   // Функция сортировки учителей по фамилии
   public static void sortByLastName(List<Teacher> teachers) {
       Collections.sort(teachers, Comparator.comparing(Teacher::getSecondName));
   }
}

class TeacherView {
   // Вывод конкретного Teacher в консоль
   public static void displayTeacher(Teacher teacher) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       String formattedDateOfBirth = teacher.getDateOfBirth().format(formatter);

       System.out.println("Имя: " + teacher.getFirstName());
       System.out.println("Фамилия: " + teacher.getSecondName());
       System.out.println("Отчество: " + teacher.getPatronymic());
       System.out.println("Дата рождения: " + formattedDateOfBirth);
   }
}

class TeacherController {
   private List<Teacher> teachers;

   public TeacherController() {
       this.teachers = new ArrayList<>();
   }

   public List<Teacher> getTeachers() {
       return this.teachers ;
   }

    public Teacher getTeacherByIndex(int ind) {
       return this.teachers.get(ind) ;
   }
 
   public void createTeacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
       Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth);
       teachers.add(teacher);
   }

   public void editTeacher(Teacher teacher, String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
       teacher.firstName = firstName;
       teacher.secondName = secondName;
       teacher.patronymic = patronymic;
       teacher.dateOfBirth = dateOfBirth;
   }

   public void displayTeachers() {
       for (Teacher teacher : teachers) {
           TeacherView.displayTeacher(teacher);
           System.out.println();
       }
   }
}