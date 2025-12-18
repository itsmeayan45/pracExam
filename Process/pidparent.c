#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
int main()
{
    pid_t pid;
    pid=fork();
    if(pid<0)
    {
        printf("fork failed");
    }
    if(pid==0)
    {
        printf("the child process id is: %d",getpid());
        printf("the child process's parent id is: %d", getppid());

    }
    else
    {
        printf("The parent process id is: %d",getpid());
        printf("The parent process's child process id is: %d",pid);
    }
}