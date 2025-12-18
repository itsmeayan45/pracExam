#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>

int isPrime(int num)
{
    if(num<0)
        return 0;
    for(int i=2;i*i<num;i++)
    {
        if(num%i==0)
            return 0;
    }
    return 1;
}
int main()
{
    int num;
    int fd[2];
    pid_t pid;
    
    if(pipe(fd)==-1)
    {
        printf("Pipe creation failed");
        return 1;
    }
    pid = fork();
    if(pid<0)
    {
        printf("fork creation failed");
    }
    if(pid>0)
    {
        close(fd[0]);
        printf("Enter the number ");
        scanf("%d",&num);
        write(fd[1],&num,sizeof(num));
        close(fd[1]);
    }
    else
    {
        close(fd[1]);
        read(fd[0],&num,sizeof(num));
        close(fd[0]);
        printf("factors are: ");
        for(int i=0;i<num;i++)
        {
            if(isPrime(i))
            {
                printf("%d",i);
            }
            printf("\n");
        }
    }
}