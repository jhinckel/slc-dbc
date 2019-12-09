package br.com.dbc.slc.bcmsg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.slc.model.BcMsg;

@Service
public class BcmsgService {

	@Autowired
	private BcmsgController bcmsgController;

    public BcMsg getBcmsgById(Long bcmsgId) throws BcmsgNotFoundException {
        BcMsg bcmsgFilter = getBcmsgFilter(bcmsgId);

        return this.bcmsgController.getBcmsgById(bcmsgFilter);
    }

	public List<BcMsg> getBcmsgByOperationNumber(String opNumber) throws BcmsgNotFoundException {
        BcMsg bcmsgFilter = getOpNumberFilter(opNumber);

		return this.bcmsgController.getBcmsgByOperationNumber(bcmsgFilter);
	}

	private BcMsg getBcmsgFilter(Long id) {
	    BcMsg bcmsg = new BcMsg();

	    bcmsg.setId(id);

	    return bcmsg;
	}

	private BcMsg getOpNumberFilter(String opNumber) {
	    BcMsg bcmsg = new BcMsg();

	    bcmsg.setnUOp(opNumber);

	    return bcmsg;
	}

}
