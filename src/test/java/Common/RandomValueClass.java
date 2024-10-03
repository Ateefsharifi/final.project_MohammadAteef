package Common;

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
        int day=generateNumber(30,1);
        int month=generateNumber(12,1);
        int year=random.nextInt((2024-1990)+1)+1990;
        return month+"/"+day+"/"+year;
    }

}
