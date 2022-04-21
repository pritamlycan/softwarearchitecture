package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/*
3 things to note:
  1. When the number of ExportingProcess instances is less than minObjects,  
      missing instances will be created. 
  2. When the number of ExportingProcess instances is greater than maxObjects, 
       too many instances will be removed. 
  3. If the validation interval is negative, no periodical checking of  
       minObjects / maxObjects conditions in a separate thread take place. 
   These boundaries are ignored then. 
*/

public class ObjectPoolDemo {
    private ObjectPool<ExportingProcess> pool;
    private AtomicLong processNo = new AtomicLong(0);

    public void setUp() {
        // Create a pool of objects of type ExportingProcess.

        pool = new ObjectPool<ExportingProcess>(4, 10, 5) {
            protected ExportingProcess createObject() {
                // create a test object which takes some time for creation
                return new ExportingProcess(processNo.incrementAndGet());
            }
        };
    }

    public void tearDown() {
        pool.shutdown();
    }

    public void testObjectPool() {
        ExecutorService executor = Executors.newFixedThreadPool(8);

        // execute 8 tasks in separate threads

        executor.execute(new ExportingTask(pool, 1));
        executor.execute(new ExportingTask(pool, 2));
        executor.execute(new ExportingTask(pool, 3));
        executor.execute(new ExportingTask(pool, 4));
        executor.execute(new ExportingTask(pool, 5));
        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e)

        {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ObjectPoolDemo op = new ObjectPoolDemo();
        op.setUp();
        op.tearDown();
        op.testObjectPool();
    }
}