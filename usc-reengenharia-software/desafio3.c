/* Desafio 3. Descreva a melhora do algoritmo abaixo corn base no algoritmo do desafio 2. */ 
#include <stdio.h>
#include <math.h> 
int main (void) { 
	int i, nb, count, test, limit;
	test = count = 0; 

	printf ("Enter a integer number : "); 
	if (scanf ("%d", &nb) != 1) 
		return -1; 

	limit = sqrt(nb) + 1; 

	if (nb%2==0) test = 1; 
	else { 
		for (i = 3 ; i < limit; i+=2, count++) 
			if (nb%i ==0) test = 1; 
	} 

	if (!test) 
		printf ("%d . Ok, it is. Iteration count = %d\n", nb, count); 
	else 
		printf ("%d . it is not. Iteration count = %d\n",nb, count); 

	return 0; 
}
