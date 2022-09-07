package ru.knyazev.cloud.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ListMessage extends AbstractMessage{

    private final List<String> filesList;

    public ListMessage(Path rootPath) throws IOException {
        try (Stream<Path> filesWalk = Files.walk(rootPath)) {
            filesList = filesWalk
                    .filter(p -> !p.equals(rootPath))
                    .filter(p -> !p.toFile().isHidden())
                    .map(Path::toString)
                    .map((s) -> s.substring(rootPath.toString().length() + 1))
                    .toList();
        }
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.LIST;
    }

    public List<String> getFilesList() {
        return filesList;
    }
}
