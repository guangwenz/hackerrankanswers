#include<stdio.h>

// https://www.hackerrank.com/challenges/maxsubarray/problem
void printc(int c[], int n) {
	for(int i=0;i<n;i++) {
		printf("%d\n", c[i]);
	}
}

int max(int c[], int n, int start) {
	int largest = 0;
	if(start < n) {
		int sum = 0;
		int i=start;
		while(i<n) {
			sum = sum + c[i];
			if(sum > largest) largest = sum;
			i++;
		}
	}
	return largest;
}
int maxc(int c[], int n) {
	int lastMax = 0;
	for(int i=0;i<n;i++) {
		int ret = max(c,n,i);
		if(ret > lastMax) lastMax = ret;
	}
	return lastMax;
}
int main(int argc, char const *argv[])
{
	/* code */
	int q;
	scanf("%d", &q);
	int i;
	for(i=0;i<q;i++) {
		int n;
		scanf("%d", &n);
		int c[n];
		int j;
		for(j=0;j<n;j++) {
			scanf("%d", &c[j]);
		}
		printf("%d\n",maxc(c, n));
	}
	return 0;
}