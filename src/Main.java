import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "D:\\Doc\\Desktop";
        File file = new File(folderPath);
//        System.out.println(getFolderSize(file) + "B");

//        long start = System.currentTimeMillis();

        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);

//        long duration = System.currentTimeMillis() - start;
//        System.out.println(duration + " ms");
//
        System.out.println(getReadableSize(size));
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }

    public static String getReadableSize(long size) {
        int oneBite = 1024;
        return size / oneBite + "Kb";
    }

    public static long getSizeFromHumanReadable(String size) {
        int oneBite = 1024;

        return 0;
    }
}
