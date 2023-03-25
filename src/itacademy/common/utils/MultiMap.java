package itacademy.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMap<K, V> {

  private final Map<K, List<V>> map = new HashMap<>();

  public void put(K key, V value) {
    map.computeIfAbsent(
      key, 
      k -> new ArrayList<>()
    ).add(value);
  }

  public List<V> get(K key) {
    return map.getOrDefault(key, Collections.emptyList());
  }

  public Set<K> keySet() {
    return map.keySet();
  }

  public boolean containsKey(K key) {
    return map.containsKey(key);
  }

  public boolean containsValue(V value) {
    return map.values().stream().anyMatch(list -> list.contains(value));
  }

  public int size() {
    return map.values().stream().mapToInt(List::size).sum();
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  @Override
  public String toString() {
    return map.toString();
  }
}