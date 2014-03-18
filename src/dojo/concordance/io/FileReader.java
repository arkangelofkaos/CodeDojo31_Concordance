package dojo.concordance.io;

import dojo.concordance.Line;

import java.io.IOException;
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

    public List<Line> read(String absolutePath) {
        try {
            AtomicInteger lineNumber = new AtomicInteger(1);
            return Files.lines(Paths.get(absolutePath), Charset.defaultCharset())
                        .map(lineText -> new Line(lineNumber.getAndIncrement(), lineText))
                        .collect(toList());
        } catch (IOException e) {
            return null; // todo - handle this properly
        }
    }

}
