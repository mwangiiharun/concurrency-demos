package com.mwangii.concurrency.sharing;

import jdk.internal.vm.annotation.Contended;

/**
 * An object with one field that *should* be immune to false-sharing effects.
 */
public class SomePaddedClass {
    @Contended
    public volatile long valueA;
    public volatile long valueB;
}
