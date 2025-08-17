package homeworks.homework05;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TV[] tvs = new TV[10];

        TV tvLG = new TV("LG",2,60,true);
        TV tvSamsung = new TV("Samsung",3,50,true);
        TV tvXiaomi = new TV("Xiaomi",1,50,true);
        TV tvLenovo = new TV("Lenovo",11, 80,true);
        TV tvHuawei = new TV("Huawei",7, 40,false);
        TV tvApple = new TV("Apple",12, 56,true);
        TV tvAsus = new TV("Asus",8, 50,false);
        TV tvGoogle = new TV("Google",17, 90,true);
        TV tvPhilips = new TV("Philips",14, 60,true);
        TV tvSony = new TV("Sony",13, 80,true);

        tvs[0] = tvLG;
        tvs[1] = tvSamsung;
        tvs[2] = tvXiaomi;
        tvs[3] = tvLenovo;
        tvs[4] = tvHuawei;
        tvs[5] = tvApple;
        tvs[6] = tvAsus;
        tvs[7] = tvGoogle;
        tvs[8] = tvPhilips;
        tvs[9] = tvSony;

        for (int i = 0; i < tvs.length - 1; i++) {
            for (int j = 0; j < tvs.length - 1; j++) {
                if (tvs[j].getNumberChanel() > tvs[j + 1].getNumberChanel()) {
                    TV temp = tvs[j];
                    tvs[j] = tvs[j + 1];
                    tvs[j + 1] = temp;
                }
            }
        }

        int maxVolume = scanner.nextInt();

        for (TV tv : tvs) {
            if (tv.isOn() && tv.getVolume() <= maxVolume) {
                System.out.println(tv);
            }
        }
    }
}
