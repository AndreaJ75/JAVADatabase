package co.bnppf.df.upskilling.cardgame.daoall;

import java.util.List;

public interface IDao <T> {

    T findOne(final long id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}