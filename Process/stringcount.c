#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>

int main()
{
    int fd[2];
    pid_t pid;
    char str[100];
    int alphabet=0,digit=0,special=0;
    if(pipe(fd)==-1)
    {
        printf("Pipe creation failed");
        return 1;
    }
    pid=fork();
    if(pid<0)
    {
        printf("Fork creation failed");
        return 1;
    }
    if(pid>0)
    {
        close(fd[0]);
        printf("parent: Enter a string: ");
        fgets(str,sizeof(str),stdin);
        write(fd[1],str,strln(str)+1);
        close(fd[1]);
    }
    else
    {
        close(fd[1]);
        read(fd[0],str,sizeof(str));
        close(fd[0]);
        for(int i=0;str[i]!='\0';i++)
        {
            if(isalpha(str[i]))
                alphabet++;
            else if(isdigit(str[i]))
                digit++;
            else if(str[i]=='#'||str[i]=='&')
                special++;
        }
        printf("\nChild Process Analysis:\n");
        printf("Alphabets        : %d\n", alphabet);
        printf("Digits           : %d\n", digit);
        printf("Special (#, &)   : %d\n", special);
    }

}