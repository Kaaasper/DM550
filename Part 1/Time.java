public class Time{

    public static void main(String[] args){
        int hours = 20;
        int minutes = 44;
        int seconds = 23;
        
        System.out.println(convertToSeconds(hours, minutes, seconds));


    }

    public static int convertToSeconds(int hours, int minutes, int seconds){
        return (seconds + (60*minutes) + ((60*hours)*60));

    }

}