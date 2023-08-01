package com.zack.algorithm.backtracking;


import com.alibaba.fastjson2.JSON;

import java.util.*;

/**
 * 332. 重新安排行程
 */
public class ReconstructItinerary {

    LinkedList<String> path = new LinkedList();

    Map<String, Map<String, Integer>> sameStartTicMap=new TreeMap<>();


    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String startStation = ticket.get(0);
            if (sameStartTicMap.containsKey(startStation)) {
                Map<String, Integer> ticMap = sameStartTicMap.get(startStation);
                ticMap.put(ticket.get(1), ticMap.getOrDefault(ticket.get(1), 0) + 1);
                sameStartTicMap.put(startStation, ticMap);
            } else {
                Map<String, Integer> ticMap = new TreeMap<>();//默认升序
                ticMap.put(ticket.get(1), 1);
                sameStartTicMap.put(startStation, ticMap);
            }
        }
        path.add("JFK");
        backtracking(tickets.size());
        return new ArrayList<>(path);
    }

    public boolean backtracking(int size) {
        if (path.size() == size + 1) {
            return true;
        }
        if (sameStartTicMap.containsKey(path.getLast())) {
            for (Map.Entry<String, Integer> entry : sameStartTicMap.get(path.getLast()).entrySet()) {
                int count = entry.getValue();
                if (count > 0) {
                    path.add(entry.getKey());
                    entry.setValue(count - 1);
                    if (backtracking(size)) {
                        return true;
                    }
                    path.removeLast();
                    entry.setValue(count);
                }
            }
        }
        return false;
    }


    public void main(String[] args) {
        //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("KUL");

        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("NRT");

        List<String> list3 = new ArrayList<>();
        list3.add("NRT");
        list3.add("JFK");

        List<String> list4 = new ArrayList<>();
        list4.add("ATL");
        list4.add("JFK");

        List<String> list5 = new ArrayList<>();
        list5.add("ATL");
        list5.add("SFO");

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
//        tickets.add(list4);
//        tickets.add(list5);

        System.out.println(JSON.toJSONString(findItinerary(tickets)));
    }

}
