package service.impl;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import service.ReportCreator;
import service.WriterService;

public class FruitReportCreator implements ReportCreator {
    public static final String SEPARATOR_NEW_LINE = "\n";
    public static final String SEPARATOR_COMA = ",";
    public static final String REPORT_HEADER = "fruit, quantity";
    private final Storage fruitStorage;

    public FruitReportCreator(Storage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public WriterService createReport() {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER + SEPARATOR_NEW_LINE);
        for (String s : fruitStorage.getAllItems()) {
            report.add(s + SEPARATOR_COMA + fruitStorage.getQuantity(s) + SEPARATOR_NEW_LINE);
        }
        return new FruitReport(report);
    }

}
