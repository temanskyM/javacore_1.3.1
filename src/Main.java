import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Получаем текущую папку, в которой запущенна программа (чтобы не было привязки к ОС)
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        //Создаем папку Games
        File mainDir = new File(System.getProperty("user.dir") + "//Games");

        if (mainDir.mkdir()) System.out.println("Каталог Games создан");
        else System.out.println("Каталог Games уже существует");

        gamesDirFill(mainDir.getPath());
    }

    private static void gamesDirFill(String path) {
        File srcDir = new File(path + "//src");
        if (srcDir.mkdir()) System.out.println("Каталог src создан");
        else System.out.println("Каталог src уже существует");

        File resDir = new File(path + "//res");
        if (resDir.mkdir()) System.out.println("Каталог res создан");
        else System.out.println("Каталог res уже существует");

        File saveGamesDir = new File(path + "//savegames");
        if (saveGamesDir.mkdir()) System.out.println("Каталог savegames создан");
        else System.out.println("Каталог savegames уже существует");

        File tempDir = new File(path + "//temp");
        if (tempDir.mkdir()) System.out.println("Каталог temp создан");
        else System.out.println("Каталог temp уже существует");

        srcDirFill(srcDir.getPath());
        resDirFill(resDir.getPath());
        tempDirFill(tempDir.getPath());

    }

    private static void srcDirFill(String path) {
        File mainDir = new File(path + "//main");
        if (mainDir.mkdir()) System.out.println("Каталог main создан");
        else System.out.println("Каталог main уже существует");

        File testDir = new File(path + "//test");
        if (testDir.mkdir()) System.out.println("Каталог test создан");
        else System.out.println("Каталог test уже существует");

        mainDirFill(mainDir.getPath());
    }

    private static void mainDirFill(String path) {
        File mainJavaFile = new File(path + "//Main.java");
        try {
            if (mainJavaFile.exists()) {
                System.out.println("Файл Main.java существует");
            }
            else{
                if (mainJavaFile.createNewFile())
                    System.out.println("Файл Main.java был создан");
                else
                    System.out.println("Невозможно создать файл Main.java");
            }
        } catch (IOException ex) {
            System.out.println("Невозможно создать файл Main.java");
            //ex.printStackTrace();
        }

        File utilsJavaFile = new File(path + "//Utils.java");
        try {
            if (utilsJavaFile.exists()) {
                System.out.println("Файл Utils.java существует");
            }
            else{
                if (utilsJavaFile.createNewFile())
                    System.out.println("Файл Utils.java был создан");
                else
                    System.out.println("Невозможно создать файл Utils.java");
            }
        } catch (IOException ex) {
            System.out.println("Невозможно создать файл Utils.java");
            //ex.printStackTrace();
        }
    }

    private static void resDirFill(String path) {
        File mainDir = new File(path + "//drawables");
        if (mainDir.mkdir()) System.out.println("Каталог drawables создан");
        else System.out.println("Каталог drawables уже существует");

        File testDir = new File(path + "//vectors");
        if (testDir.mkdir()) System.out.println("Каталог vectors создан");
        else System.out.println("Каталог vectors уже существует");

        File iconsDir = new File(path + "//icons");
        if (iconsDir.mkdir()) System.out.println("Каталог icons создан");
        else System.out.println("Каталог icons уже существует");
    }

    private static void tempDirFill(String path) {
        File tempFile = new File(path + "//temp.txt");
        try {
            if (tempFile.exists()) {
                System.out.println("Файл temp.txt существует");
            }
            else{
                if (tempFile.createNewFile())
                    System.out.println("Файл temp.txt был создан");
                else
                    System.out.println("Невозможно создать файл temp.txt");
            }
        } catch (IOException ex) {
            System.out.println("Невозможно создать файл temp.txt");
            //ex.printStackTrace();
        }
    }
}
