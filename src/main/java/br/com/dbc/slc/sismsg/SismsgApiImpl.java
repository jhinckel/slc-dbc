package br.com.dbc.slc.sismsg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.dbc.slc.model.SisMsg;

@Component
public class SismsgApiImpl implements SismsgApi {

    private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private SismsgService sismsgService;

    @Override
    public ResponseEntity<SisMsg> getSismsgById(Long sismsgId) throws SismsgNotFoundException {
        LOGGER.debug("Running: getSismsgById(String sismsgId)");

        SisMsg sismsg = sismsgService.getSismsgById(sismsgId);

        return ResponseEntity.ok(sismsg);
    }

}
