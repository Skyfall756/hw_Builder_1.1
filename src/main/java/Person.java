import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String adress) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = adress;
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
        if (age == 0 || getAge().isEmpty()) {
            return false;
        } else return true;
    }

    public boolean hasAdress() {
        if (getAddress() == null || getAddress().isEmpty()) {
            return false;
        } else return true;
    }

    public void happyBirthday() {
        this.age = age + 1;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nSurname: " + surname +
                "\nAge: " + (hasAge() ? age : "Возраст не указан") +
                "\nAddres: " + (hasAdress() ? address : "Адрес не указан\n");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
