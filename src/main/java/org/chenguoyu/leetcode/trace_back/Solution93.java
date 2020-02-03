package org.chenguoyu.leetcode.trace_back;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原IP地址
 */
public class Solution93 {
    private int n;
    private LinkedList<String> tmp;
    private List<String> result;


    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        if (s == null || "".equals(s)) {
            return result;
        }
        tmp = new LinkedList<>();
        restoreIpAddresses(s, 0);
        return result;
    }

    private void restoreIpAddresses(String s, int index) {
        if (tmp.size() == 4) {
            String ip = validIp();
            if (!"".equals(ip)) {
                result.add(ip);
            }
            return;
        }
        if (n < 3) {
            int end = index + 3;
            if (end > s.length()) {
                end = s.length();
            }
            String subStr = s.substring(index, end);
            n++;
            for (int i = 1; i <= subStr.length(); i++) {
                String ipSegment = subStr.substring(0, i);
                if (!isIpStage(ipSegment)) {
                    continue;
                }
                tmp.add(ipSegment);
                restoreIpAddresses(s, index + i);
                tmp.removeLast();
            }
            n--;
        } else {
            String ipSegment = s.substring(index);
            if (isIpStage(ipSegment)) {
                tmp.add(ipSegment);
                restoreIpAddresses(s, s.length());
                tmp.removeLast();
            }
        }

    }

    private String validIp() {
        for (String ipSegment : tmp) {
            if (!isIpStage(ipSegment)) {
                return "";
            }
        }
        return String.join(".", tmp);
    }

    private boolean isIpStage(String str) {
        if (str.startsWith("0") && str.length() > 1) {
            return false;
        }
        if ("".equals(str)) {
            return false;
        }
        if (str.length() > 3) {
            return false;
        }
        int ipStage = Integer.parseInt(str);
        return ipStage >= 0 && ipStage <= 255;
    }
}
