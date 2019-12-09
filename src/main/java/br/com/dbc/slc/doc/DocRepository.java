package br.com.dbc.slc.doc;

import org.springframework.stereotype.Repository;

import br.com.dbc.slc.model.BcMsg;
import br.com.dbc.slc.persistence.GenericRepository;

@Repository
public interface DocRepository extends GenericRepository<BcMsg, Long> {

}
