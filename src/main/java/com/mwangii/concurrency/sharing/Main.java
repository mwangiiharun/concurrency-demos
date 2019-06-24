package com.mwangii.concurrency.sharing;

/**
 * Benchmark runner.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            printUsage();
        }

        switch (args[0]) {
            case "plain":
                FalseSharingBenchmark.run();
                break;
            default:
                printUsage();
                break;
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar false-sharing-demo-1.0.0-SNAPSHOT.jar (jmh|plain)");
        System.exit(1);
    }
}
