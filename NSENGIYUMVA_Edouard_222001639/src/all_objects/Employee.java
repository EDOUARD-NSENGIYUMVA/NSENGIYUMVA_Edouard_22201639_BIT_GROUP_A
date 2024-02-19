Apackage all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Employee {
 private int Employee_id;
				private String Employee_name;
				private String department_id;
				private  String manager_id;
				private String position;
				private String salary;
				private String date_of_hire;
				public Employee() {}
				public Employee(int Employee_id, String Employee_name , String department_id,String manager_id,String position, String salary, String date_of_hire ) {
					this.Employee_id =  Employee_id;
					this.Employee_name = Employee_name;
					this.department_id = department_id;
					this.manager_id= manager_id;
					this.position = position;
					this.salary = salary;
					this.date_of_hire = date_of_hire;
				}
				
				public Employee( String Employee_name, String departmentid,String manager_id,String position, String salary, String date_of_hire) {
					this.Employee_name= Employee_name;
					this.department_id = departmentid;
					this.manager_id= manager_id;
					this.position = position;
					this.salary= salary;
					this.date_of_hire=date_of_hire;}
				
				
				public int getEmployee_id() {
					return Employee_id;
				}
				public void setEmployee_id(int Employee_id) {
					this.Employee_id = Employee_id;
				}
				public String getEmployee_name() {
					return Employee_name;
				}
				public void setEmployee_name(String Employee_name) {
					this.Employee_name = Employee_name;
				}
				public String getDepartment_id() {
					return department_id;
				}
				public void setDepartment_id(String department_id) {
					this.department_id = department_id;
				}
				
				public String getManager_id() {
					return manager_id;
				}
				public void setManager_id(String manager_id) {
					this.manager_id = manager_id;
				}
				public String getPosition() {
					return position;
				}
				public void setPosition(String position) {
					this.position = position;
				}
				public String getSalary() {
					return salary;
				}
				public void setSalary(String salary) {
					this.salary = salary;
				}
				public String getDate_of_hire() {
					return date_of_hire;
				}
				public void setDate_of_hire(String date_of_hire) {
					this.date_of_hire = date_of_hire;
				}
				public void makeconnection() {
				}
				public void insertData(String name,String department,String manager,String position ,String salary,String date_of_hire) {
					// JDBC URL, username, and password of MySQL server
				    String host = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to insert data
				    String sql = "INSERT INTO Employee (Employee_name,department_id,manager_id,position,salary,date_of_hire) VALUES ( ?, ?, ?,?,?,?)";
				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
							   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, name);
				        preparedStatement.setString(2, department);
				        preparedStatement.setString(3, manager);
				        preparedStatement.setString(4, position);
				        preparedStatement.setString(5, salary);
				        preparedStatement.setString(6, date_of_hire);

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
				    String sql = "INSERT INTO Employee (Employee_name,department_id,manager_id,position,salary,date_of_hire) VALUES ( ?, ?, ?,?,?,?)";

				    try (
				        // Establish the connection
				        Connection con = DriverManager.getConnection(host, user, password);

				        // Create a prepared statement
				    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
				    	    ) {
				        // Set the values for the prepared statement
				       preparedStatement.setString(1, this.Employee_name);
				        preparedStatement.setString(2, this.department_id);
				        preparedStatement.setString(3, this.manager_id);
				        preparedStatement.setString(4, this.position);
				        preparedStatement.setString(5, this.salary);
				        preparedStatement.setString(6, this.date_of_hire);
				     
				       
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
				    String sql = "SELECT * FROM Employee WHERE Employee_id = ?";

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
				        	this.setEmployee_id(resultSet.getInt("Employee_id"));
				           this.setEmployee_name(resultSet.getString("Employee_name"));
				           this.setDepartment_id(resultSet.getString("department_id"));
				           this.setManager_id(resultSet.getString("manager_id"));
				           this.setPosition(resultSet.getString("position"));
				           this.setSalary(resultSet.getString("salary"));
				            this.setDate_of_hire(resultSet.getString("date_of_hire"));

				            }

				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				}
				public void update1(int inputbankid) {
					// JDBC URL, username, and password of MySQL server
				    String url = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
				    String user = "222001639";
				    String password = "222001639";

				    // SQL query to update data
				    String sql = "UPDATE Employee SET  Employee_name= ?, department_id = ?,manager_id = ?, position = ?,salary=?,date_of_hire=? WHERE Employee_id = ?";

				    try (
				        // Establish the co
				        Connection co = DriverManager.getConnection(url, user, password);

				        // Create a prepared statement
				        PreparedStatement emp = co.prepareStatement(sql);
				    ) {
				        // Set the new values for the update
				    	 emp.setString(1, this.getEmployee_name());
				        emp.setString(2, this.getDepartment_id());
				        emp.setString(3, this.getManager_id());
				        emp.setString(4, this.getPosition());
				       emp.setString(5, this.getSalary()); // Assuming there is a column named 'id' for the WHERE clause
				        emp.setString(6, this.getDate_of_hire());
				       emp.setInt(7, inputbankid);
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
				    String sql = "DELETE FROM Employee WHERE Employee_id = ?";

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
				


