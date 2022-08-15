package com.demo1_25;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/12 13:32
 */
public class _24LRUCache {

    public class LRUCache {
        private class Node {
            int key, val;
            Node prev, next;

            Node(int key, int val, Node prev, Node next) {
                this.key = key;
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }

        private Node head = new Node(-1, -1, null, null);
        private Map<Integer, Node> map = new HashMap<>();

        // 移动到头部
        private void move2Head(Node cur) {
            if (cur == head) {
                head = head.prev;
                return;
            }
            // 断开从原来位置取下
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            // 插入导头结点后
            cur.next = head.next;
            cur.next.prev = cur;
            head.next = cur;
            cur.prev = head;
        }

        // 构造双向链表
        public LRUCache(int capacity) {
            Node cur = head;
            for (int i = 0; i < capacity - 1; i++) {
                cur.next = new Node(-1, -1, cur, null);
                cur = cur.next;
            }
            cur.next = head;
            head.prev = cur;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node cur = map.get(key);
            move2Head(cur);
            return cur.val;
        }

        public void put(int key, int value) {
            // 包含的话就更新
            if (map.containsKey(key)) {
                // 获取值
                Node cur = map.get(key);
                // 赋值
                cur.val = value;
                move2Head(cur);
            } else {
                // 移除head节点 最久未使用得
                if (head.val != -1) map.remove(head.key);
                // 更新head的key val
                head.key = key;
                head.val = value;
                map.put(key, head);
                // 指向前一个最久未使用的节点
                head = head.prev;
            }
        }
    }



}
