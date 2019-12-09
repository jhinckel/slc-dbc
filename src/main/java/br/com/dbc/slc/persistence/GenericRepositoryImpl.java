package br.com.dbc.slc.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements GenericRepository<T, ID> {

    private final EntityManager entityManager;

    public GenericRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
     super(entityInformation, entityManager);
     this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T load(T entity) {
        return (T) entityManager.find(entity.getClass(), ((PersistentObject) entity).getId());
    }

    @Override
    // FIXME implement this!
    public List<T> search(T entity) {
        return null;
    }

    @Override
    @Transactional
    public T insert(T entity) {
        entityManager.persist(entity);

        return entity;
    }

  }
