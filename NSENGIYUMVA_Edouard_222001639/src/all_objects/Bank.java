package all_objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Bank{
	private int bank_id;
		private String bank_name;
		private String branch;
		private String bank_account;
		public Bank() {}
		public Bank(int bank_id, String bank_name , String branch, String contact ,String bank_account) {
			this. bank_id =  bank_id;
			this.bank_name = bank_name;
			this.bank_account=bank_account;
			this.branch = branch;
		}
		public Bank( String lname, String fname, String website, String telephone,String bankaccount) {
			this.bank_name = fname;
			this.branch = lname;
			this.bank_account=bankaccount;
			}
		public int getId1() {
			return bank_id ;
		}
		public void setId(int bank_id) {
		this.bank_id = bank_id;
		}
		public void setbankname(String bank_name) {
			this.bank_name = bank_name;
		}
		public String getbankname() {
			return bank_name;
		}

		public void setbranch1(String branch) {
			this.branch = branch;
		}
		public String getbranch1() {
			return branch;
		}
		public void setbank_account(String bank_account) {
			this.bank_account = bank_account;
		}

		public String  getbankaccount1() {
			return bank_account;
		}
	public void makeconnection() {
		}
		public void insertData(String ba_n,int ba_ac, String b_n) {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    // SQL query to insert data
		    String sql = "INSERT INTO banks (bank_name,bank_account,branch_name) VALUES (?, ?, ?, ?)";
		
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
					   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, ba_n);
		       preparedStatement.setInt(2, ba_ac);
	 preparedStatement.setString(3, b_n);
			     
		        
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
		public void insertData() {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    // SQL query to insert data
		    String sql = "INSERT INTO bank (bank_name,account_number,branch_name) VALUES ( ?, ?, ?)";

		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.bank_name);
		        preparedStatement.setString(2, this.bank_account);
		        preparedStatement.setString(3, this.branch);
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

		public void readwithID(int inputid) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    // SQL query to select all columns from student where id = ?
		    String sql = "SELECT * FROM bank WHERE bank_id = ?";

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
		        	this.setId(resultSet.getInt("bank_id"));
		           this.setbankname(resultSet.getString("bank_name"));
		           this.setbranch1(resultSet.getString("branch_name"));
		         this.setbank_account(resultSet.getString("Account_number"));
		            }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		public void update(int inputbankid) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    // SQL query to update data
		    String sql = "UPDATE bank SET  bank_name= ?, account_number = ?, branch_name = ? WHERE bank_id = ?";

		    try (
		        // Establish the co
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the new values for the update
		    	  pl.setString(1, this.getbankname());
		        pl.setString(2, this.getbranch1());
		        pl.setString(3, this.getbankaccount1());
		        pl.setInt(4, inputbankid);
		        // Execute the update
		        int rowsAffected = pl.executeUpdate();

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
		public void delete(int inputid) {
			// JDBC URL, username, and password of MySQL server
		    String url = "jdbc:mysql://localhost/nsengiyumva_edouard_ems";
		    String user = "222001639";
		    String password = "222001639";

		    // SQL query to delete data
		    String sql = "DELETE FROM bank WHERE bank_id = ?";

		    try (
		        // Establish the 
		        Connection co = DriverManager.getConnection(url, user, password);

		        // Create a prepared statement
		        PreparedStatement pl = co.prepareStatement(sql);
		    ) {
		        // Set the value for the WHERE clause
		        pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

		        // Execute the delete
		        int rowsAffected = pl.executeUpdate();

		        // Check the result
		        if (rowsAffected > 0) {
		            System.out.println("Data deleted successfully!");
		        } else {
		            System.out.println("Failed to delete data. No matching record found.");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }}}
		
	

