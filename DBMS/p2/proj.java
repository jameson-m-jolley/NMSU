
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;



public class proj {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root"; // Replace with your database username (if needed)
    private static final String DB_PASSWORD = "";//"my-secret-pw"; // Replace with your database password (if needed)
    private static final String DB_PORT = "3306";
    private static final String DB_HOST = "localhost";
    public static void main(String[] args) throws SQLException{


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            // we make a conection to the DBMS
             // this is done with the local host in the example so you will need to update the code if you do what to use a dif serves 
             try(final Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)){
                if(args.length == 0){
                    System.err.println("example usage >> <num of query you would like to execute> <query args>");
                }else {

                 switch (args[0]) {
                     case "1":
                        System.err.println("block 1");
                        findPhysiciansByProcedure(con, args[1]);
                        break;
                     case "2":
                        System.err.println("block 2");
                        break;
                     case "3":
                        System.err.println("block 3");
                         break;
                     case "4":
                     System.err.println("block 4");
                         break;
                     case"5":
                     System.err.println("block 5");
                         break;
                     case"6":
                     System.err.println("block 6");
                         break;
                     case"7":
                     System.err.println("block 7");
                         break;
                     case"8":
                     System.err.println("block 8");
                         break;
                     default:
                     System.err.println("example usage >> <num of query you would like to execute> <query args>");
                         break;
                 }
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
         }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)

        }catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }


    private static void findPhysiciansByProcedure(Connection con, String procedureName) throws SQLException {
        // SQL query to find physicians who have performed the given procedure
        String sql = "SELECT * " +
        "FROM Physician p " +
        "JOIN `Procedure` pr ON pr.procID = p.physicianID " +
        "WHERE pr.name = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, procedureName); // Set the procedure name as a parameter
            ResultSet rs = stmt.executeQuery();

            // Display the results
            while (rs.next()) {
                int physicianID = rs.getInt("physicianID");
                String name = rs.getString("name");
                String position = rs.getString("position");
                String ssn = rs.getString("ssn");

                System.out.printf("physicianID: %d, name: %s, position: %s, ssn: %s%n",
                        physicianID, name, position, ssn);
            }

            if (!rs.isBeforeFirst()) {
                System.out.println("No physicians found for the given procedure.");
            }
        }
    }


    private static void findAppointments(Connection con, String procedureName) throws SQLException {
        // SQL query to find physicians who have performed the given procedure
        String sql = "";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, procedureName); // Set the procedure name as a parameter
            ResultSet rs = stmt.executeQuery();

            // Display the results
            while (rs.next()) {
                int physicianID = rs.getInt("physicianID");
                String name = rs.getString("name");
                String position = rs.getString("position");
                String ssn = rs.getString("ssn");

                System.out.printf("physicianID: %d, name: %s, position: %s, ssn: %s%n",
                        physicianID, name, position, ssn);
            }

            if (!rs.isBeforeFirst()) {
                System.out.println("No physicians found for the given procedure.");
            }
        }
    }
}