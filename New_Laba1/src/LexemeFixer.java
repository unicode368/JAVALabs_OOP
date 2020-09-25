import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LexemeFixer implements Runnable {

    File dir;
    ExecutorService pool = Executors.newCachedThreadPool();


    public LexemeFixer(String dir) {
        this.dir = new File(dir);
    }


    @Override
    public void run() {
        findJavaFiles();
        pool.shutdown();
    }

    public void findJavaFiles() {
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                pool.submit(new LexemeFixer(f.getAbsolutePath()));
            } else {
                System.out.println(f.getName());
                if (f.getName().endsWith(".java")) {
                    change(f);
                }
            }
        }
    }

    public void change(File f) {
        BufferedReader reader;
        StringBuilder s = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(
                    f.getAbsoluteFile()));
            String line = reader.readLine();
            while (line != null) {
                s.append(identifyLexema(line) + "\n");
                line = reader.readLine();
            }
            reader.close();
            File file = new File(f.getAbsolutePath());
            FileOutputStream fooStream = new FileOutputStream(file, false); // true to append
            byte[] bytes = s.toString().getBytes();
            fooStream.write(bytes);
            fooStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String identifyLexema(String line) {
        String[] s = line.split(" ");
        String[] strings = {};
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > 3 && !s[i].contains("\"")) {
                s[i] = s[i].toUpperCase();
            }
            if (s[i].contains("\"")) {
                strings = s[i].split("\"");
                for (int j = 0; j < strings.length; j++) {
                    if (strings[j].length() > 3) {
                        strings[j] = strings[j].toUpperCase();
                    }
                }
                s[i] = String.join("\"", strings);
            }
        }
        return String.join(" ", s);
    }
}
