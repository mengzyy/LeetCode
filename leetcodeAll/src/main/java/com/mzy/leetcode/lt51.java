package com.mzy.leetcode;

import com.mzy.offer.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-05-04 12:43
 **/
public class lt51 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[] book = new int[n];
        for (int i = 0; i < book.length; i++) {
            book[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            book[0] = i;
            Dfs(book, 0, n);
            book[0] = -1;

        }
        return res;


    }

    private void Dfs(int[] book, int i, int n) {
        if (i == n - 1) {
            //add
            List<String> ans = new ArrayList<>();
            for (int k = 0; k < book.length; k++) {
                StringBuilder sb = new StringBuilder();
                for (int g = 0; g < n; g++) {
                    if (book[k] == g) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                if (!sb.toString().contains("Q")) return;
                ans.add(sb.toString());
            }
            res.add(ans);

        } else {
            for (int j = 0; j < n; j++) {
                if (book[i] != j) {
                    //左斜
                    int left = j;
                    boolean isDui = false;

                    for (int i1 = i; i1 >= 0; i1--) {
                        if (left >= 0) {
                            if (book[i1] == left - 1) {
                                isDui = true;
                                break;
                            } else {
                                left--;
                            }
                        }
                    }

                    boolean riDui = false;
                    int right = j;
                    if (!isDui) {
                        for (int i1 = i; i1 >= 0; i1--) {
                            if (right < n) {
                                if (book[i1] == right + 1) {
                                    riDui = true;
                                    break;
                                } else {
                                    right++;
                                }
                            }
                        }

                    }
                    if (!riDui) {
                        if (j - 1 >= 0 && book[i] == j - 1) continue;
                        if (j + 1 < n && book[i] == j + 1) continue;
                        boolean is = false;
                        for (int w = 0; w <= i; w++) {
                            if (book[w] == j) {
                                is = true;
                                break;
                            }
                        }
                        if (!is) {
                            book[i + 1] = j;
                            Dfs(book, i + 1, n);
                            book[i + 1] = -1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new lt51().solveNQueens(4);


    }
}
