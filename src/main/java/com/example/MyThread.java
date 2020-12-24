package com.example;

/**
 * @author 郝少杰
 * @date 2020/12/21 16:46
 */
public class MyThread extends Thread {

    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice(new Object(), 20);
        new Thread(ticketOffice, "窗口1").start();
        new Thread(ticketOffice, "窗口2").start();
        new Thread(ticketOffice, "窗口3").start();
    }
}

class TicketOffice implements Runnable {
    private Object object;

    private int ticketNum;

    public TicketOffice(java.lang.Object object, int ticketNum) {
        this.object = object;
        this.ticketNum = ticketNum;
    }

    @Override
    public void run() {
        while (ticketNum > 0) {
            synchronized (object) {
                if (ticketNum <= 0) {
                    System.out.println(Thread.currentThread().getName() + "没有票了");
                } else {
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票，剩余" + --ticketNum + "张票");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


