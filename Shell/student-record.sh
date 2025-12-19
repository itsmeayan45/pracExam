file=$1
temp_file="temp.txt"
read -p "Enter roll number to update: " roll
found=0
while IFS='|' read r n m
    do
        if [[ "$r" == "$roll" ]]; then
            found=1;
            echo "record found"
            echo "$r|$n|$m"
            read -p "Enter new name: " new_name
            read -p "Enter new marks: " new_marks
            echo "$r|$new_name|$new_marks">>$temp_file
        else
            echo "$r|$n|$m">>$temp_file
        fi
    done < $file


if [ $found -eq 1 ]
then
    mv $temp_file $file
    echo "Record updated successfully."
else
    rm $temp_file
    echo "Roll number not found."
fi
