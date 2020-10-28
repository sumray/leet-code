package algorithm.lru;

public class LRUTest {

	static void printLRUCache() {
		LRUCache<String, Integer> c = new LRUCache<>(5);
		String s1 = "你好1";
		String s2 = "你好2";
		String s3 = "你好3";
		String s4 = "你好4";
		String s5 = "你好5";
		String s6 = "你好6";
		String s7 = "你好7";
		c.set(s1, 1);
		c.set(s2, 2);
		c.set(s3, 3);
		c.set(s4, 4);
		c.set(s5, 5);
		c.set(s6, 6);
		Integer v1 = c.get(s6);
		Integer v2 = c.get(s1);
		System.out.println(v1);
		System.out.println(v2);

		c.set(s3, 4);
		Integer v3 = c.get(s3);
		System.out.println(v3);

		c.set(s7, 7);
		Integer v4 = c.get(s2);
		System.out.println(v4);
	}

	static void printLRUCacheBySelf() {
		System.out.println("----------------");
		LRUCacheByself c = new LRUCacheByself(5);
		int s1 = 1;
		int s2 = 2;
		int s3 = 3;
		int s4 = 4;
		int s5 = 5;
		int s6 = 6;
		int s7 = 7;
		c.put(s1, 1);
		c.put(s2, 2);
		c.put(s3, 3);
		c.put(s4, 4);
		c.put(s5, 5);
		c.put(s6, 6);
		Integer v1 = c.get(s6);
		Integer v2 = c.get(s1);
		System.out.println(v1);
		System.out.println(v2);

		c.put(s3, 4);
		Integer v3 = c.get(s3);
		System.out.println(v3);

		c.put(s7, 7);
		Integer v4 = c.get(s2);
		System.out.println(v4);
	}

	static void printLRUCacheBySelf2() {
		System.out.println("----------------");
		LRUCacheByself cache = new LRUCacheByself( 2 /* 缓存容量 */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // 返回  1
		cache.put(3, 3);                        // 该操作会使得关键字 2 作废
		System.out.println(cache.get(2));       // 返回 -1 (未找到)
		cache.put(4, 4);                        // 该操作会使得关键字 1 作废
		System.out.println(cache.get(1));       // 返回 -1 (未找到)
		System.out.println(cache.get(3));       // 返回  3
		System.out.println(cache.get(4));       // 返回  4
	}
	
	public static void main(String[] args) {
		printLRUCache();
		printLRUCacheBySelf();
		printLRUCacheBySelf2();
	}
}
