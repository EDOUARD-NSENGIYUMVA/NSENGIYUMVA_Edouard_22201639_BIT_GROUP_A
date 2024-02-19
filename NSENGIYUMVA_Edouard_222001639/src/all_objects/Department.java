package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Department {
	            private int Department_id;
				private String Department_name;
				private String location;
				private String budget;
				public Department() {}
				public Department(int Department_id, String Department_name , String department_id, String location, String budget ) {
					this.Department_id =  Department_id;
					this.Department_name = Department_name;
					this.location = location;
					this.budget = budget;
				}
				
				public Department( String Department_name, String departmentid, String location, String budget) {
					this.Department_name= Department_name;
					this.location= location;
					this.budget=budget;
					}
				
				public int getDepartment_id() {
					return Department_id;
				}
				public void setDepartment_id(int department_id) {
					Department_id = department_id;
				}
				public String getDepartment_name() {
					return Department_name;
				}
				public void setDepartment_name(String department_name) {
					Department_name = department_name;
				}
				public String getLocation() {
					return location;
				}
				public void setLocation(String location) {
					this.location = location;
				}
				public String getBudget() {
					return budget;
				}
				public void setBudget(String budget) {
					this.budget = budget;
				}
				public void makeconnection() {
				}
				public void insertData(String department, String location,String budget) {
					// JDBC URL, username, and password of MySQL server
				    String host = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to insert data
				   String sql = "INSERT INTO department (department_name, location, budget) VALUES (?, ?, ?)";

				
				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
							   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				        preparedStatement.setString(1, department);
				        preparedStatement.setString(2, location);
				        preparedStatement.setString(3, budget);

				        // Execute the query
				        int rowsAffected = preparedStatement.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				        	System.out.println("Data inserted successfully!");
				            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            System.out.println("Failed to insert data.");
				            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }	
				}
				public void insertData11() {
					// JDBC URL, username, and password of MySQL server
				    String host = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to insert data
				    String sql = "INSERT INTO Department (Department_name,location,budget) VALUES ( ?, ?,?)";

				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
				    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, this.Department_name);
				        preparedStatement.setString(2, this.location);
				        preparedStatement.setString(3, this.budget);
				     
				       
				        // Execute the query
				        int rowsAffected = preparedStatement.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				        	System.out.println("Data inserted successfully!");
				            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
				        } else {
				            System.out.println("Failed to insert data.");
				            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }	
				}

				public void readwithID1(int inputid) {
					// JDBC URL, username, and password of MySQL server
				    String url = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to select all columns from student where id = ?
				    String sql = "SELECT * FROM Department WHERE Department_id = ?";

				    try (
				        // Establish the connection
				        Connection connection = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement preparedStatement = connection.prepareStatement(sql);
				    ) {
				        // Set the value for the parameterized query
				       
				    	preparedStatement.setInt(1, inputid);

				        // Execute the query and get the result set
				        ResultSet resultSet = preparedStatement.executeQuery();

				        // Process the result set
				        while (resultSet.next()) {
				        	this.setDepartment_id(resultSet.getInt("Department_id"));
				           this.setDepartment_name(resultSet.getString("Department_name"));
				           this.setlocation(resultSet.getString("location"));
				            this.setBudget(resultSet.getString("budget"));

				            }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
				private void setlocation(String string) {
					// TODO Auto-generated method stub
					
				}
				public void update1(int inputdepartmentid) {
					// JDBC URL, username, and password of MySQL server
				    String url = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to update data
				    String sql = "UPDATE Department SET  Department_name = ?,location = ?, budget= ?WHERE Department_id = ?";

				    try (
				        // Establish the co
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement emp = co.prepareStatement(sql);
				    ) {
				        // Set the new values for the update
				    	 emp.setString(1, this.getDepartment_name());
				       emp.setString(2, this.getLocation()); // Assuming there is a column named 'id' for the WHERE clause
				        emp.setString(3, this.getBudget());
				       emp.setInt(4, inputdepartmentid);
				        // Execute the update
				        int rowsAffected = emp.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				            System.out.println("Data updated successfully!");
				        } else {
				            System.out.println("Failed to update data. No matching record found.");
				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }   
				}
				public void delete1(int inputid) {
					// JDBC URL, username, and password of MySQL server
				    String url = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to delete data
				    String sql = "DELETE FROM Department WHERE Department_id = ?";

				    try (
				        // Establish the 
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement pst = co.prepareStatement(sql);
				    ) {
				        // Set the value for the WHERE clause
				        pst.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

				        // Execute the delete
				        int rowsAffected = pst.executeUpdate();

				        // Check the result
				        if (rowsAffected > 0) {
				            System.out.println("Data deleted successfully!");
				        } else {
				            System.out.println("Failed to delete data. No matching record found.");
				        }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }}}
				



