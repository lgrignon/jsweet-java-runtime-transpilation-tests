package test;

import javaoverride.lang.System;

import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.js.Globals.undefined;
import static javaoverride.util.Arrays.asList;
import static jsweet.util.Lang.any;

import def.dom.HTMLElement;
import javaemul.internal.CharSequenceHelper;
import javaoverride.io.ByteArrayInputStream;
import javaoverride.io.IOException;
import javaoverride.text.Collator;
import javaoverride.lang.StringBuilder;
import javaoverride.util.ArrayList;
import javaoverride.util.Arrays;
import javaoverride.util.BitSet;
import javaoverride.util.Collections;
import javaoverride.util.Comparator;
import javaoverride.util.HashMap;
import javaoverride.util.HashSet;
import javaoverride.util.Iterator;
import javaoverride.util.List;
import javaoverride.util.Map;
import javaoverride.util.Scanner;
import javaoverride.util.Set;
import javaoverride.util.stream.Collectors;
import javaoverride.util.stream.Stream;

enum MyEnum {
	A, B, C;
}

enum MyComplexEnum {
	A, B, C;
	public String aFunction() {
		return "test";
	}
}

public class Test {

	public static void main(String[] args) {
		System.out.println(asList("a", "b", "c"));
		test();
	}

	public static void assertEquals(Object o1, Object o2) {
		if (!(o1 == o2)) {
			throw new Error("invalid assertion: " + o1 + "!=" + o2);
		}
	}

	public static void assertTrue(boolean b) {
		if (!b) {
			throw new Error("invalid assertion");
		}
	}

	public static void assertFalse(boolean b) {
		if (b) {
			throw new Error("invalid assertion");
		}
	}

