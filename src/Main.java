import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        String folderPath = "D:\\Doc\\Desktop\\web-projects";
        File file = new File(folderPath);
        Node root = new Node(file);
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(calculator);
        System.out.println(root);
        System.exit(0);

        System.out.println(SizeCalculator.getSizeFromHumanReadable("235K"));
        System.out.println(SizeCalculator.getReadableSize(240640));
        System.out.println(SizeCalculator.getReadableSize(10158988));
    }
}