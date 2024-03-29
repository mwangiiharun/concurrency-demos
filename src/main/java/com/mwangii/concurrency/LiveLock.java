 package com.mwangii.concurrency;
//Created by: mwangiiharun


public class LiveLock {
 static class Spoon {
  private Diner owner;
  public Spoon(Diner d) { owner = d; }
  public Diner getOwner() { return owner; }
  public synchronized void setOwner(Diner d) { owner = d; }
  public synchronized void use() {
   System.out.printf("%s has eaten!", owner.name);
  }
 }

 static class Diner {
  private String name;
  private boolean isHungry;

  public Diner(String n) { name = n; isHungry = true; }
  public String getName() { return name; }
  public boolean isHungry() { return isHungry; }

  public void eatWith(Spoon spoon, Diner spouse) {
   while (isHungry) {
    // Don't have the spoon, so wait patiently for spouse.
    if (spoon.owner != this) {
     try { Thread.sleep(1); }
     catch(InterruptedException e) { continue; }
     continue;
    }

    // If spouse is hungry, insist upon passing the spoon.
    if (spouse.isHungry()) {
     System.out.printf(
             "%s: You eat first my darling %s!%n",
             name, spouse.getName());
     spoon.setOwner(spouse);
     continue;
    }

    // Spouse wasn't hungry, so finally eat
    spoon.use();
    isHungry = false;
    System.out.printf(
            "%s: I am stuffed, my darling %s!%n",
            name, spouse.getName());
    spoon.setOwner(spouse);
   }
  }
 }

 public static void main(String[] args) {
  final Diner husband = new Diner("Kevo");
  final Diner wife = new Diner("Irene");

  final Spoon s = new Spoon(husband);

  new Thread(() -> husband.eatWith(s, wife)).start();

  new Thread(() -> wife.eatWith(s, husband)).start();
 }

  


}
