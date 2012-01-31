/*****************************************************************************
 * Copyright 2010 Novasprint Pte Ltd. All Rights Reserved.
 * This software is the proprietary information of Novasprint Pte Ltd.
 * Use is subject to license terms.
 *****************************************************************************/
package smva.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author allan.lee
 */
public class commonUtil {

    public static Timestamp convertDateToTimestamp(String dateEntry) throws ParseException {
        Timestamp dateValue = null;
        if (dateEntry != null && !dateEntry.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat(AVMSConstant.DISPLAY_DATE_FORMAT);
            Date dt = sdf.parse(dateEntry);
            dateValue = new Timestamp(dt.getTime());
        }
        return dateValue;
    }

    //converts a date string entry by user to Timestamp
    public static Timestamp convertDateToTimestamp(String dateEntry, boolean withTime) throws ParseException {
        Timestamp dateValue = null;
        if (dateEntry != null && !dateEntry.equals("")) {
            String dateformat = "";
            if (withTime) {
                if (dateEntry.length() == 19) {
                    dateformat = AVMSConstant.DISPLAY_DATE_FORMAT + " " + AVMSConstant.DISPLAY_TIME_FORMAT;
                } else {
                    dateformat = AVMSConstant.DISPLAY_DATE_FORMAT + " " + "HH:mm";
                }
            } else {
                dateformat = AVMSConstant.DISPLAY_DATE_FORMAT;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
            Date dt = sdf.parse(dateEntry);
            dateValue = new Timestamp(dt.getTime());
        }
        return dateValue;
    }

    //converts a Timestamp to a date string format dd/MM/yyyy
    public static String convertTimestampToDateString(Timestamp timestamp) {
        String dateValue = "";
        if (timestamp != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(AVMSConstant.DISPLAY_DATE_FORMAT);
            dateValue = sdf.format(timestamp);
        }
        return dateValue;
    }

    //converts a Timestamp to a date string format
    public static String formatTimestamp(Timestamp timestamp, String format) {
        String dateValue = "";
        if (timestamp != null && format != null && !format.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateValue = sdf.format(timestamp);
        }
        return dateValue;
    }
}
