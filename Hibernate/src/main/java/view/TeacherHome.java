package view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherHome extends JFrame {

    private JPanel contentPane;

    public TeacherHome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 162, 230);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnCourseManagement = new JButton("Qu\u1EA3n l\u00FD m\u00F4n h\u1ECDc ");
        btnCourseManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CourseManagement courseManagement = new CourseManagement();
                courseManagement.setVisible(true);
                dispose();
            }
        });

        JButton btnRoomCreation = new JButton("T\u1EA1o ph\u00F2ng h\u1ECDc");
        btnRoomCreation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnTimeCreation = new JButton("T\u1EA1o gi\u1EDD h\u1ECDc");
        btnTimeCreation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnSignOut = new JButton("\u0110\u0103ng xu\u1EA5t");
        btnSignOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnCourseManagement, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addComponent(btnRoomCreation, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addComponent(btnTimeCreation, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addComponent(btnSignOut, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                                .addGap(10))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(16)
                                .addComponent(btnCourseManagement, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                .addGap(21)
                                .addComponent(btnRoomCreation, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                .addGap(21)
                                .addComponent(btnTimeCreation, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                .addGap(21)
                                .addComponent(btnSignOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
