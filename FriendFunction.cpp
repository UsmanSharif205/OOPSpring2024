#include<iostream>
using namespace std;
class Y;
class X{


int a;
public:
	void setdata(int num){
		a=num;
	}
	friend add(X a1, Y a2);
};
	class Y{
		
	int b;
	public:
	
	int setvalue(int data){
		b=data;
	  }
	   friend add(X a1, Y a2);
	};
	
	int add(X a1, Y a2){
	
	cout<<"the values are now "<<a1.a + a2.b;
}

	int main(){
   X p1;
   p1.setdata(2);
	
	 Y p2;
	 p2.setvalue(3);
	 add(p1,p2);
	return 0;			
	}
	
