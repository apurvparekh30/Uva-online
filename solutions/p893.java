// Apurv Parekh




import java.util.*;


class Main {
    static Scanner scan = new Scanner(System.in);
    static int daysAhead,day,month,year;

    static int numberDaysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int numberDaysInMonthLeap[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 

    static boolean isLeap(int year){
        return year%4==0 && (year%100!=0 || year%400==0);
    }

    static int yearToDays(int year){
        int base = year*365;
        int numOfLeapYears = year/4 - year/100 + year/400;
        return base+numOfLeapYears;
    }

    static int monthToDays(int month,int year){
        int days = 0;
        for(int i=0;i<month;i++)
            days+=numberDaysInMonth[i];
        if(month > 1 && isLeap(year))
            days++;
        return days;
    }

    static int getYearFromDays(int days){
        int year = 1;
        int sizeOfYear = 365;
        while(days > sizeOfYear){
            days-=sizeOfYear;
            year++;
            sizeOfYear = (isLeap(year)) ? 366:365;
        }
        return year;
    }

    static int getMonthFromDays(int days,int year){
        int month = 0;
        int []dInMonth = isLeap(year) ? numberDaysInMonthLeap:numberDaysInMonth;
        for(;days>dInMonth[month];month++)
            days-=dInMonth[month];
        return month+1;
    }

    public static void main(String[] args) {  
        while(true){
            daysAhead = scan.nextInt();
            day = scan.nextInt();
            month = scan.nextInt();
            year = scan.nextInt();
            if(daysAhead==0 && day==0 && month==0 && year==0) break;
            month--;
            year--;
            day += monthToDays(month, year);
            day += yearToDays(year); // or may be year+1
            day += daysAhead;

            year = getYearFromDays(day);
            int newDays = yearToDays(year-1);
            day-=newDays;
            
            month = getMonthFromDays(day, year);
            newDays = monthToDays(month-1, year);
            day-=newDays;
            System.out.println(day+ " " +month + " "+ year);
        }  
    }
}