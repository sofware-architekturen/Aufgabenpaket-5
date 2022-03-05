package de.hskl.itanalyst.supplier.model;

public class BookOrderDTO {
    public String title;
    public Long amount;

    @Override
    public String toString() {
        return "BookOrderDTO{" +
                "title='" + title + '\'' +
                ", amount=" + amount +
                '}';
    }
}
