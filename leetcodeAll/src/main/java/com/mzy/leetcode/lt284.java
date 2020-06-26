package com.mzy.leetcode;

import java.util.Iterator;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-02 11:56
 **/

public class lt284 implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer cache = null; // 第一次peek时, 缓存迭代的元素

    public lt284(Iterator<Integer> iter) {
        iterator = iter;
    }

    public Integer peek() {
        if (cache == null)
            cache = iterator.next();
        return cache;
    }

    @Override
    public Integer next() {
        if (cache == null)
            return iterator.next();
        Integer temp = cache;
        cache = null;
        return temp;
    }

    @Override
    public void remove() {

    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}