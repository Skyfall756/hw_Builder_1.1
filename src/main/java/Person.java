import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        if (age == null || getAge().isEmpty()) {
            return false;
        } else return true;
    }

    public boolean hasAdress() {
        if (getAddress() == null || getAddress().isEmpty()) {
            return false;
        } else return true;
    }

    public void happyBirthday(){
        try {
            this.age = age + 1;
        } catch (NullPointerException e) {
            System.out.println("Ошибка в happyBirthday, тк у " + Person.class.getName() +" " + this.getName()
                    + " не указан возраст");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setAge(0)
                .setSurname(this.surname)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "[" + name + ", " + surname + ", " + (hasAge() ? age : "Возраст не указан") + ", "
                + (hasAdress() ? address : "Адрес не указан") + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
