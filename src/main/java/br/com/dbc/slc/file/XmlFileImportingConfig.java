package br.com.dbc.slc.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("xml")
public class XmlFileImportingConfig {

    private String folderPath;

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

}
