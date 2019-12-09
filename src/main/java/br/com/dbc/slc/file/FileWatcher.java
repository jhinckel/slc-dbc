package br.com.dbc.slc.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileWatcher.class);

    private Map<String, byte[]> files = Collections.synchronizedMap(new HashMap<String, byte[]>());

    public FileWatcher(Path path) {
        launchFileListenThread(path);
    }

    private void launchFileListenThread(Path path) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        watchChanges(path);
                    } catch (IOException | InterruptedException e) {
                        files.clear();
                        LOGGER.error(String.format("Error listen by folder changes: %s ", path), e);
                    }
                }
            }
        });
    }

    private void fillMapWithFolderFiles(Path path) throws IOException {
        Map<String, byte[]> listFiles = FileUtils.listFiles(path.toString());

        for (String key : listFiles.keySet()) {
            this.files.put(key, listFiles.get(key));
            LOGGER.info(String.format("Arquivo carregado: %s", key));
        }
    }

    private void watchChanges(Path path) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey key;

        fillMapWithFolderFiles(path);

        // path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                String filePath = path.getRoot().toString() + path.getFileName() + "\\" + event.context();

                if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    LOGGER.info(String.format("Arquivo removido: %s", filePath));
                    files.remove(event.context().toString());
                } else {
                    LOGGER.info(String.format("Arquivo adicionado: %s", filePath));
                    files.put(event.context().toString(), FileUtils.readFileContent(filePath));
                }
            }
            key.reset();
        }
    }

    public synchronized Map<String, byte[]> getFiles() {
        return this.files;
    }

}
