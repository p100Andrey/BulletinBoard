package myspring.service;

import myspring.dao.AnnounceDao;
import myspring.model.Announce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {
    private AnnounceDao announceDao;

    public void setAnnounceDao(AnnounceDao announceDao) {
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