echo "Checking for palindrome: "
echo "--------------------------"

for num in "$@"; do
    org_num=$num
    temp=$num
    rev=0

    while [ $temp -gt 0 ]; do
        remainder=$(( temp%10 ))
        rev=$(( rev*10+remainder ))
        temp=$(( temp/10 ))
    done
    if [ $org_num -eq $rev ]; then
        echo "$org_num is a palindrome number"  
    else
        echo "$org_num is not a palindrome number"
    fi
done