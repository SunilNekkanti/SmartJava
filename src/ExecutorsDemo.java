import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {

int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
        ExecutorService service = Executors.newFixedThreadPool(count);

        for(int i=0;i<100;i++){
          service.execute(new Task());
        }

        System.out.println("Thread Name: "+ Thread.currentThread().getName());
    }

    static class Task implements Runnable{
        public void run(){

            System.out.println("Thread Name: "+ Thread.currentThread().getName());

        }

    }
}
