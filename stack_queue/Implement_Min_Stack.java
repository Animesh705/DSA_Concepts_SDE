package stack_queue;
import java.util.*;
public class Implement_Min_Stack {
        // Normal stack to store values (sometimes modified values)
        private Stack<Integer> st;

        // Variable to store current minimum element
        private int mini;

        // Empty Constructor
        public Implement_Min_Stack() {
            st = new Stack<>();
        }

        // Method to push a value in stack
        public void push(int value) {

            // Case 1: Stack is empty
            if (st.isEmpty()) {

                // First element is always the minimum
                mini = value;

                // Push value directly
                st.push(value);
                return;
            }

            // Case 2: New value is greater than current minimum
            if (value > mini) {

                // Normal push, no trick needed
                st.push(value);

            } else {
            /*
             Case 3: New value is smaller or equal to current minimum

             Trick:
             Push a MODIFIED value instead of real value
             modifiedValue = 2*value - mini

             Why?
             - This modified value will always be < new mini
             - It helps us detect during pop that min has changed
            */
                st.push(2 * value - mini);

                // Update minimum to new value
                mini = value;
            }
        }

        // Method to pop a value from stack
        public void pop() {

            // Base case: empty stack
            if (st.isEmpty()) return;

            // Pop the top element
            int x = st.pop();

        /*
         If popped value is less than current minimum,
         it means this was a MODIFIED value
         and minimum was updated when it was pushed
        */
            if (x < mini) {

            /*
             Restore previous minimum using formula:
             previousMin = 2*currentMin - modifiedValue
            */
                mini = 2 * mini - x;
            }
        }

        // Method to get the top of stack
        public int top() {

            // Base case
            if (st.isEmpty()) return -1;

            int x = st.peek();

        /*
         If top is greater than minimum,
         then it is a normal value
        */
            if (x > mini) return x;

        /*
         Otherwise, top is a modified value
         Real top value is actually mini
        */
            return mini;
        }

        // Method to get the minimum in stack
        public int getMin() {

            // Minimum is always stored in 'mini'
            return mini;
        }
        public static void main(String[] args) {

            Implement_Min_Stack s = new Implement_Min_Stack();

            // Push elements
            s.push(-2);
            s.push(0);
            s.push(-3);

            // Minimum so far
            System.out.print(s.getMin() + " "); // -3

            // Pop top (-3)
            s.pop();

            // Top element
            System.out.print(s.top() + " ");    // 0

            // Pop top (0)
            s.pop();

            // Minimum now
            System.out.print(s.getMin());        // -2
        }
    }

