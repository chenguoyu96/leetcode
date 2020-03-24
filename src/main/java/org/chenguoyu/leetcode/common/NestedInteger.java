package org.chenguoyu.leetcode.common;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
    private int value;
    private List<NestedInteger> nestedIntegers;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }


    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }


    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return nestedIntegers == null || nestedIntegers.size() == 0;
    }


    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }


    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
    }


    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        if (nestedIntegers == null) {
            nestedIntegers = new ArrayList<>();
        }
        nestedIntegers.add(ni);
    }


    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return nestedIntegers;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, true);
    }
}
