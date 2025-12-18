read -p "Enter the value of x: " x
read -p "Enter the value of n: " n
awk -v x="$x" -v n="$n" '
BEGIN {
    sum =1;
    for( i=2 ;i<=n ;i++ )
    {
        num=2*(i-1)
        den=x;
        term=(num/den) ^ i; 
        if (i%2==0)
            sum=sum+term;
        else
            sum=sum-term;
    }
    printf "The sum of the digits are: %.4f ",sum;
}'