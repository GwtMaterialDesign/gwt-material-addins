/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.addins.client.moment;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import gwt.material.design.addins.client.moment.option.CalendarFormat;
import gwt.material.design.addins.client.moment.option.CreationData;
import gwt.material.design.addins.client.moment.option.Duration;
import gwt.material.design.jquery.client.api.Functions;
import jsinterop.annotations.*;

@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public class Moment {

    @JsOverlay
    public static JavaScriptObject ISO_8601;

    @JsOverlay
    public static JavaScriptObject RFC_2822;

    @JsProperty
    public Functions.Func1<String> parseTwoDigitYear;

    // Parse : Now

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Moment moment();

    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native Moment moment(String[] arr);

    // Parse : String

    @JsMethod(namespace = "moment")
    public static native Moment moment(String value);

    // Parse : String + Format

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String format);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String format, String locale);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String format, Boolean strict);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String format, String locale, Boolean strict);

    // Parse : String + Formats

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String[] format);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String[] format, String locale);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String[] format, Boolean strict);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String date, String[] format, String locale, Boolean strict);

    @JsMethod(namespace = "moment")
    public static native Moment moment(String s, JavaScriptObject special_format);

    // Parse : Special Formats

    @JsMethod(namespace = "moment")
    public static native Moment moment(JavaScriptObject object);

    // Parse : Unix Timestamp (milliseconds)

    @JsMethod(namespace = "moment")
    public static native Moment moment(double milliseconds);

    // Parse : Unix Timestamp (seconds)

    @JsMethod
    public static native Moment unix(double seconds);

    // Parse : Date

    @JsMethod
    public static native Moment moment(JsDate date);

    // Parse : Arrays
    @JsMethod
    public static native Moment moment(int[] arr);

    // Parse : Moment Clone
    @JsMethod
    public static native Moment moment(Moment clone);

    // Parse : UTC
    @JsMethod
    public native Moment utc();

    @JsMethod
    public native Moment utc(int param);

    @JsMethod
    public native Moment utc(int[] arr);

    @JsMethod
    public native Moment utc(String param);

    @JsMethod
    public native Moment utc(String date, String format);

    @JsMethod
    public native Moment utc(String date, String[] format);

    @JsMethod
    public native Moment utc(String date, String format, String locale);

    @JsMethod
    public native Moment utc(String date, String format, boolean strict);

    @JsMethod
    public native Moment utc(String date, String format, String locale, Boolean strict);

    @JsMethod
    public native Moment utc(Moment clone);

    @JsMethod
    public native Moment utc(JsDate date);

    // Parse : Zone
    @JsMethod
    public native Moment parseZone();

    @JsMethod
    public native Moment parseZone(String param);

    @JsMethod
    public native Moment parseZone(String date, String format);

    @JsMethod
    public native Moment parseZone(String date, String[] format);

    @JsMethod
    public native Moment parseZone(String date, String format, boolean strict);

    @JsMethod
    public native Moment parseZone(String date, String format, String locale, Boolean strict);

    // Parse : Validation

    @JsMethod
    public native boolean isValid();

    @JsMethod
    public native int invalidAt();

    // Parse : Creation Data

    @JsMethod
    public native CreationData creationData();

    // Parse : Defaults

    @JsMethod
    public static native Moment moment(int val, String unit);

    @JsMethod
    public static native Moment moment(Duration duration);

    // Get + Set : Milliseconds

    @JsMethod
    public native Moment millisecond(int val);

    @JsMethod
    public native int millisecond();

    @JsMethod
    public native Moment milliseconds(int val);

    @JsMethod
    public native int milliseconds();

    // Get + Set : Seconds

    @JsMethod
    public native Moment second(int val);

    @JsMethod
    public native int second();

    @JsMethod
    public native Moment seconds(int val);

    @JsMethod
    public native int seconds();

    // Get + Set : Minute

    @JsMethod
    public native Moment minute(int val);

    @JsMethod
    public native int minute(); // Number

    @JsMethod
    public native Moment minutes(int val);

    @JsMethod
    public native int minutes(); // Number

    // Get + Set : Hour

    @JsMethod
    public native Moment hour(int val);

    @JsMethod
    public native int hour(); // Number

    @JsMethod
    public native Moment hours(int val);

    @JsMethod
    public native int hours(); // Number

    // Get + Set : Date of Month

    @JsMethod
    public native Moment date(int val);

    @JsMethod
    public native int date(); // Number

    @JsMethod
    public native Moment dates(int val);

    @JsMethod
    public native int dates(); // Number

    // Get + Set : Day of Week

    @JsMethod
    public native Moment day(Object val);

    @JsMethod
    public native int day(); // Number

    @JsMethod
    public native Moment days(Object val);

    @JsMethod
    public native int days(); // Number

    // Get + Set : Day of Week (Locale Aware)

    @JsMethod
    public native Moment weekday(int val);

    @JsMethod
    public native int weekday(); // Number

    // Get + Set : ISO Day of Week
    @JsMethod
    public native Moment isoWeekday(int val);

    @JsMethod
    public native int isoWeekday();

    // Get + Set : Day of Year

    @JsMethod
    public native Moment dayOfYear(int val);

    @JsMethod
    public native int dayOfYear(); // Number

    // Get + Set : Week of Year

    @JsMethod
    public native Moment week(int val);

    @JsMethod
    public native int week(); // Number

    @JsMethod
    public native Moment weeks(int val);

    @JsMethod
    public native int weeks(); // Number

    // Get + Set : Week of Year (ISO)

    @JsMethod
    public native Moment isoWeek(int val);

    @JsMethod
    public native int isoWeek(); // Number

    @JsMethod
    public native Moment isoWeeks(int val);

    @JsMethod
    public native int isoWeeks(); // Number

    // Get + Set : Month

    @JsMethod
    public native Moment month(Object val);

    @JsMethod
    public native int month(); // Number

    @JsMethod
    public native Moment months(Object val);

    @JsMethod
    public native int months(); // Number

    // Get + Set : Quarter

    @JsMethod
    public native int quarter(); // Number

    @JsMethod
    public native Moment quarter(int val);

    @JsMethod
    public native int quarters(); // Number

    @JsMethod
    public native Moment quarters(int val);

    // Get + Set : Year

    @JsMethod
    public native Moment year(int val);

    @JsMethod
    public native int year(); // Number

    @JsMethod
    public native Moment years(int val);

    @JsMethod
    public native int years(); // Number

    // Get + Set : Week Year

    @JsMethod
    public native Moment weekYear(int val);

    @JsMethod
    public native int weekYear(); // Number

    // Get + Set : Week Year (ISO)

    @JsMethod
    public native Moment isoWeekYear(int val);

    @JsMethod
    public native int isoWeekYear(); // Number

    // Get + Set : Weeks in Year

    @JsMethod
    public native Moment weeksInYear();

    // Get + Set : Weeks in Year ISO

    @JsMethod
    public native Moment isoWeeksInYear();

    // Get + Set : Get

    @JsMethod
    public native Moment get(String duration);

    // Get + Set : Set

    @JsMethod
    public native Moment set(String duration, int value);

    // Get + Set : Max / Min

    @JsMethod
    public static native int max(Moment[] moments);

    @JsMethod
    public static native int min(Moment[] moments);

    // Manipulate : Add

    @JsMethod
    public native Moment add(int value, String duration);

    @JsMethod
    public native Moment add(Duration duration);

    @JsMethod
    public native Moment add(Object param);

    // Manipulate : Subtract

    @JsMethod
    public native Moment subtract(int value, String duration);

    @JsMethod
    public native Moment subtract(Duration duration);

    @JsMethod
    public native Moment subtract(Object param);

    // Manipulate : Start of Time

    @JsMethod
    public native Moment startOf(String duration);

    // Manipulate : End of Time

    @JsMethod
    public native Moment endOf(String duration);

    // Manipulate : Locale

    @JsMethod
    public native Moment local();


    // Manipulate : UTC Offset

    @JsMethod
    public native Moment utcOffset();

    @JsMethod
    public native Moment utcOffset(int value, boolean strict);

    @JsMethod
    public native Moment utcOffset(String value, boolean strict);

    // Manipulate : TimeZone Offset

    @JsMethod
    public native Moment zone();

    @JsMethod
    public native Moment zone(int val);

    @JsMethod
    public native Moment zone(String val);

    // Display : Format

    @JsMethod
    public native String format();

    @JsMethod
    public native String format(String param);

    // Display : Time From now

    @JsMethod
    public native String fromNow();

    @JsMethod
    public native String fromNow(Boolean param);

    // Display : Time From X

    @JsMethod
    public native String from(Moment moment);

    @JsMethod
    public native String from(Moment moment, boolean noSuffix);

    @JsMethod
    public native String from(String value);

    @JsMethod
    public native String from(String value, boolean noSuffix);

    @JsMethod
    public native String from(int value);

    @JsMethod
    public native String from(int value, boolean noSuffix);

    @JsMethod
    public native String from(JsDate value);

    @JsMethod
    public native String from(JsDate value, boolean noSuffix);

    @JsMethod
    public native String from(int[] values);

    @JsMethod
    public native String from(int[] values, boolean noSuffix);

    // Display : Time To Now

    @JsMethod
    public native String toNow();

    @JsMethod
    public native String toNow(boolean param);

    // Display : Time To X

    @JsMethod
    public native String to(Moment moment);

    @JsMethod
    public native String to(Moment moment, boolean noSuffix);

    @JsMethod
    public native String to(String value);

    @JsMethod
    public native String to(String value, boolean noSuffix);

    @JsMethod
    public native String to(int value);

    @JsMethod
    public native String to(int value, boolean noSuffix);

    @JsMethod
    public native String to(JsDate value);

    @JsMethod
    public native String to(JsDate value, boolean noSuffix);

    @JsMethod
    public native String to(int[] values);

    @JsMethod
    public native String to(int[] values, boolean noSuffix);

    // Display : Calendar Time

    @JsMethod
    public native String calendar();

    @JsMethod
    public native String calendar(Moment referenceTime);

    @JsMethod
    public native String calendar(Moment referenceTime, CalendarFormat formats);

    // Display : Difference

    @JsMethod
    public native double diff(Moment moment);

    @JsMethod
    public native double diff(Moment moment, String s);

    @JsMethod
    public native double diff(Moment moment, String s, boolean noSuffix);

    @JsMethod
    public native double diff(String value);

    @JsMethod
    public native double diff(String value, String s);

    @JsMethod
    public native double diff(String value, boolean noSuffix);

    @JsMethod
    public native double diff(int value);

    @JsMethod
    public native double diff(int value, String s);

    @JsMethod
    public native double diff(int value, boolean noSuffix);

    @JsMethod
    public native double diff(JsDate value);

    @JsMethod
    public native double diff(JsDate value, String s);

    @JsMethod
    public native double diff(JsDate value, String s, boolean noSuffix);

    @JsMethod
    public native double diff(int[] values);

    @JsMethod
    public native double diff(int[] values, String s);

    @JsMethod
    public native double diff(int[] values, String s, boolean noSuffix);

    // Display : Unix Timestamp (milliseconds)

    @JsMethod
    public native double valueOf();

    // Display : Unix Timestamp (seconds)
    @JsMethod
    public native double unix();

    // Display : Days in Month

    @JsMethod
    public native int daysInMonth();

    // Display : As Javascript Date

    @JsMethod
    public native JsDate toDate();

    // Display : As Array

    @JsMethod
    public native int[] toArray();

    // Display : As Json

    @JsMethod
    public native String toJSON();

    // Display : As ISO 8601 String

    @JsMethod
    public native String toISOString();

    @JsMethod
    public native String toISOString(boolean keepOffset); // from 2.20.0

    // Display : As Object

    @JsMethod
    public native JavaScriptObject toObject();


    // Display : Inspect
    @JsMethod
    public native Moment inspect();

    // Query : Is Before

    @JsMethod
    public native boolean isBefore(Moment moment);

    @JsMethod
    public native boolean isBefore(Moment moment, String s);

    @JsMethod
    public native boolean isBefore(String value);

    @JsMethod
    public native boolean isBefore(String value, String s);

    @JsMethod
    public native boolean isBefore(double value);

    @JsMethod
    public native boolean isBefore(double value, String s);

    @JsMethod
    public native boolean isBefore(JsDate date);

    @JsMethod
    public native boolean isBefore(JsDate date, String s);

    @JsMethod
    public native boolean isBefore(int[] values);

    @JsMethod
    public native boolean isBefore(int[] values, String s);

    // Query : Is Same

    @JsMethod
    public native boolean isSame(Moment moment);

    @JsMethod
    public native boolean isSame(Moment moment, String s);

    @JsMethod
    public native boolean isSame(String value);

    @JsMethod
    public native boolean isSame(String value, String s);

    @JsMethod
    public native boolean isSame(double value);

    @JsMethod
    public native boolean isSame(double value, String s);

    @JsMethod
    public native boolean isSame(JsDate date);

    @JsMethod
    public native boolean isSame(JsDate date, String s);

    @JsMethod
    public native boolean isSame(int[] values);

    @JsMethod
    public native boolean isSame(int[] values, String s);

    // Query : Is After

    @JsMethod
    public native boolean isAfter(Moment moment);

    @JsMethod
    public native boolean isAfter(Moment moment, String s);

    @JsMethod
    public native boolean isAfter(String value);

    @JsMethod
    public native boolean isAfter(String value, String s);

    @JsMethod
    public native boolean isAfter(double value);

    @JsMethod
    public native boolean isAfter(double value, String s);

    @JsMethod
    public native boolean isAfter(JsDate date);

    @JsMethod
    public native boolean isAfter(JsDate date, String s);

    @JsMethod
    public native boolean isAfter(int[] values);

    @JsMethod
    public native boolean isAfter(int[] values, String s);

    // Query : Is Same or Before

    @JsMethod
    public native boolean isSameOrBefore(Moment moment);

    @JsMethod
    public native boolean isSameOrBefore(Moment moment, String s);

    @JsMethod
    public native boolean isSameOrBefore(String value);

    @JsMethod
    public native boolean isSameOrBefore(String value, String s);

    @JsMethod
    public native boolean isSameOrBefore(double value);

    @JsMethod
    public native boolean isSameOrBefore(double value, String s);

    @JsMethod
    public native boolean isSameOrBefore(JsDate date);

    @JsMethod
    public native boolean isSameOrBefore(JsDate date, String s);

    @JsMethod
    public native boolean isSameOrBefore(int[] values);

    @JsMethod
    public native boolean isSameOrBefore(int[] values, String s);

    // Query : Is Same or After

    @JsMethod
    public native boolean isSameOrAfter(Moment moment);

    @JsMethod
    public native boolean isSameOrAfter(Moment moment, String s);

    @JsMethod
    public native boolean isSameOrAfter(String value);

    @JsMethod
    public native boolean isSameOrAfter(String value, String s);

    @JsMethod
    public native boolean isSameOrAfter(double value);

    @JsMethod
    public native boolean isSameOrAfter(double value, String s);

    @JsMethod
    public native boolean isSameOrAfter(JsDate date);

    @JsMethod
    public native boolean isSameOrAfter(JsDate date, String s);

    @JsMethod
    public native boolean isSameOrAfter(int[] values);

    @JsMethod
    public native boolean isSameOrAfter(int[] values, String s);

    // Query : Is Between

    @JsMethod
    public native boolean isBetween(Moment moment, Moment moment2);

    @JsMethod
    public native boolean isBetween(Moment moment, Moment moment2, String s);

    @JsMethod
    public native boolean isBetween(String value, String value2);

    @JsMethod
    public native boolean isBetween(String value, String value2, String s);

    @JsMethod
    public native boolean isBetween(double value, double value2);

    @JsMethod
    public native boolean isBetween(double value, double value2, String s);

    @JsMethod
    public native boolean isBetween(JsDate date1, JsDate date2);

    @JsMethod
    public native boolean isBetween(JsDate date1, JsDate date2, String s);

    @JsMethod
    public native boolean isBetween(int[] values, int[] values2);

    @JsMethod
    public native boolean isBetween(int[] values, int[] values2, String s);

    // Query : Is Daylight Saving Time

    @JsMethod
    public native boolean isDST();

    // Query : Is Leap Year

    @JsMethod
    public native boolean isLeapYear();

    // Is a Moment

    @JsMethod
    public native boolean isMoment(Object obj);

    // I18n

    @JsMethod
    public native Moment locale(String param);

    @JsMethod
    public native Moment locale(boolean reset);

    @JsMethod
    public native Moment locale(String[] param);

    @JsMethod
    public native Moment locale(String param, Object param2);

    // I18n : list

    @JsMethod
    public native String[] monthsShort();

    @JsMethod
    public native String[] weekdays();

    @JsMethod
    public native String[] weekdaysShort();

    @JsMethod
    public native String[] weekdaysMin();

    // Duration

    @JsMethod
    public native Duration duration(Number value, String timeunit);

    @JsMethod
    public native Duration duration(Number value);

    @JsMethod
    public native Duration duration(Object value);

    @JsMethod
    public native Duration duration(String value);

    // Utilities

    @JsMethod
    public native static Moment normalizeUnits(String unit);

    @JsMethod
    public native static Moment invalid(Object object);
}
