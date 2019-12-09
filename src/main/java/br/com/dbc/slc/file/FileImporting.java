package br.com.dbc.slc.file;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.slc.bcmsg.BcmsgRepository;
import br.com.dbc.slc.model.DOC;
import br.com.dbc.slc.model.SISMSG;
import br.com.dbc.slc.sismsg.SismsgRepository;
import br.com.dbc.slc.xml.XmlUtils;

@Service
public class FileImporting {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private XmlFileImportingConfig xmlConfig;

    @Autowired
    private BcmsgRepository bcmsgRepository;

    @Autowired
    private SismsgRepository sismsgRepository;

    @PostConstruct
    private void fileListenerInit() throws Exception {
        Path path = Paths.get(xmlConfig.getFolderPath());
        FileWatcher fileWatcher = new FileWatcher(path);

        // We need to wait some time until FileWatcher initialize...
        Thread.sleep(2000);

        Map<String, byte[]> files = fileWatcher.getFiles();

        for (String fileName : files.keySet()) {
            byte[] xmlFileContent = files.get(fileName);

            try {
                DOC doc = unmarshalXmlFile(DOC.class, xmlFileContent);
                List<JAXBElement<Object>> slcItems = doc.getSismsg().getSlcItem();
                SISMSG xmlGenericNodes = XmlUtils.processXmlGenericNodes(slcItems, SISMSG.class);

                doc.setSismsg(xmlGenericNodes);

                insertObjectData(doc);
            } catch (JAXBException e) {
                LOGGER.error("Error parsing SLC XML to Java object", e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T unmarshalXmlFile(Class<T> clazz, byte[] xmlFileContent) throws JAXBException {
        return (T) XmlUtils.unmarshall(clazz, xmlFileContent);
    }

    @Transactional(rollbackOn = Exception.class)
    private void insertObjectData(DOC doc) {
        bcmsgRepository.insert(doc.getBcmsg());
        sismsgRepository.insert(doc.getSismsg());
    }

}
