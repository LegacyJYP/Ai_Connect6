package main.java.com.asuscomm.yangyinetwork.test;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.asuscomm.yangyinetwork.utils.BoardUtils.string2board;

/**
 * Created by jaeyoung on 2017. 5. 11..
 */
public class Samples {
    public static List<String[]> samples = new ArrayList<String[]>();
    public static List<String[]> getSamples() {
        if(samples.size() == 0) {
            initSamples();
        }

        return samples;
    }

    public static int[][] getSample(int idx) {
        return string2board(getSamples().get(idx));
    }

    public static void initSamples() {

        // 0
        samples.add(new String[]{
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000001000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",

                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
                "0000000000000000000",
        });

        // 1
        samples.add(new String[]{
                "200000",
                "200000",
                "200000",
                "200000",
                "200000",
                "000000",
        });
        // 2
        samples.add(new String[]{
                "100000",
                "100000",
                "100000",
                "100000",
                "100000",
                "100000",
        });

        // 3
        samples.add(new String[]{
                "010000",
                "010000",
                "010000",
                "010000",
                "010000",
                "000000",
        });


        // 4
        samples.add(new String[]{
                "001000",
                "000000",
                "000000",
                "001000",
                "001000",
                "000000",
        });

        // 5
        samples.add(new String[]{
                "001000",
                "001000",
                "001000",
                "001000",
                "001000",
                "000000",
        });

        // 6
        samples.add(new String[]{
                "001000",
                "000000",
                "000000",
                "001000",
                "001000",
                "011000",
        });
    }
}
