

public class Checker {
    public boolean isDayOfWeek(String string){
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public boolean allVowels(String string){
        return string.matches("[a,e,i,o,u]*");
    }
    
    public boolean timeOfDay(String string){
        return string.matches("((0|1){1}[0-9]{1}|2([0-3]){1}){1}:([0-5]{1}[0-9]{1}):([0-5]{1}[0-9]{1})");
    }
}
