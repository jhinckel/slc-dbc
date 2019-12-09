package br.com.dbc.slc.bcmsg;

import org.springframework.stereotype.Repository;

import br.com.dbc.slc.model.BcMsg;
import br.com.dbc.slc.persistence.GenericRepository;

@Repository
public interface BcmsgRepository extends GenericRepository<BcMsg, Long> {

}
