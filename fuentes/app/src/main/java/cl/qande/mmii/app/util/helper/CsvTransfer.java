package cl.qande.mmii.app.util.helper;

import java.util.ArrayList;
import java.util.List;

public class CsvTransfer {
    private List<String[]> csvStringList;

    private List<CsvBean> csvList;

    public List<String[]> getCsvStringList() {
        if (csvStringList != null) return csvStringList;
        return new ArrayList<>();
    }

    public void addLine(String[] line) {
        if (this.csvList == null) this.csvStringList = new ArrayList<>();
        this.csvStringList.add(line);
    }

    public void setCsvStringList(List<String[]> csvStringList) {
        this.csvStringList = csvStringList;
    }

    public void setCsvList(List<CsvBean> csvList) {
        this.csvList = csvList;
    }

    public List<CsvBean> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<>();
    }
}
