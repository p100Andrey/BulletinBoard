package myspring.dao;

import myspring.model.Announce;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnounceDaoImpl implements AnnounceDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAnnounce(Announce announce) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(announce);
    }

    @Override
    public void updateAnnounce(Announce announce) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(announce);
    }

    @Override
    public void removeAnnounce(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Announce announce = (Announce) session.load(Announce.class, new Integer(id));

        if (announce != null) {
            session.delete(announce);
        }
    }

    @Override
    public Announce getAnnounceById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Announce announce = (Announce) session.load(Announce.class, new Integer(id));

        return announce;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Announce> listAnnounce() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Announce> announceList = session.createQuery("from Announce").list();

        return announceList;
    }
}