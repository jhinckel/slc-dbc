package br.com.dbc.slc.sismsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.slc.model.SisMsg;

@Service
public class SismsgService {

	@Autowired
	private SismsgController sismsgController;

    public SisMsg getSismsgById(Long sismsgId) throws SismsgNotFoundException {
        return this.sismsgController.getSismsgById(sismsgId);
    }

}
