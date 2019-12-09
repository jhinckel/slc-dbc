package br.com.dbc.slc.doc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.dbc.slc.model.DOC;

@Component
public class DocApiImpl implements DocApi {

    private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private DocService docService;

    @Override
    public ResponseEntity<DOC> getDocById(Long docId) throws DocNotFoundException {
        LOGGER.debug("Running: getBcmsgById(Long docId)");

        DOC doc = docService.getDocById(docId);

        return ResponseEntity.ok(doc);
    }

}
