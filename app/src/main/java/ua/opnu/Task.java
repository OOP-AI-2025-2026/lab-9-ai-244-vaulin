
package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        if (list == null || list.size() < 2) return;
        int i = 0;
        while (i + 1 < list.size()) {
            String firstOne = list.get(i);
            String secondOne = list.get(i + 1);
            if (firstOne.length() <= secondOne.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i += 1;
        }
    }

    public void stutter(List<String> list) {
        if (list == null || list.isEmpty()) return;
        int i = 0;
        while (i < list.size()) {
            String vaule = list.get(i);
            list.add(i + 1, vaule);
            i += 2;
        }
    }

    public void switchPairs(List<String> list) {
        if (list == null || list.size() < 2) return;
        for (int i = 0; i + 1 < list.size(); i += 2) {
            Collections.swap(list, i, i + 1);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list == null || list.size() < 2) return;
        int i = 0;
        while (i + 1 < list.size()) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i);
            } else {
                i += 1;
            }
        }
    }

    public void markLength4(List<String> list) {
        if (list == null || list.isEmpty()) return;
        int i = 0;
        while (i < list.size()) {
            String str = list.get(i);
            if (str != null && str.length() == 4) {
                list.add(i, "****");
                i += 2;
            } else {
                i += 1;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) return true;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Integer v = queue.remove();
            stack.push(v);
            queue.add(v);
        }
        boolean isPal = true;
        for (int i = 0; i < size; i++) {
            Integer v = queue.remove();
            Integer fromStack = stack.pop();
            if (!Objects.equals(v, fromStack)) {
                isPal = false;
            }
            queue.add(v);
        }
        return isPal;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) return;
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) tmp.add(queue.remove());
        Collections.sort(tmp);
        queue.addAll(tmp);
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) return;
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            if (v % 2 == 0) evens.add(v);
            else odds.add(v);
        }
        queue.addAll(evens);
        queue.addAll(odds);
    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) return 0;
        int max = 0;
        for (String s : set) {
            if (s != null) max = Math.max(max, s.length());
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) return;
        set.removeIf(s -> s != null && s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return 0;
        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> common = new HashSet<>();
        for (Integer v : list2) {
            if (s1.contains(v)) common.add(v);
        }
        return common.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null) return true;
        Set<String> vals = new HashSet<>();
        for (String v : map.values()) {
            if (!vals.add(v)) return false;
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> res = new HashMap<>();
        if (map1 == null || map2 == null) return res;
        for (Map.Entry<String, Integer> e : map1.entrySet()) {
            String k = e.getKey();
            Integer v = e.getValue();
            if (map2.containsKey(k) && Objects.equals(map2.get(k), v)) {
                res.put(k, v);
            }
        }
        return res;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> res = new HashMap<>();
        if (map == null || map.isEmpty()) return res;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer key = e.getKey();
            String val = e.getValue();
            if (!res.containsKey(val)) {
                res.put(val, key);
            } else {
                Integer existing = res.get(val);
                if (key > existing) res.put(val, key);
            }
        }
        return res;
    }

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer v : map.values()) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }
        int minFreq = Integer.MAX_VALUE;
        for (Integer count : freq.values()) minFreq = Math.min(minFreq, count);
        int bestVal = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey();
            int count = e.getValue();
            if (count == minFreq && val < bestVal) bestVal = val;
        }
        return bestVal;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int best = 0;
        for (Integer v : list) {
            int f = freq.getOrDefault(v, 0) + 1;
            freq.put(v, f);
            best = Math.max(best, f);
        }
        return best;
    }

}
