package view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentHome extends JFrame {

    private JPanel contentPane;

    public StudentHome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 228, 248);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnAttendance = new JButton("\u0110i\u1EC3m danh");
        btnAttendance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnInfomation = new JButton("Th\u00F4ng tin ng\u01B0\u1EDDi d\u00F9ng");
        btnInfomation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnResultAttendance = new JButton("K\u1EBFt qu\u1EA3 \u0111i\u1EC3m danh");
        btnResultAttendance.addActionListener(new ActionListener() {
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
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(8)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnInfomation, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnResultAttendance, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSignOut))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addComponent(btnAttendance, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnInfomation, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnResultAttendance, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnSignOut)
                                .addGap(3))
        );
        gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnAttendance, btnInfomation, btnResultAttendance, btnSignOut});
        gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnAttendance, btnInfomation, btnResultAttendance, btnSignOut});
        contentPane.setLayout(gl_contentPane);
    }
}
