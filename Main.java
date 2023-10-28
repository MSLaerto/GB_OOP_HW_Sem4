package sem4hw;
import java.time.LocalDate;

public class Main {
   public static void main(String[] args) {
       TeacherController teacherController = new TeacherController();

       // Создание учителей
       teacherController.createTeacher("Иван", "Иванов", "Иванович", LocalDate.of(1990, 1, 1));
       teacherController.createTeacher("Петр", "Петров", "Петрович", LocalDate.of(1980, 2, 2));
       teacherController.createTeacher("Алексей", "Алексеев", "Алексеевич", LocalDate.of(1970, 3, 3));

       // Отображение списка учителей
       teacherController.displayTeachers();

       // Редактирование учителя
       Teacher teacher = teacherController.getTeacherByIndex(0);
       teacherController.editTeacher(teacher, "Новое имя", "Новая фамилия", "Новое отчество", LocalDate.of(1995, 5, 5));

       // Отображение списка учителей после редактирования
       teacherController.displayTeachers();

       // Сортировка учителей по фамилии
       TeacherService.sortByLastName(teacherController.getTeachers());

       // Отображение списка учителей после сортировки
       teacherController.displayTeachers();
   }
}