package com.hibernate.onetoone.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_link")
public class UserLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "github")
    private String gitHub;

    @Column(name = "linkedin")
    private String linkedIn;

    @Column(name = "youtube")
    private String youTube;

    public UserLink(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }

    @Override
    public String toString() {
        return "UserLink{" +
                "id=" + id +
                ", gitHub='" + gitHub + '\'' +
                ", linkedIn='" + linkedIn + '\'' +
                ", youTube='" + youTube + '\'' +
                '}';
    }
}
