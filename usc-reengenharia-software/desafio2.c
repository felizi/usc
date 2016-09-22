/* Desafio 2. Descreva a melhoria do algoritmo abaixo com base no algoritmo do Desafio 1. */
#include <stdio.h>

int main(void) {
	int i, nb, count, test;
	test = count = 0; // true
	printf("Enter a integer number: ");
	if(scanf("%d", &nb) != 1)
		return -1;

	if(nb % 2 == 0){
		test = 1;
	} else { 
		for(i = 3; i < nb; i++, count++)
			if(nb % i == 0)
				test = 1; // false
	}
	if(!test)
		printf("%d. Ok, it is a prime number. Iteration count = %d\n", nb, count);
	else
		printf("%d. it is not a prime number. Iteration count = %d\n", nb, count);

	return 0;
}