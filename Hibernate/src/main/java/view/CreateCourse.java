package view;

import com.toedter.calendar.JDateChooser;
import common.DateOfWeek;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreateCourse extends JFrame {

    private JPanel contentPane;
    private JTextField txtCourseCode;
    private JTextField txtCourseName;
    private JTextField txtRoomName;

    public CreateCourse() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 438);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        JPanel panelForm = new JPanel();
        contentPane.add(panelForm, "name_495184731900900");

        JPanel panelInfo = new JPanel();

        JLabel lblCourseCode = new JLabel("M\u00E3 m\u00F4n");

        txtCourseCode = new JTextField();
        txtCourseCode.setColumns(10);

        JLabel lblCourseName = new JLabel("T\u00EAn m\u00F4n");

        txtCourseName = new JTextField();
        txtCourseName.setColumns(10);

        JLabel lblSchedule = new JLabel("Th\u1EDDi kh\u00F3a bi\u1EC3u");
        lblSchedule.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JLabel lblStart = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");

        JDateChooser DateStartChoose = new JDateChooser();

        JLabel lblDateEnd = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");

        JDateChooser DateEndChoose = new JDateChooser();

        JLabel lblDateOfWeek = new JLabel("Ng\u00E0y trong tu\u1EA7n");

        JComboBox DateOfWeekChoose = new JComboBox();
        DateOfWeekChoose.setModel(new DefaultComboBoxModel(DateOfWeek.values()));

        JLabel lblTimeStart = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u");

        JComboBox TimeStartChoose = new JComboBox();
        TimeStartChoose.setModel(new DefaultComboBoxModel(new String[] {"07:00", "08:00", "09:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"}));

        JLabel lblTimeEnd = new JLabel("Gi\u1EDD k\u1EBFt th\u00FAc");

        JComboBox TimeEndChoose = new JComboBox();

        JLabel lblRoomName = new JLabel("T\u00EAn ph\u00F2ng h\u1ECDc");

        txtRoomName = new JTextField();
        txtRoomName.setColumns(10);

        JButton btnCreate = new JButton("T\u1EA1o m\u1EDBi");

        JButton btnCancel = new JButton("H\u1EE7y");
        GroupLayout gl_panelForm = new GroupLayout(panelForm);
        gl_panelForm.setHorizontalGroup(
                gl_panelForm.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelForm.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addComponent(lblCourseCode, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(txtCourseCode, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addComponent(lblCourseName, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(txtCourseName, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGroup(gl_panelForm.createParallelGroup(Alignment.TRAILING, false)
                                                        .addComponent(lblRoomName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblTimeEnd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblDateEnd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblSchedule, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblTimeStart, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblDateOfWeek, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(22)
                                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(TimeStartChoose, 0, 285, Short.MAX_VALUE)
                                                        .addComponent(DateOfWeekChoose, Alignment.TRAILING, 0, 285, Short.MAX_VALUE)
                                                        .addComponent(DateEndChoose, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                                        .addComponent(DateStartChoose, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                                        .addComponent(TimeEndChoose, 0, 285, Short.MAX_VALUE)
                                                        .addComponent(txtRoomName, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
                                        .addGroup(Alignment.TRAILING, gl_panelForm.createSequentialGroup()
                                                .addComponent(btnCancel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnCreate)))
                                .addContainerGap())
        );
        gl_panelForm.setVerticalGroup(
                gl_panelForm.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panelForm.createSequentialGroup()
                                .addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblCourseCode)
                                        .addComponent(txtCourseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addGap(9)
                                                .addComponent(lblCourseName))
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtCourseName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panelForm.createSequentialGroup()
                                                .addComponent(lblSchedule)
                                                .addGap(12)
                                                .addComponent(lblStart))
                                        .addComponent(DateStartChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblDateEnd)
                                        .addComponent(DateEndChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblDateOfWeek)
                                        .addComponent(DateOfWeekChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblTimeStart)
                                        .addComponent(TimeStartChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblTimeEnd)
                                        .addComponent(TimeEndChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblRoomName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRoomName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addGroup(gl_panelForm.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnCreate)
                                        .addComponent(btnCancel))
                                .addContainerGap())
        );

        JLabel lblCourseInfo = new JLabel("Th\u00F4ng tin m\u00F4n h\u1ECDc");
        panelInfo.add(lblCourseInfo);
        panelForm.setLayout(gl_panelForm);
    }
}
