package fr.univcorse.mlignereux.projetiot.dao;

import fr.univcorse.mlignereux.projetiot.entity.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by asus on 11/10/2015.
 */
@Stateless
@LocalBean
public class CPerformanceDAO{

    @PersistenceContext
    private EntityManager em;

    public List<CPerformance> getPerformances(CAthlete pAthlete){
        return null;
    }

    public List<CPerformance> getPerformances(CTraining pTraining){
        return null;
    }

    public List<CPerformance> getPerformances(CAthlete pAthlete, CTraining pTraining){
        return null;
    }

    public void createPerformance(CAthlete pAthlete, CTraining pTraining){
        CPerformance performance = new CPerformance(pAthlete, pTraining);
       /* performance.setChrono(null);
        performance.setCardiacFrequency(null);
        performance.setDistanceTraveled(null);
        performance.setVideo(null);*/
        em.persist(performance);
    }

    public CPerformance find(int pPerformanceId) {
        Query query = em.createQuery("select p from CPerformance p where p.id = :performance_id");
        //TypedQuery<CPerformance> query = em.createQuery("select p from CPerformance p where p.id = :performance_id and p.athlete = :athlete", cPerformanceClass);
        query.setParameter("performance_id", pPerformanceId);
        //query.setParameter("athlete", athlete);
        return (CPerformance) query.getSingleResult();
    }

    public void addCardiacFrequency(CPerformance performance, CCardiacFrequency cardiacFrequency){
        find(performance.getId()).setCardiacFrequency(cardiacFrequency);
        em.persist(cardiacFrequency);
    }

    public void addChrono(CPerformance performance, CChrono chrono) {
        find(performance.getId()).setChrono(chrono);
        em.persist(chrono);
    }
}
