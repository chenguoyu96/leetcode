package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二进制手表
 */
public class Solution401 {
    private List<String> result;
    private List<Integer> hours;
    private List<Integer> minutes;
    private List<List<Integer>> resultHours;
    private List<List<Integer>> resultMinutes;

    public List<String> readBinaryWatch(int num) {
        result = new ArrayList<>();
        if (num < 0 || num >= 10) {
            return result;
        }
        resultHours = new ArrayList<>();
        resultMinutes = new ArrayList<>();
        hours = Arrays.asList(1, 2, 4, 8);
        minutes = Arrays.asList(1, 2, 4, 8, 16, 32);
        for (int i = 0; i <= num; i++) {
            getHours(i, 0, new ArrayList<>());
            getMinutes(num - i, 0, new ArrayList<>());
            List<Integer> hour = resultHours.stream().map(hourList -> hourList.stream().mapToInt(item -> item).sum()).collect(Collectors.toList());
            List<Integer> minute = resultMinutes.stream().map(minuteList -> minuteList.stream().mapToInt(item -> item).sum()).sorted().collect(Collectors.toList());
            addTime(hour, minute);
            resultHours.clear();
            resultMinutes.clear();
        }
        return result;
    }

    private void getHours(int num, int index, List<Integer> hourList) {
        if (num == hourList.size()) {
            resultHours.add(new ArrayList<>(hourList));
            return;
        }
        for (int i = index; i < hours.size(); i++) {
            hourList.add(hours.get(i));
            int hourSum = hourList.stream().mapToInt(item -> item).sum();
            if (hourSum >= 0 && hourSum <= 11) {
                getHours(num, i + 1, hourList);
            }
            hourList.remove(hourList.size() - 1);
        }
    }

    private void getMinutes(int num, int index, List<Integer> minuteList) {
        if (minuteList.size() == num) {
            resultMinutes.add(new ArrayList<>(minuteList));
            return;
        }
        for (int i = index; i < minutes.size(); i++) {
            minuteList.add(minutes.get(i));
            int minuteSum = minuteList.stream().mapToInt(item -> item).sum();
            if (minuteSum >= 0 && minuteSum <= 59) {
                getMinutes(num, i + 1, minuteList);
            }
            minuteList.remove(minuteList.size() - 1);
        }
    }

    private void addTime(List<Integer> hourList, List<Integer> minuteList) {
        for (int i = 0; i < hourList.size(); i++) {
            for (int j = 0; j < minuteList.size(); j++) {
                Integer minute = minuteList.get(j);
                result.add(hourList.get(i) + ":" + (minute < 10 ? ("0" + minute) : minute));
            }
        }
    }
}
