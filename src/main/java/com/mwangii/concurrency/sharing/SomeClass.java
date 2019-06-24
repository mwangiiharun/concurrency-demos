package com.mwangii.concurrency.sharing;

/**
 * An object with fields that are likely to end up in the same cache line.
 */
public class SomeClass {
    public volatile long valueA;
    public volatile long valueB;
}
