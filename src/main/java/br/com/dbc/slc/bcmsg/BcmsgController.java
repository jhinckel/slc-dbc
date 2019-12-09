package br.com.dbc.slc.bcmsg;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.dbc.slc.model.BcMsg;
import br.com.dbc.slc.persistence.GenericRepository;

@Controller
public class BcmsgController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private GenericRepository<BcMsg, Long> bcmsgRepository;

    public BcMsg getBcmsgById(BcMsg filter) throws BcmsgNotFoundException {
        BcMsg bcmsg = Optional.ofNullable(this.bcmsgRepository.load(filter)).orElseThrow(BcmsgNotFoundException::new);

        return bcmsg;
    }

	public List<BcMsg> getBcmsgByOperationNumber(BcMsg filter) throws BcmsgNotFoundException {
        List<BcMsg> bcmsgList = Optional.ofNullable(this.bcmsgRepository.search(filter)).get();

        if (bcmsgList.isEmpty()) {
            LOGGER.info(String.format("None BCMSG found by bcmsg filter %s", filter));
        }
		return bcmsgList;
	}

}
