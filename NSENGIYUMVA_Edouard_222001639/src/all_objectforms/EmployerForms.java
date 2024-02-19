package all_objectforms;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import all_objects.Employer;
public class EmployerForms implements ActionListener{ 
	JFrame frame;
			//playeer_id;last_name;first_name;email;contact;position;club_id;country;date_of_birth; match_id;
			JLabel id_lb=new JLabel("employer_id");
			JLabel name_lb=new JLabel("employer_name");
			JLabel bankid_lb=new JLabel("bank_id");
			JLabel phone_lb=new JLabel("contact_number");
			JLabel address_lb=new JLabel("address");
			
			
			JTextField id_txf=new JTextField();
			JTextField name_txf=new JTextField();
			JTextField bankid_txf=new JTextField();
			JTextField phone_txf=new JTextField();
			JTextField address_txf=new JTextField();
			//Buttons CRUD
			JButton insert_btn=new JButton("Insert");
			JButton Read_btn=new JButton("View");
			JButton update_tbtn=new JButton("Update");
			JButton delete_btn=new JButton("Delete");
			Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
			int w=(int) screensize.getWidth();
			int h=(int) screensize.getHeight();
			public EmployerForms(){
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
				frame.setTitle("EMPLOYER FORM");
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
				bankid_lb.setBounds(10, 90, 100, 30);
				phone_lb.setBounds(10, 130, 100, 30);
				address_lb.setBounds(10, 170, 100, 30);
				
				id_txf.setBounds(160, 10, 130, 30);
				name_txf.setBounds(160, 50, 130, 30);
				bankid_txf.setBounds(160, 90, 130, 30);
				phone_txf.setBounds(160, 130, 130, 30);
				address_txf.setBounds(160, 170, 130, 30);
				
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
				bankid_lb.setFont(font);
				phone_lb.setFont(font);
				address_lb.setFont(font);

				id_txf.setFont(font);
				name_txf.setFont(font);
				bankid_txf.setFont(font);
				phone_txf.setFont(font);
				address_txf.setFont(font);
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
				frame.add(bankid_lb);
				frame.add(phone_lb);
				frame.add(address_lb);
				
				//text
				frame.add(id_txf);
				frame.add(name_txf);
				frame.add(bankid_txf);
				frame.add(phone_txf);
				frame.add(address_txf);
				
				
				//Buttons CRUD
				frame.add(insert_btn);
				frame.add(Read_btn);
				frame.add(update_tbtn);
				frame.add(delete_btn);
				ActionEvent();
			}
			@Override
		   public void actionPerformed(ActionEvent e) {
				Employer<String, PreparedStatement, PreparedStatement> emp=new Employer<String, PreparedStatement, PreparedStatement>();
				if(e.getSource()==insert_btn) {
					emp.setemployername(name_txf.getText());
					emp.setbankid(bankid_txf.getText());
					emp.setTelephone(phone_txf.getText());
					emp.setAddress(address_txf.getText());
					emp.insertData11();
				}else if (e.getSource()==Read_btn) {
					int id=Integer.parseInt(id_txf.getText());
					emp.readwithID1(id);
					id_txf.setText(String.valueOf(emp.getId1()));
					name_txf.setText(emp.getemployername());
					bankid_txf.setText(emp.getbankid());
					phone_txf.setText(emp.getTelephone());
					address_txf.setText(emp.getAddress());
				}else if (e.getSource()==update_tbtn) {
					int id=Integer.parseInt(id_txf.getText());
					emp.setemployername(name_txf.getText());
					emp.setbankid(bankid_txf.getText());
					emp.setTelephone(phone_txf.getText());
					emp.setAddress(address_txf.getText());
					emp.update1(id);
				}else {
					int id=Integer.parseInt(id_txf.getText());
					emp.delete1(id);
				}}
			public static void main(String[] args) {
			
			EmployerForms employerForms= new EmployerForms();
			System.out.println(employerForms);

			}
	}











