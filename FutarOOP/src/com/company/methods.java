package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class methods {
    private List<getterSetter> fuvarokList;

    public methods(String fileName) {
        fuvarokList = new LinkedList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                fuvarokList.add(new getterSetter((line)));
                line = br.readLine();
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String st = "";
        for(getterSetter f: fuvarokList){
            st += f +"\n";
        }
        return st;
    }

    public long összFuvar() {
        return fuvarokList.stream().count();
    }


    public double arPerFuvar(int sorszam) {
        return fuvarokList.stream()
                .filter(getterSetter -> getterSetter.getTaxiId() == sorszam)
                .mapToDouble(getterSetter -> getterSetter.getPrice() + getterSetter.getTip()).sum();

    }

    public double összMérföld() {
        return fuvarokList.stream()
                .mapToDouble(getterSetter::getDistance)
                .sum();
    }

    public int maxIdotartam() {
        return fuvarokList.stream()
                .map(getterSetter::getDuration)
                .max(Integer::compare)
                .get();
    }

    public getterSetter borravalo() {
        return fuvarokList.stream()
                .max(Comparator.comparingDouble(getterSetter -> getterSetter.getTip() / getterSetter.getPrice()))
                .get();
    }

    public double mennyiMerföld() {
        return fuvarokList.stream()
                .filter(getterSetter -> getterSetter.getTaxiId() == 4261)
                .mapToDouble(getterSetter -> getterSetter.getDistance())
                .sum() * 1.6;
    }

    public int hibak() {
        return fuvarokList.stream()
                .filter(getterSetter -> getterSetter.getPrice() > 0 && getterSetter.getDuration() > 0 && getterSetter.getDistance() == 0)
                .collect(Collectors.toList()).size();
    }

    public int hibaIdo() {
        return fuvarokList.stream()
                .filter(getterSetter -> getterSetter.getPrice() > 0 && getterSetter.getDuration() > 0 && getterSetter.getDistance() == 0)
                .mapToInt(getterSetter::getDuration).sum();
    }

    public double hibaBevetel() {
        return fuvarokList.stream()
                .filter(getterSetter -> getterSetter.getPrice() > 0 && getterSetter.getDuration() > 0 && getterSetter.getDistance() == 0)
                .mapToDouble(f -> f.getPrice() + f.getTip()).sum();
    }

    public getterSetter benneVanE(int id) {
        try {
            return fuvarokList.stream().filter(f -> f.getTaxiId() == id).findAny().get();
        } catch (Exception e) {
            return null;
        }
    }

    public List<getterSetter> minUt(int number) {
        return fuvarokList.stream().filter(getterSetter -> getterSetter.getDistance() > 0).sorted(Comparator.comparingDouble(getterSetter::getDistance))
                .distinct()
                .limit(number)
                .collect(Collectors.toList());
    }

    public long karacsony() {
        LocalDateTime dec24S = LocalDateTime.of(2016, 12, 24, 0, 0);
        LocalDateTime dec24E = LocalDateTime.of(2016, 12, 24, 23, 59, 59);
        return fuvarokList.stream()
                .filter(f -> f.getStartTime().isBefore(dec24E) && f.getStartTime()
                        .isAfter(dec24S))
                .count();
    }

    public double buek() {
        LocalDateTime dec31S = LocalDateTime.of(2016, 12, 31, 0, 0);
        LocalDateTime dec31E = LocalDateTime.of(2016, 12, 31, 23, 59, 59);
        return fuvarokList.stream()
                .filter(f -> f.getStartTime().isBefore(dec31E) && f.getStartTime().isAfter(dec31S)).mapToDouble(getterSetter::getTip)
                .sum() / fuvarokList
                .stream()
                .filter(f -> f.getStartTime().isBefore(dec31E) && f.getStartTime()
                        .isAfter(dec31S))
                .count();
    }

}
