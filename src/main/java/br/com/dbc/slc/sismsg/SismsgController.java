package br.com.dbc.slc.sismsg;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.dbc.slc.model.SisMsg;
import br.com.dbc.slc.persistence.GenericRepository;

@Controller
public class SismsgController {

    @Autowired
    private GenericRepository<SisMsg, Long> sismsgRepository;

    public SisMsg getSismsgById(Long bcmsgId) throws SismsgNotFoundException {
        SisMsg filter = getFilter(bcmsgId);
        SisMsg sismsg = Optional.ofNullable(this.sismsgRepository.load(filter)).orElseThrow(SismsgNotFoundException::new);

        return sismsg;
    }

	private SisMsg getFilter(Long id) {
	    SisMsg sismsg = new SisMsg();

	    sismsg.setId(id);

	    return sismsg;
	}

}
