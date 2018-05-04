package myspring.service;

import myspring.dao.Announcable;
import myspring.model.Announce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnounceServiceImpl implements Announcable {

    private myspring.dao.Announcable announceDao;

    public void setAnnounceDao(myspring.dao.Announcable announceDao) {
        this.announceDao = announceDao;
    }

    @Override
    @Transactional
    public void addAnnounce(Announce announce) {
        this.announceDao.addAnnounce(announce);
    }

    @Override
    @Transactional
    public void updateAnnounce(Announce announce) {
        this.announceDao.updateAnnounce(announce);
    }

    @Override
    @Transactional
    public void removeAnnounce(int id) {
        this.announceDao.removeAnnounce(id);
    }

    @Override
    @Transactional
    public Announce getAnnounceById(int id) {
        return this.announceDao.getAnnounceById(id);
    }

    @Override
    @Transactional
    public List<Announce> listAnnounce() {
        return this.announceDao.listAnnounce();
    }
}