import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Login extends JFrame implements ActionListener{

    //Class declarations

    public JLabel usernameLabel, passwordLabel, loginLabel,shoppingCartLabel,shoppingCartLabel2;
    public JTextField usernameTextField, passwordTextField;
    public JButton loginButton;
    public URL url = getClass().getResource("Images/shoppingCart.png");
    public ImageIcon shoppingCart,shoppingCart2;



    public Login(){

        //Designing the GUI for the login screen

        setTitle("Inventory Login");
        setSize(700,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(0xA8BBFF));
        setLocationRelativeTo(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(190,150,140,30);
        usernameLabel.setFont(new Font("Times New Roman",Font.BOLD,22));

        usernameTextField = new JTextField(16);
        usernameTextField.setBounds(300,155,140,22);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(190,190,140,30);
        passwordLabel.setFont(new Font("Times New Roman",Font.BOLD,22));

        passwordTextField = new JTextField(16);
        passwordTextField.setBounds(300,195,140,22);

        loginLabel = new JLabel("Inventory Login");
        loginLabel.setBounds(235,40,300,40);
        loginLabel.setFont(new Font("Times New Roman",Font.BOLD,30));

        assert url != null;
        shoppingCart = new ImageIcon(url);
        Image img = shoppingCart.getImage();
        Image newImg = img.getScaledInstance(200, 125,  java.awt.Image.SCALE_SMOOTH);
        shoppingCart = new ImageIcon(newImg);
        shoppingCartLabel = new JLabel(shoppingCart);
        shoppingCartLabel.setBounds(475,130,165,125);


        shoppingCart2 = new ImageIcon(newImg);
        shoppingCartLabel2 = new JLabel(shoppingCart);
        shoppingCartLabel2.setBounds(0,130,165,125);

        loginButton = new JButton("Login");
        loginButton.setBounds(260,270,150,50);
        loginButton.setFont(new Font("Times New Roman",Font.BOLD,22));
        loginButton.addActionListener(this);

        add(usernameLabel);
        add(passwordLabel);
        add(passwordTextField);
        add(usernameTextField);
        add(loginLabel);
        add(shoppingCartLabel);
        add(shoppingCartLabel2);
        add(loginButton);

        setVisible(true);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){

            //Makes sure that the user fills out a username and password into the text fields
            if(!usernameTextField.getText().equals("") && !passwordTextField.getText().equals("")){

                try {
                    SupermarketInventory.startProgram(); //Starts the program
                } catch(IOException ex){
                    JOptionPane.showMessageDialog(this,"IOException has been thrown!");
                    System.exit(0);
                }


            }
        }
    }

}
