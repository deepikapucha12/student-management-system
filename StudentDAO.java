import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    // Insert student
    public static boolean addStudent(Student student) {
        boolean success = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "INSERT INTO students(name, email, course) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // View students
    public static void viewStudents() {
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            System.out.println("ID | Name | Email | Course");
            while(rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("course")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update student
    public static boolean updateStudent(int id, String name) {
        boolean success = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "UPDATE students SET name=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // Delete student
    public static boolean deleteStudent(int id) {
        boolean success = false;
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
