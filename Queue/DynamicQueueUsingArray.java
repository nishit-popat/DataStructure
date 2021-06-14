/*
    Dynamic queue is different from regular queue in context that regular queue
    is that when size of regular queue is overflowed it cannot add element
    but dynamic queue will double its size and add the element in the case of overflow.
*/

import java.io.*;

public class DynamicQueueUsingArray {

  public static class CustomQueue {
    int[] data;
    int front;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    void display() {
      for(int i = 0; i < size; i++){
        int idx = (front + i) % data.length;
        System.out.print(data[idx] + " ");
      }
      System.out.println();
    }

   
    // only this code will differ from regular queue
    void add(int val) {
      if(size == data.length){
        
        // creating new array of double length
        int ndata[] = new int[2*data.length];
        for(int i=0;i<size;i++){
            int idx = (front + i) % data.length;
            ndata[i] = data[idx];  // add from front in new array
        }

        // now old data is new data
        data = ndata;
        front = 0;

        // add at front + size which is rear index
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
        
      } else {
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      }
    }

    int remove() {
      if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];

        front = (front + 1) % data.length;
        size--;

        return val;
       }
    }

    int peek() {
       if(size == 0){
        System.out.println("Queue underflow");
        return -1;
       } else {
        int val = data[front];
        return val;
       }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    qu.add(10);
	qu.add(20);
	qu.add(30);

	qu.display();

	qu.remove();
	qu.display();

	qu.peek();
	qu.add(40);
	qu.add(50);
	qu.add(60);
	qu.add(70);


	qu.remove();
	qu.display();

	qu.add(80);

	qu.display();

  }
}