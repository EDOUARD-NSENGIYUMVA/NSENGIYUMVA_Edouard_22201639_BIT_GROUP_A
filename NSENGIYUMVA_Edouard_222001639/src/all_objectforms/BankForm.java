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

import all_objects.Bank;
public class BankForm implements ActionListener{ 
	  JFrame frame;
					//playeer_id;last_name;first_name;email;contact;position;club_id;country;date_of_birth; match_id;
					JLabel id_lb=new JLabel("bank_id");
					JLabel name_lb=new JLabel("bank_name");
					JLabel account_number_lb=new JLabel("account_number");
					JLabel branch_name_lb=new JLabel("branch_name");
					
					
					JTextField id_txf=new JTextField();
					JTextField name_txf=new JTextField();
					JTextField account_number_txf=new JTextField();
					JTextField branch_name_txf=new JTextField();
					//Buttons CRUD
					JButton insert_btn=new JButton("Insert");
					JButton Read_btn=new JButton("View");
					JButton update_tbtn=new JButton("Update");
					JButton delete_btn=new JButton("Delete");
					Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
					int w=(int) screensize.getWidth();
					int h=(int) screensize.getHeight();
					public BankForm(){
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
						frame.setTitle("BANK FORM");
						frame.setBounds(10, 10, 400, 300);
						frame.getContentPane().setLayout(null);
						frame.getContentPane().setBackground(Color.LIGHT_GRAY);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setResizable(true);
						setaccount_numberandSize();
					}


					private void setaccount_numberandSize() {
						id_lb.setBounds(10, 10, 100, 30);
						name_lb.setBounds(10, 50, 100, 30);
						account_number_lb.setBounds(10, 90, 100, 30);
						branch_name_lb.setBounds(10, 130, 100, 30);
						
						id_txf.setBounds(160, 10, 130, 30);
						name_txf.setBounds(160, 50, 130, 30);
						account_number_txf.setBounds(160, 90, 130, 30);
						branch_name_txf.setBounds(160, 130, 130, 30);
						
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
						account_number_lb.setFont(font);
						branch_name_lb.setFont(font);

						id_txf.setFont(font);
						name_txf.setFont(font);
						account_number_txf.setFont(font);
						branch_name_txf.setFont(font);
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
						frame.add(account_number_lb);
						frame.add(branch_name_lb);
						
						//text
						frame.add(id_txf);
						frame.add(name_txf);
						frame.add(account_number_txf);
						frame.add(branch_name_txf);
						
						
						//Buttons CRUD
						frame.add(insert_btn);
						frame.add(Read_btn);
						frame.add(update_tbtn);
						frame.add(delete_btn);
						ActionEvent();
					}
					@Override
				   public void actionPerformed(ActionEvent e) {
						Bank department=new Bank();
						if(e.getSource()==insert_btn) {
							department.setbankname(name_txf.getText());
							department.setbank_account(account_number_txf.getText());
							department.setbranch1(branch_name_txf.getText());
							department.insertData();
						}else if (e.getSource()==Read_btn) {
							int id=Integer.parseInt(id_txf.getText());
							department.readwithID(id);
							id_txf.setText(String.valueOf(department.getId1()));
							name_txf.setText(department.getbankname());
							account_number_txf.setText(department.getbankaccount1());
							branch_name_txf.setText(department.getbranch1());
						}else if (e.getSource()==update_tbtn) {
							int id=Integer.parseInt(id_txf.getText());
							department.setbankname(name_txf.getText());
							department.setbank_account(account_number_txf.getText());
							department.setbranch1(branch_name_txf.getText());
							department.update(id);
						}else {
							int id=Integer.parseInt(id_txf.getText());
							department.delete(id);
						}}
					public static void main(String[] args) {
					
					BankForm DepartmentForms= new BankForm();
					System.out.println(DepartmentForms);

					}
			}













