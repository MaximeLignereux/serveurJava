package fr.univcorse.mlignereux.projetiot.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by asus on 29/09/2015.
 */
@Entity
@Table(name = "VIDEOS")
@XmlRootElement(name="Video")
public class CVideo {

    public static final String FIELD_ID = "id";
    public static final String FIELD_PERFORMANCE = "performance";
    public static final String FIELD_DATA = "data";

    @Id
    @XmlElement(name = FIELD_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @XmlElement(name = FIELD_PERFORMANCE)
    private CPerformance performance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CPerformance getPerformance() {
        return performance;
    }

    public void setPerformance(CPerformance performance) {
        this.performance = performance;
    }
}
