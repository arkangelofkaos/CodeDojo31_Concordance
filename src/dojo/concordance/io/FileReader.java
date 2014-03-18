package dojo.concordance.io;

import dojo.concordance.Line;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

/**
 * @author arkangelofkaos
 */
public class FileReader {

    private String getAbsolutePathForFile(String fileName) {
        return Thread.currentThread().getContextClassLoader()
                     .getResource(fileName).getPath();
    }

    public List<Line> read(String fileName) throws FileReadingException {
        try {
            AtomicInteger lineNumber = new AtomicInteger(1);
            return Files.lines(Paths.get(getAbsolutePathForFile(fileName)), Charset.defaultCharset())
                        .map(lineText -> new Line(lineNumber.getAndIncrement(), lineText))
                        .collect(toList());
        } catch (Exception e) {
            throw new FileReadingException("Could not read file: " + fileName, e);
        }
    }

}
