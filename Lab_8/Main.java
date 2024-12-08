import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> workers = new ArrayList<>();

        KitchenWorker kw = new KitchenWorker("Иван", "Иванов", "Мужской", true, "Повар", 30000.0, 5, "Кухня", "Гриль", true);
        OfficeWorker ow = new OfficeWorker("Мария", "Петрова", "Женский", true, "Менеджер", 40000.0, 7, "Администрация", "Туалет", 10);
        GuardWorker gw = new GuardWorker("Сергей", "Сидоров", "Мужской", true, "Охранник", 25000.0, 3, "Безопасность", "отъеб*сь на", true);

        workers.add(kw);
        workers.add(ow);
        workers.add(gw);

        for (Employee worker : workers) {
            worker.work();
            if (worker instanceof KitchenWorker) {
                ((KitchenWorker) worker).cleanDishes();
            } else if (worker instanceof OfficeWorker) {
                ((OfficeWorker) worker).organizeMeeting();
            } else if (worker instanceof GuardWorker) {
                ((GuardWorker) worker).monitorSecurity();
            }
            worker.sleep();
            System.out.println();
        }
    }
}

class Person {
    private String name;
    private String surname;
    private String gender;
    private boolean active;

    public Person(String name, String surname, String gender, boolean active) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.active = active;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public void sleep() {
        System.out.println(name + " " + surname + " спит.");
    }
}

class Employee extends Person implements Worker {
    private String position;
    private double payment;
    private int experience;
    private String department;

    public Employee(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department) {
        super(name, surname, gender, active);
        this.position = position;
        this.payment = payment;
        this.experience = experience;
        this.department = department;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getPayment() { return payment; }
    public void setPayment(double payment) { this.payment = payment; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}

interface Worker {
    default void work() {
        System.out.println("Работник выполняет работу.");
    }
}

class KitchenWorker extends Employee {
    private String kitchenSection;
    private boolean hasCertification;

    public KitchenWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String kitchenSection, boolean hasCertification) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.kitchenSection = kitchenSection;
        this.hasCertification = hasCertification;
    }

    public String getKitchenSection() { return kitchenSection; }
    public void setKitchenSection(String kitchenSection) { this.kitchenSection = kitchenSection; }

    public boolean isHasCertification() { return hasCertification; }
    public void setHasCertification(boolean hasCertification) { this.hasCertification = hasCertification; }

    @Override
    public void work() {
        System.out.println(getName() + " " + getSurname() + " работает в секции: " + kitchenSection);
    }

    public void cleanDishes() {
        System.out.println(getName() + " " + getSurname() + " моет посуду.");
    }
}

class OfficeWorker extends Employee {
    private String officeType;
    private int numberOfComputers;

    public OfficeWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String officeType, int numberOfComputers) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.officeType = officeType;
        this.numberOfComputers = numberOfComputers;
    }

    public String getOfficeType() { return officeType; }
    public void setOfficeType(String officeType) { this.officeType = officeType; }

    public int getNumberOfComputers() { return numberOfComputers; }
    public void setNumberOfComputers(int numberOfComputers) { this.numberOfComputers = numberOfComputers; }

    @Override
    public void work() {
        System.out.println(getName() + " " + getSurname() + " работает в офисе типа: " + officeType);
    }

    public void organizeMeeting() {
        System.out.println(getName() + " " + getSurname() + " организует встречу.");
    }
}

class GuardWorker extends Employee {
    private String shift;
    private boolean hasWeaponLicense;

    public GuardWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String shift, boolean hasWeaponLicense) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.shift = shift;
        this.hasWeaponLicense = hasWeaponLicense;
    }

    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }

    public boolean isHasWeaponLicense() { return hasWeaponLicense; }
    public void setHasWeaponLicense(boolean hasWeaponLicense) { this.hasWeaponLicense = hasWeaponLicense; }

    @Override
    public void work() {
        System.out.println(getName() + " " + getSurname() + " работает на " + shift + " смене.");
    }

    public void monitorSecurity() {
        System.out.println(getName() + " " + getSurname() + " смотрит tik tok.");
    }
}
