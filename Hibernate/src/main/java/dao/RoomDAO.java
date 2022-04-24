package dao;

import hibernate.HibernateUtils;
import model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RoomDAO {
    private SessionFactory sessionFactory;
    public RoomDAO() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }
    public void addRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.save(room);
        session.close();
    }
    public void updateRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.update(room);
        session.close();
    }
    public void deleteRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.delete(room);
        session.close();
    }
    public Room getRoomById(int id) {
        Session session = sessionFactory.openSession();
        Room room = session.get(Room.class, id);
        session.close();
        return room;
    }
    public List<Room> getAllRooms() {
        Session session = sessionFactory.openSession();
        List<Room> rooms = session.createQuery("from Room").list();
        session.close();
        return rooms;
    }
}
