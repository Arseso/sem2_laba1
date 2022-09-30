import obj.Autobus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Autobus[] ABs;
        ArrayList<Integer> groups = new ArrayList<>();
        ABs = new Autobus[]{new Autobus(), new Autobus()};

        groups = initUIgroups(groups);
        if(groups == null){System.out.println("Error groups."); return;}
        ABs = initUIabs(ABs);
        if(ABs == null){System.out.println("Error ABs."); return;}
        //ABs = task1(ABs, groups);
        //if(ABs == null) return;
        //printInto(ABs);
        task2(ABs[0],groups);
    }

    private static void task2(Autobus ab, ArrayList<Integer> groups) {
        int kolGr = 0;

        while(true){
            if((ab.getSeatsFree()- Collections.min(groups))>=0){
                ab.setSeatsTaken(ab.getSeatsTaken()+Collections.min(groups));
                kolGr++;
                groups.remove(groups.indexOf(Collections.min(groups)));
            } else break;
        }

        System.out.println("Количество групп возможно к размещению: "+ kolGr);
    }

    private static ArrayList<Integer> initUIgroups(ArrayList<Integer> groups) {
        Scanner sc = new Scanner(System.in);
        int ch;
        int kol = 0;
        System.out.println("Введите количество групп: ");
        if(sc.hasNextInt() && (ch=sc.nextInt())>=0) kol = ch;
        else return null;
        for (int i = 0; i < kol; i++) {
            System.out.println("Введите количество человек в группе: ");
            if(sc.hasNextInt() && (ch=sc.nextInt())>=0) groups.add(ch);
            else return null;
        }
        return groups;
    }

    private static Autobus[] initUIabs(Autobus[] ABs) {
        Scanner sc = new Scanner(System.in);
        int ch;
        for(int i = 0; i<=1; i++){
            System.out.println("Введите количество мест в автобусе "+(i+1)+":");
            if(sc.hasNextInt() && (ch=sc.nextInt())>=0) ABs[i].setSeats(ch);
            else return null;
            System.out.println("Введите цену 1 места в автобусе "+(i+1)+":");
            if(sc.hasNextInt() && (ch=sc.nextInt())>=0) ABs[i].setSeatCost(ch);
            else return null;
        }
        return ABs;
    }

    private static void printInto(Autobus[] ABs) {
        for(int i = 0; i<=1;i++) {
            System.out.println("Автобус " + (i+1) + ":");
            System.out.println("Количество занятый мест: " + ABs[i].getSeatsTaken());
            System.out.println("Рентабельность: " + ABs[i].getTakenCost());
        }
    }

    private static Autobus[] task1(Autobus[] ABs, ArrayList<Integer> groups) {
        //init groups
        int inTotal = 0;
        for(int i = 0; i < groups.size(); i++)
            inTotal += groups.get(i);

        if (inTotal>(ABs[0].getSeats()+ABs[1].getSeats())){
            System.out.println("Невозможно распределить людей по автобусам (людей больше, чем мест в автобусах).");
            return null;
        }
        //init rent
        int rent = 11000;
        for (int i = ABs[1].getSeats(); i > 0; i--) {
            ABs[1].setSeatsTaken(i);
            ABs[0].setSeatsTaken(inTotal - i);
            if (rent <= ABs[0].getTakenCost()) return ABs;
        }

        System.out.println("Рентабильное распределение невозможно.");
        return null;
    }
}
