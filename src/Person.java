public class Person {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;

    String  setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    String setLastName(String lastName) {
        return this.lastName = lastName;
    }

    String setSex(String sex) {
        return this.sex = sex;
    }

    int setAge(int age) {
        return this.age = age;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getSex() {
        return sex;
    }

    int getAge() {
        return age;
    }
}