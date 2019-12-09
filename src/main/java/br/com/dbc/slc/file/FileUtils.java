package br.com.dbc.slc.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {

    private static final String EXTENSION_REGEX = "[a-zA-Z0-9]+$";

    public File loadFile(String path) {
        return new File(path);
    }

    public void moveFile(File origin, File destination) {
        try {
            FileInputStream fileInput = new FileInputStream(origin);
            BufferedInputStream buffInput = new BufferedInputStream(fileInput);
            writeFile(destination, buffInput);
            origin.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(File destination, InputStream input) {
        try {
            FileOutputStream output = new FileOutputStream(destination);
            byte[] buffer = new byte[4096];
            int byteRead;

            while ((byteRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, byteRead);
            }
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String writeFile(String filePath, byte[] fileContent) throws Exception {
        File file = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileContent);
            fos.close();
        } catch (Exception e) {
            throw e;
        }
        return file.getAbsolutePath();
    }

    public String readFile(File origin) {
        StringBuilder sb = new StringBuilder(1024);

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(origin)))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Retorna os arquivos encontrados na pasta fornecida.
     */
    public static Map<String, byte[]> listFiles(String path) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        Map<String, byte[]> files = new HashMap<String, byte[]>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.put(file.getName(), Files.readAllBytes(file.toPath()));
            }
        }
        return files;
    }

    /**
     * Faz a leitura dos bytes de um arquivo.
     */
    public static byte[] readFileContent(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    public static String writeTempFile(String path, byte[] fileContent) throws Exception {
        String fileName = UUID.randomUUID().toString();
        File file = new File(path + File.separator + fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileContent);
            fos.close();
        } catch (Exception e) {
            throw e;
        }
        return file.getAbsolutePath();
    }

    public static boolean deteleFile(String fullFilePath) {
        File file = new File(fullFilePath);

        return file.delete();
    }

    public static String getFileExtension(String fileName) {
        Matcher m = Pattern.compile(EXTENSION_REGEX).matcher(fileName);
        String extension = null;

        if (m.find()) {
            extension = m.group(0);
        }
        return extension;
    }

}
