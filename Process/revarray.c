#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#define max 100
int arr[max],n;
sem_t sem;
void* inputarray(void* arg)
{
    printf("Enter the size of array: ");
    scanf("%d",&n);
    
    printf("Enter the elements of the array: ");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    sem_post(&sem);
    pthread_exit(NULL);
}
void* revArray(void* arg)
{
    sem_wait(&sem);
    printf("The reveresed array is: ");
    for(int i=n-1;i>=0;i--)
    {
        printf("%d",arr[i]);
    }
    pthread_exit(NULL);
}
int main()
{
    pthread_t t1,t2;
    sem_init(&sem,0,0);
    pthread_create(&t1,NULL,inputarray,NULL);
    pthread_create(&t2,NULL,revArray,NULL);
    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    sem_destroy(&sem);

}