import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class RegistrationPage extends JFrame implements ActionListener
{
    Container c;
    Connection con=null;
    Statement stmt=null;
    JLabel lblFirstName;
    JTextField txtFirstName;
    JTextField txtLastName;
    JLabel lblLastName;
    JButton btnRegister;
    public RegistrationPage()
    {
        c=getContentPane();
        c.setLayout(new FlowLayout());

        lblFirstName=new JLabel("First Name");
        txtFirstName=new JTextField(20);

        lblLastName=new JLabel("Last Name");
        txtLastName=new JTextField(20);

        btnRegister=new JButton("Register");

        c.add(lblFirstName);
        c.add(txtFirstName);
        c.add(lblLastName);
        c.add(txtLastName);
        c.add(btnRegister);

        btnRegister.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String FN=txtFirstName.getText();
        String LN=txtLastName.getText();
        String sqlQuery="Insert into tblregister(FirstName,LastName) values('"+FN+"','"+LN+"')";
        if(ae.getSource()==btnRegister)
        {
            con=DBConnection.getDatabaseConnection();
            try
            {
                stmt=con.createStatement();
                int rowInserted=stmt.executeUpdate(sqlQuery);
                if(rowInserted>0)
                {
                    System.out.println("Ho Geyaa Registration");
                }
                else
                {
                    System.out.println("Ni Hua");
                }
            }
            catch(SQLException ex)
            {
                ex.printStackTrace();
            }

            finally
            {
                try
                {
                        con.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        RegistrationPage page=new RegistrationPage();
        page.setTitle("Registration Page");
        page.setSize(400,400);
        page.setVisible(true);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
