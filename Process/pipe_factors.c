#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>

int main()
{
    int fd[2];
    pid_t pid;
    int number;
    if(pipe(fd)==-1)
    {
        printf("Pipe creation failed");
    }
    pid=fork();
    if(pid<0)
    {
        printf("fork failed");
    }
    if(pid>0)
    {
        close(fd[0]); // reading side bondho
        printf("Enter a number: ");
        scanf("%d",&number);
        write(fd[1],&number,sizeof(number));
        close(fd[1]);
    }
    else
    {
        close(fd[1]); // writing side bondho
        read(fd[0],&number,sizeof(number));
        close(fd[0]);
        printf("Child:factors are: ");
        for(int i=0;i<=number;i++)
        {
            if(number%i==0)
            {
                printf("%d",i);
            }
            printf("\n");
        }

    }

}