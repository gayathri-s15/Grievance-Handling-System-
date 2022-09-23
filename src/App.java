import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class App implements ActionListener {

    // Global Declarations
    static String button;
    static String book;
    static JFrame f;
    static JFrame y;
    static JButton b1;
    static JButton b2;
    static JButton b3;

    static String fromstring;
    static String tostring;
    static String classstring;
    static String pwdstring;
    static Statement stmt;
    static Connection con;
    int i = 0;

    // Main function
    public static void main(String args[]) {
        // Frame fixing
        JFrame checkframe = new JFrame("Grievance Redressal System");

        b1 = new JButton("Misconduct");
        b1.setBounds(75, 250, 150, 30);
        b2 = new JButton("Overcharging");
        b2.setBounds(300, 250, 150, 30);
        b3 = new JButton("Ignorance");
        b3.setBounds(525, 250, 150, 30);

        // Event handling using button
        App obj = new App();
        b1.addActionListener(obj);
        b2.addActionListener(obj);
        b3.addActionListener(obj);

        checkframe.add(b1);
        checkframe.add(b2);
        checkframe.add(b3);
        checkframe.setLayout(null);
        checkframe.setSize(800, 700);
        checkframe.setLocationRelativeTo(null);
        checkframe.setVisible(true);

    }

    public void loginfunction() {

        // Frame fixing
        JFrame loginframe = new JFrame("Login");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grs", "root", "Gayath6i@151");
            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
        // Label
        JLabel ulabel, passlabel;
        JButton l1;
        JTextField uname, pass;

        // Option values for form

        // Labels for all the inputs

        ulabel = new JLabel("Username");
        ulabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ulabel.setBounds(50, 50, 100, 30);

        uname = new JTextField(16);
        uname.setBounds(120, 50, 100, 30);

        passlabel = new JLabel("Password");
        passlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passlabel.setBounds(50, 130, 100, 30);

        pass = new JTextField(16);
        pass.setBounds(120, 130, 100, 30);

        // Save and close button

        l1 = new JButton("Login");
        l1.setBounds(150, 300, 100, 30);

        // Event handling using button
        App obj = new App();
        l1.addActionListener(obj);

        l1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String uuname = uname.getText();
                    String uupass = pass.getText();
                    System.out.println(uuname + uupass);
                    PreparedStatement pss = con.prepareStatement("SELECT * FROM user WHERE name=? and password=?;");

                    pss.setString(1, uuname);
                    pss.setString(2, uupass);
                    int ii = pss.executeUpdate();

                    if (ii > 0) {
                        System.out.println("You are sucessfully logged in");
                    }

                    con.close();
                } catch (Exception s) {
                    System.out.println(e);
                }

            }
        });

        // To add the components to the frames

        loginframe.add(ulabel);
        loginframe.add(uname);
        loginframe.add(passlabel);
        loginframe.add(pass);
        loginframe.add(l1);
        loginframe.setLayout(null);
        loginframe.setSize(800, 700);
        loginframe.setLocationRelativeTo(null);
        loginframe.setVisible(true);

    }

    public void signupfunction() {
        // Frame fixing
        JFrame signupframe = new JFrame("Signup");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grs", "root", "Gayath6i@151");
            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
        // Label
        JLabel slname, slage, slno, slemail, slpass;
        JButton sb1;
        JTextField stname, stage, stno, stemail, stpass;

        // Option values for form

        // Labels for all the inputs

        slname = new JLabel("Name");
        slname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        slname.setBounds(50, 50, 100, 30);

        stname = new JTextField(16);
        stname.setBounds(120, 50, 100, 30);

        slage = new JLabel("Age");
        slage.setFont(new Font("Tahoma", Font.PLAIN, 15));
        slage.setBounds(50, 90, 100, 30);

        stage = new JTextField(16);
        stage.setBounds(120, 90, 100, 30);

        slno = new JLabel("Number");
        slno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        slno.setBounds(50, 130, 100, 30);

        stno = new JTextField(16);
        stno.setBounds(120, 130, 100, 30);

        slemail = new JLabel("E-mail");
        slemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        slemail.setBounds(50, 170, 100, 30);

        stemail = new JTextField(16);
        stemail.setBounds(120, 170, 100, 30);

        slpass = new JLabel("Password");
        slpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
        slpass.setBounds(50, 210, 100, 30);

        stpass = new JTextField(16);
        stpass.setBounds(120, 210, 100, 30);

        // Save and close button

        sb1 = new JButton("Signup");
        sb1.setBounds(150, 300, 100, 30);

        // Event handling using button
        App obj = new App();
        sb1.addActionListener(obj);

        sb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    i++;
                    String ssname = stname.getText();
                    String ssmail = stemail.getText();
                    String sspass = stpass.getText();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO user(name,email,password) VALUES(?,?,?)");

                    ps.setString(1, ssname);
                    ps.setString(2, ssmail);
                    ps.setString(3, sspass);

                } catch (Exception s) {
                    System.out.println(e);
                }

            }
        });

        // To add the components to the frames

        signupframe.add(slname);
        signupframe.add(stname);

        signupframe.add(slage);
        signupframe.add(stage);

        signupframe.add(slno);
        signupframe.add(stno);

        signupframe.add(slemail);
        signupframe.add(stemail);

        signupframe.add(slpass);
        signupframe.add(stpass);

        signupframe.add(sb1);

        signupframe.setLayout(null);
        signupframe.setSize(800, 700);
        signupframe.setLocationRelativeTo(null);
        signupframe.setVisible(true);
    }

    // getComplaint functional frame
    public void getComplaint() {
        JFrame gframe = new JFrame("Complaint Box");
        JLabel ffinal;

        if (book.equals("Misconduct")) {
            ffinal = new JLabel("Misconduct");

        } else if (book.equals("Overcharging")) {
            ffinal = new JLabel("Overcharging");

        } else {
            ffinal = new JLabel("Ignorance");

        }

        ffinal.setFont(new Font("Tahoma", Font.PLAIN, 25));
        ffinal.setBounds(20, 50, 800, 40);

        JLabel rr = new JLabel("Please enter your complaint:");
        rr.setBounds(20, 100, 400, 40);
        rr.setFont(new Font("Tahoma", Font.PLAIN, 15));

        TextArea area = new TextArea();
        area.setBounds(20, 150, 760, 400);

        JButton b = new JButton("Submit");
        b.setBounds(600, 575, 100, 30);
        App obj = new App();
        b.addActionListener(obj);

        gframe.add(ffinal);
        gframe.add(area);
        gframe.add(rr);
        gframe.add(b);

        gframe.setLayout(null);
        gframe.setSize(800, 700);
        gframe.setLocationRelativeTo(null);
        gframe.setVisible(true);
    }
    // Output functional frame

    public void outputfunction() {
        // Frame fixing
        JFrame outputframe = new JFrame("Grievance Redressal System");

        JLabel note = new JLabel("Your complaint has been noted and it will be processed.");

        note.setFont(new Font("Tahoma", Font.PLAIN, 25));
        note.setBounds(75, 50, 800, 40);

        outputframe.add(note);

        outputframe.setLayout(null);
        outputframe.setSize(800, 700);
        outputframe.setLocationRelativeTo(null);
        outputframe.setVisible(true);

    }
    // Action Performed Frame Controller

    public void actionPerformed(ActionEvent e) {
        App l = new App();
        button = e.getActionCommand();
        if (button.equals("Misconduct")) {
            // this.dispose();
            book = button;
            l.signupfunction();
        }
        if (button.equals("Overcharging")) {
            // this.dispose();
            book = button;
            l.signupfunction();
        }
        if (button.equals("Ignorance")) {
            // this.dispose();
            System.out.println(button);
            book = button;
            l.signupfunction();
        }
        if (button.equals("Signup")) {
            // this.dispose();
            l.loginfunction();
        }
        if (button.equals("Login")) {
            // this.dispose();
            l.getComplaint();
        }
        if (button.equals("Submit")) {
            // this.dispose();
            l.outputfunction();
        }
    }
}