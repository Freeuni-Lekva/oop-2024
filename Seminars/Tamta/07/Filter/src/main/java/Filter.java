public interface Filter {
    // Returns total number of objects present.
    int size();
    boolean isPresent(int index);
    void add(int index);
    void remove(int index);
}
