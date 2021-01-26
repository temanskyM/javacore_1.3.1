import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Получаем текущую папку, в которой запущенна программа (чтобы не было привязки к ОС)
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        //Создаем папку Games
        File mainDir = createDir(System.getProperty("user.dir"), "Games");

        gamesDirFill(mainDir.getPath());
    }

    private static void gamesDirFill(String path) {
        File srcDir = createDir(path, "src");
        File resDir = createDir(path, "res");
        File saveGamesDir = createDir(path, "savegames");
        File tempDir = createDir(path, "temp");

        srcDirFill(srcDir.getPath());
        resDirFill(resDir.getPath());
        tempDirFill(tempDir.getPath());
    }

    private static void srcDirFill(String path) {
        File mainDir = createDir(path, "main");
        File testDir = createDir(path, "test");

        mainDirFill(mainDir.getPath());
    }

    private static void mainDirFill(String path) {
        File mainFile = createFile(path,"Main.java");
        File utilsFile = createFile(path,"Utils.java");

    }

    private static void resDirFill(String path) {
        File drawablesDir = createDir(path, "drawables");
        File testDir = createDir(path, "vectors");
        File iconsDir = createDir(path, "icons");
    }

    private static void tempDirFill(String path) {
        File tempFile = createFile(path,"temp.txt");
    }

    private static File createDir(String path, String nameDir) {
        String fullPath = path + File.pathSeparator + nameDir;

        File dir = new File(fullPath);
        if (dir.mkdir()) System.out.println("Каталог " + nameDir + " создан");
        else System.out.println("Каталог " + nameDir + " уже существует");

        return dir;
    }
    private static File createFile(String path, String nameFile) {
        String fullPath = path + File.pathSeparator + nameFile;

        File file = new File(fullPath);
        try {
            if (file.exists()) {
                System.out.println("Файл " + nameFile + " существует");
            } else {
                if (file.createNewFile())
                    System.out.println("Файл " + nameFile + " был создан");
                else
                    System.out.println("Невозможно создать файл " + nameFile);
            }
        } catch (IOException ex) {
            System.out.println("Невозможно создать файл " + nameFile);
            //ex.printStackTrace();
        }

        return file;
    }
}
