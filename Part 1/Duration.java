public class Duration{

    public static void main(String[] args){

        int seconds = 74663;
        convertToTime(seconds);


    }

    public static void convertToTime(int seconds){
        int hours = seconds / 3600;
        // System.out.println(hours);

        int hRemainder = seconds - (hours * 3600);
        // System.out.println(hRemainder);

        int minutes = hRemainder / 60;
        // System.out.println(minutes);

        int mRemainder = hRemainder - (minutes * 60);

        System.out.println(hours+":"+minutes+":"+mRemainder);
        
    }

}