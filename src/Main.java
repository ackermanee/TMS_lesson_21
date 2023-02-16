import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Текстовый файл содержит следующую информацию о персонах (Person) (имя, фамилия, пол, возраст).
Путь к файлу должен задаваться через консоль.
Каждое поле в файле разделено запятой.
Написать программу, которая читает информации из входного файла, сортирует персонов по имени и фамилии.
Отсортированные данные вывести в тот же файл, перезаписав его.
На консоль вывести количество человек с возрастом > 30.
На консоль вывести количество мужчин и женщин.

Пример данных в исходном файле:
Jack,Ward,male,16
Alex,Wilson, male,29
Monica,Lopez, female,33

Пример вывода на консоль:
Count: 1
male:2
female:1

Note:
Для работы с файлами можно использовать класс File.
Организовать корректую обработку исключений.
Для сортировки и вычислений можно использовать Stream.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> people = new ArrayList<>();
        int ageCount;
        int maleCount;
        int femaleCount;
        System.out.println("Введите ваш путь к файлу");
        String path = new Scanner(System.in).nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String document;
            String[] infPerson;
            while ((document = br.readLine()) != null) {
                infPerson = document.split(",");
                Person per = new Person();
                per.setFirstName(infPerson[0]);
                per.setLastName(infPerson[1]);
                per.setSex(infPerson[2]);
                per.setAge(Integer.parseInt(infPerson[3]));
                people.add(per);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Не верный путь!");
        }
        people.sort(Comparator.comparing(p -> (p.getFirstName() + p.getLastName())));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Person person : people) {
                bw.write(person.getFirstName() + "," + person.getLastName() + "," +
                        person.getSex() + "," + person.getAge() + "\n");
            }
        }
        catch (IOException ex) {
            throw new RuntimeException();
        }
        ageCount = (int) people.stream().filter(age -> age.getAge() > 30).count();
        System.out.println();
        System.out.println("Count: " + ageCount);
        maleCount = (int) people.stream().filter(male -> male.getSex().trim().equals("male")).count();
        System.out.println("Male: " + maleCount);
        femaleCount = (int) people.stream().filter(female -> female.getSex().trim().equals("female")).count();
        System.out.println("Female: " + femaleCount);
    }
}