/*
 * Personal project
 * Anh - Viet Dictionary
 * Author: Tee Le
 * Created: 5/26/2020
 */

package personal.project.dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Functionalities class
 */
public class DictionaryFunc {
    //The map to store the word and its definition
    private Map<String, String> map;
    //The sorted set to store the word to be searched
    private SortedSet<String> words;
    //String of the path to the dictionary file
    private String file = "src/personal/project/dictionary/vnedict.txt";

    /**
     * Constructor of the functionality class
     * Initializes the hashmap and the set
     */
    public DictionaryFunc(){
        map = new HashMap<>();
        words = new TreeSet<>();
    }

    /**
     * Reads and store the word and definition into the hash map, set
     * @throws IOException if the file cannot be loaded
     */
    public void loadAnhViet() throws IOException{
        words.clear();
        List<String> lines = Files.readAllLines(Paths.get(file));
        for(int i = 1; i < lines.size(); i++){
            String[] split = lines.get(i).split(" : ", 2);
            String viet = split[0].toLowerCase();
            String anh = split[1].toLowerCase();
            if(!anh.startsWith("(") && !anh.startsWith("-")){
                words.add(anh);
                map.put(anh, viet);
            }

        }
    }

    /**
     * Reads and store the word and definition into the hash map, set
     * @throws IOException if the file cannot be loaded
     */
    public void loadVietAnh() throws IOException{
        words.clear();
        List<String> lines = Files.readAllLines(Paths.get(file));
        for(int i = 1; i < lines.size(); i++){
            String[] split = lines.get(i).split(" : ", 2);
            String viet = split[0].toLowerCase();
            String anh = split[1].toLowerCase();
            words.add(viet);
            map.put(viet, anh);
        }
    }


    public SortedSet<String> allThatBeginsWith(String prefix){
        for(String s : words){
            if(prefix.length() <= s.length()){
                String str = s.toLowerCase();
                if(str.substring(0, prefix.length()).equals(prefix)){
                    return words.subSet(prefix, prefix + "zzz");
                }
            }
        }
        return null;
    }

    public String getDef(String key){
        if(map.containsKey(key)){
            return map.get(key);
        }
        return "No definition found! :(";
    }


}
