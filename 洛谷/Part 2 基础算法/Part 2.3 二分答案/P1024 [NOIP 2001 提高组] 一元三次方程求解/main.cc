#include "bits/stdc++.h"
using namespace std;
int main(){
    double a,b,c,d;
    cin>>a>>b>>c>>d;
    for(double i=-100.00;i<100.00;i+=0.001){
        double val1 = a*i*i*i+b*i*i+c*i+d;
        if(fabs(val1)<=0.000001){
            printf("%.2lf ",i);
        }
    }
    return 0;
}