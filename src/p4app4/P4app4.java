/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4app4;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vsa
 */
public class P4app4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kniha k = new Kniha();
        Firma f = new Firma();
        
        k.setNazov("Jazyk C++");
        f.setNazov("Kniznica");

        
        f.setPublikacia(new ArrayList<>());
        f.getPublikacia().add(k);
        persist(k);
        persist(f);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p4app4PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
