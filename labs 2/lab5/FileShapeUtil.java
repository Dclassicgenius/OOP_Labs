package ru.labs.lab5;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




public final class FileShapeUtil {
    private FileShapeUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static final Logger log = Logger.getLogger(FileShapeUtil.class);

    public static String readFile(Path path) {
        try {
            if (!Files.exists(path)) {
                log.error(String.format("Файл '%s' не существует", path.getFileName()));
            }
            if (!Files.isReadable(path)) {
                log.error(String.format("Файл '%s' недоступен для чтения", path.getFileName()));
            }
            return Files.readString(path);
        } catch (IOException e) {

        }
        return null;
    }

    public static String readFile(String path) {
        return readFile(Paths.get(path));
    }

    public static void writeFile(Path path, String json) {
        try {
            if (!Files.isWritable(path)) {
                log.error(String.format("Файл '%s' недоступен для записи", path.getFileName()));
            }
            Files.write(path, json.getBytes());
        } catch (IOException e) {

        }
    }

    public static void writeFile(String path, String json) {
        writeFile(Paths.get(path), json);
    }
}
