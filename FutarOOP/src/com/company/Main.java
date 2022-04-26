package com.company;

public class Main {

    public static void main(String[] args) {
        //System.out.println(new File("fuvar.csv").getAbsolutePath()); Hova kell tenni a forrást
        methods fr = new methods("fuvar.csv");
        System.out.println(fr.összFuvar()+ " fuvar");
        System.out.println(fr.arPerFuvar(6185)+" dollár volt a bevétele");
        System.out.println(fr.összMérföld() + " mérföldet tettek meg a taxisok.");
        System.out.println("A leghosszabb fuvar "+ fr.maxIdotartam() + " másodperc volt.");
        System.out.println("A legbőkezűbb borravalójú fuvar adatai:\n"+fr.borravalo());
        System.out.println("4261 taxi " + String.format("%.2f",fr.mennyiMerföld()) + " km-t tett meg." );
        System.out.println(fr.hibak()+ " hibas adat");
        System.out.println("Hibás idő: "+fr.hibaIdo()+"másodperc");
        System.out.println("Hibás bevétel "+fr.hibaBevetel()+"dollár");
        System.out.println(fr.benneVanE(1452) != null ? "Benne van": "Nincs benne");
        System.out.println("A 3 Legrövídebb út:\n"+fr.minUt(3));
        System.out.println("Karácsonykor fuvarok száma: "+fr.karacsony());
        System.out.println("Szilveszteri borravaló:  "+ String.format("%.2f",fr.buek()));
    }
}
