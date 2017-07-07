public class Solution<K, V> {
  // limit is the max capacity of the cache
  static class Node<K, V> {
    K key;
    V val;
    Node<K, V> pre;
    Node<K, V> next;
    public Node (K key, V val) {
      this.key = key;
      this.val = val;
    }
  }
  private final int limit;
  private Node<K, V> head;
  private Node<K, V> tail;
  Map<K, Node<K, V>> map;
  
  public Solution(int limit) {
    this.limit = limit;
    map = new HashMap<>();
  }
  
  public void set(K key, V value) {
    Node<K, V> cur = map.get(key);
    if (cur != null) {
      cur.val = value;
      remove(cur);
      append(cur);
    } else {
      cur = new Node<K, V> (key, value);
      if (map.size() == limit) {
        remove(tail);
      }
      append(cur);
    }
  }
  
  public V get(K key) {
    Node<K, V> cur = map.get(key);
    if (cur == null) {
      return null;
    }
    remove(cur);
    append(cur);
    return cur.val;
  }
  
  private Node<K, V> remove (Node<K, V>  node) {
    map.remove(node.key);
    if (node == head && node == tail) {
      head = null;
      tail = null;
      return node;
    }
    if (node == head) {
      head = head.next;
      node.next = null;
      return node;
    }
    if (node == tail) {
      tail = tail.pre;
      node.pre = null;
      return node;
    }
    node.pre.next = node.next;
    node.next.pre = node.pre;
    node.next = null;
    node.pre = null;
    return node;
  }
  
  private Node<K, V> append (Node<K, V> node) {
    map.put(node.key, node);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.pre = node;
      head = node;
    }
    return node;
  }
}