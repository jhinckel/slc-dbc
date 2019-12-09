package br.com.dbc.slc.doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.slc.model.DOC;

@Service
public class DocService {

	@Autowired
	private DocController docController;

    public DOC getDocById(Long docId) throws DocNotFoundException {
        DOC docFilter = getDocFilter(docId);

        return this.docController.getDocById(docFilter);
    }

	private DOC getDocFilter(Long id) {
	    DOC doc = new DOC();

//	    doc.setId(id);

	    return doc;
	}

}
