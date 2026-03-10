
import java.util.*;
import java.util.stream.Collectors;

 class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 4, 2, 8, 9, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");

        // 1. Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("1. Even numbers: " + evenNumbers);

        // 2. Convert to uppercase
        List<String> upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("2. Uppercase: " + upperCaseStrings);

        // 3. Count strings starting with 'a'
        long countA = strings.stream()
                .filter(s -> s.startsWith("a"))
                .count();
        System.out.println("3. Count starting with 'a': " + countA);

        // 4. Sort in descending order
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("4. Sorted descending: " + sortedDesc);

        // 5. Max and Min
        int max = numbers.stream().max(Integer::compare).orElse(0);
        int min = numbers.stream().min(Integer::compare).orElse(0);
        System.out.println("5. Max: " + max + ", Min: " + min);

        // 6. Remove duplicates
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("6. Unique: " + uniqueNumbers);

        // 7. Concatenate into a comma-separated string
        String joined = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println("7. Joined: " + joined);

        // --- Работа со студентами ---
        List<Student> students = Arrays.asList(
                new Student("Alice", "Group-A", 3.8),
                new Student("Bob", "Group-B", 3.2),
                new Student("Charlie", "Group-A", 3.9),
                new Student("Diana", "Group-C", 3.4),
                new Student("Eve", "Group-B", 4.0)
        );

        // 8. Group students by group field
        Map<String, List<Student>> groupedByGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));
        System.out.println("8. Grouped by group: " + groupedByGroup);

        // 9. Average GPA
        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
        System.out.printf("9. Average GPA: %.2f\n", averageGpa);

        // 10. First 3 students with GPA > 3.5
        List<Student> top3 = students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("10. First 3 with GPA > 3.5: " + top3);

        // 11. Count students with GPA > 3.5
        long countHighGpa = students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .count();
        System.out.println("11. Count GPA > 3.5: " + countHighGpa);
    }
}

class Student {
    private String name;
    private String group;
    private double gpa;

    public Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String getGroup() { return group; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return name + "(" + gpa + ")";
    }
}