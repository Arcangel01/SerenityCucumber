package org.arcangel07.screenplay.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Search {
    private final String source;
    private final String destination;

    public Search(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public static String getFecha() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime diaDespues = fechaActual.plusDays(1);
        String fechaFormat = diaDespues.format(dtf);

        return fechaFormat;
    }
}
