#include <stdio.h>
#ifdef _WIN32
#include <windows.h>
// Use Windows threading and semaphores
#else
#include <pthread.h>
#include <semaphore.h>
#endif
#define max 100
int arr[max], n;
#ifdef _WIN32
HANDLE sem;
#else
sem_t sem;
#endif
int isPrime(int num)
{
    if (num <= 0)
    {
        return 0;
    }
    for (int i = 2; i * i <= num; i++)
    {
            if(num%i==0)
            {
                return 0;
            }
    }
    return 1;
}
void* inputThread(void* arg)
{
    printf("Enter the number of elements: ");
    scanf("%d",&n);
    printf("enter %d integers",n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    sem_post(&sem);
    pthred_exit(NULL);
}
void* primeThread(void* arg)
{
    sem_wait(&sem);
    printf("The prime numbers in the array are: ");
    for(int i=0;i<n;i++)
    {
        if(isPrime(arr[i]))
        {
            printf("%d",arr[i]);
        }
    }
    printf("\n");
    pthread_exit(NULL);

    
}
int main()
{
    pthread_t t1,t2;
    sem_init(&sem,0,0);
    pthread_create(&t1,NULL,inputThread,NULL);
    pthrea_create(&t2,NULL,primeThread,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    sem_destroy(&sem);
    return 0;
}