#include <iostream>
#include <stack>
#include <vector>
using namespace std;

/* A special stack having peek() pop() and
* push() along with additional getMin() that
* returns minimum value in a stack without
* using extra space and all operations in O(1)
* time.. ???? */
class SpecialStack
{
	
	// Sentinel value for min
	int min = -1;
	
	// DEMO_VALUE
	static const int demoVal = 9999;
	stack<int> st;

public:

	void getMin()
	{
		cout << "min is: " << min << endl;
	}

	void push(int val)
	{
		
		// If stack is empty OR current element
		// is less than min, update min.
		if (st.empty() || val < min)
		{
			min = val;
		}
		
		// Encode the current value with
		// demoVal, combine with min and
		// insert into stack
		st.push(val * demoVal + min);
	}

	int pop()
	{	
		// if stack is empty return -1;
		if ( st.empty() ) {
		cout << "stack underflow" << endl ;
		return -1;
		}
		
		int val = st.top();
		st.pop();
		
		// If stack is empty, there would
		// be no min value present, so
		// make min as -1
		if (!st.empty())
			min = st.top() % demoVal;
		else
			min = -1;
		
		// Decode actual value from
		// encoded value
		return val / demoVal;
	}

	int peek()
	{
		
		// Decode actual value
		// from encoded value
		return st.top() / demoVal;
	}
};

// Driver Code
int main()
{
	SpecialStack s;
	cout << "Enter the number of elements you want to push :";
	int n;
	cin >> n;

	int count = 0;
	for(int i = 0; i < n; i++)
	{
		int p;
		cin >> p; 
		s.push(p);
		count++;
	}
	
	cout << endl;
	s.getMin();
	return 0;
}

