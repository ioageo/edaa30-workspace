package map;

import java.util.ArrayList;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	private int capacity;
	private int size;
	final double factor = 0.750;

	public SimpleHashMap() {
		this(16);
	}

	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		this.capacity = capacity;
		table = (Entry<K, V>[]) new Entry[capacity];
		size = 0;
	}

	@Override
	public void show() {
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				System.out.println("Pos: " + i + " inehåller " + table[i].toString());
			} else {
				System.out.println("Pos: " + i + " inehåller " + null);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object arg0) {
		if (size() == 0)
			return null;

		K key;
		try {
			key = (K) arg0;
		} catch (Exception e) {
			return null;
		}
		int k = index(key);

		while (table[k] != null) {
			if (table[k].getKey().equals(key)) {
				return table[k].getValue();
			}
			k = (k + 3) % capacity;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {

		return size() == 0;
	}

	@Override
	public V put(K arg0, V arg1) {
		int pos = index(arg0);
		V value = null;
		while (table[pos] != null) {
			if (table[pos].getKey().equals(arg0)) {
				value = table[pos].getValue();
				table[pos].setValue(arg1);
				break;
			}
			pos = (pos + 3) % capacity;
		}
		if (table[pos] == null) {
			table[pos] = new Entry<K, V>(arg0, arg1);
			size++;
			value = null;
		}
		if ((((float) size()) / ((float) capacity)) >= factor) {
			resize();
		}
		return value;

	}

	@SuppressWarnings("unchecked")
	private void resize() {

		ArrayList<Object> list = new ArrayList<Object>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				list.add(table[i]);
			}
		}
		capacity = capacity * 2;
		size = 0;
		table = (Entry<K, V>[]) new Entry[capacity];

		Entry<K, V> entry;
		for (int i = 0; i < list.size(); i++) {
			entry = (Entry<K, V>) list.get(i);
			put(entry.getKey(), entry.getValue());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object arg0) {
		K key;
		try {
			key = (K) arg0;
		} catch (Exception e) {
			System.err.println("Key whas not mach this Hashtabel");
			return null;
		}
		final int ind = index(key);
		V value = null;
		int i = ind;
		ArrayList<Object> list = new ArrayList<Object>();
		if (table[i] == null) {
		} else {
			
			while (table[i] != null) {
				list.add(table[i]);
				table[i]=null;
				size--;
				i = (i + 3) % capacity;
			}
			Entry<K, V> entry;
			for (int k = 0; k < list.size(); k++) {
				entry = (Entry<K, V>) list.get(k);

				if (!entry.getKey().equals(key)) {
					put(entry.getKey(), entry.getValue());
				}else {
					value=entry.getValue();
				}
				
			}

		}

		return value;
	}

	@Override
	public int size() {

		return size;
	}

	private int index(K key) {

		return Math.abs(key.hashCode() % capacity);
	}

	private Entry<K, V> find(int index, K key) {
		while (table[index].getKey() != key) {
			index = (index + 1) % (capacity - 1);
			if (table[index].getKey() == null) {
				return null;
			}
		}
		return table[index];
	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}

		@Override
		public String toString() {
			return key + " = " + value;
		}
	}

}
