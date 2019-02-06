import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class ParseINI {
    public static void main(String args[]) {
        try {
            String pattern = "^([\\p{Alnum}]+)?=((?:START.*?END.*?)|(?:[^\\n]*))*$";
            byte[] encoded = Files.readAllBytes(Paths.get("ini.txt"));
            String ini = new String(encoded);
            System.out.println("Ini "+ini);
            Pattern r = Pattern.compile(pattern, Pattern.MULTILINE|Pattern.DOTALL);
            Matcher matcher = r.matcher(ini);
            while (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
