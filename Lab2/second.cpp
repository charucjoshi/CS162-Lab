#include<iostream>
using namespace std;

#define MAX 1000

class stack{
public:
	int top;
	char a[MAX];
	
	stack(){ top = -1;}
	
	bool isEmpty(){
		if(top < 0) return true;
		else return false;
	}
	
	bool push(char x)
	{
		if(top == MAX-1) return false;
		else
		{
			a[++top] = x;
			return true;
		}
	}
	
	char pop(){
		if(top < 0)
		{
			cout << "Stack Underflow";
			return '\0';
		}
		else
			return a[top--];
	}
	
	char peek(){
		
		if(top < 0)
		{
			cout <<"Stack Underflow.";
			return '\0';
		}
		else
			return a[top];
	}
}st;

int precedence(char c)
{
	if(c == '^')
		return 3;
	else
		if(c == '/' || c == '*')
			return 2;
		else
			if(c == '+' || c == '-')
				return 1;
}

void postfix(string infix)
{
	string pf;
	char c;
	for(int i = 0; i < infix.length(); ++i)
	{
		c = infix[i];
		if((c >= 'a' && c <='z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
			pf += c;
		else
		if(c == '(')
			st.push('(');
		else
		if(c == ')')
		{
			while(st.peek() != '(')
			{
				pf += st.peek();
				st.pop();
			}	
			st.pop();
		}
		
		else{
			while(!st.isEmpty() && precedence(infix[i] <= st.peek()))
				if(c == '^' && st.peek() == '^')
					break;
				else
			{
				pf += st.peek();
				st.pop();
			}
			st.push(c);
		}
	}
	
	while(!st.isEmpty())
		{pf += st.peek();
	st.pop();}
	
	cout << pf << endl;
}


int main(){
	
	string infix;
	cin >> infix;
	postfix(infix);
	return 0;
}