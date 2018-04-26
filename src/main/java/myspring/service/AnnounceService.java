package myspring.service;

import myspring.model.Announce;

import java.util.List;

public interface AnnounceService {
    public void addAnnounce(Announce announce);

    public void updateAnnounce(Announce announce);

    public void removeAnnounce(int id);

    public Announce getAnnounceById(int id);

    public List<Announce> listAnnounce();
}