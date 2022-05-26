#include<iostream>
using namespace std;

int main(){
	string s;
	cin >> s;
	bool flag = false;
	for(int i = 0; i < s.length(); ++i)
	{
		//for []
		if(s[i] == ']')
		{
			s[i] = 'x';
			if(s[i-1] == '[')
			{
				s[i-1] = 'x';
				flag = true;
			}
			else
			if(s[i-1] == 'x')
			{
				int k = i-1;
				while(s[--k] == 'x')
					continue;
				if(s[k] == '[')
				{
					s[k] = 'x';
					flag = true;
				}
				else flag = false;
			}
			else flag = false;
		}
		
		//for {}
		if(s[i] == '}')
		{
			s[i] = 'x';
			if(s[i-1] == '{')
			{
				s[i-1] = 'x';
				flag = true;
			}
			else
			if(s[i-1] == 'x')
			{
				int k = i-1;
				while(s[--k] == 'x')
					continue;
				if(s[k] == '{')
				{
					s[k] = 'x';
					flag = true;
				}
				else flag = false;
			}
			else flag = false;
		}
		
		//for ()
		if(s[i] == ')')
		{
			s[i] = 'x';
			if(s[i-1] == '(')
			{
				s[i-1] = 'x';
				flag = true;
			}
			else
			if(s[i-1] == 'x')
			{
				int k = i-1;
				while(s[--k] == 'x')
					continue;
				if(s[k] == '(')
				{
					s[k] = 'x';
					flag = true;
				}
				else flag = false;
			}
			else flag = false;
		}
	}
	for(int i = 0; i<s.length(); ++i)
		if(s[i] != 'x')
		{
			flag = false;
			break;
		}
	if(flag)	cout <<"BALANACED";
	else	cout<<"NOT BALANCED";
	return 0;
}