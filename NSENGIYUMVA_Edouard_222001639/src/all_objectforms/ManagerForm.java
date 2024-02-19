package all_objectforms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import all_objects.Manager;
public class ManagerForm  implements ActionListener{ 
JFrame frame;
				//playeer_id;last_name;first_name;email;contact;position;club_id;country;date_of_birth; match_id;
				JLabel id_lb=new JLabel("Manager_id");
				JLabel name_lb=new JLabel("Manager_name");
				JLabel departmentid_lb=new JLabel("department_id");
				JLabel salary_lb=new JLabel("salary");
				JLabel date_of_hire_lb=new JLabel("date_of_hire");
				
				
				JTextField id_txf=new JTextField();
				JTextField name_txf=new JTextField();
				JTextField departmentid_txf=new JTextField();
				JTextField salary_txf=new JTextField();
				JTextField date_of_hire_txf=new JTextField();
				//Buttons CRUD
				JButton insert_btn=new JButton("Insert");
				JButton Read_btn=new JButton("View");
				JButton update_tbtn=new JButton("Update");
				JButton delete_btn=new JButton("Delete");
				Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
				int w=(int) screensize.getWidth();
				int h=(int) screensize.getHeight();
				public ManagerForm(){
					createForm();

				}
				private <insertbtn, delete_btn> void ActionEvent() {
					insert_btn.addActionListener(this);
					Read_btn.addActionListener(this);
					update_tbtn.addActionListener(this);
					delete_btn.addActionListener(this);
				}
				private void createForm() {
					frame=new JFrame();
					frame.setTitle("MANAGER FORM");
					frame.setBounds(10, 10, 700, 300);
					frame.getContentPane().setLayout(null);
					frame.getContentPane().setBackground(Color.LIGHT_GRAY);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(true);
					setLocationandSize();
				}


				private void setLocationandSize() {
					id_lb.setBounds(10, 10, 100, 30);
					name_lb.setBounds(10, 50, 100, 30);
					departmentid_lb.setBounds(10, 90, 100, 30);
					salary_lb.setBounds(10, 130, 100, 30);
					date_of_hire_lb.setBounds(10, 170, 100, 30);
					
					id_txf.setBounds(160, 10, 130, 30);
					name_txf.setBounds(160, 50, 130, 30);
					departmentid_txf.setBounds(160, 90, 130, 30);
					salary_txf.setBounds(160, 130, 130, 30);
					date_of_hire_txf.setBounds(160, 170, 130, 30);
					
					    //Buttons CRUD
					insert_btn.setBounds(10,210, 85, 30);
					Read_btn.setBounds(100,210, 85, 30);
					update_tbtn.setBounds(190,210, 85, 30);
					delete_btn.setBounds(280,210, 85, 30);
					setFontforall();
					addcomponentforFrame();
					}
				private void setFontforall() {
					Font font = new Font("Georgia", Font.BOLD, 18);

					id_lb.setFont(font);
					name_lb.setFont(font);
					departmentid_lb.setFont(font);
					salary_lb.setFont(font);
					date_of_hire_lb.setFont(font);

					id_txf.setFont(font);
					name_txf.setFont(font);
					departmentid_txf.setFont(font);
					salary_txf.setFont(font);
					date_of_hire_txf.setFont(font);
					//Buttons CRUD
					Font fonti = new Font("Courier New", Font.ITALIC, 12);

					insert_btn.setFont(fonti);
					Read_btn.setFont(fonti);
					update_tbtn.setFont(fonti);
					delete_btn.setFont(fonti);

				}
				private void addcomponentforFrame() {
					frame.add(id_lb);
					frame.add(name_lb);
					frame.add(departmentid_lb);
					frame.add(salary_lb);
					frame.add(date_of_hire_lb);
					
					//text
					frame.add(id_txf);
					frame.add(name_txf);
					frame.add(departmentid_txf);
					frame.add(salary_txf);
					frame.add(date_of_hire_txf);
					
					
					//Buttons CRUD
					frame.add(insert_btn);
					frame.add(Read_btn);
					frame.add(update_tbtn);
					frame.add(delete_btn);
					ActionEvent();
				}
				@Override
			   public void actionPerformed(ActionEvent e) {
					Manager manager=new Manager();
					if(e.getSource()==insert_btn) {
						manager.setManager_name(name_txf.getText());
						manager.setDepartment_id(departmentid_txf.getText());
						manager.setSalary(salary_txf.getText());
						manager.setDate_of_hire(date_of_hire_txf.getText());
						manager.insertData11();
					}else if (e.getSource()==Read_btn) {
						int id=Integer.parseInt(id_txf.getText());
						manager.readwithID1(id);
						id_txf.setText(String.valueOf(manager.getManager_id()));
						name_txf.setText(manager.getManager_name());
						departmentid_txf.setText(manager.getDepartment_id());
						salary_txf.setText(manager.getSalary());
						date_of_hire_txf.setText(manager.getDate_of_hire());
					}else if (e.getSource()==update_tbtn) {
						int id=Integer.parseInt(id_txf.getText());
						manager.setManager_name(name_txf.getText());
						manager.setDepartment_id(departmentid_txf.getText());
						manager.setSalary(salary_txf.getText());
						manager.setDate_of_hire(date_of_hire_txf.getText());
						manager.update1(id);
					}else {
						int id=Integer.parseInt(id_txf.getText());
						manager.delete1(id);
					}}
				public static void main(String[] args) {
				
				ManagerForm ManagerForms= new ManagerForm();
				System.out.println(ManagerForms);

				}
		}












