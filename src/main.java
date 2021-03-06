import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	static Map<String, HashMap<Integer, List<Object>>> rateMap = new HashMap<String, HashMap<Integer, List<Object>>>();
	static String rateMapKey = null;

	static HashMap<Integer, List<Object>> hMap = new HashMap<Integer, List<Object>>();
	static List<Object> value = new ArrayList<Object>();
	static Double rate = 0.0;
	static String effectiveFrom = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	static String effectiveTo = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy";

	public static void main(String[] args) {

		// Connecting to Redis server on localhost
		// Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// check whether server is running or not
		// System.out.println("Server is running: " + jedis.ping());

		for (int i = 0; i < 1000000000; i++) {

			// what does the HashMap<Integer, List<Object>>> consists of?
			// Integer is the PolicyYear
			// List of Object is 1. Rate, 2. Effective From, 3. Effective To
			rate = ThreadLocalRandom.current().nextDouble(0, 10000);
			value.add(rate);
			value.add(effectiveFrom);
			value.add(effectiveTo);

			hMap.put(i, value);

			// rateMapKey =
			// Double.toString(ThreadLocalRandom.current().nextDouble(0,
			// 20000));
			rateMapKey = Integer.toString(1000000000 + 1);
			rateMap.put(rateMapKey, hMap);

			if (i % 100000 == 0) {
				System.out.println(i);

				// Get current size of heap in bytes
				long heapSize = Runtime.getRuntime().totalMemory();
				System.out.println("heapSize = " + heapSize);

				// Get maximum size of heap in bytes. The heap cannot grow
				// beyond this size.// Any attempt will result in an
				// OutOfMemoryException.
				long heapMaxSize = Runtime.getRuntime().maxMemory();
				System.out.println("heapMaxSize = " + heapMaxSize);

				// Get amount of free memory within the heap in bytes. This size
				// will increase // after garbage collection and decrease as new
				// objects are created.
				long heapFreeSize = Runtime.getRuntime().freeMemory();
				System.out.println("heapFreeSize = " + heapFreeSize);
			}
		}

	}

}
