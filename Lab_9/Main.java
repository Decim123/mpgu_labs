import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class NotCorrectAgeException extends Exception {
    public NotCorrectAgeException(String message) {
        super(message);
    }
}

class GroupFullException extends Exception {
    public GroupFullException(String message) {
        super(message);
    }
}

class GroupTooSmallException extends Exception {
    public GroupTooSmallException(String message) {
        super(message);
    }
}

class Student {
    private int age;
    private String gender;
    private String firstName;
    private String lastName;
    private String middleName;
    private int course;
    private double gradePointAverage;

    public Student() {}

    public Student(int age, String gender, String firstName, String lastName,
                   String middleName, int course, double gradePointAverage) throws NotCorrectAgeException {
        setAge(age);
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.course = course;
        this.gradePointAverage = gradePointAverage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws NotCorrectAgeException {
        if (age < 16 || age > 60) {
            throw new NotCorrectAgeException("Возраст должен быть от 16 до 60 лет.");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "Возраст=" + age +
                ", Пол='" + gender + '\'' +
                ", Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", Отчество='" + middleName + '\'' +
                ", Курс=" + course +
                ", Средний балл=" + gradePointAverage +
                '}';
    }
}

class Group {
    private ArrayList<Student> students;
    private final int MAX_SIZE = 15;
    private final int MIN_SIZE = 3;

    public Group() {
        students = new ArrayList<>();
    }

    public void addStudent() throws GroupFullException, NotCorrectAgeException {
        if (students.size() >= MAX_SIZE) {
            throw new GroupFullException("Группа уже заполнена. Невозможно добавить нового студента.");
        }

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите данные студента:");
            System.out.print("Имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Фамилия: ");
            String lastName = scanner.nextLine();
            System.out.print("Отчество: ");
            String middleName = scanner.nextLine();
            System.out.print("Пол: ");
            String gender = scanner.nextLine();
            System.out.print("Возраст: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Курс: ");
            int course = Integer.parseInt(scanner.nextLine());
            System.out.print("Средний балл: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            Student student = new Student(age, gender, firstName, lastName, middleName, course, gpa);
            students.add(student);
            System.out.println("Студент успешно добавлен.");
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод данных. Попробуйте снова.");
        }
    }

    public void addStudent(Student student) throws GroupFullException {
        if (students.size() >= MAX_SIZE) {
            throw new GroupFullException("Группа уже заполнена. Невозможно добавить нового студента.");
        }
        students.add(student);
        System.out.println("Студент успешно добавлен.");
    }

    public void removeStudent(int index) throws GroupTooSmallException, IndexOutOfBoundsException {
        if (students.size() <= MIN_SIZE) {
            throw new GroupTooSmallException("Группа должна содержать не менее 3 студентов.");
        }
        if (index < 0 || index >= students.size()) {
            throw new IndexOutOfBoundsException("Неверный индекс. Невозможно удалить студента.");
        }
        students.remove(index);
        System.out.println("Студент успешно удален.");
    }

    public Student getStudent(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= students.size()) {
            throw new IndexOutOfBoundsException("Неверный индекс. Невозможно получить студента.");
        }
        return students.get(index);
    }

    public void displayGroup() {
        if (students.isEmpty()) {
            System.out.println("Группа пуста.");
            return;
        }
        System.out.println("Список студентов в группе:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Добавление студентов через консоль:");
            for (int i = 0; i < 3; i++) {
                group.addStudent();
            }

            System.out.println("\nДобавление студента через объект:");
            Student student = new Student(20, "Мужской", "Алёша", "нет", "Попович", 3, 4.5);
            group.addStudent(student);

            System.out.println("\nТекущий список студентов:");
            group.displayGroup();

            System.out.print("\nВведите номер студента для доступа: ");
            int accessIndex = Integer.parseInt(scanner.nextLine()) - 1;
            Student accessedStudent = group.getStudent(accessIndex);
            System.out.println("Доступ к студенту: " + accessedStudent);

            System.out.print("\nВведите номер студента для удаления: ");
            int deleteIndex = Integer.parseInt(scanner.nextLine()) - 1;
            group.removeStudent(deleteIndex);

            System.out.println("\nСписок студентов после удаления:");
            group.displayGroup();

            System.out.println("\nПопытка добавить больше студентов:");
            for (int i = group.getStudents().size(); i < 16; i++) {
                group.addStudent(new Student(18 + i % 5, "Женский", "Мария" + i, "Иванова" + i, "Сергеевна", 1 + i % 4, 4.0 + (i % 5) * 0.1));
            }

        } catch (GroupFullException | GroupTooSmallException | NotCorrectAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Некорректный формат ввода.");
        } finally {
            scanner.close();
        }
    }
}
