package view;

import service.CourseService;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseManagement extends JFrame {

    private JPanel contentPane;
    private JTable tbListCourse;
    private JTextField txtCourseCode;
    private JTextField txtCourseName;
    private JTextField txtDescription;
    private JTextField txtDateStart;
    private JTextField txtDateEnd;
    private JTextField txtDateOfWeek;
    private JTextField txtTimeStart;
    private JTextField txtTimeEnd;
    private JTextField txtNumberOfWeek;
    private JTextField txtRoom;
    private CourseService courseService;

    public CourseManagement() {
        courseService = new CourseService();
        courseService.getListCourse();
        courseService.getListRoom();
        courseService.getListStudent();
        courseService.getListCourseStudent();
        courseService.getListAttendanceCourse();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 671);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblCourseManagement = new JLabel("Qu\u1EA3n l\u00FD m\u00F4n h\u1ECDc");
        lblCourseManagement.setHorizontalAlignment(SwingConstants.CENTER);
        lblCourseManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCourseManagement, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addContainerGap())
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblCourseManagement, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panel.setLayout(gl_panel);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);

        JLabel lblListCourse = new JLabel("Danh s\u00E1ch m\u00F4n h\u1ECDc");
        lblListCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnBack = new JButton("Tr\u1EDF v\u1EC1");
        btnBack.addActionListener(e -> {
            TeacherHome view = new TeacherHome();
            view.setVisible(true);
            dispose();
        });

        JButton btnCreateCourse = new JButton("T\u1EA1o m\u00F4n h\u1ECDc m\u1EDBi");
        btnCreateCourse.addActionListener(e->{
            CreateCourse view = new CreateCourse();
            view.setVisible(true);
            this.dispose();
        });

        JScrollPane scrollPane = new JScrollPane();

        tbListCourse = new JTable();
        tbListCourse.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "STT", "M\u00E3 m\u00F4n h\u1ECDc", "T\u00EAn m\u00F4n h\u1ECDc"
                }
        ));
        tbListCourse.getColumnModel().getColumn(0).setPreferredWidth(47);
        scrollPane.setViewportView(tbListCourse);

        JPopupMenu popupMenu = new JPopupMenu();
        addPopup(tbListCourse, popupMenu);

        JMenuItem mntmAddStudent = new JMenuItem("Th\u00EAm sinh vi\u00EAn v\u00E0o m\u00F4n h\u1ECDc");
        popupMenu.add(mntmAddStudent);

        JLabel lblInfoCourse = new JLabel("Th\u00F4ng tin m\u00F4n h\u1ECDc");
        lblInfoCourse.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfoCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JPanel formInfo = new JPanel();

        JLabel lblCourseCode = new JLabel("M\u00E3 m\u00F4n h\u1ECDc");

        JLabel lblCourseName = new JLabel("T\u00EAn m\u00F4n h\u1ECDc");

        JLabel lblDescription = new JLabel("M\u00F4 t\u1EA3");

        JLabel lblDateStart = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");

        JLabel lblDateEnd = new JLabel("Ng\u00E0y k\u1EBFt th\u00FAc");

        JLabel lblDateOfWeek = new JLabel("Th\u1EE9 trong tu\u1EA7n");

        JLabel lblTimeStart = new JLabel("Gi\u1EDD b\u1EAFt \u0111\u1EA7u");

        JLabel lblTimeEnd = new JLabel("Gi\u1EDD k\u1EBFt th\u00FAc");

        JLabel lblNumberOfWeek = new JLabel("S\u1ED1 l\u01B0\u1EE3ng tu\u1EA7n");

        txtCourseCode = new JTextField();
        txtCourseCode.setEnabled(false);
        txtCourseCode.setEditable(false);
        txtCourseCode.setColumns(10);

        txtCourseName = new JTextField();
        txtCourseName.setEnabled(false);
        txtCourseName.setEditable(false);
        txtCourseName.setColumns(10);

        txtDescription = new JTextField();
        txtDescription.setEnabled(false);
        txtDescription.setEditable(false);
        txtDescription.setColumns(10);

        txtDateStart = new JTextField();
        txtDateStart.setEnabled(false);
        txtDateStart.setEditable(false);
        txtDateStart.setColumns(10);

        txtDateEnd = new JTextField();
        txtDateEnd.setEnabled(false);
        txtDateEnd.setEditable(false);
        txtDateEnd.setColumns(10);

        txtDateOfWeek = new JTextField();
        txtDateOfWeek.setEnabled(false);
        txtDateOfWeek.setEditable(false);
        txtDateOfWeek.setColumns(10);

        txtTimeStart = new JTextField();
        txtTimeStart.setEnabled(false);
        txtTimeStart.setEditable(false);
        txtTimeStart.setColumns(10);

        txtTimeEnd = new JTextField();
        txtTimeEnd.setEnabled(false);
        txtTimeEnd.setEditable(false);
        txtTimeEnd.setColumns(10);

        txtNumberOfWeek = new JTextField();
        txtNumberOfWeek.setEnabled(false);
        txtNumberOfWeek.setEditable(false);
        txtNumberOfWeek.setColumns(10);

        JLabel lblRoom = new JLabel("Ph\u00F2ng h\u1ECDc");

        txtRoom = new JTextField();
        txtRoom.setEnabled(false);
        txtRoom.setEditable(false);
        txtRoom.setColumns(10);
        GroupLayout gl_formInfo = new GroupLayout(formInfo);
        gl_formInfo.setHorizontalGroup(
                gl_formInfo.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_formInfo.createSequentialGroup()
                                .addGap(24)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblCourseCode)
                                                .addGap(39)
                                                .addComponent(txtCourseCode, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblCourseName)
                                                .addGap(35)
                                                .addComponent(txtCourseName, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblDescription)
                                                .addGap(69)
                                                .addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblDateStart)
                                                .addGap(35)
                                                .addComponent(txtDateStart, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblDateEnd)
                                                .addGap(33)
                                                .addComponent(txtDateEnd, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblDateOfWeek)
                                                .addGap(26)
                                                .addComponent(txtDateOfWeek, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblTimeStart)
                                                .addGap(43)
                                                .addComponent(txtTimeStart, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblTimeEnd)
                                                .addGap(41)
                                                .addComponent(txtTimeEnd, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblNumberOfWeek)
                                                .addGap(31)
                                                .addComponent(txtNumberOfWeek, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addComponent(lblRoom, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                .addGap(31)
                                                .addComponent(txtRoom, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                                .addGap(10))
        );
        gl_formInfo.setVerticalGroup(
                gl_formInfo.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_formInfo.createSequentialGroup()
                                .addGap(17)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblCourseCode))
                                        .addComponent(txtCourseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblCourseName))
                                        .addComponent(txtCourseName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblDescription))
                                        .addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblDateStart))
                                        .addComponent(txtDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblDateEnd))
                                        .addComponent(txtDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblDateOfWeek))
                                        .addComponent(txtDateOfWeek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblTimeStart))
                                        .addComponent(txtTimeStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblTimeEnd))
                                        .addComponent(txtTimeEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblNumberOfWeek))
                                        .addComponent(txtNumberOfWeek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(14)
                                .addGroup(gl_formInfo.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_formInfo.createSequentialGroup()
                                                .addGap(3)
                                                .addComponent(lblRoom))
                                        .addComponent(txtRoom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        formInfo.setLayout(gl_formInfo);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addComponent(lblListCourse, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addGap(92)
                                .addComponent(btnCreateCourse)
                                .addGap(21))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addGap(10))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addComponent(lblInfoCourse, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                                .addGap(10))
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addComponent(formInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10))
                        .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addGap(331)
                                .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addGap(10))
        );
        gl_panel_1.setVerticalGroup(
                gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                                .addGap(10)
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblListCourse, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                .addGap(11)
                                                .addComponent(btnCreateCourse)))
                                .addGap(23)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addGap(23)
                                .addComponent(lblInfoCourse, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(formInfo, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(btnBack))
        );
        panel_1.setLayout(gl_panel_1);
    }
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}

