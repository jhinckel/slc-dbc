package br.com.dbc.slc.bcmsg;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.dbc.slc.model.BcMsg;

@Component
public class BcmsgApiImpl implements BcmsgApi {

    private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private BcmsgService bcmsgService;

    @Override
    public ResponseEntity<BcMsg> getBcmsgById(Long bcmsgId) throws BcmsgNotFoundException {
        LOGGER.debug("Running: getBcmsgById(String bcmsgId)");

        BcMsg bcmsg = bcmsgService.getBcmsgById(bcmsgId);

        return ResponseEntity.ok(bcmsg);
    }

    @Override
    public ResponseEntity<List<BcMsg>> getBcmsgByOperationNumber(String operationNumber) throws BcmsgNotFoundException {
        LOGGER.debug("Running: getBcmsgByOperationNumber(String operationNumber)");

        List<BcMsg> bcmsgList = bcmsgService.getBcmsgByOperationNumber(operationNumber);

        return ResponseEntity.ok(bcmsgList);
    }

}
