package Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RandomValueClass {
    Random random;

    public String generateRandomEmail(){
        String characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomString=new StringBuilder(10);
        for (int i=0; i<10; i++){
            random=new Random();
            int index=random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString()+ "@gmail.com";
    }

    public Integer generateNumber(Integer max,Integer min){
        random=new Random();
        return random.nextInt((max-min)+min);
    }
    public String generateName(){
        String[] FirstNames={"Ahmad","Mahmood","Jawad","Naseem","Waseem"};
        random=new Random();
        return FirstNames[random.nextInt(FirstNames.length)];
    }
    public String generateDate(){
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = today.minusYears(30).minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return dateOfBirth.format(formatter);
    }

}
