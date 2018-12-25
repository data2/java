/**
 * FileName:   ForkJoinJudge.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.muskteer.java.concurrency.framework;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.google.common.collect.Lists;

public class PrimeForkJoin {
/**
 * search prime number from 0 - 1000
 * @param args
 */
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        List<Integer> list = pool.invoke(new PrimeForkJoin().new SearchPrimeNumberTask(0, 1000));
        System.out.println(list);
        System.out.println(list.size());
    }
    
    class SearchPrimeNumberTask extends RecursiveTask<List<Integer>>{
        
        private static final long serialVersionUID = 1L;

        int minNum;
        int maxNum;
        public SearchPrimeNumberTask(int miniNumber, int maxNumber) {
            minNum = miniNumber;
            maxNum = maxNumber;
        }

        @Override
        protected List<Integer> compute() {
            List<Integer> list = Lists.newArrayList();
            if((maxNum - minNum) <= 100){
                for(int i = minNum; i <= maxNum ; i ++ ){
                    if(isPrimeNumber(i)){
                        list.add(i);
                    }
                }
                return list;
            }
            SearchPrimeNumberTask task1;
            SearchPrimeNumberTask task2 = null;
            if((maxNum - 99) > 0){
                task1 = new SearchPrimeNumberTask(maxNum-99, maxNum);
                if(minNum >= 0){
                    task2 = new SearchPrimeNumberTask(minNum, maxNum-100); 
                }
            }else{
                task1 = new SearchPrimeNumberTask(0, maxNum);
            }
            
            task1.fork();
            List<Integer> list2 = task1.join();
            if(task2 != null){
                task2.fork();
                list2.addAll(task2.join());
            }
            return list2;
        }
        
    }
    
    /**
     * 
     */
    private static boolean isPrimeNumber(int num) {
        if(num < 2){   
            return false;
        }   
        //因为要判断的数的最小公因子小于等于该数的平方根 
        for(int i = 2 ; Math.sqrt(num) >=i ; i ++ ){             
            if(num % i == 0){   
                return false;
            }   
        }   
        return true;
    }

}

