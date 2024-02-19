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

import all_objects.Department;
public class DepartmentForm implements ActionListener{ 
	  JFrame frame;
					//playeer_id;last_name;first_name;email;contact;position;club_id;country;date_of_birth; match_id;
					JLabel id_lb=new JLabel("Department_id");
					JLabel name_lb=new JLabel("Department_name");
					JLabel Location_lb=new JLabel("Location");
					JLabel Badget_lb=new JLabel("Badget");
					
					
					JTextField id_txf=new JTextField();
					JTextField name_txf=new JTextField();
					JTextField Location_txf=new JTextField();
					JTextField Badget_txf=new JTextField();
					//Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public DepartmentForm(){
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
						frame.setTitle("DEPARTMENT FORM");
						frame.setBounds(10, 10, 400, 300);
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
						Location_lb.setBounds(10, 90, 100, 30);
						Badget_lb.setBounds(10, 130, 100, 30);
						
						id_txf.setBounds(160, 10, 130, 30);
						name_txf.setBounds(160, 50, 130, 30);
						Location_txf.setBounds(160, 90, 130, 30);
						Badget_txf.setBounds(160, 130, 130, 30);
						
						    //Buttons CRUD
						insert_btn.setBounds(10,170, 85, 30);
						Read_btn.setBounds(100,170, 85, 30);
						update_tbtn.setBounds(190,170, 85, 30);
						delete_btn.setBounds(280,170, 85, 30);
						setFontforall();
						addcomponentforFrame();
						}
					private void setFontforall() {
						Font font = new Font("Georgia", Font.BOLD, 18);

						id_lb.setFont(font);
						name_lb.setFont(font);
						Location_lb.setFont(font);
						Badget_lb.setFont(font);

						id_txf.setFont(font);
						name_txf.setFont(font);
						Location_txf.setFont(font);
						Badget_txf.setFont(font);
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
						frame.add(Location_lb);
						frame.add(Badget_lb);
						
						//text
						frame.add(id_txf);
						frame.add(name_txf);
						frame.add(Location_txf);
						frame.add(Badget_txf);
						
						
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
				   public void actionPerformed(ActionEvent e) {
						Department department=new Department();
						if(e.getSource()==insert_btn) {
							department.setDepartment_name(name_txf.getText());
							department.setLocation(Location_txf.getText());
							department.setBudget(Badget_txf.getText());
							department.insertData11();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							department.readwithID1(id);
							id_txf.setText(String.valueOf(department.getDepartment_id()));
							name_txf.setText(department.getDepartment_name());
							Location_txf.setText(department.getLocation());
							Badget_txf.setText(department.getBudget());
						}else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							department.setDepartment_name(name_txf.getText());
							department.setLocation(Location_txf.getText());
							department.setBudget(Badget_txf.getText());
							department.update1(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							department.delete1(id);
						}}
					public static void main(String[] args) {
					
					DepartmentForm DepartmentForms= new DepartmentForm();
					System.out.println(DepartmentForms);

					}
			}













