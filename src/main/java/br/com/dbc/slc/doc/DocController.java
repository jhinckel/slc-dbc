package br.com.dbc.slc.doc;

import org.springframework.stereotype.Controller;

import br.com.dbc.slc.model.DOC;

@Controller
public class DocController {

//    @Autowired
//    private GenericRepository<BCMSG, Long> docRepository;

    public DOC getDocById(DOC filter) throws DocNotFoundException {
//        DOC doc = Optional.ofNullable(this.docRepository.load(filter)).orElseThrow(DocNotFoundException::new);
//
//        return doc;
        return null;
    }

}
