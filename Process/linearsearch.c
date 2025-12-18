#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#define max 100
int arr[max],n,item;
sem_t sem;
void* inputArray(void* arg)
{
    printf("Enter the number of elements of the array: ");
    scanf("%d",&n);
    printf("Enter the array elements: ");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    sem_post(&sem);
    pthread_exit(NULL);

}
void linearSearch(void* arg)
{
    sem_wait(&sem);
    printf("Enter the item you want to search: ");
    scanf("%d",&item);
    for(int i=0;i<n;i++)
    {
        if(arr[i]==item)
        {
            printf("Item Found at %d index",i);
        }
    }
    pthread_exit(NULL);
}
int main()
{
    pthread_t t1,t2;
    sem_init(&sem,0,0);
    pthread_create(&t1,NULL,inputArray,NULL);
    pthread_create(&t2,NULL,linearSearch,NULL);
    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    sem_destroy(&sem);
}