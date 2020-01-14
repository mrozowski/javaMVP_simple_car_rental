package pl.kul.summary;

import java.time.LocalDate;

public interface SummaryView {
    void setPresenter(SummaryPresenter presenter);
    void showSummary(String car, LocalDate[] reservation, float price);
}
