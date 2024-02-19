package mainmenu;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import all_objectforms.BankForm;
import all_objectforms.DepartmentForm;
import all_objectforms.EmployeeForm;
import all_objectforms.EmployerForms;
import all_objectforms.ManagerForm;

public class MENUFORM extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu BankMenu;
    private JMenu DepartmentMenu;
    private JMenu EmployeeMenu;
    private JMenu EmployerMenu;
    private JMenu ManagerMenu;
    private JMenu logoutMenu;

    private JMenuItem BankItem;
    private JMenuItem DepartmentItem;
    private JMenuItem EmployeeItem;
    private JMenuItem EmployerItem;
    private JMenuItem ManagerItem;
    private JMenuItem logoutItem;

    private String loggedInUser;

    public MENUFORM(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create menu items
        BankMenu = new JMenu("CUSTOMER");
        BankItem = new JMenuItem("Bank Form");
        BankItem.addActionListener(this);

        DepartmentMenu = new JMenu("PAYMENT");
        DepartmentItem = new JMenuItem("Department Form");
        DepartmentItem.addActionListener(this);

        EmployeeMenu = new JMenu("RESERVATION");
        EmployeeItem = new JMenuItem("Reservation Form");
        EmployeeItem.addActionListener(this);

        EmployerMenu = new JMenu("ROOM");
        EmployerItem = new JMenuItem("Employer Form");
        EmployerItem.addActionListener(this);

        ManagerMenu = new JMenu("STAFF");
        ManagerItem = new JMenuItem("Manager Form");
        ManagerItem.addActionListener(this);


        logoutMenu = new JMenu("LOGOUT");
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to respective menus
        BankMenu.add(BankItem);
        DepartmentMenu.add(DepartmentItem);
        EmployeeMenu.add(EmployeeItem);
        EmployerMenu.add(EmployerItem);
        ManagerMenu.add(ManagerItem);
        logoutMenu.add(logoutItem);

        // Add menus to menu bar
        menuBar.add(BankMenu);
        menuBar.add(DepartmentMenu);
        menuBar.add(EmployeeMenu);
        menuBar.add(EmployerMenu);
        menuBar.add(ManagerMenu);
        menuBar.add(logoutMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME"+loggedInUser+"TO THE EMPLOYMANT MANAGEMENT SYSTEM");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BankItem) {
            new BankForm();
        } else if (e.getSource() == DepartmentItem) {
            new DepartmentForm();
        } else if (e.getSource() == EmployeeItem) {
            new EmployeeForm();
        } else if (e.getSource() == EmployerItem) {
            new EmployerForms();
        } else if (e.getSource() == ManagerItem) {
            new ManagerForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new MENUFORM("TO THE EMPLOYMENT MANAGEMENT SYSTEM"));
    }
}

