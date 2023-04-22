package org.example.Homework;

public class RobotManager {
    private Thread[] threads;

    public RobotManager(Thread[] threads) {
        this.threads = threads;
    }

    public void pauseAll(){
        for(Thread thread : threads) {
            synchronized (thread) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void pauseAllForTime(int seconds){
        for(Thread thread : threads) {
           synchronized (thread){
            try {
                thread.wait(seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
                }
            }
        }
    }

    public void pauseOne(int index){
       synchronized (threads[index]){
           try {
               threads[index].wait();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

    public void pauseOneForTime(int index, int seconds){
        synchronized (threads[index]){
            try {
                threads[index].wait(seconds * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startOne(int index)
    {
        synchronized (threads[index]) {
            threads[index].notify();
        }
    }

    public void startAll()
    {
        for(Thread thread : threads)
           synchronized (thread){
            thread.notify();
           }
    }

    public void startFirstTime(int index)
    {
        threads[index].start();
    }

    public void startAllFirstTime()
    {
       for(Thread thread : threads)
           thread.start();
    }

}
