package models;

import javax.persistence.*;


@Entity
public class Match {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String id;
    public String localTeam;
    public String awayTeam;
    public String stadium;
    public int goalsLocalTeam;
    public int goalsAwayTeam;

}
