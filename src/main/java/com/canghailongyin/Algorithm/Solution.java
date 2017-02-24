package com.canghailongyin.Algorithm;

import com.canghailongyin.Utils.ListNode;

import java.util.List;
import java.util.Random;

/**
 * Created by mingl on 2017-2-23.
 */
public class Solution {
    public static void main(String[] args){

    }

    //2017-02-23
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode cur = head,next = head.next;
        while(next != null){
            if(next.val == val){
                cur.next = next.next;
                next = next.next;
            }else{
                cur = cur.next;
                next = next.next;
            }
        }
        //最后去除表头
        if(head.val == val)
            head = head.next;
        return head;
    }

    //2017-02-23
    //最直观易懂，但是递归太慢，数字较大时超时
    public static int fibonacci(int n) {
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        return fibonacci(n-2)+fibonacci(n-1);
    }

    //一种折中的思路,效率提高
    public static int fibonacci1(int n) {
        if(n < 0)
            return 0;
        if(n == 1||n == 2)
            return n-1;
        int last = 0;
        int cur = 1;
        int result = 0;
        for(int i=2;i<n;i++){
            result = cur + last;
            last = cur;
            cur = result;
        }
        return result;
    }

    //2017-02-22
    public static void randomMusic(List<String> songs){
        Random random = new Random();
        boolean last = false;
        while(songs.size()>0){
            int size = songs.size();
            if(size == 1){//random.nextInt(0)会抛出异常
                last = true;
                size = 2;
            }
            //1,生成0-size的随机数
            int index = random.nextInt(size-1);
            //2,取出该条数据
            if(last){
                System.out.print(songs.get(index));
            }else{
                System.out.print(songs.get(index)+",");
            }
            //3,将该数据从list中去除
            songs.remove(index);
        }
    }


}
