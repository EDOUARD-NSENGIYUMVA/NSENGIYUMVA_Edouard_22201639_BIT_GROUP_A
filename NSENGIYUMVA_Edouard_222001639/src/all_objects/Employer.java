package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Employer <string, preparestatement, PrepareStatement> {
		private int employer_id;
		private String employer_name;
		private String bank_id;
		private String contact_number;
		private String address;
		public Employer() {}
		public Employer(int employer_id, String employer_name , String bank_id, String contact_number, String address ,int bank_account) {
			this. employer_id =  employer_id;
			this.employer_name = employer_name;
			this.bank_id = bank_id;
			this.contact_number = contact_number;
			this.address = address;
		}
		public Employer( String lname, String fname, String contact_number, String telephone,String position,int bank_account,String country,string date_of_birth,int match_id) {
			this.employer_name = fname;
			this.bank_id = lname;
			this.contact_number = contact_number;
			this.address= telephone;
			}
		public int getId1() {
			return employer_id ;
		}
		public void setId(int employer_id) {
		this.employer_id = employer_id;
		}
		public void setemployername(String employer_name) {
			this.employer_name = employer_name;
		}
		public String getemployername() {
			return employer_name;
		}

		public void setbankid(String bank_id) {
			this.bank_id = bank_id;
		}
		public String getbankid() {
			return bank_id;
		}

		public String getcontactnumber() {
			return contact_number;
		}
		public String getTelephone() {
			return contact_number;	
		}
		public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
		

		public void setTelephone(String telephone) {
			this.contact_number= telephone;
		}
		public void makeconnection() {
		}
		public void insertData(String name,String bank, String contact,String address) {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    // SQL query to insert data
		    String sql = "INSERT INTO Employer (employer_name,bank_id,contact_number,address) VALUES ( ?, ?, ?,?,?,?)";
		
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
					   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, name);
		        preparedStatement.setString(2, bank);
		        preparedStatement.setString(3, contact);
		        preparedStatement.setString(4, address);

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
		    String host = "jdbc:mysql://localhost/ nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    String sql = "INSERT INTO Employer (employer_name,bank_id,contact_number,address) VALUES ( ?, ?, ?,?)";

		    try (Connection con = DriverManager.getConnection(host, user, password);
		         PreparedStatement preparedStatement = con.prepareStatement(sql)) {
		        preparedStatement.setString(1, this.employer_name);
		        preparedStatement.setString(2, this.bank_id);
		        preparedStatement.setString(3, this.contact_number);
		        preparedStatement.setString(4, this.address);

		        // Missing setString for parameter 5

		        int rowsAffected = preparedStatement.executeUpdate();

		        if (rowsAffected > 0) {
		            System.out.println("Data inserted successfully!");
		            JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            System.out.println("Failed to insert data.");
		            JOptionPane.showMessageDialog(null, "Failed to insert data.!", "After insert", JOptionPane.ERROR_MESSAGE);
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
		    String sql = "SELECT * FROM employer WHERE employer_id = ?";

		    try (
		        // Establish the connection
		        Connection connection = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    ) {
		        // Set the value for the parameterized query
		        //int studentId = 1; // Replace with the desired student id
		        //if()
		    	preparedStatement.setInt(1, inputid);

		        // Execute the query and get the result set
		        ResultSet resultSet = preparedStatement.executeQuery();

		        // Process the result set
		        while (resultSet.next()) {
		        	this.setId(resultSet.getInt("employer_id"));
		           this.setemployername(resultSet.getString("employer_name"));
		           this.setbankid(resultSet.getString("bank_id"));
		           this.setTelephone(resultSet.getString("contact_number"));
		            this.setAddress(resultSet.getString("address"));

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
		    String sql = "UPDATE Employer SET  employer_name= ?, bank_id = ?,contact_number = ?, address = ?WHERE employer_id = ?";

		    try (
		        // Establish the co
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement emp = co.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	 emp.setString(1, this.getemployername());
		        emp.setString(2, this.getbankid());
		       emp.setString(3, this.getcontactnumber()); // Assuming there is a column named 'id' for the WHERE clause
		        emp.setString(4, this.getTelephone());
		       emp.setInt(5, inputbankid);
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
		    String sql = "DELETE FROM employer WHERE employer_id = ?";

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
		    }}
		public void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
		
			public void login() {
			       
		        String password;
				if (isValidUser(employer_name, contact_number)) {
		            System.out.println("Login successful");
		        } else {
		            System.out.println("Invalid username or password");
		        }
		    }
		    
		    private boolean isValidUser(String email, String password) {
		        // TODO: Implement your user validation logic here
		        // This could involve checking credentials against a database, file, or other storage
		        
		        // Example validation (replace with your actual logic):
		        return email.equals("admin") && password.equals("password");
		}
			public void setEmail(String text) {
				// TODO Auto-generated method stub
				
			}
			public void setPassword(String passwordString) {
				// TODO Auto-generated method stub
				
			}}
		
		
		
	

