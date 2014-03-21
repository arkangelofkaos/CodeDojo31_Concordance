package dojo.concordance.io;

import dojo.concordance.Line;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

/**
 * @author arkangelofkaos
 */
public class FileToLinesReader {

    private static String absolutePathTo(String file) {
        return Thread.currentThread().getContextClassLoader().getResource(file).getPath();
    }

    public static List<Line> readLinesFromFile(String file) throws FileReadingException {
        try {
            AtomicInteger lineNumber = new AtomicInteger(1);
            return Files.lines(Paths.get(absolutePathTo(file)))
                        .map(lineText -> new Line(lineNumber.getAndIncrement(), lineText))
                        .collect(toList());
        } catch (Exception e) {
            throw new FileReadingException("Could not read file: " + file, e);
        }
    }

}
