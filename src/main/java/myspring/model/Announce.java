package myspring.model;

import javax.persistence.*;

@Entity
@Table(name = "announce")
public class Announce {
    @Id
//    @Column(name = "announceid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int announceid;

//    @Column(name = "announcetitle")
    private String announceTitle;

//    @Column(name = "announcetext")
    private String announceText;

//    @Column(name = "announcefoto")
    private String announceFoto;

//    @Column(name = "announceauthor")
    private int announceAuthor;

//    @Column(name = "announcecreationtime")
    private int announceCreationTime;

    public int getAnnounceid() {
        return announceid;
    }

    public void setAnnounceid(int announceid) {
        this.announceid = announceid;
    }

    public String getAnnounceTitle() {
        return announceTitle;
    }

    public void setAnnounceTitle(String announceTitle) {
        this.announceTitle = announceTitle;
    }

    public String getAnnounceText() {
        return announceText;
    }

    public void setAnnounceText(String announceText) {
        this.announceText = announceText;
    }

    public String getAnnounceFoto() {
        return announceFoto;
    }

    public void setAnnounceFoto(String announceFoto) {
        this.announceFoto = announceFoto;
    }

    public int getAnnounceAuthor() {
        return announceAuthor;
    }

    public void setAnnounceAuthor(int announceAuthor) {
        this.announceAuthor = announceAuthor;
    }

    public int getAnnounceCreationTime() {
        return announceCreationTime;
    }

    public void setAnnounceCreationTime(int announceCreationTime) {
        this.announceCreationTime = announceCreationTime;
    }
}
