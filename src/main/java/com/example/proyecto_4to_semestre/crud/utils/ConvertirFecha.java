package com.example.proyecto_4to_semestre.crud.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertirFecha {
    // Método para convertir de "dd-MM-yyyy" a "yyyy-MM-dd"
    public static String convertDateFormat(String dateStr, String inputFormat, String outputFormat) throws ParseException {
        SimpleDateFormat fromFormat = new SimpleDateFormat(inputFormat);
        SimpleDateFormat toFormat = new SimpleDateFormat(outputFormat);
        Date date = fromFormat.parse(dateStr);
        return toFormat.format(date);
    }
}

