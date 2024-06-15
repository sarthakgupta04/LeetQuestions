class T {
  public int pro;
  public int cap;
  public T(int pro, int cap) {
    this.pro = pro;
    this.cap = cap;
  }
}

class Solution {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    Queue<T> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.cap, b.cap));
    Queue<T> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.pro, a.pro));

    for (int i = 0; i < Profits.length; ++i)
      minHeap.offer(new T(Profits[i], Capital[i]));

    while (k > 0) {
      while (!minHeap.isEmpty() && minHeap.peek().cap <= W) {
        maxHeap.offer(minHeap.poll());
      }

      if (maxHeap.isEmpty()) break;
      W += maxHeap.poll().pro;
      k--;
    }

    return W;
  }
}
