package Strings.Easy;

public class isisomorphc {
    public static void main(String[] args) {
       String s = "egg";
        String t = "add";
        System.out.println(new isisomorphc().isIsomorphic(s, t));
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] map1 = new char[256];
        char[] map2 = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1[c1] != map2[c2]) {
                return false;
            }
            map1[c1] = (char) (i + 1);
            map2[c2] = (char) (i + 1);
        }
        return true;
    }
}
