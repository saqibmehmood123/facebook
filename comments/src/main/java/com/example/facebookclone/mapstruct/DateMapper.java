package com.example.facebookclone.mapstruct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DateMapper {

    public String asString(LocalDate date) {
        return date != null ? new SimpleDateFormat( "yyyy-MM-dd" )
                .format( date ) : null;
    }

    public LocalDate asDate(String date) {
        try {

            return date != null ? LocalDate.parse(date) : null;
        }
        catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }
}