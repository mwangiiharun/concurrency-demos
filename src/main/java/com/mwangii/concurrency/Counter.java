package com.mwangii.concurrency;



public class Counter {
 private  int count = 0;

 public  synchronized    void increment() {
  count = count + 1;
 }

 public int getCount() {
  return count;
 }
}

