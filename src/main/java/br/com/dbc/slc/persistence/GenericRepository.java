package br.com.dbc.slc.persistence;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    T load(T entity);

    T insert(T entity);

    List<T> search(T entity);

}
