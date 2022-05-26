#include<iostream>
#include<string.h>
using namespace std;

#define MAX 1000
class Stack{
	
	int top;
	
public:
	int a[MAX];
	
	Stack()
	{
		top = -1;
	}
	
	bool push(int x){
		if(top >= MAX-1)
		{
			cout << "Stack Overflow\n";
			return false;
		}
		else
		{
			top++;
			a[top] = x;
			// cout << x << " pushed successfully.\n";
			return true;
		}
	}
	
	int pop() {
		if(top < 0)
		{
			cout << "Stack Underflow.\n";
			return 0;
		}
		else
		{
			// cout << a[top] << " will be popped.\n";
			top--;
			return a[top];
		}
	}
	
	int peek(){
		if(top < 0)
		{
			cout << "Stack Underflow.\n";
			return 0;
		}
		else
			return a[top];
	}
	
	bool isEmpty()
	{
		if(top < 0)
			return true;
		else return false;
	}
	
	void display()
	{
		for(int i = top; i >= 0; --i)
			cout << a[i] << " ";
		cout << endl;
	}
	
};		

Stack obj;

void ParenthesisBalanced(){
	string s;
	cin >> s;
	bool flag = true;
	cout << "Checking if " << s << " is balanced or not." << endl;
	for(int i = 0; s[i] != '\0'; ++i)
	{
		
		if(s[i] == '[')
			obj.push(1);
		else
			if(s[i] == ']')
			{
				if(obj.peek() == 1)
					obj.pop();
				else
				{
					flag = false;
					break;
				}
			}
			
		if(s[i] == '{')
			obj.push(2);
		else
			if(s[i] == '}')
			{
				if(obj.peek() == 2)
					obj.pop();
				else
				{
					flag = false;
					break;
				}
			}
			
		if(s[i] == '(')
			obj.push(3);
		else
			if(s[i] == ')')
			{
				if(obj.peek() == 3)
					obj.pop();
				else
				{
					flag = false;
					break;
				}
			}	
	}
	if(!obj.isEmpty())
		flag = false;
	if(flag)
			cout << "Balanced.\n";
	else
		cout << "Not Balanced.\n";
}
		
int main(){

	ParenthesisBalanced();		
	return 0;
}