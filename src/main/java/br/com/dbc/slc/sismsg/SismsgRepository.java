package br.com.dbc.slc.sismsg;

import org.springframework.stereotype.Repository;

import br.com.dbc.slc.model.SisMsg;
import br.com.dbc.slc.persistence.GenericRepository;

@Repository
public interface SismsgRepository extends GenericRepository<SisMsg, Long> {

}
