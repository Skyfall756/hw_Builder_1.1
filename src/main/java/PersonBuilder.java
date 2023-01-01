public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Некорректный возраст");
        } else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || name.isEmpty()) throw new IllegalStateException("Не указали имя");
        if (surname == null || surname.isEmpty()) throw new IllegalStateException("Не указали фамилию");
        else return new Person(name,surname,age, address);
    }
}
