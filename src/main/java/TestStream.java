import ua.goit.hw9Stream.*;

public class TestStream {
    public static void main(String[] args) {

        System.out.println("Test phones");
        try {
            ReadWriteFile.output(
                    ReadWriteFile.getValidPhones(
                            ReadWriteFile.readFromFileToList(".\\src\\main\\resources\\testPhones\\file.txt", "[\\n\\r]+")),
                    Outputs.CONSOLE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Test JSON");
        try {
            ReadWriteFile.output(
                    ReadWriteFile.getJson(
                            ReadWriteFile.readFromFileToListObjects(".\\src\\main\\resources\\testJson\\file.txt")),
                    Outputs.FILE, "user.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("Test repeats");
        try {
            ReadWriteFile.output(
                    ReadWriteFile.getNumberRepeats(
                            ReadWriteFile.readFromFileToList(".\\src\\main\\resources\\testRepeats\\file.txt", "[\\s\\n\\r\\t]+")),
                    Outputs.CONSOLE, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

    }
}
