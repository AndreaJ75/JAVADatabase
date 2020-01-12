package co.bnppf.df.upskilling.cardgame.daoall;


import javax.persistence.EntityManager;
import java.util.List;

public abstract class Dao <T> implements IDao<T> {
    protected EntityManager em;
    private Class <T> clazz;

    public Dao(EntityManager em,Class <T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    @Override
    public T findOne(long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {        return null;    }


    @Override
    public T create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void deleteById(long entityId) {
        delete(findOne(entityId));
    }
}
