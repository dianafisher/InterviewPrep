package com.dianafisher.interviewprep.week2.challenges;

import java.util.HashMap;
import java.util.HashSet;

/*
* "to"        → 2
"be"        → 2
"or"        → 1
"not"       → 1
"that"      → 1
"is"        → 1
"the"       → 1
"question"  → 1

becomes

2 → ["to", "be"]
1 → ["or", "not", "that", "is", "the", "question"]


* **/

public class MultiMaps {

    public HashMap<Integer,HashSet<String>> convertMap(HashMap<String,Integer> inputMap) {


        if (inputMap == null) return null;

        HashMap<Integer, HashSet<String>> result = new HashMap<>();

        for (String s : inputMap.keySet()) {

            Integer count = inputMap.get(s);
            if (result.containsKey(count)) {
                HashSet<String> strings = result.get(count);
                // add this string to the set
                strings.add(s);
                result.put(count, strings);
            } else {
                HashSet<String> strings = new HashSet<>();
                strings.add(s);
                result.put(count, strings);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("to", 2);
        map.put("be", 2);
        map.put("or", 1);
        map.put("not", 1);
        map.put("that", 1);
        map.put("is", 1);
        map.put("the", 1);
        map.put("question", 1);
        map.put("a", 10000000);

        MultiMaps mm = new MultiMaps();
        HashMap<Integer, HashSet<String>> result = mm.convertMap(map);
        System.out.println(result);
    }
}
