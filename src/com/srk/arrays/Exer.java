package com.srk.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * a1 = { 2, 6, 9, 10}
 * a2 = { 4, 7, 11}
 *
 * O/p = 2,4,6,7,9,10,11,14
 *
 */
public class Exer {

    public static void main(String[] args) {
        int[] a1 = { 2, 6, 9, 10, 14, 20, 25};
        int[] a2 = { 4, 7, 11};
        Lock lock = new ReentrantLock();
        List<Integer> ints = new ArrayList<>(2);
        ints.add(0, -1);
        ints.add(1, -1);
        Thread t1 = new Thread(new Test1(a1,0,ints, lock));
        Thread t2 = new Thread(new Test1(a2,1,ints, lock));
        t1.start();
        t2.start();

    }

    static class Test1 implements Runnable {
        int id;
        int[] arr;
        int l = 0;
        List<Integer> ints;
        Lock lock;

        Test1(int[] arr, int id, List<Integer> ints, Lock lock) {
            this.id = id;
            this.arr = arr;
            this.ints = ints;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (l < arr.length) {
                lock.lock();
                    compare();
                    if (ints.get(id) == -1) {
                        ints.remove(id);
                        //if (!isLastElement()){
                            ints.add(id, arr[l]);
                            l++;
                        //}
                    }
                    
                    if (ints.size() == 1) {
                        ints.remove(0);
                        //if(!isLastElement()) {
                            ints.add(0, arr[l]);
                            l++;
                        //}
                    }
                lock.unlock();

            }
        }

        private boolean isLastElement() {
            int oid = (id==0)?1:0;
            if(l==arr.length-1 && ints.get(oid)!=-1){
                System.out.println(arr[l]);
                l++;
                return true;
            }
            return false;
        }

        private synchronized void compare() {
            int oid = (id==0)?1:0;
            if (ints.get(id) != -1 && ints.get(oid) != -1) {
                if (ints.get(id) < ints.get(oid)) {
                    System.out.println(ints.get(id));
                    ints.remove(id);
                    if(l < arr.length) {
                        ints.add(id, -1);
                    }
                }
            }
            if(ints.size()==1){
                System.out.println(ints.get(0));
            }
        }
    }
}
