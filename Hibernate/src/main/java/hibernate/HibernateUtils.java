package hibernate;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static {
        Configuration config = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_db?createDatabaseIfNotExist=true&upgradeDatabase=true");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "11111111");
        props.put(Environment.SHOW_SQL, "true");
        props.put(Environment.FORMAT_SQL, "true");
        props.put(Environment.HBM2DDL_AUTO, "update");
        props.put(Environment.AUTOCOMMIT, "true");

        config.setProperties(props);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Course.class);
        config.addAnnotatedClass(Room.class);
        config.addAnnotatedClass(Student.class);
        config.addAnnotatedClass(CourseStudent.class);
        config.addAnnotatedClass(AttendanceCourse.class);

        ServiceRegistry register = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        FACTORY = config.buildSessionFactory(register);
    }
    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }
}
