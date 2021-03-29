package fs;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Files {

    private static final char EXT_SEPARATOR = '.';
    private static final String EXT_DIR = "<DIR>";

    public static final String[] TABLE_COLUMNS = {"Имя", "Расширение"};

    public static String getFileExt(File file) {
        int pointIndex = file.getName().lastIndexOf(EXT_SEPARATOR);
        if (pointIndex > 0) {
            return file.getName().substring(pointIndex + 1);
        }

        return "";
    }

    public static String getFileName(File file) {
        int pointIndex = file.getName().lastIndexOf(EXT_SEPARATOR);
        if (pointIndex > 0) {
            return file.getName().substring(0, pointIndex);
        }

        return file.getName();
    }

    public static void getFiles(String folderPath, GetFiles getFiles) {
        final File folder = new File(folderPath);
        for (final File fileEntry : folder.listFiles()) {
            String[] fileInfo = {getFileName(fileEntry), (fileEntry.isDirectory() ? EXT_DIR : getFileExt(fileEntry))};
            getFiles.fileInfo(fileInfo);
        }
    }

    public static String[][] getFiles(String folderPath) {
        List<String[]> resultList = new ArrayList<>(10);
        getFiles(folderPath, resultList::add);

        resultList.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                if (EXT_DIR.equals(a[1]) && !EXT_DIR.equals(b[1])) {
                    return -1;
                } else if (!EXT_DIR.equals(a[1]) && EXT_DIR.equals(b[1])) {
                    return 1;
                }

                return 0;
            }
        });

        return resultList.toArray(new String[][]{});
    }
}
