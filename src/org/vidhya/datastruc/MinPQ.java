package org.vidhya.datastruc;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MinPQ<Key> implements Iterable<Key> {
	
	private Key[] pq;
	private int N;
	private Comparator<Key> comp;
	
	public MinPQ() {
		this(1);
	}
	public MinPQ(int initCapacity) {
		pq = (Key[]) new Object[initCapacity+1];
		N = 0;
	}
	public MinPQ(Comparator<Key> comparator) {
		this(1);
		this.comp = comparator;
	}
	
	public MinPQ(int initCapacity, Comparator<Key> comparator) {
		this(initCapacity);
		this.comp = comparator;
	}
	
	
	private void resize(int capacity) {
        assert capacity > N;
		Key[] n_pq = (Key[]) new Object[capacity];
		for (int i = 1; i <= N; i++) {
			n_pq[i] = pq[i];
		}
		pq = n_pq;
	}
	
	private void swap(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;		
	}
	
	private boolean greater(Key k1, Key k2) {
		if (comp == null) {
			return (((Comparable<Key>) k1).compareTo((Key) k2) > 0);
		}else {
			return (comp.compare(k1, k2) > 0);			
		}		
	}
	
	
	private void swim(int n){
		int k = n;
		while (k > 1 && greater(pq[k/2], pq[k])) {
			swap(k, k/2);
			k = k/2;			
		}
	}
	
	private void sink(int n) {
		int k;
		while(2*n <= N) {
			k = 2*n;
			if (k < N && greater(pq[k], pq[k+1])) {
				k++;
			}
			if (greater(pq[k], pq[n]))
				break;
			swap(n, k);
			n = k;			
		}		
	}
	
	public boolean isEmpty() {
		return N==0; 
	}
	public void add(Key k) {
		if (N == pq.length-1) {
			resize(2*pq.length);
		}
		pq[++N] = k;
		swim(N);	
        assert(isMinHeap());
	}
	
	public Key remove() {
		if (isEmpty()) {
			throw new NoSuchElementException("PQ underflow");
		}
		// take note of order of operations. 
		swap(1, N);
		Key minKey = pq[N--];
		sink(1);
		pq[N+1] = null;
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length  / 2);
        assert(isMinHeap());
		return minKey;
	}
	
	public Key element() {
		if (isEmpty()) {
			throw new NoSuchElementException("PQ underflow");
		}
		return pq[1];
	}
	
	public int size() {
		return N;
	}
	
    // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > N) return true;
        int left = 2*k, right = 2*k + 1;
        if (left  <= N && greater(pq[k], pq[left]))  return false;
        if (right <= N && greater(pq[k], pq[right])) return false;
        return isMinHeap(left) && isMinHeap(right);
    }


    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in ascending order.
     * <p>
     * The iterator doesn't implement <tt>remove()</tt> since it's optional.
     *
     * @return an iterator that iterates over the keys in ascending order
     */
    public Iterator<Key> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Key> {
        // create a new pq
        private MinPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comp == null) copy = new MinPQ<Key>(size());
            else                    copy = new MinPQ<Key>(size(), comp);
            for (int i = 1; i <= N; i++)
                copy.add(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.remove();
        }
    }

    /**
     * Unit tests the <tt>MinPQ</tt> data type.
     */
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<Integer>();
        Scanner sc = new Scanner(System.in);
        String item;
        while (sc.hasNextLine()) {
        	item = sc.next();
        	if (item.equals("q")) break;
        	else if (!item.equals("-")) pq.add(Integer.parseInt(item));
            else if (!pq.isEmpty()) System.out.println(pq.remove() + " ");
        }
        System.out.println("(" + pq.size() + " left on pq)");
    }
 
}
