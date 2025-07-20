import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Sort this list by age in ascending order of age
 * if age is equal then name with shorter name will come first in order
 */

 public class Sorting {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Aman", 13),
                new Student("Akash", 15),
                new Student("Piyush", 15),
                new Student("Ankit", 12)
                ));

    }
    // public static void sortorder(int arr[]){
    //     int n=arr.length;
    //     HashMap<String ,Integer> mp = new HashMap<>();
    //     for(int i=0; i<n; i++){
    //         mp.
    //     }
    // }
    public static Map<String,int> sortorder(Map<String,int> studentss){
        int n=studentss.length();
        Map<String,int>mp;
        for(int i=0; i<n; i++){
            mp[studentss[i]]++;
        }
        Map<string,int>ans;
        for(auto i: mp){
            if(mp.second(i) < mp.second(i+1)){
               ans[mp[i]];
            }if else(mp.second(i) == mp.second(i+1)){
                //  mp.first[i].length  mp.first[i+1].length){
                sort(mp,mp+1);
                ans[mp[i]];
            }
            }
            return ans;
        }

    }
}

class Student {

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    String name;
    Integer age;

    public String toString() {
        return name.concat(" " + age);
    }
}