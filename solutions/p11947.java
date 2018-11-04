import java.util.*;

class Main {
    final static int gestationTime = 40 * 7;
    static Scanner scan = new Scanner(System.in);
    static int day, month, year;

    static int numberDaysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static int numberDaysInMonthLeap[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static boolean isLeap(int year) {
        return year%4==0 && (year%100!=0 || year%400==0);
    }

    static int getDaysFromYear(int year) {
        int base = year*365;
        int leapYears = year/4 - year/100 + year/400;
        return base+leapYears;
    }

    static int getYearFromDays(int days){
        int year = 1;
        int sizeOfYear = 365;
        while(days>sizeOfYear){
            days-=sizeOfYear;
            year++;
            sizeOfYear = (isLeap(year)) ? 366:365;
        }
        return year;
    }

    static int getDaysFromMonth(int month, int year) {
        int days = 0;
        for (int i = 0; i < month; i++)
            days += numberDaysInMonth[i];
        if (month > 1 && isLeap(year))
            days++;
        return days;
    }

    static int getMonthFromDays(int days, int year){
        
        int month = 0;
        int []dayInMonth = (isLeap(year)) ? numberDaysInMonthLeap:numberDaysInMonth;
        for(;days>dayInMonth[month];month++)
            days-=dayInMonth[month];
        return month+1;
    }

    public static void main(String[] args) {
        int tc = scan.nextInt();
        for (int t = 1; t <= tc; t++) {
            int inp = scan.nextInt();
            year = inp % 10000;
            inp /= 10000;
            day = inp % 100;
            inp /= 100;
            month = inp;
            month--;
            day += getDaysFromMonth(month, year);
            day += getDaysFromYear(year-1);
            day += gestationTime;
            //day=day-1;

            year = getYearFromDays(day);
            int ndays = getDaysFromYear(year-1);
            day -= ndays;
            //System.out.println(day);
            month = getMonthFromDays(day, year);
            ndays = getDaysFromMonth(month-1, year);
            day -=ndays;


            String sign = "";
            if((month == 1 && day<=20) || (month==12 && day>=23))   sign = "capricorn";
            else if((month == 2 && day<=19) || (month==1 && day>=21) ) sign = "aquarius";
            else if((month == 3 && day<=20) || (month==2 && day>=20)) sign = "pisces";
            else if((month == 4 && day<=20) || (month==3 && day>=21)) sign = "aries";
            else if((month == 5 && day<=21) || (month==4 && day>=21)) sign = "taurus";
            else if((month == 6 && day<=21) || (month==5 && day>=22)) sign = "gemini";
            else if((month == 7 && day<=22) || (month==6 && day>=22)) sign = "cancer";
            else if((month == 8 && day<=21) || (month==7 && day>=23)) sign = "leo";
            else if((month == 9 && day<=23) || (month==8 && day>=22)) sign = "virgo";
            else if((month == 10 && day<=23) || (month==9 && day>=24) ) sign = "libra";
            else if((month == 11 && day<=22) || (month==10 && day>=24)) sign = "scorpio";
            else if((month == 12 && day<=22)|| (month==11 && day>=23)) sign = "sagittarius";

            String mn;
            String d;
            if(month<=9) mn="0"+new Integer(month).toString(); else mn=new Integer(month).toString();
            if(day<=9) d="0"+new Integer(day).toString(); else d=new Integer(day).toString();
            System.out.println(t + " " +mn+"/"+d+"/"+year + " " + sign);
        }
    }
}