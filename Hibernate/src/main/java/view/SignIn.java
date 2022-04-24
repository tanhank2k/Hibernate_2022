package view;

import common.Role;
import model.User;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame {

    private JPanel contentPane;
    private JTextField txtFieldUsername;
    private JPasswordField txtFieldPassword;
    private UserService userService;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public SignIn() {
        setLocationRelativeTo(null);
        userService = new UserService();
        setTitle("\u0110\u0103ng nh\u1EADp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 252);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        JPanel panelMain = new JPanel();
        contentPane.add(panelMain, "name_449871348779600");

        JPanel panelTitle = new JPanel();

        JLabel labelSignIn = new JLabel("\u0110\u0102NG NH\u1EACP");
        labelSignIn.setHorizontalAlignment(SwingConstants.CENTER);
        labelSignIn.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel panelForm = new JPanel();

        JLabel labelPassword = new JLabel("M\u1EADt kh\u1EA9u");

        txtFieldUsername = new JTextField();
        txtFieldUsername.setColumns(10);

        JLabel labelUsername = new JLabel("T\u00EAn ng\u01B0\u1EDDi d\u00F9ng");

        txtFieldPassword = new JPasswordField();
        txtFieldPassword.setColumns(10);

        JButton btnSignIn = new JButton("\u0110\u0103ng nh\u1EADp");
        btnSignIn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup.getSelection() == null) {
                    JOptionPane.showMessageDialog(null, "Vui l\u00F2ng ch\u1ECDn lo\u1EA1i t\u00E0i kho\u1EA3n");
                    return;
                }

                if (buttonGroup.getSelection().getActionCommand().equals("Gi\u00E1o vi\u00EAn")){
                    User user = userService.signIn(txtFieldUsername.getText(), String.valueOf(txtFieldPassword.getPassword()), Role.TEACHER.name());
                    if (user != null) {
                        new TeacherHome().setVisible(true);
                        dispose();
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "M\u1EADt kh\u1EA9u ho\u1EB7c t\u00EAn ng\u01B0\u1EDDi d\u00F9ng kh\u00F4ng ch\u00EDnh x\u00E1c");
                }

                if (buttonGroup.getSelection().getActionCommand().equals("Sinh vi\u00EAn")){
                    User user = userService.signIn(txtFieldUsername.getText(), String.valueOf(txtFieldPassword.getPassword()), Role.STUDENT.name());
                    if (user != null) {
                        new StudentHome().setVisible(true);
                        dispose();
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "M\u1EADt kh\u1EA9u ho\u1EB7c t\u00EAn ng\u01B0\u1EDDi d\u00F9ng kh\u00F4ng ch\u00EDnh x\u00E1c");
                }
            }
        });

        JRadioButton radioTeacher = new JRadioButton("Gi\u00E1o vi\u00EAn");
        radioTeacher.setActionCommand("Gi\u00E1o vi\u00EAn");
        buttonGroup.add(radioTeacher);

        JRadioButton radioStudent = new JRadioButton("Sinh vi\u00EAn");
        radioStudent.setActionCommand("Sinh vi\u00EAn");
        buttonGroup.add(radioStudent);
        GroupLayout gl_panelMain = new GroupLayout(panelMain);
        gl_panelMain.setHorizontalGroup(
                gl_panelMain.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, gl_panelMain.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelMain.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(panelForm, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                        .addComponent(panelTitle, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_panelMain.setVerticalGroup(
                gl_panelMain.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panelMain.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelForm, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addContainerGap())
        );

        JButton btnSignUp = new JButton("\u0110\u0103ng k\u00FD");
        btnSignUp.addActionListener(e -> {
            SignUp signUp = new SignUp();
            signUp.setVisible(true);
            dispose();
        });
        GroupLayout gl_panelForm = new GroupLayout(panelForm);
        gl_panelForm.setHorizontalGroup(
                gl_panelForm.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panelForm.createSequentialGroup()
                                .addGap(10)
                                .addComponent(labelUsername, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(14)
                                .addComponent(txtFieldUsername, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addGap(10))
                        .addGroup(gl_panelForm.createSequentialGroup()
                                .addContainerGap(244, Short.MAX_VALUE)
                                .addComponent(btnSignUp)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSignIn)
                                .addGap(6))
                        .addGroup(GroupLayout.Alignment.TRAILING, gl_panelForm.createSequentialGroup()
                                .addGroup(gl_panelForm.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.LEADING, gl_panelForm.createSequentialGroup()
                                                .addGap(252)
                                                .addComponent(radioTeacher)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(radioStudent, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(10)
                                                .addComponent(labelPassword, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addGap(14)
                                                .addComponent(txtFieldPassword, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)))
                                .addGap(10))
        );
        gl_panelForm.setVerticalGroup(
                gl_panelForm.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panelForm.createSequentialGroup()
                                .addGroup(gl_panelForm.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelUsername, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFieldUsername, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(10)
                                .addGroup(gl_panelForm.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelPassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFieldPassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_panelForm.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(radioTeacher)
                                        .addComponent(radioStudent))
                                .addGap(24)
                                .addGroup(gl_panelForm.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSignIn, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelForm.setLayout(gl_panelForm);
        panelTitle.setLayout(new CardLayout(0, 0));
        panelTitle.add(labelSignIn, "name_450555451896300");
        panelMain.setLayout(gl_panelMain);
    }
}