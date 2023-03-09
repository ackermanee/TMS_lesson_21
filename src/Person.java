public class Person {
    private String firstName;
    private String lastName;
    private String sex;
    private int age;

    protected String setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    protected String setLastName(String lastName) {
        return this.lastName = lastName;
    }

    protected String setSex(String sex) {
        return this.sex = sex;
    }

    protected int setAge(int age) {
        return this.age = age;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected String getSex() {
        return sex;
    }

    protected int getAge() {
        return age;
    }
}