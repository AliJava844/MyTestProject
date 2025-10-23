package homeworks.homework06.task2;

import java.util.ArrayList;
import java.util.List;

public class AppTv {
    public static void main(String[] args) {
        Program program1 = new Program("Винни пух", 4, 100);
        Program program2 = new Program("Кухня", 5, 200);
        Program program3 = new Program("Эртугрул", 5, 250);
        Program program4 = new Program("Новости", 5, 300);
        Program program5 = new Program("Финес и Ферб", 3, 75);

        // ложит программы в список
        List<Program> programs = new ArrayList<>();
        programs.add(program1);
        programs.add(program2);
        programs.add(program3);
        programs.add(program4);
        programs.add(program5);

        Channel channel0 = new Channel("Ntv",0,programs);
        Channel channel1 = new Channel("Russia", 1, programs);
        Channel channel2 = new Channel("Sts", 2, programs);
        Channel channel3 = new Channel("Roman", 3, programs);
        Channel channel4 = new Channel("Nickelodion", 4, programs);

        // ложит каналы в список
        List<Channel> channels = new ArrayList<>();
        channels.add(channel0);
        channels.add(channel1);
        channels.add(channel2);
        channels.add(channel3);
        channels.add(channel4);

        TV tvLg = new TV("Lg", 50, true, channels);
        TV tvSamsung = new TV("Samsung", 70, true, channels);
        TV tvPhilips = new TV("Philips", 40, true, channels);
        TV tvHuawei = new TV("Huawei", 50, true, channels);
        TV tvXiaomi = new TV("Xiaomi", 55, false, channels);
        TV tvLenovo = new TV("Lenovo", 80, false, channels);
        TV tvApple = new TV("Apple", 40, false, channels);
        TV tvAsus = new TV("Asus", 50, false, channels);
        TV tvGoogle = new TV("Google", 100, false, channels);

        tvLg.turnOn();
        tvHuawei.turnOff();
        tvXiaomi.turnOff();
        tvAsus.turnOn();
        tvGoogle.turnOn();

        tvLg.nextChannel(channel0);
        tvAsus.previousChannel(channel3);

        int maxVolume = 60;

        List<TV> tvs = new ArrayList<>();
        tvs.add(tvLg);
        tvs.add(tvSamsung);
        tvs.add(tvPhilips);
        tvs.add(tvHuawei);
        tvs.add(tvXiaomi);
        tvs.add(tvLenovo);
        tvs.add(tvApple);
        tvs.add(tvAsus);
        tvs.add(tvGoogle);

        for (TV tv : tvs) {
            if (tv.isOn() && tv.getVolume() <= maxVolume) {
                System.out.println(tv);
            }
        }
    }
}
