public class BitmaskFilter implements Filter{
    // invariants:
    //       numPresents is sum of ones in presents array
    //       isPresent must return 1 iff presents[index/n]'s index%n bit is one
    // abstract function
    private int[] presents;
    int numPresents;

    public BitmaskFilter() {
        this.presents = new int[4];
        this.numPresents = 0;
    }

    @Override
    public int size() {
        return numPresents;
    }

    @Override
    public boolean isPresent(int index) {
        int n = index / 32;
        int m = index % 32;

        if (n >= presents.length) return false;
        return (presents[n] & (1 << m)) != 0;
    }

    @Override
    public void add(int index) {
        int n = index / 32;
        int m = index % 32;
        if (n >= presents.length) {
            int[] tmp = new int[Math.max(2*presents.length, n + 1)];
            System.arraycopy(presents, 0, tmp,0, presents.length);
            presents = tmp;
        }
        if (isPresent(index)) {
            return;
        }
        numPresents++;
        presents[n] = (presents[n] | (1 << m));
    }

    @Override
    public void remove(int index) {
        int n = index / 32;
        int m = index % 32;
        if (n >= presents.length) return;

        presents[n] = (presents[n] ^ (1 << m));
    }
}
