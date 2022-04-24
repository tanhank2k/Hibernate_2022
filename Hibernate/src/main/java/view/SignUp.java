package view;

import com.toedter.calendar.JDateChooser;
import common.Role;
import common.Status;
import model.User;
import service.UserService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class SignUp extends JFrame {

    private JPanel contentPane;
    private JTextField txtFieldUsername;
    private JTextField txtFieldEmail;
    private JTextField txtFieldAddress;
    private JTextField txtFieldFullname;
    private JPasswordField txtFieldPassword;
    private JPasswordField passwordField;
    private UserService userService;

    public SignUp() {
        userService = new UserService();
        setTitle("\u0110\u0103ng k\u00FD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 470);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, "name_9202060617400");

        JPanel panelTitle = new JPanel();

        JPanel panelForm = new JPanel();

        JLabel lblUsername = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");

        txtFieldUsername = new JTextField();
        txtFieldUsername.setColumns(10);

        JLabel lblPassword = new JLabel("M\u1EADt kh\u1EA9u");

        JLabel lblEmail = new JLabel("Email");

        txtFieldEmail = new JTextField();
        txtFieldEmail.setColumns(10);

        JLabel lblAddress = new JLabel("\u0110\u1ECBa ch\u1EC9");

        txtFieldAddress = new JTextField();
        txtFieldAddress.setColumns(10);

        JLabel lblRole = new JLabel("Role");

        JLabel lblFullname = new JLabel("H\u1ECD t\u00EAn");

        txtFieldFullname = new JTextField();
        txtFieldFullname.setColumns(10);

        JLabel lblBirthday = new JLabel("Sinh ng\u00E0y");

        txtFieldPassword = new JPasswordField();

        JComboBox cbBoxRole = new JComboBox();
        cbBoxRole.setModel(new DefaultComboBoxModel(Role.values()));

        JDateChooser dateChooseBirthday = new JDateChooser();

        JButton btnSignUp = new JButton("\u0110\u0103ng k\u00FD");

        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isValid = true;
                isValid = ValidateInput(txtFieldUsername, "T\u00EAn \u0111\u0103ng nh\u1EADp kh\u00F4ng \u0111\u01B0\u1EE3c tr\u1ED1ng");
                isValid = ValidatePassword(txtFieldPassword, passwordField, "M\u1EADt kh\u1EA9u kh\u00F4ng \u0111\u01B0\u1EE3c tr\u1ED1ng", "M\u1EADt kh\u1EA9u kh\u00F4ng h\u01A1n 8 k\u00FD t\u1EF1");
                isValid = ValidateInput(txtFieldEmail, "Email kh\u00F4ng \u0111\u01B0\u1EE3c tr\u1ED1ng");
                isValid = ValidateInput(txtFieldAddress, "\u0110\u1ECBa ch\u1EC9 kh\u00F4ng \u0111\u01B0\u1EE3c tr\u1ED1ng");
                isValid = ValidateInput(txtFieldFullname, "H\u1ECD t\u00EAn kh\u00F4ng \u0111\u01B0\u1EE3c tr\u1ED1ng");
                if(cbBoxRole.getSelectedItem() == null) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Vui l\u00F2ng ch\u1ECDn quy\u1EC1n ng\u01B0\u1EDDi d\u00F9ng");
                    cbBoxRole.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
                if(dateChooseBirthday.getDate() == null) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Vui l\u00F2ng ch\u1ECDn ng\u00E0y sinh");
                    dateChooseBirthday.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
                if (!isValid) {
                    return;
                }
                String username = txtFieldUsername.getText();
                String password = String.valueOf(txtFieldPassword.getPassword());
                String passwordConfirm = String.valueOf(passwordField.getPassword());
                String email = txtFieldEmail.getText();
                String address = txtFieldAddress.getText();
                String fullname = txtFieldFullname.getText();
                String role = cbBoxRole.getSelectedItem().toString();
                String birthday = new SimpleDateFormat("yyyy-MM-dd").format(dateChooseBirthday.getDate());

                User newUser = User.builder().username(username).email(email).address(address).fullname(fullname).birthday(birthday).role(role).password(String.valueOf(password.hashCode())).status(Status.ACTIVE.name()).build();
                try{
                    userService.addUser(newUser);
                    JOptionPane.showMessageDialog(new SignIn(), "T\u1EA1o t\u00E0i kho\u1EA3n th\u00E0nh c\u00F4ng");
                    new SignIn().setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "T\u1EA1o t\u00E0i kho\u1EA3n th\u00E0nh c\u00F4ng");
                }
            }
        });

        JButton btnCancel = new JButton("H\u1EE7y");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn signIn = new SignIn();
                signIn.setVisible(true);
                dispose();
            }
        });

        JLabel lblRepeatPassword = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");

        passwordField = new JPasswordField();
        GroupLayout gl_panelForm = new GroupLayout(panelForm);
        gl_panelForm.setHorizontalGroup(
                gl_panelForm.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panelForm.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRepeatPassword)
                                        .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFullname, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblBirthday, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(txtFieldUsername, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                        .addComponent(txtFieldPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtFieldEmail, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                                .addGap(1))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtFieldAddress, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                                .addGap(1))
                                        .addGroup(Alignment.TRAILING, gl_panelForm.createSequentialGroup()
                                                .addGap(5)
                                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(txtFieldFullname, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                                                        .addComponent(cbBoxRole, Alignment.TRAILING, 0, 299, Short.MAX_VALUE)
                                                        .addComponent(dateChooseBirthday, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))))
                                .addGap(9))
                        .addGroup(Alignment.TRAILING, gl_panelForm.createSequentialGroup()
                                .addContainerGap(268, Short.MAX_VALUE)
                                .addComponent(btnCancel)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnSignUp)
                                .addContainerGap())
        );
        gl_panelForm.setVerticalGroup(
                gl_panelForm.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelForm.createSequentialGroup()
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(txtFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(13)
                                                .addComponent(lblUsername)))
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(16)
                                                .addComponent(lblPassword))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(13)
                                                .addComponent(txtFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblRepeatPassword)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblEmail))
                                        .addComponent(txtFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblAddress)
                                        .addComponent(txtFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(lblRole))
                                        .addComponent(cbBoxRole, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblFullname))
                                        .addComponent(txtFieldFullname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addComponent(dateChooseBirthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblBirthday))
                                .addGap(32)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnSignUp)
                                        .addComponent(btnCancel))
                                .addGap(159))
        );
        gl_panelForm.linkSize(SwingConstants.VERTICAL, new Component[] {txtFieldUsername, txtFieldEmail, txtFieldAddress, txtFieldFullname, txtFieldPassword, cbBoxRole, dateChooseBirthday, passwordField});
        gl_panelForm.linkSize(SwingConstants.VERTICAL, new Component[] {lblUsername, lblPassword, lblEmail, lblAddress, lblRole, lblFullname, lblBirthday, lblRepeatPassword});
        gl_panelForm.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblUsername, lblPassword, lblEmail, lblAddress, lblRole, lblFullname, lblBirthday, lblRepeatPassword});
        panelForm.setLayout(gl_panelForm);

        JLabel lblSignUp = new JLabel("\u0110\u0103ng k\u00FD");
        lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
        panelTitle.add(lblSignUp);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(10)
                                .addComponent(panelTitle, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelForm, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(10))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(panelForm, GroupLayout.PREFERRED_SIZE, 313, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panel.setLayout(gl_panel);
    }

    private boolean ValidateInput(JTextField txtField, String errorMessage) {
        if (txtField.getText().isEmpty()) {
            txtField.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, errorMessage);
            return false;
        }
        return true;
    }
    private boolean ValidatePassword(JPasswordField fieldPassword, JPasswordField fieldPasswordConfirm, String errorMessageEmpty, String errorMessageNotMatch) {
        boolean isValid = true;
        if (String.valueOf(fieldPassword.getPassword()).isEmpty()) {
            fieldPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(new SignIn(), errorMessageEmpty);
            isValid = false;
        }

        if (String.valueOf(fieldPasswordConfirm.getPassword()).isEmpty()) {
            fieldPasswordConfirm.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, errorMessageEmpty);
            isValid = false;
        }
        if (!String.valueOf(fieldPasswordConfirm.getPassword()).equals(String.valueOf(fieldPassword.getPassword()))) {
            fieldPasswordConfirm.setBorder(BorderFactory.createLineBorder(Color.RED));
            fieldPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, errorMessageNotMatch);
            isValid = false;
        }
        return isValid;
    }
}
