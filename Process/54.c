#include<stdio.h>
#include<semaphore.h>
#include<pthread.h>
#include<unistd.h>

#define buffer_size 5

int buffer[buffer_size];
int in=0,out=0;
sem_t empty,full,mutex;
void* producer(void* arg)
{
    int item;
    for(int i=0;i<10;i++)
    {
        item=i+1;
        sem_wait(&empty);
        sem_wait(&mutex);
        buffer[in]=item;
        printf("Producer produces %d item",item);
        in=(in+1)%buffer_size;
        sem_post(&mutex);
        sem_post(&full);
        sleep(1);

    }
    pthread_exit(NULL);

}
void* consumer(void* arg)
{
    int item;
    for(int i=0;i<10;i++)
    {
        sem_wait(&full);
        sem_wait(&mutex);
        item=buffer[out];
        printf("consumer consumed %d item",item);
        out=(out+1)%buffer_size;
        sem_post(&mutex);
        sem_post(&empty);
        sleep(1);
    }
    pthread_exit(NULL);
}
int main()
{
    pthread_t p,c;
    sem_init(&empty,0,buffer_size);
    sem_init(&full,0,0);
    sem_init(&mutex,0,1);
    pthread_create(&p,NULL,producer,NULL);
    pthread_create(&c,NULL,consumer,NULL);
    pthread_join(p,NULL);
    pthread_join(c,NULL);
    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&mutex);
}