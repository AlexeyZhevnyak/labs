package service;

import lab1.AbstractVisitLogFactory;
import lab1.factories.VisitLogFileFactory;
import lab1.factories.VisitLogXMLFactory;
import java.util.function.Function;

public enum FileExtensions {
    TXT(VisitLogFileFactory::new),
    XML(VisitLogXMLFactory::new);
    private final Function<String, AbstractVisitLogFactory> constructor;

    FileExtensions(Function<String, AbstractVisitLogFactory> function) {
        constructor = function;
    }

    public AbstractVisitLogFactory getFactory(String path) {
        return constructor.apply(path);
    }
}