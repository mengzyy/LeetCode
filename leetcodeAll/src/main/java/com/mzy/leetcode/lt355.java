package com.mzy.leetcode;


import java.util.*;

/**
 * @program: LeetCode
 * @author: mengzy 18306299232@163.com
 * @create: 2020-04-13 11:26
 **/

public class lt355 {
    class userInfo {
        //用户id
        private int userID;
        //用户关注ID信息
        private HashSet<Integer> hashSet;
        //用户推文信息
        private List<int[]> twitterId;

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public HashSet<Integer> getHashSet() {
            return hashSet;
        }

        public void setHashSet(HashSet<Integer> hashSet) {
            this.hashSet = hashSet;
        }


        public List<int[]> getTwitterId() {
            return twitterId;
        }

        public void setTwitterId(List<int[]> twitterId) {
            this.twitterId = twitterId;
        }


    }

    //全局时间
    static int time;
    //用户信息
    static HashMap<Integer, userInfo> userInfoMap;


    /**
     * Initialize your data structure here.
     */
    public lt355() {
        time = 0;
        userInfoMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userInfoMap.containsKey(userId)) {
            userInfo userInfo = new userInfo();
            userInfo.setUserID(userId);
            userInfo.setHashSet(new HashSet<Integer>());
            List<int[]> twitterInfo = new ArrayList<>();
            twitterInfo.add(new int[]{tweetId, time});
            userInfo.setTwitterId(twitterInfo);
            userInfoMap.put(userId, userInfo);
        } else {
            userInfo userInfo = userInfoMap.get(userId);
            List<int[]> twitterInfo = userInfo.getTwitterId();
            twitterInfo.add(new int[]{tweetId, time});
        }
        time++;

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> newsInfo = new ArrayList<>();
        if (!userInfoMap.containsKey(userId)) {
            userInfo userInfo = new userInfo();
            userInfo.setUserID(userId);
            userInfo.setHashSet(new HashSet<Integer>());
            List<int[]> twitterInfo = new ArrayList<>();
            userInfo.setTwitterId(twitterInfo);
            userInfoMap.put(userId, userInfo);
        }
        userInfo userInfo = userInfoMap.get(userId);
        HashSet<Integer> hashSet = userInfo.getHashSet();
        if (hashSet.size() != 0) {
            for (Integer integer : hashSet) {
                userInfo userInfo1 = userInfoMap.get(integer);
                List<int[]> twitterId = userInfo1.getTwitterId();
                for (int[] ints : twitterId) {
                    newsInfo.add(ints);
                }
            }
        }
        userInfo userInfo2 = userInfoMap.get(userId);
        List<int[]> twitterId = userInfo2.getTwitterId();
        for (int[] ints : twitterId) {
            newsInfo.add(ints);
        }
        //排序
        if (newsInfo.size() != 0) {
            Collections.sort(newsInfo, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] > o2[1]) {
                        return -1;
                    } else if (o1[1] < o2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
        }
        //取前10
        List<Integer> res = new ArrayList<>();
        int count = 10;
        int i = 0;
        while (count != 0) {
            if (newsInfo.size() - 1 >= i) {
                if (!res.contains(newsInfo.get(i)[0])) {
                    res.add(newsInfo.get(i)[0]);
                    count--;

                }
            } else {
                break;
            }


        }
        return res;


    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userInfoMap.containsKey(followerId)) {
            userInfo userInfo = new userInfo();
            userInfo.setUserID(followerId);
            userInfo.setHashSet(new HashSet<Integer>());
            List<int[]> twitterInfo = new ArrayList<>();
            userInfo.setTwitterId(twitterInfo);
            userInfoMap.put(followerId, userInfo);
        }
        if (!userInfoMap.containsKey(followeeId)) {
            userInfo userInfo = new userInfo();
            userInfo.setUserID(followeeId);
            userInfo.setHashSet(new HashSet<Integer>());
            List<int[]> twitterInfo = new ArrayList<>();
            userInfo.setTwitterId(twitterInfo);
            userInfoMap.put(followeeId, userInfo);
        }
        //加入关注信息
        userInfo userInfo = userInfoMap.get(followerId);
        HashSet<Integer> hashSet = userInfo.getHashSet();
        hashSet.add(followeeId);


    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userInfoMap.containsKey(followerId)) {
            userInfo userInfo = new userInfo();
            userInfo.setUserID(followerId);
            userInfo.setHashSet(new HashSet<Integer>());
            List<int[]> twitterInfo = new ArrayList<>();
            userInfo.setTwitterId(twitterInfo);
            userInfoMap.put(followerId, userInfo);
        }
        if (!userInfoMap.containsKey(followeeId)) {
            userInfo userInfo = new userInfo();
            userInfo.setUserID(followeeId);
            userInfo.setHashSet(new HashSet<Integer>());
            List<int[]> twitterInfo = new ArrayList<>();
            userInfo.setTwitterId(twitterInfo);
            userInfoMap.put(followeeId, userInfo);
        }
        //取消关注信息
        userInfo userInfo = userInfoMap.get(followerId);
        HashSet<Integer> hashSet = userInfo.getHashSet();
        hashSet.remove(followeeId);


    }
}