package MRCS.Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MAin {

    public static void main(String[] args) {

        Map<String ,String> fp = new HashMap<>();

        File dir = new File("src/test/java/MRCS/tests");
        if(dir.exists()){
            String[] ext={"java"};
            FileUtils.listFiles(dir,ext,true).forEach((File f) ->{
                //System.out.println(f.getAbsolutePath());
                String fName=f.getName();
                String fps[] = f.getAbsolutePath().split("tests");
                System.out.println(Arrays.asList(fps).get(fps.length-1));

            });
        }
    }
}