	public static void test() {
		try {
			testArrays();
			testList();
			testMap();
			testSet();
			testString();
			testIO();
			testEnums();
			testStreams();

			console.info("OS NAME: " + System.getProperty("os.name"));
			console.info("Get input: ");
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNextLine()) {
				console.info("Got input: " + scanner.nextLine());
			} else {
				console.info("No any input :(");
			}

			if (System.ENVIRONMENT_IS_WEB) {
				HTMLElement result = document.getElementById("result");
				if (result != null) {
					result.innerHTML = "Success!";
				}
			} else {
				console.info("Success!");
			}
		} catch (Exception e) {
			console.error(e);
			if (System.ENVIRONMENT_IS_WEB) {
				HTMLElement result = document.getElementById("result");
				if (result != null) {
					result.innerHTML = "Failure: " + e.getMessage();
				}
			} else {
				console.info("Failure: " + e.getMessage());
			}
		}
	}

	public static int comp1(Comparable<MyComplexEnum> e) {
		return e.compareTo(MyComplexEnum.A);
	}

	public static int comp2(Comparable<MyEnum> e) {
		// this does not work with simple enums because we cannot infer it is an
		// enum
		return e.compareTo(MyEnum.A);
	}

	public static void testEnums() {
		console.info("testing enums");
		assertEquals(1, MyEnum.B);
		assertEquals("A", MyEnum.A.name());
		assertEquals("A", MyComplexEnum.A.name());
		assertEquals(0, MyEnum.A.compareTo(MyEnum.A));
		assertEquals(MyEnum.B, MyEnum.values()[1]);
		assertEquals(0, comp1(MyComplexEnum.A));
		// assertEquals(0, comp2(MyEnum.A));
		// EnumSet.of(MyEnum.A);
		console.info("end testing enums");
	}

	public static void testArrays() {
		console.info("testing arrays");
		String[] srcArray = { "a", "b", "c" };
		String[] dstArray = new String[srcArray.length - 1];
		java.lang.System.arraycopy(srcArray, 1, dstArray, 0, srcArray.length - 1);
		assertEquals(2, dstArray.length);
		assertEquals("b", dstArray[0]);
		assertEquals("c", dstArray[1]);
		int[] myArray = { 3, 2, 1 };
		assertEquals(3, myArray[0]);
		Arrays.sort(myArray);
		assertEquals(1, myArray[0]);

		List<String> l = asList("a", "b", "c", "d");

		assertEquals(4, l.size());

		// TODO: fix type exception
		String[] a = any(Arrays.copyOf(l.toArray(new String[0]), 3));

		assertEquals(3, a.length);

		Comparator<String> reverse = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};

		Arrays.sort(a, reverse);
		// TODO: fix varargs
		assertEquals("[c, b, a]", asList(a[0], a[1], a[2]).toString());

		console.info("end testing arrays");
	}

	public static void testList() {
		console.info("testing lists");
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		assertEquals(l.toString(), "[a, b, c]");
		assertEquals(l.subList(1, 3).toString(), "[b, c]");
		assertEquals(l.remove("b"), true);
		assertEquals(l.remove("d"), false);
		assertEquals(l.remove(1), "c");
		l.add("c");
		// l.remove("b");
		assertEquals(l.toString(), "[a, c]");
		assertEquals(l.size(), 2);
		assertEquals(l.get(1), "c");
		assertEquals(l.indexOf("a"), 0);
		String res = "";
		for (String s : l) {
			res += s;
		}
		assertEquals("ac", res);
		java.util.Iterator<String> it = l.iterator();
		assertTrue(it.hasNext());
		assertEquals("a", it.next());
		assertTrue(it.hasNext());
		assertEquals("c", it.next());
		assertFalse(it.hasNext());

		l.clear();
		l.add("bb");
		l.add("aa");
		assertEquals(l.toString(), "[bb, aa]");
		Collections.sort(l, Collator.getInstance());
		assertEquals(l.toString(), "[aa, bb]");

		console.info("end testing lists");
	}

	public static void testSet() {
		console.info("testing sets");
		Set<String> s = new HashSet<String>();
		s.add("a");
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("c");
		assertEquals(s.toString(), "[a, b, c]");
		s.remove("b");
		assertTrue(s.contains("a"));
		assertTrue(s.contains("c"));
		assertFalse(s.contains("b"));
		assertEquals(s.size(), 2);
		// BitSet
		console.info("testing bit sets");
		BitSet bs = BitSet.valueOf(new long[] { 255 });
		assertTrue(bs.get(0));
		assertTrue(bs.get(1));
		assertTrue(bs.get(7));
		assertFalse(bs.get(8));
		BitSet bs2 = BitSet.valueOf(new long[] { 1 });
		assertTrue(bs2.get(0));
		assertFalse(bs2.get(1));
		bs.and(bs2);
		assertTrue(bs.get(0));
		assertFalse(bs.get(1));
		console.info("end testing sets");
	}

	public static void testMap() {
		console.info("testing maps");
		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "aa");
		m.put("b", "bb");
		m.put("c", "cc");
		assertEquals(m.size(), 3);
		assertEquals("bb", m.get("b"));
		m.remove("aa");
		assertEquals(m.size(), 3);
		m.remove("a");
		assertEquals(m.size(), 2);
		assertEquals(null, m.get("undefinedKey"));
		assertFalse(m.get("undefinedKey") == undefined);

		Map<MyKey, String> m2 = new HashMap<>();

		m2.put(key1(), "a");
		m2.put(new MyKey("2"), "b");

		assertEquals(2, m2.size());
		assertEquals("a", m2.get(new MyKey("1")));

		assertTrue(m2.containsKey(new MyKey("2")));

		assertEquals("[1, 2]", m2.keySet().toString());
		assertEquals("[a, b]", m2.values().toString());

		m2.remove(new MyKey("1"));

		assertEquals(1, m2.size());
		assertEquals(null, m2.get(new MyKey("1")));
		assertEquals(null, Collections.singletonMap(key1(), "1").get(new MyKey("a")));
		assertEquals("1", Collections.singletonMap(key2(), "1").get(new MyKey("a")));
		assertEquals("2", Collections.singletonMap(new MyKey("b"), "2").get(new MyKey("b")));

		console.info("end testing maps");
	}

	public static void testString() {
		console.info("testing strings");
		StringBuilder sb = new StringBuilder();
		sb.append(true);
		sb.append('c');
		sb.append("test");
		sb.deleteCharAt(sb.length() - 1);
		assertEquals("truectes", sb.toString());
		sb.append(CharSequenceHelper.castToOverride("abc"), 0, 1);
		assertEquals("truectesa", sb.toString());
		StringBuffer sb2 = new StringBuffer();
		sb2.append(true);
		sb2.append('c');
		sb2.append("test");
		sb2.deleteCharAt(sb2.length() - 1);
		assertEquals("truectes", sb2.toString());
		assertEquals('a', Character.toLowerCase('A'));
		assertEquals("abc", "ABC".toLowerCase());
		console.info("end testing strings");
	}

	public static void testIO() throws IOException {
		console.info("testing io");
		ByteArrayInputStream s = new ByteArrayInputStream("abc".getBytes());
		assertEquals(Character.getNumericValue('a'), s.read());
		console.info("end testing io");
	}

	public static void testStreams() {
		console.info("testing streams");
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		assertEquals(l.stream().collect(Collectors.toList()).toString(), "[a, b, c]");
		assertEquals(l.stream().filter(e -> e.equals("a")).collect(Collectors.toList()).toString(), "[a]");

		Stream<String[]> str = Stream
				.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "G", "Geeks" } });
		Map<String, String> map = str.collect(Collectors.toMap(p -> p[0], p -> p[1]));
		assertEquals(map.size(), 3);
		assertEquals(map.get("g"), "geeks");
		console.info("end testing streams");
	}

	static MyKey key1() {
		return new MyKey("1");
	}

	static MyKey key2() {
		return new MyKey("a");
	}

}

class MyKey {
	String data;

	public MyKey(String data) {
		this.data = data;
	}

	public String toString() {
		return data;
	}

	@Override
	public boolean equals(Object obj) {
		return data.equals(((MyKey) obj).data);
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}
}
