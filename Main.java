import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    Student student = new Student(name, email, course);

                    if (StudentDAO.addStudent(student)) {
                        System.out.println("✔ Student added successfully!");
                    } else {
                        System.out.println("✖ Failed to add student.");
                    }
                    break;

                case 2:
                    StudentDAO.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    if (StudentDAO.updateStudent(updateId, newName)) {
                        System.out.println("✔ Student updated successfully!");
                    } else {
                        System.out.println("✖ Update failed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (StudentDAO.deleteStudent(deleteId)) {
                        System.out.println("✔ Student deleted successfully!");
                    } else {
                        System.out.println("✖ Delete failed.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program…");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
