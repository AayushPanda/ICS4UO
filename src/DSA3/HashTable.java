package DSA3;

import java.util.Arrays;
import java.lang.Math;

public class HashTable {

    /**
     * Represents an entry in the hash table, consisting of a key and a value.
     */
    protected class Entry {
        protected Object key;
        protected Object value;

        /**
         * Constructs a new Entry with the given key and value.
         *
         * @param key   The key of the entry.
         * @param value The value associated with the key.
         */
        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Returns a string representation of the entry.
         *
         * @return A string representation of the entry.
         */
        public String toString() {
            return key + ": " + value;
        }
    }

    private int size = 1;
    protected Entry[] table = new Entry[size];

    /**
     * Default constructor for HashTable with a default size of 1.
     */
    public HashTable() {}

    /**
     * Constructs a HashTable with the specified size.
     *
     * @param size The size of the hash table.
     */
    public HashTable(int size) {
        this.size = size;
        table = new Entry[size];
    }

    /**
     * Adds a key-value pair to the hash table.
     *
     * @param key   The key of the entry.
     * @param value The value associated with the key.
     */
    public void put(Object key, Object value) {
        int start = hashFunction(key.hashCode() - 1);
        int index = hashFunction(key.hashCode());

        // Check if the key already exists and update its value
        if (getIndex(key) != -1) {
            table[getIndex(key)] = new Entry(key, value);
            return;
        }

        // Handle collisions by linear probing
        while (table[index] != null) {
            index = hashFunction(index + 1);
            if (index == start) {
                // If the table is full, double its size and rehash
                table = Arrays.copyOf(table, table.length * 2);
                rehash();
                index = hashFunction(key.hashCode());
            }
        }
        table[index] = new Entry(key, value);
    }

    /**
     * Retrieves the index of a key in the hash table.
     *
     * @param key The key to search for.
     * @return The index of the key, or -1 if not found.
     */
    public int getIndex(Object key) {
        int start = hashFunction(key.hashCode() - 1);
        int index = hashFunction(key.hashCode());
        if (table[start] != null && table[start].key.equals(key)) {
            return start;
        }
        while (index != start) {
            if (table[index] != null && table[index].key.equals(key)) {
                return index;
            }
            index = hashFunction(index + 1);
        }
        return -1;
    }

    /**
     * Removes a key-value pair from the hash table.
     *
     * @param key The key to remove.
     */
    public void remove(Object key) {
        int start = hashFunction(key.hashCode() - 1);
        int index = hashFunction(key.hashCode());
        if (table[start] != null && table[start].key.equals(key)) {
            table[start] = null;
        }
        while (index != start) {
            if (table[index] != null && table[index].key.equals(key)) {
                table[index] = null;
                break;
            }
            index = hashFunction(index + 1);
        }
        rehash();
    }

    /**
     * Retrieves the value associated with a key from the hash table.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if not found.
     */
    public Object get(Object key) {
        int start = hashFunction(key.hashCode() - 1);
        int index = hashFunction(key.hashCode());
        if (table[start] != null && table[start].key.equals(key)) {
            return table[start].value;
        }
        while (index != start) {
            if (table[index] != null && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = hashFunction(index + 1);
        }
        return null;
    }

    /**
     * Counts the number of non-null entries in the hash table.
     *
     * @return The count of non-null entries.
     */
    protected int countNonNull() {
        return countNonNull(table);
    }

    /**
     * Counts the number of non-null entries in the given array.
     *
     * @param array The array to count non-null entries from.
     * @return The count of non-null entries.
     */
    protected static int countNonNull(Object[] array) {
        int count = 0;
        for (Object object : array) {
            if (object != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Rehashes the hash table to maintain a proper load factor.
     */
    protected void rehash() {
        if (countNonNull() < size / 2) {
            shrink();
        }

        size = table.length;
        Entry[] temp = new Entry[size];
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                temp[i] = table[i];
            }
        }
        table = temp;
        size = table.length;
    }

    /**
     * Shrinks the hash table by removing null entries.
     */
    protected void shrink() {
        int newSize = countNonNull();
        Entry[] temp = new Entry[newSize];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                temp[index] = table[i];
                index++;
            }
        }
        table = temp;
        size = table.length;
    }

    /**
     * Computes the hash function for a given hash code.
     *
     * @param hashCode The hash code to compute the hash function from.
     * @return The hash function result.
     */
    protected int hashFunction(int hashCode) {
        return Math.abs(hashCode % table.length);
    }

    /**
     * Returns a string representation of the hash table.
     *
     * @return A string representation of the hash table.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Entry entry : table) {
            sb.append(entry == null ? "" : entry.key + ": " + entry.value + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns the size of the hash table.
     *
     * @return The size of the hash table.
     */
    public int size() {
        return size;
    }

    /**
     * Returns an array of keys in the hash table.
     *
     * @return An array of keys.
     */
    public Object[] keys() {
        Object[] keys = new Object[countNonNull()];
        int index = 0;
        for (Entry entry : table) {
            if (entry != null) {
                keys[index] = entry.key;
                index++;
            }
        }
        return keys;
    }

    /**
     * Returns an array of values in the hash table.
     *
     * @return An array of values.
     */
    public Object[] values() {
        Object[] values = new Object[countNonNull()];
        int index = 0;
        for (Entry entry : table) {
            if (entry != null) {
                values[index] = entry.value;
                index++;
            }
        }
        return values;
    }

    /**
     * The main method for self-testing the HashTable implementation.
     */
    public static void main(String[] args) {
        // Try adding duplicate keys
        HashTable table = new HashTable();
        table.put("a", 1);
        table.put("b", 2);
        table.put("c", 3);
        table.put("d", 4);
        table.put("a", 5);
        System.out.println(table);
        System.out.println(table.get("a"));
    }
}